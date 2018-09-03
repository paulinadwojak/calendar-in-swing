package views.buttons;
import controllers.Controller;
import enums.View;
import interfaces.DateChanged;
import interfaces.ViewChanged;

import javax.swing.*;
import java.time.LocalDate;

public abstract class ChangingDateButton extends JButton implements DateChanged, ViewChanged {

    protected LocalDate date;
    protected View view;

    public ChangingDateButton() {
        view = View.WEEK;

        Controller.getInstance().addDateChanged(this);
        Controller.getInstance().addViewChanged(this);

        addActionListener(e -> {

            switch (view) {
                case WEEK:
                    date = getChangedDay();
                    break;
                case MONTH:
                    date = getChangedMonth();
                    break;
            }
            Controller.getInstance().dateEvent(date);
        });
    }

    public abstract LocalDate getChangedDay();

    public abstract LocalDate getChangedMonth();

    @Override
    public void onDateChange(LocalDate date) {
        this.date = date;
    }

    @Override
    public void onViewChanged(View view) {
        this.view = view;
    }
}
