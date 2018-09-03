package views;

import controllers.NoteService;
import models.Note;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NoteFrame extends JFrame {

    private NoteService noteService = NoteService.getInstance();
    private List<Note> notesList = new ArrayList<>();
    private JPanel notePanel;
    private JTextArea noteTextArea;
    private JButton noteButton;

    public JTextArea getNoteTextArea() {
        return noteTextArea;
    }

    public NoteFrame(LocalDate date) {

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(300, 300);
        setTitle("Note");

        addPanel();

        noteButton.addActionListener(e -> {
            Note note = new Note(noteTextArea.getText());
            notesList.add(note);

            noteService.addNoteToTheMap(date, notesList);
            NoteService.getInstance().noteEvent(date, noteTextArea.getText());

            setVisible(false);
        });

    }

    public void addPanel() {
        notePanel = new JPanel();
        notePanel.setLayout(null);
        notePanel.setBounds(0, 0, 300, 300);
        notePanel.setVisible(true);
        add(notePanel);

        addTextAreaToThePanel();
        addButtonToThePanel();
    }

    public void addTextAreaToThePanel() {
        noteTextArea = new JTextArea();
        noteTextArea.setBounds(10, 10, 265, 200);
        noteTextArea.setLineWrap(true);
        notePanel.add(noteTextArea);
    }

    public void addButtonToThePanel() {
        noteButton = new JButton("Add");
        noteButton.setBounds(130, 220, 80, 30);
        notePanel.add(noteButton);
    }

}
