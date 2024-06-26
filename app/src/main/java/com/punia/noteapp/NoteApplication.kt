package com.punia.noteapp

import android.app.Application
import com.punia.noteapp.repository.NoteRepository
import com.punia.noteapp.room.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NoteApplication: Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy {
        NoteDatabase.getDatabase(this, applicationScope)
    }

    val repository by lazy {
        NoteRepository(database.getNoteDao())
    }
}