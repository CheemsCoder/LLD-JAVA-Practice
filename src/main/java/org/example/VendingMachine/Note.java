package org.example.VendingMachine;


public class Note {
    NoteType noteType;
    Integer amount;

    public Note(NoteType noteType, Integer amount) {
        this.noteType = noteType;
        this.amount = amount;
    }
}
