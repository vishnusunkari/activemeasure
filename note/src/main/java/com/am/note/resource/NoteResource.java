package com.am.note.resource;

import com.am.note.model.Note;
import com.am.note.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noteapp/notes")
public class NoteResource {

    NotesService notesService;

    @Autowired
    NoteResource(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/")
    public List<Note> getNotes(@PathVariable("email") final String email){
        return notesService.getAllNotes(email);
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Note note){
        String userEmail = "abc@gmail.com";
        notesService.createNotes(note, userEmail);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
    }

    /*@DeleteMapping("/")
    public ResponseEntity delete(@PathVariable("username") final String username){
        notesService.deleteNotes(notes)
    }*/
}
