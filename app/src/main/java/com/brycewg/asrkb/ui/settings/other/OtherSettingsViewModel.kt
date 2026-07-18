package com.brycewg.asrkb.ui.settings.other

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brycewg.asrkb.store.Prefs
import com.brycewg.asrkb.store.SpeechPreset
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Compose other settings screen that manages speech presets and sync clipboard settings.
 * Uses StateFlow to drive reactive UI updates and eliminates manual UI refresh complexity.
 */
class OtherSettingsViewModel(private val prefs: Prefs) : ViewModel() {

    companion object {
        private const val TAG = "OtherSettingsViewModel"
    }

    // Speech presets state
    private val _speechPresetsState = MutableStateFlow(buildSpeechPresetsStateSafely())
    val speechPresetsState: StateFlow<SpeechPresetsState> = _speechPresetsState.asStateFlow()

    private var speechPresetPersistJob: Job? = null

    data class SpeechPresetsState(
        val presets: List<SpeechPreset> = emptyList(),
        val activePresetId: String = "",
        val currentPreset: SpeechPreset? = null,
        val isEnabled: Boolean = false
    )

    // Speech Presets Management

    private fun loadSpeechPresets() {
        viewModelScope.launch {
            try {
                _speechPresetsState.value = buildSpeechPresetsState()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load speech presets", e)
            }
        }
    }

    private fun buildSpeechPresetsState(): SpeechPresetsState {
        val presets = prefs.getSpeechPresets()
        val activeId = prefs.activeSpeechPresetId
        val current = if (presets.isNotEmpty()) {
            presets.firstOrNull { it.id == activeId } ?: presets.firstOrNull()
        } else {
            null
        }

        if (current != null && prefs.activeSpeechPresetId != current.id) {
            prefs.activeSpeechPresetId = current.id
        }

        return SpeechPresetsState(
            presets = presets,
            activePresetId = current?.id ?: "",
            currentPreset = current,
            isEnabled = presets.isNotEmpty()
        )
    }

    private fun buildSpeechPresetsStateSafely(): SpeechPresetsState = try {
        buildSpeechPresetsState()
    } catch (e: Exception) {
        Log.e(TAG, "Failed to build speech presets state", e)
        SpeechPresetsState()
    }

    fun addSpeechPreset(defaultName: String) {
        viewModelScope.launch {
            try {
                flushPendingSpeechPreset()
                val list = prefs.getSpeechPresets().toMutableList()
                val newId = java.util.UUID.randomUUID().toString()
                list.add(SpeechPreset(newId, defaultName, ""))
                prefs.setSpeechPresets(list)
                prefs.activeSpeechPresetId = newId
                loadSpeechPresets()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to add speech preset", e)
            }
        }
    }

    fun deleteSpeechPreset(presetId: String) {
        viewModelScope.launch {
            try {
                flushPendingSpeechPreset()
                val list = prefs.getSpeechPresets().toMutableList()
                val idx = list.indexOfFirst { it.id == presetId }
                if (idx >= 0) {
                    list.removeAt(idx)
                    prefs.setSpeechPresets(list)
                    if (list.isNotEmpty()) {
                        val nextIdx = idx.coerceAtMost(list.lastIndex)
                        prefs.activeSpeechPresetId = list[nextIdx].id
                    } else {
                        prefs.activeSpeechPresetId = ""
                    }
                    loadSpeechPresets()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to delete speech preset", e)
            }
        }
    }

    fun updateActivePresetName(name: String) {
        try {
            updateActiveSpeechPresetState { it.copy(name = name) }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to update preset name", e)
        }
    }

    fun updateActivePresetContent(content: String) {
        try {
            updateActiveSpeechPresetState { it.copy(content = content) }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to update preset content", e)
        }
    }

    fun setActivePreset(presetId: String) {
        viewModelScope.launch {
            try {
                flushPendingSpeechPreset()
                prefs.activeSpeechPresetId = presetId
                loadSpeechPresets()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to set active preset", e)
            }
        }
    }

    private fun updateActiveSpeechPresetState(mutator: (SpeechPreset) -> SpeechPreset) {
        val state = _speechPresetsState.value
        val activeId = state.activePresetId.ifBlank { prefs.activeSpeechPresetId }
        val list = state.presets.toMutableList()
        val idx = list.indexOfFirst { it.id == activeId }
        if (idx < 0) return

        val mutated = mutator(list[idx])
        if (mutated == list[idx]) return

        list[idx] = mutated
        _speechPresetsState.value = state.copy(
            presets = list,
            activePresetId = activeId,
            currentPreset = mutated,
            isEnabled = list.isNotEmpty()
        )

        if (mutated.name.isNotBlank()) {
            scheduleSpeechPresetPersist(list)
        } else {
            speechPresetPersistJob?.cancel()
        }
    }

    private fun scheduleSpeechPresetPersist(list: List<SpeechPreset>) {
        speechPresetPersistJob?.cancel()
        speechPresetPersistJob = viewModelScope.launch {
            delay(350L)
            prefs.setSpeechPresets(list)
            speechPresetPersistJob = null
        }
    }

    private fun flushPendingSpeechPreset() {
        speechPresetPersistJob?.cancel()
        speechPresetPersistJob = null
        val state = _speechPresetsState.value
        if (state.currentPreset?.name?.isNotBlank() == true) {
            prefs.setSpeechPresets(state.presets)
        }
    }

    override fun onCleared() {
        flushPendingSpeechPreset()
        super.onCleared()
    }
}
