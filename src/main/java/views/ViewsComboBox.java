package views;

import controllers.Controller;
import enums.View;
import interfaces.ViewChanged;

import javax.swing.*;

import static enums.View.findByName;

public class ViewsComboBox extends JComboBox implements ViewChanged {

    private View currentView;

    public ViewsComboBox() {
        this.currentView = View.WEEK;
        Controller.getInstance().viewEvent(currentView);

        for (View enumString : View.values()) {
            addItem(enumString.toString());
        }

        setBounds(400, 10, 90, 45);
        Controller.getInstance().addViewChanged(this);

        addActionListener(e -> {
            currentView = findByName(currentView.toString());
            Controller.getInstance().viewEvent(currentView);
        });
    }

    @Override
    public void onViewChanged(View view) {
        this.currentView = view;
    }
}
