package fp;

import java.awt.Point;

/**
 *	Class that extends ship. It has the methods you would expect such as movement 
 *	to the east, west, south, and north.  
 *
 *	@author Anthony Perez
 */
public class ChristopherColumbus extends Ship {

	public ChristopherColumbus(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		this.currentLocation = oceanMap.getShipLocation();
	}

	public Point getShipLocation() {
		return currentLocation;
	}

	public void goEast() {
		// checks to make sure the ship wont go out of bounds or hit an island.
		if (currentLocation.x < oceanMap.getDimensions() - 1
				&& oceanMap.isMountable(currentLocation.x + 1, currentLocation.y)) {
			currentLocation.x++;
		}
		// when ship moves notify the pirate
		setChanged();
		notifyObservers();
	}

	public void goWest() {
		if (currentLocation.x > 0 && oceanMap.isMountable(currentLocation.x - 1, currentLocation.y)) {
			currentLocation.x--;
		}
		setChanged();
		notifyObservers();
	}

	public void goNorth() {
		if (currentLocation.y > 0 && oceanMap.isMountable(currentLocation.x, currentLocation.y - 1)) {
			currentLocation.y--;
		}
		setChanged();
		notifyObservers();
	}

	public void goSouth() {
		if (currentLocation.y < oceanMap.getDimensions() - 1
				&& oceanMap.isMountable(currentLocation.x, currentLocation.y + 1)) {
			currentLocation.y++;
		}
		setChanged();
		notifyObservers();
	}
}
