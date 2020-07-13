package redactor;

import ColorFabric.*;
import ColorFabric.BlueColorButton;
import java.awt.Color;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorButtonPanel extends JPanel{
	public ColorButtonPanel(){
		super();
		int buttonSize = Settings.getSettings().getButtonSize();
                int height = Settings.getSettings().getDimension().height;
		this.setBounds(0, buttonSize, buttonSize, height);
		this.setBackground(new Color(127, 255, 212));
                this.add(new BlueColorButton());
                this.add(new RedColorButton());
                this.add(new GreenColorButton());
                
	}
}