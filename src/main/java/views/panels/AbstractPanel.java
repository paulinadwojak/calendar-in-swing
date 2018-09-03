package views.panels;

import controllers.Controller;
import controllers.NoteService;
import interfaces.DateChanged;
import interfaces.NoteAdded;
import views.buttons.DateButton;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPanel extends JPanel implements DateChanged, NoteAdded {

    private List<DateButton> buttonList = new ArrayList<>();
    private DateButton dateButton;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
    protected LocalDate date;
    protected int buttonWidth = 120;
    protected int buttonPositionX = 14;


    public AbstractPanel() {
        date = LocalDate.now();
        setLayout(null);
        setBounds(0, 0, 860, 550);
        setVisible(true);
        Controller.getInstance().addDateChanged(this);
        NoteService.getInstance().addNote(this);
    }

    public void addButtonsToBottomPanel() {

        for (int i = 0; i < getHowManyDays(); i++) {
            dateButton = new DateButton();
            dateButton.setBounds(buttonPositionX, 40, buttonWidth, 550);
            dateButton.setText(getDate().plusDays(i).toString());
            add(dateButton);
            buttonList.add(dateButton);
            buttonPositionX = buttonPositionX + buttonWidth;
        }
    }

    @Override
    public void onDateChange(LocalDate date) {
        this.date = date;
        LocalDate newDateFromTextField;

        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).setText(getDate().plusDays(i).toString());
            buttonList.get(i).setBackground(Color.lightGray);

            if ((buttonList.get(i).getText()).equals(date.toString())) {
                buttonList.get(i).setBackground(Color.gray);
            }
            newDateFromTextField = LocalDate.parse(buttonList.get(i).getText(), formatter);

            if (NoteService.getInstance().giveNotesMap().containsKey(newDateFromTextField)) {
               buttonList.get(i).setBackground(Color.yellow);
            }
        }
    }

    public void addNote(LocalDate date, String note) {
        this.date = date;
        LocalDate newDateFromTextField;

        for (int i = 0; i < buttonList.size(); i++) {
            newDateFromTextField = LocalDate.parse(buttonList.get(i).getText(), formatter);

            if (NoteService.getInstance().giveNotesMap().containsKey(newDateFromTextField)) {
                buttonList.get(i).setBackground(Color.yellow);
            }
        }
    }

    public abstract LocalDate getDate();

    public abstract int getHowManyDays();

}
