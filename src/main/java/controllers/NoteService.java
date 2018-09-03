package controllers;

import interfaces.NoteAdded;
import models.Note;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteService {

    public static NoteService noteService;

    private Map<LocalDate, List<Note>> notesMap = new HashMap();
    private List<NoteAdded> noteAddedList = new ArrayList<>();


    private NoteService() {
    }

    public static NoteService getInstance() {
        if (noteService == null) {
            noteService = new NoteService();
        }
        return noteService;
    }

    public Map<LocalDate,List<Note>> giveNotesMap() {
        return notesMap;
    }

    public void addNoteToTheMap(LocalDate date, List<Note> notesList) {
        notesMap.put(date, notesList);
    }

    public void addNote(NoteAdded noteAdded) {
        noteAddedList.add(noteAdded);
    }

    public void noteEvent(LocalDate date, String note) {
        for (NoteAdded noteAdded : noteAddedList) {
            noteAdded.addNote(date, note);
        }
    }


}
