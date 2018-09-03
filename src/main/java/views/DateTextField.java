package views;

import controllers.Controller;
import interfaces.DateChanged;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateTextField extends JFormattedTextField implements DateChanged {

    private LocalDate today;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
    private String dateString;

    public DateTextField() {
        today = LocalDate.now();
        setText(today.toString());

        setBounds(100, 10, 185, 45);
        Controller.getInstance().addDateChanged(this);
        Controller.getInstance().dateEvent(today);

        addActionListener(e -> {
            dateString = getText();
            LocalDate newDateFromTextField = LocalDate.parse(dateString, formatter);
            setText(newDateFromTextField.toString());
            Controller.getInstance().dateEvent(newDateFromTextField);
        });
    }

    @Override
    public void onDateChange(LocalDate date) {
        this.today = date;
        this.setText(date.toString());
    }
}
