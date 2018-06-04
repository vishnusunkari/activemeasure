package com.am.note.service;

import com.am.note.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotesService {

    public List<Note> getAllNotes(String email);
    public boolean createNotes(Note note, String email);
    public boolean deleteNotes(Note note);

}
