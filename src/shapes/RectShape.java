package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class RectShape extends BaseShape {
	private List<Point2D> coordinates;
	private Color shapeColor;
	private Shape shape=null;
	public RectShape(){
		this.coordinates = new ArrayList<Point2D>();
		coordinates.add(new Point2D.Double(0,0));
		coordinates.add(new Point2D.Double(0,0));
	}
	@Override
	public void drawShape(Graphics g) {
		if(shape!=null) {
		g.setColor(shapeColor);
		g.drawRect(((Rectangle)shape).x,((Rectangle)shape).y, ((Rectangle)shape).width,((Rectangle)shape).height);
		}
	}
	@Override
	public Color getColor() {
		return shapeColor;
	}
	@Override
	public void setColor(Color color) {
		shapeColor = color;
	}
	@Override
	public void setShape(Shape shape) {
		this.shape = (Rectangle)shape;
	}
	@Override
	public void addFirstCoordinates(Point2D point) {
		coordinates.set(0, point);
	}
	@Override
	public void addSecondCoordinates(Point2D point) {
		coordinates.set(1, point);
	}
	@Override
	public void addCurrCoordinates(Point2D point) {
		coordinates.set(1, point);
		Rectangle rect = new Rectangle();
		rect.setFrameFromDiagonal(coordinates.get(0), coordinates.get(1));
		shape=rect;
	}
	@Override
	public List<Point2D> getPoints() {
		return coordinates;
	}
	@Override
	public String getType() {
		return "Rectangle";
	}
	@Override
	public void setCoordinates(List<Point2D> points) {
		addFirstCoordinates(points.get(0));
		addCurrCoordinates(points.get(1));
	}
	@Override
	public boolean isNull() {
		if (this.shape==null) {
			return true;
		}
		return false;
	}

}
