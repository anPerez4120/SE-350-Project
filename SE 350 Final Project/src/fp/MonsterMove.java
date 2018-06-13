package fp;

/**
 * Abstract Super class that serves as the Template design Pattern and delegates
 * the definition of the move() method to two concrete Monster classes:
 * Monster and Monster2.
 * 
 * @author Anthony Perez
 */
public abstract class MonsterMove {//Abstract Super class MonsterMove serves as Template for the move() method
	/**
	 * Abstract move method that is implemented by Monster and Monster2 for a vertical
	 * and horizontal move respectfully.
	 */
	public abstract void move();//Abstract move method that is implemented by Monster and Monster2 for a vertical and horizontal move respectfully.
}
