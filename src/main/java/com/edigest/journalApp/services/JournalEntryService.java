package com.edigest.journalApp.services;

import com.edigest.journalApp.entity.JournalEntity;
import com.edigest.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntity journalEntity){
        journalEntryRepo.save(journalEntity);
    }

    public List<JournalEntity> getAllEntry(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntity> findEntry(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    public void deleteEntry(ObjectId id){
        journalEntryRepo.deleteById(id);
    }
}
