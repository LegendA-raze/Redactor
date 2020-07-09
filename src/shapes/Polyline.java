package shapes;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.List;

public class Polyline{
	private List<Point2D> coordinates;
	Polyline(){
		this.coordinates = new ArrayList<Point2D>();
	}
	public int[] getX() {
		int[] m = new int [this.coordinates.size()];
		for(int i=0;i<this.coordinates.size();i++) {
			m[i]=(int) this.coordinates.get(i).getX();
		}
		return m;
	}
	
	public int[] getY() {
		int[] m = new int [this.coordinates.size()];
		for(int i=0;i<this.coordinates.size();i++) {
			m[i]=(int) this.coordinates.get(i).getY();
		}
		return m;
	}
	public int size() {
		return this.coordinates.size();
	}
	public void addCoordinates(Point2D point) {
		this.coordinates.add(point);
	}
	public void addCurrCoordinates(Point2D point) {
		this.coordinates.set(coordinates.size()-1, point);
	}
	public List<Point2D> getPoints() {
		return coordinates;
	}
}
