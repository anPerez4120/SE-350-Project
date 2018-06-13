package tc;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import fp.ChristopherColumbus;
import fp.OceanMap;

/**
 * Test for the ChristopherColumbus class to see whether its methods work.
 * @author Anthony Perez
 */
public class ChristopherColumbusTest {

	@Test
	public void testGetShipLocation() {
		OceanMap oceanMap = OceanMap.getInstance(10, 10);
		fp.ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		Point toTest = new Point(cc.getShipLocation()); 
		assertTrue(toTest.equals(oceanMap.getShipLocation()));
	}
	
	@Test
	//It makes an empty OceanMap so that the ship can move freely
	//checks to see if the ship does indeed move east
	public void testGoEastMoves(){
		OceanMap oceanMap = OceanMap.getInstance(10, 0);
		fp.ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		cc.goWest(); // to make sure that the ship isn't at the East-most side
		Point lastPosition =  new Point(cc.getShipLocation());
		cc.goEast();
		System.out.println("testGoEastMoves\n" + lastPosition + "\n"+ cc.getShipLocation() + "\n");
		//confirms that the ship went East from its last position
		assertTrue(lastPosition.getX()+1 == cc.getShipLocation().getX() && lastPosition.getY() == cc.getShipLocation().getY());
		
	}
	
	@Test
	//checks to see if the ship does indeed move West
	public void testGoWestMoves(){
		OceanMap oceanMap = OceanMap.getInstance(10, 0);
		fp.ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		cc.goEast(); // to make sure the ship isn't at the West-most side
		Point lastPosition =  new Point(cc.getShipLocation());
		cc.goWest();
		System.out.println("testGoWestMoves\n" + lastPosition + "\n"+ cc.getShipLocation() + "\n");
		assertTrue(lastPosition.getX()-1 == cc.getShipLocation().getX() && lastPosition.getY() == cc.getShipLocation().getY());
	}
	
	@Test
	//checks to see if the ship does indeed move North
	public void testGoNorthMoves(){
		OceanMap oceanMap = OceanMap.getInstance(10, 0);
		fp.ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		cc.goSouth();// to make sure the ship isn't at the North-most side
		Point lastPosition =  new Point(cc.getShipLocation());
		cc.goNorth();
		System.out.println("testGoNorthMoves\n" + lastPosition + "\n"+ cc.getShipLocation() + "\n");
		assertTrue(lastPosition.getX() == cc.getShipLocation().getX() && lastPosition.getY()-1 == cc.getShipLocation().getY());
	}
	
	@Test
	//checks to see if the ship does indeed move South
	public void testGoSouthMoves(){
		OceanMap oceanMap = OceanMap.getInstance(10, 0);
		fp.ChristopherColumbus cc = new ChristopherColumbus(oceanMap);
		cc.goNorth();// to make sure the ship isn't at the South-most side
		Point lastPosition =  new Point(cc.getShipLocation());
		cc.goSouth();
		System.out.println("testGoSouthMoves\n" + lastPosition + "\n"+ cc.getShipLocation() + "\n");
		assertTrue(lastPosition.getX() == cc.getShipLocation().getX() && lastPosition.getY()+1 == cc.getShipLocation().getY());
	}
	
}
