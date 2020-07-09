package ToolFabric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import redactor.Model;

/**
 *
 * @author user
 */
public class SaveaspngButton extends BaseButton {

    private static final long serialVersionUID = 1L;

    public SaveaspngButton() {
        super("Save as PNG file");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Model.getModel().savePng();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
