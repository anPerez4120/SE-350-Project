package fp;

/**
 * State that lets the player know via a print to the console that their Ship has received
 * the Inverse Curse disadvantage granted by the decorator.
 * 
 * @author Anthony Perez
 */
public class CurseState implements State {//CurseState implements the State interface

	/* (non-Javadoc)
	 * @see fp.State#checkShip(fp.Context)
	 */
	@Override
	public void checkShip(Context context) {//Request handler that prints out 'You have been cursed!!!' when the ship lands on the Inverse Curse object
		System.out.println("You have been cursed!!!");// Prints 'You have been cursed!!!' out to the console
		context.setState(this);//Makes the context's current state the CurseState
	}
}