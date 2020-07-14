package ToolFabric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import redactor.Model;
import shapes.PolylineShape;

/**
 *
 * @author user
 */
public class PolylineButton extends BaseButton {

    private static final long serialVersionUID = 1L;

    public PolylineButton() {
        super("Polyline");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Model.getModel().addShape(new PolylineShape());
            }
        });
    }
}
