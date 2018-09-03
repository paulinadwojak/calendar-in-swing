package views.buttons;

import java.time.LocalDate;

public class ForwardButton extends ChangingDateButton {

    public ForwardButton() {
        setText(">");
        setBounds(300, 10, 45, 45);
    }

    @Override
    public LocalDate getChangedMonth() {
        return date.plusMonths(1);
    }

    @Override
    public LocalDate getChangedDay() {
        return date.plusDays(1);
    }
}
