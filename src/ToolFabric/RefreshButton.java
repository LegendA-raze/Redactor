package ToolFabric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import redactor.Model;

public class RefreshButton extends BaseButton {

    private static final long serialVersionUID = 1L;

    public RefreshButton() {
        super("Refresh");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Model.getModel().refresh();
            }
        });
    }
}
    
