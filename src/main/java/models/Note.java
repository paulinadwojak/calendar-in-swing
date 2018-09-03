package models;

public class Note {

    private String note;

    public Note(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return note;
    }
}
