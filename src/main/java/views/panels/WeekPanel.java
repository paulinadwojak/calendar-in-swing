package views.panels;

import java.time.LocalDate;


public class WeekPanel extends AbstractPanel {

    public LocalDate getDate() {
        return date;
    }

    public int getHowManyDays() {
        return 7;
    }
}
