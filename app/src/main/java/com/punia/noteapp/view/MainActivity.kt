package com.punia.noteapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.punia.noteapp.NoteApplication
import com.punia.noteapp.R
import com.punia.noteapp.viewModel.NoteViewModel
import com.punia.noteapp.viewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel : NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = NoteViewModelFactory((application as NoteApplication).repository)
        noteViewModel = ViewModelProvider(this, viewModelFactory).get(NoteViewModel :: class.java)
        noteViewModel.myAllNotes.observe(this, Observer {notes->
            // UPDATE UI
        })
    }

}