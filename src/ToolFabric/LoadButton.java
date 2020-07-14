package ToolFabric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import redactor.Model;

public class LoadButton extends BaseButton {

    private static final long serialVersionUID = 1L;

    public LoadButton() {
        super("Load");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Model.getModel().load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoadButton.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
