package views.panels;

import controllers.Controller;
import enums.View;
import interfaces.ViewChanged;

import javax.swing.*;

public class BottomPanel extends JPanel implements ViewChanged {

    private WeekPanel weekPanel;
    private MonthPanel monthPanel;

    public BottomPanel() {
        setLayout(null);
        setBounds(15, 75, 860, 550);
        setVisible(true);
        Controller.getInstance().addViewChanged(this);

        weekPanel = new WeekPanel();
        weekPanel.addButtonsToBottomPanel();
        add(weekPanel);
        monthPanel = new MonthPanel();
        monthPanel.addButtonsToBottomPanel();
    }

    @Override
    public void onViewChanged(View view) {
        if (view.toString().equals("WEEK")) {
            removeAll();
            add(weekPanel);
        } else if (view.toString().equals("MONTH")) {
            removeAll();
            add(monthPanel);
        }
        repaint();
        revalidate();
    }

}
