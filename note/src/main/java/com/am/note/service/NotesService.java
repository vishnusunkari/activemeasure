package com.am.note.service;

import com.am.note.model.Note;

import java.util.List;

public interface NotesService {

    public List<Note> getAllNotes(String email);
    public boolean createNotes(Note note, String email);
    public boolean deleteNotes(Note note);

}
