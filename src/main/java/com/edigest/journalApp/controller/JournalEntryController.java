package com.edigest.journalApp.controller;

import com.edigest.journalApp.entity.JournalEntity;
import com.edigest.journalApp.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<List<JournalEntity>> getAll() {
        List<JournalEntity> allEntry = journalEntryService.getAllEntry();
        if(!allEntry.isEmpty()) {
            return new ResponseEntity<>(allEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody JournalEntity myEntry) {
        try{
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry((myEntry));
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{updateId}")
    public JournalEntity updateEntry(@PathVariable ObjectId updateId, @RequestBody JournalEntity myEntry) {
        JournalEntity old = journalEntryService.findEntry(updateId).orElse(null);
        if(old != null){
            old.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().isEmpty()? myEntry.getTitle() : old.getTitle());
            old.setContent(myEntry.getContent() != null && !myEntry.getContent().isEmpty()? myEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }

    @GetMapping("/{getId}")
    public ResponseEntity<JournalEntity> getById(@PathVariable ObjectId getId){
        Optional<JournalEntity> journalEntry = journalEntryService.findEntry(getId);
        if (journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{deleteId}")
    public boolean deleteEntry(@PathVariable ObjectId deleteId) {
        journalEntryService.deleteEntry((deleteId));
        return true;
    }
}