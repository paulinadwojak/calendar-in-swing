package views;

import views.buttons.BackwardButton;
import views.buttons.ForwardButton;
import views.panels.BottomPanel;
import views.panels.UpperPanel;

import javax.swing.*;

public class Frame extends JFrame {

    private UpperPanel upperPanel;


    public Frame() {
        setLayout(null);
        setSize(900, 700);
        setResizable(false);
        setTitle("Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addPanels();
        setVisible(true);
    }

    public void addPanels() {

        BottomPanel bottomPanel = new BottomPanel();
        upperPanel = new UpperPanel();

        addUpperPanelElements();
        add(upperPanel);
        add(bottomPanel);
    }

    public void addUpperPanelElements() {

        ViewsComboBox viewsComboBox = new ViewsComboBox();
        upperPanel.add(viewsComboBox);

        BackwardButton backwardButton = new BackwardButton();
        upperPanel.add(backwardButton);

        ForwardButton forwardButton = new ForwardButton();
        upperPanel.add(forwardButton);

        DateTextField dateTextField = new DateTextField();
        upperPanel.add(dateTextField);


    }

}
