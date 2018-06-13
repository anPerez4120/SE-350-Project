package fp;

/**
 * State for when the Ship object has run into a Pirate or Monster object's space on the grid.
 * Will exit the game and print 'GAME OVER' to the console.
 * 
 * @author Anthony Perez
 */
public class StopState implements State {//StopState implements State interface and is used when game has ended in a loss

	@Override
	public void checkShip(Context context) {//Request handler that takes context and executes a print with 'GAME OVER', launched when the ship hits a Monster or Pirate object
		// TODO Auto-generated method stub
		System.out.println("GAME OVER");//Prints 'GAME OVER' to the console.
		context.setState(this);//Makes the context's current state the StopState
		System.exit(0);//Exit the game and application
	}
}