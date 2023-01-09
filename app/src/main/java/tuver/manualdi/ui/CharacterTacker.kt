package tuver.manualdi.ui

import android.util.Log

class CharacterTacker {

    private val eventList = mutableListOf<String>()

    fun trackCharacterListView() {
        eventList.add("Character list viewed")
    }

    fun trackCharacterView(characterName: String) {
        eventList.add("Character $characterName viewed")
    }

    fun saveSession() {
        eventList.forEach { event ->
            Log.i("CharacterTacker", event)
        }
    }

}