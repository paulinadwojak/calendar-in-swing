package controllers;

import interfaces.DateChanged;
import interfaces.ViewChanged;
import enums.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static Controller controller;

    private List<DateChanged> dateChangingList = new ArrayList<>();
    private List<ViewChanged> viewChangingList = new ArrayList<>();

    private Controller() {
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public void addDateChanged(DateChanged dateChanged) {
        dateChangingList.add(dateChanged);
    }

    public void addViewChanged(ViewChanged viewChanged) {
        viewChangingList.add(viewChanged);
    }


    public void dateEvent(LocalDate date) {
        for (DateChanged dateChanged : dateChangingList) {
            dateChanged.onDateChange(date);
        }
    }

    public void viewEvent(View view) {
        for (ViewChanged viewChanged : viewChangingList) {
            viewChanged.onViewChanged(view);
        }
    }
}
