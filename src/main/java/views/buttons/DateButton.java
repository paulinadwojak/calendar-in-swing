package views.buttons;

import controllers.Controller;
import controllers.NoteService;
import models.Note;
import views.NoteFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateButton extends JButton {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
    private String dateString;
    private NoteFrame noteFrame;
    private NoteService noteService = NoteService.getInstance();

    public DateButton() {

        addActionListener(e -> {
            dateString = getText();
            LocalDate newDateFromTextField = LocalDate.parse(dateString, formatter);
            Controller.getInstance().dateEvent(newDateFromTextField);
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dateString = getText();
                LocalDate newDateFromTextField = LocalDate.parse(dateString, formatter);

                int modifiers = e.getModifiers();
                if ((modifiers & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
                    noteFrame = new NoteFrame(newDateFromTextField);

                    if (noteService.giveNotesMap().get(newDateFromTextField) != null) {
                        for (Note note : noteService.giveNotesMap().get(newDateFromTextField)) {

                            noteFrame.getNoteTextArea().setLayout(new GridLayout());
                            noteFrame.getNoteTextArea().setText(note.toString());
                           // noteFrame.getNoteTextArea().setText(note.toString() + "\n");
                        }
                    }
                }
            }
        });
    }
}
