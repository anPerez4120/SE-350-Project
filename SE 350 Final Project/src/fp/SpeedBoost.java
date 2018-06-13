package fp;

import java.awt.Point;

/**
 * 	A class that extends PowerDecorator to decorate the ship with a speed boost 
 * 	during the runtime. With it the ship will move twice as quickly.
 * 
 *	@author Anthony Perez
 */
public class SpeedBoost extends PowerDecorator {
	Ship ship;

	public SpeedBoost(Ship ship) {
		this.ship = ship;
	}

	@Override
	public Point getShipLocation() {
		return ship.getShipLocation();
	}

	@Override
	public OceanMap getOceanMap() {
		return ship.getOceanMap();
	}
	
	public void goEast() {
		// checks to make sure the ship wont go out of bounds or hit an island.
		if (getShipLocation().x < getOceanMap().getDimensions() - 2
				&& getOceanMap().isMountable(getShipLocation().x + 1, getShipLocation().y)
				&& getOceanMap().isMountable(getShipLocation().x + 2, getShipLocation().y)) {
			getShipLocation().x += 2;
		} else if (getShipLocation().x < getOceanMap().getDimensions() - 1
				&& getOceanMap().isMountable(getShipLocation().x + 1, getShipLocation().y)) {
			getShipLocation().x++;
		}
		// when ship moves notify the pirate
		setChanged();
		notifyObservers();
	}

	public void goWest() {
		// checks to make sure the ship wont go out of bounds or hit an island.
		if (getShipLocation().x > 1 && getOceanMap().isMountable(getShipLocation().x - 1, getShipLocation().y)
				&& getOceanMap().isMountable(getShipLocation().x - 2, getShipLocation().y)) {
			getShipLocation().x -= 2;
		} else if (getShipLocation().x > 0 && getOceanMap().isMountable(getShipLocation().x - 1, getShipLocation().y)) {
			getShipLocation().x--;
		}
		// when ship moves notify the pirate
		setChanged();
		notifyObservers();
	}

	public void goNorth() {
		// checks to make sure the ship wont go out of bounds or hit an island.
		if (getShipLocation().y > 1 && getOceanMap().isMountable(getShipLocation().x, getShipLocation().y - 2)
				&& getOceanMap().isMountable(getShipLocation().x, getShipLocation().y - 1)) {
			getShipLocation().y -= 2;
		} else if (getShipLocation().y > 0 && getOceanMap().isMountable(getShipLocation().x, getShipLocation().y - 1)) {
			getShipLocation().y--;
		}
		// when ship moves notify the pirate
		setChanged();
		notifyObservers();
	}

	public void goSouth() {
		// checks to make sure the ship wont go out of bounds or hit an island.
		if (getShipLocation().y < getOceanMap().getDimensions() - 2
				&& getOceanMap().isMountable(getShipLocation().x, getShipLocation().y + 2)
				&& getOceanMap().isMountable(getShipLocation().x, getShipLocation().y + 1)) {
			getShipLocation().y += 2;
		} else if (getShipLocation().y < getOceanMap().getDimensions() - 1
				&& getOceanMap().isMountable(getShipLocation().x, getShipLocation().y + 1)) {
			getShipLocation().y++;
		}
		// when ship moves notify the pirate
		setChanged();
		notifyObservers();
	}
}
