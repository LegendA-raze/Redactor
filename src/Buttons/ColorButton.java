//package Buttons;
//
//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import redactor.Model;
//
//@SuppressWarnings("serial")
//public class ColorButton extends JButton {
//    ColorButton colorButton = this;
//	public ColorButton(Color color){
//		super();
//		this.setBackground(color);
//		this.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent arg0) {
//                        if (Model.getModel().getLast()!=null) {
//                            Model.getModel().getLast().setColor(color);
//                        }
//                        Model.getModel().setCurrColor(color);
//                    }
//		});
//	}
//
//
//}