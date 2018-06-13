package tc;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import fp.Monster2;
import fp.OceanMap;

/**
 * Monster2 concrete class test cases that test the monster2 object being properly placed 
 * on the oceanMap and also that the monster2 moves properly on the oceanMap.
 * 
 * @author Anthony Perez
 */
public class Monster2Test {//Monster2 object test cases

	/**
	 * Tests if the monster2 object is properly placed on the oceanMap
	 */
	@Test
	public void testGetMonster2Position() {//Monster2 placement test
		OceanMap oceanMap = OceanMap.getInstance(10,10);//instantiates a test OceanMap
		fp.Monster2 monster2 = new Monster2(oceanMap);//creates a monster2 to test
		assertEquals(monster2.getMonsterPosition2(), oceanMap.getMonsterLocation2());//asserts that the monster2 object's position is the same as where it is in the oceanMap
	}

	/**
	 * Tests if the monster2 can properly move within the oceanMap
	 */
	@Test
	public void testMove2(){//Monster2 move test
		OceanMap oceanMap = OceanMap.getInstance(10,0);//instantiates a test OceanMap
		fp.Monster2 monster2 = new Monster2(oceanMap);//creates a monster2 to test
		Point toTest = new Point(monster2.getMonsterPosition2());//stores the location of the initial spawning point of the monster2
		monster2.move();//tries to move monster2
		assertTrue(toTest!=monster2.getMonsterPosition2());
		monster2.move();//tries to move monster2
		monster2.move();//tries to move monster2
		assertEquals(monster2.getMonsterPosition2(), oceanMap.getMonsterLocation2());//asserts that the monster2 object's position is the same as where it is in the oceanMap
	}
	
	
	/**
	 * Tests if the monster2 is moving horizontally as it should
	 */
	@Test
	public void testMoveHorizontal() {
		OceanMap oceanMap = OceanMap.getInstance(10,0);//instantiates a test OceanMap
		fp.Monster2 monster2 = new Monster2(oceanMap);//creates a monster2 to test
		Point toTest = new Point(monster2.getMonsterPosition2());//stores the location of the initial spawning point of the monster2
		monster2.move();//tries to move monster2
		assertTrue(toTest.getY()==monster2.getMonsterPosition2().getY());//asserts monster 2 hasn't moved vertically
		assertTrue(toTest.getX()+1==monster2.getMonsterPosition2().getX() || toTest.getX()-1 == monster2.getMonsterPosition2().getX());//asserts monster 2 has moved horizontally
	}
}