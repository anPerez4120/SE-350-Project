package fp;
import java.awt.Point;
import java.util.Observable;

/**
 * Ship is an abstract class that extends observable and sets up the moves
 * @author Anthony Perez
 */
public abstract class Ship extends Observable {
	Point currentLocation;
	OceanMap oceanMap;

	public Point getShipLocation() {
		return currentLocation;
	}

	public OceanMap getOceanMap() {
		return oceanMap;
	}

	public abstract void goEast();

	public abstract void goWest();

	public abstract void goNorth();

	public abstract void goSouth();
}
