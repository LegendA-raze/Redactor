package ToolFabric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import redactor.Model;
import shapes.PolygonShape;

public class PolygonButton extends BaseButton {

    private static final long serialVersionUID = 1L;

    public PolygonButton() {
        super("Polygon");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Model.getModel().addShape(new PolygonShape());
            }
        });
    }
}
