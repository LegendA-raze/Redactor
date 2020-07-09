package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class PolygonShape extends BaseShape {	
	private Color shapeColor;
	private Polygon shape=null;
	public PolygonShape(){
		this.shape=new Polygon();
	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(shapeColor);
		g.drawPolygon(shape);	
	}
	@Override
	public Color getColor() {
		return this.shapeColor;
	}
	@Override
	public void setColor(Color color) {
		this.shapeColor=color;	
	}
	@Override
	public void setShape(Shape shape) {
		this.shape=(Polygon) shape;
	}
	@Override
	public void addCurrCoordinates(Point2D point) {	
	}
	@Override
	public List<Point2D> getPoints() {
		int[] x = shape.xpoints;
		int[] y = shape.ypoints;
		List<Point2D> points = new ArrayList<Point2D>();
		for(int i=0;i<shape.npoints;i++) {
			points.add(new Point2D.Double(x[i],y[i]));
		}
		return points;
	}
	@Override
	public String getType() {
		return "Polygon";
	}
	@Override
	public void setCoordinates(List<Point2D> points) {
		for(int i = 0 ;i < points.size();i++) {
			addFirstCoordinates(points.get(i));
		}	
	}
	@Override
	public void addFirstCoordinates(Point2D point) {
		shape.addPoint((int)point.getX(), (int)point.getY());
	}
	@Override
	public void addSecondCoordinates(Point2D point) {
	}	
	@Override
	public boolean isNull() {
		if (this.shape==null) {
			return true;
		}
		return false;
	}
}
