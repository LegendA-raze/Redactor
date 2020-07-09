package redactor;

import ColorFabric.BlueColorButton;
import ToolFabric.*;
import java.awt.Color;
import java.awt.PopupMenu;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {	
	public ButtonPanel(){
		super();
		int buttonSize = Settings.getSettings().getButtonSize();
		this.setBounds(0, 0, Settings.getSettings().getDimension().width, buttonSize);
		this.setBackground(new Color(127, 255, 212));
                this.add(new EllipseButton());
                this.add(new RectangleButton());
                this.add(new PolylineButton());
                this.add(new PolygonButton());
                this.add(new SaveButton());
                this.add(new LoadButton());
                this.add(new SaveaspngButton());
                this.add(new RefreshButton());
                
	}
}
