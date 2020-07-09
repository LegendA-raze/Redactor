	/**
 * 
 */
package redactor;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;



public class Canvas extends JPanel {
	private Model model;
	private Canvas me;
        private Settings par;
	private int buttonSize;
	
	public Canvas() {
		me=this;
                this.model = Model.getModel();
                this.par = Settings.getSettings();
		Settings settings = Settings.getSettings();
		int width = settings.getDimension().width;
		int heigth = settings.getDimension().height;
		this.buttonSize = settings.getButtonSize();
		this.setBounds(buttonSize, buttonSize, width , heigth);
		this.repaint();
                this.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent event) {}

                        @Override
                        public void mouseEntered(MouseEvent event) {}

                        @Override
                        public void mouseExited(MouseEvent event) {}

                        @Override
                        public void mousePressed(MouseEvent event) {
                                if(model.getLast() != null) {
                                    model.addFirstCoordinates(event.getPoint());
                                    model.addCurrCoordinates(event.getPoint());
                                }
                        }

                        @Override
                        public void mouseReleased(MouseEvent event) {
                                if(model.getLast() != null) {
                                    model.addSecondCoordinates(event.getPoint());
                                }
                        }
                });
                this.addMouseMotionListener(new MouseMotionListener() {
                        @Override
                        public void mouseDragged(MouseEvent event) {
                                if(model.getLast() != null) {
                                    model.addCurrCoordinates(event.getPoint());
                                }
                        }

                        @Override
                        public void mouseMoved(MouseEvent event) {
                        }
                });
        }
	public void paint(Graphics g) {
		g.drawImage(model.getBuf(),0,0,me);
	}

}
