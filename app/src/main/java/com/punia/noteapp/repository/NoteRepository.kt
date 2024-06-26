package com.punia.noteapp.repository

import androidx.annotation.WorkerThread
import com.punia.noteapp.model.Note
import com.punia.noteapp.room.NoteDAO
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao : NoteDAO) {

    val myAllNotes : Flow<List<Note>> = noteDao.getAllNotes()
    @WorkerThread
    suspend fun insert(note : Note)
    {
        noteDao.insert(note)
    }

    @WorkerThread
    suspend fun update(note : Note)
    {
        noteDao.update(note)
    }

    @WorkerThread
    suspend fun deleteAllNotes()
    {
        noteDao.getAllNotes()
    }
    @WorkerThread
    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }

}