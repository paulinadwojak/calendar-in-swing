package views.buttons;

import java.time.LocalDate;

public class BackwardButton extends ChangingDateButton {

    public BackwardButton() {
        setText("<");
        setBounds(40, 10, 45, 45);
    }

    @Override
    public LocalDate getChangedMonth() {
        return date.minusMonths(1);
    }

    @Override
    public LocalDate getChangedDay() {
        return date.minusDays(1);
    }
}
