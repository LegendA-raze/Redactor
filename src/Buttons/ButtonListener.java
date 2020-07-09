package Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import redactor.Model;
import shapes.EllipseShape;
import shapes.PolygonShape;
import shapes.PolylineShape;
import shapes.RectShape;

public class ButtonListener implements ActionListener{
	private String action;
	public ButtonListener(String action){
		this.action=action;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (action.equals("Элипс")) {
			Model.getModel().addShape(new EllipseShape());
		} else if (action.equals("Прямоугольник")) {
			Model.getModel().addShape(new RectShape());
		}else if (action.equals("Ломанная")) {
			Model.getModel().addShape(new PolylineShape());
		}else if (action.equals("Полигон")) {
			Model.getModel().addShape(new PolygonShape());
		}else if (action.equals("Обновить")) {
			Model.getModel().refresh();
		}else if (action.equals("Сохранить проект")) {
			
		}else if (action.equals("Загрузить проект")) {
			
		}else if (action.equals("Сохранить в формате PNG")) {
		
                }
        }
}
