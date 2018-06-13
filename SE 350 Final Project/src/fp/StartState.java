package fp;

/**
 * State that lets the Player know the game and application has successfully launched
 * and is ready to be run.
 * 
 * @author Anthony Perez
 */
public class StartState implements State {//StartState implements the State interface

	/* 
	 * @see fp.State#checkShip(fp.Context)
	 */
	@Override
	public void checkShip(Context context) {//Request handler that prints out 'Columbus sails the ocean blue and is after treasure!' to indicate the game has started
		// TODO Auto-generated method stub
		System.out.println("Columbus sails the ocean blue and is after treasure!");//Prints 'Columbus sails the ocean blue and is after treasure!' out to the console
		context.setState(this);//Makes the context's current state the StartState
	}
}