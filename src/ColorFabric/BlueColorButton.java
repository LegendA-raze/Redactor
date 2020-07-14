/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColorFabric;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import redactor.Model;

public class BlueColorButton extends BaseColorButton {

    private static final long serialVersionUID = 1L;
    BaseColorButton colorButton = this;

    public BlueColorButton() {
        super();
        this.setBackground(this.getColor());
        this.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent arg0) {
                        if (Model.getModel().getLast()!=null) {
                            Model.getModel().getLast().setColor(colorButton.getColor());
                        }
                        Model.getModel().setCurrColor(colorButton.getColor());
                    }
        });
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
