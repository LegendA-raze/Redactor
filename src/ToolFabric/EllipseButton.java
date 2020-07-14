package ToolFabric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import redactor.Model;
import shapes.EllipseShape;


public class EllipseButton extends BaseButton {

    private static final long serialVersionUID = 1L;

    public EllipseButton() {
        super("Ellipse");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Model.getModel().addShape(new EllipseShape());
            }
        });
    }
}
