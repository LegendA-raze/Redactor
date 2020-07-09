/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ToolFabric;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import redactor.Model;
import shapes.EllipseShape;

/**
 *
 * @author user
 */
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
