package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class EllipseShape extends BaseShape {
	private List<Point2D> coordinates;
	private Color shapeColor;
	private Shape shape=null;
	public EllipseShape(){
		this.coordinates = new ArrayList<Point2D>();
		coordinates.add(new Point2D.Double (0,0));
		coordinates.add(new Point2D.Double (0,0));
	}
	@Override
	public void drawShape(Graphics g) {
		g.setColor(shapeColor);
		g.drawOval((int)(((Ellipse2D.Double)shape).x),(int)(((Ellipse2D.Double)shape).y), (int)(((Ellipse2D.Double)shape).width),(int)(((Ellipse2D.Double)shape).height));
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
		this.shape = (Ellipse2D)shape;
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
		Ellipse2D elip = new Ellipse2D.Double();
		elip.setFrameFromDiagonal(coordinates.get(0), coordinates.get(1));
		shape=elip;
	}
	@Override
	public List<Point2D> getPoints() {
		return coordinates;
	}
	@Override
	public String getType() {
		return "Ellipse";
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