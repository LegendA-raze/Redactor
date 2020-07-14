package ToolFabric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import redactor.Model;
import shapes.RectShape;

public class RectangleButton extends BaseButton {

    private static final long serialVersionUID = 1L;

    public RectangleButton() {
        super("Rectangle");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Model.getModel().addShape(new RectShape());
            }
        });
    }
}
