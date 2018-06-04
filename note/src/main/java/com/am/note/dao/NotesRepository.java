package com.am.note.dao;

import com.am.note.model.Note;
import com.am.note.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Note, Integer> {

    public List<Note> findByEmail(String email);
   // public boolean createNote(Note note);
}