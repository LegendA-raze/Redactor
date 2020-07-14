package ToolFabric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import redactor.Model;

public class SaveButton extends BaseButton {

    private static final long serialVersionUID = 1L;

    public SaveButton() {
        super("Save");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Model.getModel().save();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
