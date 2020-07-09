package redactor;

import shapes.BaseShape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import save.*;
import shapes.*;
import spotter.Observed;
import spotter.Observer;

public class Model implements Observed{
	private List<Observer> listOfObservers;
	private Queue queue;
	private BufferedImage buf;
	private Graphics buffer;
	private Settings settings;
	private static Model me;
	
	private Model(){
		queue = new Queue();
		listOfObservers = new ArrayList<Observer>();
		this.settings=Settings.getSettings();
		buf=new BufferedImage(this.settings.getDimension().width,this.settings.getDimension().height, BufferedImage.TYPE_INT_ARGB);
		buffer=buf.getGraphics();
		buffer.setColor(Color.white);
		buffer.fillRect(this.settings.getButtonSize(),this.settings.getButtonSize(), this.settings.getDimension().width, this.settings.getDimension().height);
	}
	
	public static Model getModel() {
		if(me==null) {
			me=new Model();
		}
		return me;	
	}
	public void refresh() {
		this.queue.refresh();
		notifyObservers();
	}
	public BaseShape getLast() {
		return queue.getLast();
	}
	public void addShape(BaseShape shape) {
		queue.addShape(shape);
	}
	public void addFirstCoordinates(Point2D point) {
		if(point.getY()>settings.getButtonSize() & point.getX()>settings.getButtonSize()) {
                        queue.getLast().addFirstCoordinates(point);
                        notifyObservers();
		}
	}
	public void addSecondCoordinates(Point2D point) {
		if(point.getY()>settings.getButtonSize() & point.getX()>settings.getButtonSize()) {
                        queue.getLast().addSecondCoordinates(point);
                        notifyObservers();
		}
	}
	public void addCurrCoordinates(Point2D point) {
		if(point.getY()>settings.getButtonSize() & point.getX()>settings.getButtonSize()) {
                        queue.getLast().addCurrCoordinates(point);
                        notifyObservers();
		}
	}
	public void setCurrColor(Color color) { //установка постоянного цвета
		queue.setCurrColor(color);
		notifyObservers(); 
	}
	public BufferedImage getBuf() {
		buffer.setColor(Color.white);
		buffer.fillRect(settings.getButtonSize(),settings.getButtonSize(), settings.getDimension().width, settings.getDimension().height);
		queue.printTo(buffer);
		return buf; 
	}
	@Override
	public void addObserver(Observer observer) { 
		listOfObservers.add(observer);
	}
	@Override
	public void notifyObservers() {
		for (Observer observer: listOfObservers) {
			observer.handleEvent();
		}
	}
	public void savePng() throws IOException {
		File outputfile = new File("image.png");
		ImageIO.write(buf, "png", outputfile);
	}
	public void save() throws IOException {
                SaveShapeQueue shapes = new SaveShapeQueue();
                for(BaseShape shape:queue.getShapes()){
                        shapes.addShape(new SaveShape(shape));
                }
                FileOutputStream outputStream = new FileOutputStream("save.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(shapes);
                objectOutputStream.close();
	}

	public void load() throws IOException, ClassNotFoundException {
                SaveShapeQueue shapes = new SaveShapeQueue();
                FileInputStream fileInputStream = new FileInputStream("save.ser");
                try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                        shapes = (SaveShapeQueue) objectInputStream.readObject();
                        refresh();
                        for (SaveShape saveShape:shapes.getShapes()) {
                                setCurrColor(saveShape.getColor());
                                if(saveShape.getType().equals("Ellipse")) {
                                        addShape(new EllipseShape());
                                }else if (saveShape.getType().equals("Rectangle")) {
                                        addShape(new RectShape());
                                }else if (saveShape.getType().equals("Polygon")) {
                                        addShape(new PolygonShape());
                                }else if (saveShape.getType().equals("Polyline")) {
                                        addShape(new PolylineShape());
                                }else throw new RuntimeException("problem");
                                        if(saveShape.getPoints().size()!=0) {
                                                getLast().setCoordinates(saveShape.getPoints());
                                        }
                        }
                        notifyObservers(); //
                }
	    
	}		
}
