
package redactor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import spotter.Observer;

/**
 *
 * @author legen
 */
public class Redactor extends JFrame implements Observer {
	private static final long serialVersionUID = 2L;
	public Redactor(){
		super("Redactor");
		setLocationByPlatform(true);
		this.setSize(Settings.getSettings().getDimension().width, Settings.getSettings().getDimension().height);
                JLabel le = new JLabel ("Графический редактор");
                le.setBounds(50,0,400,50);
                le.setForeground(Color.white);
                le.setFont(new Font("Arial", Font.BOLD, 25));
                this.add(le);
                this.add(new ColorButtonPanel());
		this.add(new ButtonPanel());
		this.add(new Canvas());
		setExtendedState(MAXIMIZED_BOTH);
                this.setVisible(true);		
	}
	@Override
	public void handleEvent(){ //так-как мы произвели изменения, мы перерисуем все окно
		repaint();
	}
        public static void main(String[] args) {
        	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //определяем размеры экрана
		int buttonSize = 40; // размер кнопки
		Settings.getSettings().setDimension(screenSize); //устанавливаем размер окна
		Settings.getSettings().setButtonSize(buttonSize); // устанваливаем размер кнопок
                Redactor ai = new Redactor();
		ai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Model.getModel().addObserver(ai); //Получает информацию о том, что мы произвели какие-то изменения
        }
}
