package tc;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import fp.Monster;
import fp.OceanMap;

/**
 * Monster concrete class test cases that test the monster object being properly placed 
 * on the oceanMap and also that the monster moves properly on the oceanMap.
 * 
 * @author Anthony Perez
 */
public class MonsterTest {//Monster object test cases

	
	//Tests if the monster object is properly placed on the oceanMap
	@Test
	public void testGetMonsterPosition() {//Monster placement test
		OceanMap oceanMap = OceanMap.getInstance(10,10);//instantiates a test OceanMap
		fp.Monster monster = new Monster(oceanMap);//creates a monster to test
		assertEquals(monster.getMonsterPosition(), oceanMap.getMonsterLocation());//asserts that the monster object's position is the same as where it is in the oceanMap
	}

	//Tests if the monster can properly move within the oceanMap	 
	@Test
	public void testMove(){//Monster move test
		OceanMap oceanMap = OceanMap.getInstance(10,0);//instantiates a test OceanMap
		fp.Monster monster = new Monster(oceanMap);//creates a monster to test
		Point toTest = new Point(monster.getMonsterPosition());//stores the location of the initial spawning point of the monster
		monster.move();//tries to move monster
		assertTrue(toTest!=monster.getMonsterPosition());//makes sure the initial position has changed and that the monster has moved
		monster.move();//tries to move monster
		monster.move();//tries to move monster
		assertEquals(monster.getMonsterPosition(), oceanMap.getMonsterLocation());//asserts that the monster object's position is the same as where it is in the oceanMap
	}

	
	//Tests if the monster is moving vertically as it should
	@Test
	public void testMoveVertical() {
		OceanMap oceanMap = OceanMap.getInstance(10,0);//instantiates a test OceanMap
		fp.Monster monster = new Monster(oceanMap);//creates a monster to test
		Point toTest = new Point(monster.getMonsterPosition());//stores the location of the initial spawning point of the monster
		monster.move();//tries to move monster
		assertTrue(toTest.getX()==monster.getMonsterPosition().getX());//asserts monster  hasn't moved vertically
		assertTrue(toTest.getY()+1==monster.getMonsterPosition().getY() || toTest.getY()-1==monster.getMonsterPosition().getY());//asserts monster has moved vertically
	}
}
