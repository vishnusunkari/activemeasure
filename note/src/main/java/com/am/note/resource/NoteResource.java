package com.am.note.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noteapp/notes")
public class NoteResource {
    @Autowired
    NotesService notesService;

    @GetMapping("/")
    public List<String> getQuotes(@PathVariable("username") final String username){
        return quotesRepository.findByUsername(username).stream().map(quote -> quote.getQuote()).collect(Collectors.toList());
    }

    @PostMapping("/")
    public List<String> add(@RequestBody final Quotes quotes){
        for(String quoteStr : quotes.getQuotes()){
            Quote quote = new Quote(quotes.getUsername(), quoteStr);
            quotesRepository.save(quote);
        }
        return getQuotes(quotes.getUsername());
    }

    @DeleteMapping("/")
    public List<String> delete(@PathVariable("username") final String username){
        List<Quote> quotes = quotesRepository.findByUsername(username);
        quotesRepository.deleteAll(quotes);
        return quotes.stream().map(Quote::getQuote).collect(Collectors.toList());
    }
}
