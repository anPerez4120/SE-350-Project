package fp;

import java.awt.Point;

/**
 * A decorator class for decorating the ship with different functions at runtime
 *
 *	@author Anthony Perez
 */
public abstract class PowerDecorator extends Ship {
	public abstract Point getShipLocation();

	public abstract OceanMap getOceanMap();
}
