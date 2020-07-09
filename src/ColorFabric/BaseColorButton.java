package ColorFabric;

import java.awt.Color;
import javax.swing.JButton;


public abstract class BaseColorButton extends JButton {

    private static final long serialVersionUID = 1L;

    BaseColorButton() {
        super();
    }

    abstract public Color getColor();
}
