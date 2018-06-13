package fp;

/**
 * State that lets the player know via a print to the console that their Ship has received
 * the Speed Boost power-up granted by our decorator.
 * 
 * @author Anthony Perez
 */
public class PowerState implements State {//PowerState that implements the State interface

	/* (non-Javadoc)
	 * @see fp.State#checkShip(fp.Context)
	 */
	@Override
	public void checkShip(Context context) {//Request handler that takes context and executes a print with 'Powered Up Speeeeeed BOOOOST!!!', launched when the ship hits the speed boost power up object location
		// TODO Auto-generated method stub
		System.out.println("Powered Up Speeeeeed BOOOOST!!!");//Prints 'Powered Up Speeeeeed BOOOOST!!!' out to the console
		context.setState(this);//Makes the context's current state the PowerState
	}

}