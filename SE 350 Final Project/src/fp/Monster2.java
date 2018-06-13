package fp;

import java.awt.Point;

/**
 * Second Concrete Monster Class which extends MonsterMove and 
 * utilizes the Template method to extend the base move method from the template
 * MonsterMove to be implemented uniquely in each Monster concrete class.
 * Monster uses move to do a horizontal move. 
 * 
 * @author Anthony Perez
 */
public class Monster2 extends MonsterMove {//Monster2 uses the template move from the super class MonsterMove
	boolean movingRight = true;//boolean to determine when the monster2 is moving right.
	Point monsterPosition2;//the monster2's current position
	OceanMap oceanMap;//the oceanMap shared by all classes

	/**
	 * Default constructor for the Monster2 object which sets the oceanMap it is on and 
	 * it's current position
	 * 
	 * @param oceanMap The shared OceanMap object
	 */
	public Monster2(OceanMap oceanMap) {
		this.oceanMap = oceanMap;//Ties the monster2 object to the oceanMap used in the game 
		this.monsterPosition2 = oceanMap.getMonsterLocation2();//Sets current monster2 position to where it is located on the oceanMap
	}

	/**
	 * Returns the Monster2 object's current position
	 * 
	 * @return the Monster2 object's current position
	 */
	public Point getMonsterPosition2() {//Point position of the Monster2 object
		return monsterPosition2;//Monster2's current position
	}

	/* (non-Javadoc)
	 * @see fp.MonsterMove#move()
	 */
	@Override
	public void move() {
		// TODO Auto-generated method stub
		int monsterLocation2X = (int) oceanMap.getMonsterLocation2().getX();//gets current Monster2 object location's x coordinate
		int monsterLocation2Y = (int) oceanMap.getMonsterLocation2().getY();//gets current Monster2 object location's y coordinate
		if (monsterLocation2X < oceanMap.getDimensions() - 1 && oceanMap.isMountable(monsterLocation2X + 1, monsterLocation2Y) && movingRight == true) {//makes sure monster2 can move right and that it is a valid ocean space
			oceanMap.getMonsterLocation2().setLocation(monsterLocation2X + 1, monsterLocation2Y);//sets new monster2 location on the oceanMap
			monsterLocation2X = (int) oceanMap.getMonsterLocation2().getX();//resets the x variable with the new x location of the Monster2 object
			if (monsterLocation2X == oceanMap.dimensions - 1 || !oceanMap.isMountable(monsterLocation2X + 1, monsterLocation2Y)) {//checks to see if the Monster2 no longer has a valid space it can move right to
				movingRight = false;//changes the boolean so the monster knows it now has to move left
			}
		} 
		else if (monsterLocation2X < oceanMap.getDimensions() && oceanMap.isMountable(monsterLocation2X - 1, monsterLocation2Y)) {//makes sure monster2 can move left and that it is a valid ocean space
			oceanMap.getMonsterLocation2().setLocation(monsterLocation2X - 1, monsterLocation2Y);//sets new monster2 location on the oceanMap
			monsterLocation2X = (int) oceanMap.getMonsterLocation2().getX();//resets the x variable with the new x location of the Monster2 object
			if (monsterLocation2X == 0 || !oceanMap.isMountable(monsterLocation2X - 1, monsterLocation2Y)) {//checks to see if the Monster2 no longer has a valid space it can move left to
				movingRight = true;//changes the boolean so the monster knows it now has to move right
			}
		}
	}
}