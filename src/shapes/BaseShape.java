package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.List;

public abstract class BaseShape{
	abstract public void drawShape(Graphics g);
	abstract public Color getColor();
	abstract public void setColor(Color color);
	abstract public void setShape(Shape shape);
	abstract public void addFirstCoordinates(Point2D point);
	abstract public void addSecondCoordinates(Point2D point);
	abstract public void addCurrCoordinates(Point2D point);
	abstract public List<Point2D> getPoints();
	abstract public String getType();
	abstract public void setCoordinates(List<Point2D> points);
	abstract public boolean isNull();
}
