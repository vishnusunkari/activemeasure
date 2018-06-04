package com.am.note.dao;

import com.am.note.model.Note;
import com.am.note.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note, Integer> {

    List<Note> findByEmail(String email);
}