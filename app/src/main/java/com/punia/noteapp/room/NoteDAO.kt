package com.punia.noteapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.punia.noteapp.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDAO {
    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note : Note)

    @Delete
    suspend fun delete(note : Note)

    @Query("DELETE from note_table")
    suspend fun deleteAllNodes()

    @Query("SELECT * FROM note_table ORDER BY id ASC")
    fun getAllNotes() : Flow<List <Note>>
}