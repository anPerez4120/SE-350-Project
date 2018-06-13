package fp;

/**
 * State for when the Ship object has landed on the treasure object's space on the grid.
 * Will exit the game and print 'YOU WIN!!!' to the console.
 * 
 * @author Anthony Perez
 */
public class WinState implements State {//WinState implements State interface

	/* (non-Javadoc)
	 * @see fp.State#checkShip(fp.Context)
	 */
	@Override
	public void checkShip(Context context) {//Request handler that takes context and executes a print with 'YOU WIN!!!', launched when the ship hits a treasure object
		// TODO Auto-generated method stub
		System.out.println("YOU WIN!!!");//Prints 'You Win!!!' out to the console
		context.setState(this);//Makes the context's current state the WinState
		System.exit(0);//Exit the game and application
	}
}