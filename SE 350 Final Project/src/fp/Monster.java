package fp;

import java.awt.Point;

/**
 * First Concrete Monster Class which extends MonsterMove and 
 * utilizes the Template method to extend the base move method from the template
 * MonsterMove to be implemented uniquely in each Monster concrete class.
 * Monster uses move to do a vertical move. 
 * 
 * @author Anthony Perez
 */
public class Monster extends MonsterMove {//Monster uses the template move from the super class MonsterMove
	boolean movingDown = true;//boolean to determine when the monster is moving down.
	Point monsterPosition;//the monster's current position
	OceanMap oceanMap;//the oceanMap shared by all classes

	/**
	 * Default constructor for the Monster object which sets the oceanMap it is on and 
	 * it's current position
	 * 
	 * @param oceanMap The shared OceanMap object
	 */
	public Monster(OceanMap oceanMap) {
		this.oceanMap = oceanMap;//Ties the monster object to the oceanMap used in the game 
		this.monsterPosition = oceanMap.getMonsterLocation();//Sets current monster position to where it is located on the oceanMap
	}

	/**
	 * Returns the Monster object's current position
	 * 
	 * @return the Monster object's current position
	 */
	public Point getMonsterPosition() {//Point position of the Monster object
		return monsterPosition;//Monster's current position
	}

	/* (non-Javadoc)
	 * @see fp.MonsterMove#move()
	 */
	@Override
	public void move() {//move method override from the template in MonsterMove
		// TODO Auto-generated method stub
		int monsterLocationX = (int) oceanMap.getMonsterLocation().getX();//gets current Monster object location's x coordinate
		int monsterLocationY = (int) oceanMap.getMonsterLocation().getY();//gets current Monster object location's y coordinate
		if (monsterLocationY < oceanMap.getDimensions() - 1 && oceanMap.isMountable(monsterLocationX, monsterLocationY + 1) && movingDown == true) {//makes sure monster can move down and that it is a valid ocean space
			oceanMap.getMonsterLocation().setLocation(monsterLocationX, monsterLocationY + 1);//sets new monster location on the oceanMap
			monsterLocationY = (int) oceanMap.getMonsterLocation().getY();//resets the y variable with the new y location of the Monster object
			if (monsterLocationY == oceanMap.dimensions - 1 || !oceanMap.isMountable(monsterLocationX, monsterLocationY + 1)) {//checks to see if the Monster no longer has a valid space it can move down to
				movingDown = false;//changes the boolean so the monster knows it now has to move up
			}
		} else if (monsterLocationY < oceanMap.getDimensions() && oceanMap.isMountable(monsterLocationX, monsterLocationY - 1)) {//makes sure monster can move up and that it is a valid ocean space
			oceanMap.getMonsterLocation().setLocation(monsterLocationX, monsterLocationY - 1);//sets the new monster location on the oceanMap
			monsterLocationY = (int) oceanMap.getMonsterLocation().getY();//resets the y variable with the new y location of the Monster object
			if (monsterLocationY == 0 || !oceanMap.isMountable(monsterLocationX, monsterLocationY - 1)) {//checks to see if the Monster no longer has a valid space it can move up to
				movingDown = true;//changes the boolean so the monster knows it now has to move down
			}
		}
	}
}