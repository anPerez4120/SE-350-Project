package fp;

import java.awt.Point;

import java.util.Observable;
import java.util.Observer;

/**
 *	Class that observes the ship, and reacts according to it. It tries to get
 *	closer to the ship any time the ship makes a move.
 *	@author Anthony Perez
 */
public class Pirate implements Observer {
	Point shipPosition;
	Point piratePosition;
	OceanMap oceanMap;

	public Pirate(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		// places the pirate at a random position on the map
		piratePosition = oceanMap.placeShip();
	}

	public void movePirate() {
		// each if statement checks to make sure the pirate won't go outside the
		// matrix or on top of an island
		if (piratePosition.x < shipPosition.x && oceanMap.isMountable(piratePosition.x + 1, piratePosition.y))
			piratePosition.x++;
		else if (piratePosition.x > shipPosition.x && oceanMap.isMountable(piratePosition.x - 1, piratePosition.y))
			piratePosition.x--;
		else if (piratePosition.y < shipPosition.y && oceanMap.isMountable(piratePosition.x, piratePosition.y + 1))
			piratePosition.y++;
		else if (piratePosition.y > shipPosition.y && oceanMap.isMountable(piratePosition.x, piratePosition.y - 1))
			piratePosition.y--;
		// pirate algorithm improvement so that it doesn't get stuck
		// if pirate gets stuck it respawns
		else piratePosition = oceanMap.placeShip();
		//if a single island is between the pirate and the ship, it works its way around it
	}

	public Point getPiratePosition() {
		return piratePosition;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Ship) {
			shipPosition = ((Ship) o).getShipLocation();
			movePirate(); // move pirate whenever the ship moves
		}
	}
}
