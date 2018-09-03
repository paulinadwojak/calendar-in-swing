package views.panels;

import utils.DateCalculation;

import java.awt.*;
import java.time.LocalDate;


public class MonthPanel extends AbstractPanel {

    private GridLayout grid;

    public MonthPanel() {
        grid = new GridLayout(5, 7);
        setLayout(grid);
    }

    public LocalDate getDate() {
        return DateCalculation.calculateTheFirstOfTheMonth(date);
    }

    public int getHowManyDays() {
        return date.lengthOfMonth();
    }

}
