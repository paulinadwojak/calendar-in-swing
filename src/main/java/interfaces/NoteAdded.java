package interfaces;

import java.time.LocalDate;

public interface NoteAdded {

    void addNote(LocalDate date, String note);
}
