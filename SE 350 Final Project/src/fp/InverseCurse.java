package fp;

import java.awt.Point;

/**
 * Decorates the ship with new feature during runtime. Now the ship
 * will go the opposite direction of the key one presses.
 *
 * @author Anthony Perez
 */
public class InverseCurse extends PowerDecorator {
	Ship ship;

	public InverseCurse(Ship ship) {
		this.ship = ship;
	}

	public Point getShipLocation() {
		return ship.getShipLocation();
	}

	@Override
	public OceanMap getOceanMap() {
		return ship.getOceanMap();
	}
	
	//when goWest() is called it goes East instead, InverseCurse!!! 
	public void goWest() {
		// checks to make sure the ship wont go out of bounds or hit an island.
		if (getShipLocation().x < getOceanMap().getDimensions() - 1
				&& getOceanMap().isMountable(getShipLocation().x + 1, getShipLocation().y)) {
			getShipLocation().x++;
		}
		// when ship moves notify the pirate
		setChanged();
		notifyObservers();
	}

	//when goEast() is called it goes West instead, InverseCurse!!! 
	public void goEast() {
		if (getShipLocation().x > 0 && getOceanMap().isMountable(getShipLocation().x - 1, getShipLocation().y)) {
			getShipLocation().x--;
		}
		setChanged();
		notifyObservers();
	}

	//when goSouth() is called it goes North instead, InverseCurse!!! 
	public void goSouth() {
		if (getShipLocation().y > 0 && getOceanMap().isMountable(getShipLocation().x, getShipLocation().y - 1)) {
			getShipLocation().y--;
		}
		setChanged();
		notifyObservers();
	}

	//when goNorth() is called it goes South instead, InverseCurse!!! 
	public void goNorth() {
		if (getShipLocation().y < getOceanMap().getDimensions() - 1
				&& getOceanMap().isMountable(getShipLocation().x, getShipLocation().y + 1)) {
			getShipLocation().y++;
		}
		setChanged();
		notifyObservers();
	}
}
