package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.List;


public class PolylineShape extends BaseShape {	
	private Color shapeColor;
	private Polyline shape=null;
	public PolylineShape(){
		this.shape = new Polyline();
	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(shapeColor);
		g.drawPolyline(shape.getX(),shape.getY(),shape.size());
	}
	@Override
	public Color getColor() {
		return shapeColor;
	}
	@Override
	public void setColor(Color color) {
		this.shapeColor=color;
	}
	@Override
	public void setShape(Shape shape) {
		this.shape=(Polyline) shape;
	}
	@Override
	public void addFirstCoordinates(Point2D point) {
		this.shape.addCoordinates(point);
	}
	@Override
	public void addSecondCoordinates(Point2D point) {
		this.shape.addCoordinates(point);
	}
	@Override
	public void addCurrCoordinates(Point2D point) {
		this.shape.addCurrCoordinates(point);
	}
	@Override
	public List<Point2D> getPoints() {
		return shape.getPoints();
	}
	@Override
	public String getType() {
		return "Polyline";
	}
	@Override
	public void setCoordinates(List<Point2D> points) {
		for(int i = 0 ;i < points.size()-1;i++) {
			addFirstCoordinates(points.get(i));
		}
		addCurrCoordinates(points.get(points.size()-1));
	}
	
	@Override
	public boolean isNull() {
		if (this.shape==null) {
			return true;
		}
		return false;
	}
}
