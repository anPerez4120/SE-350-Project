package fp;

/**
 * State that lets the player know via a print to the console that their Ship 
 * is moving through the OceanMap and the game is functioning properly.
 * 
 * @author Anthony Perez
 */
public class MoveState implements State {//MoveState implements the State interface

	/* (non-Javadoc)
	 * @see fp.State#checkShip(fp.Context)
	 */
	@Override
	public void checkShip(Context context) {//Request handler that prints 'Columbus moves and the Pirates draw closer!' every time the ship object moves
		// TODO Auto-generated method stub
		System.out.println("Columbus moves and the Pirates draw closer!");//Prints 'Columbus moves and the Pirates draw closer!' out to the console
		context.setState(this);//Makes the context's current state the MoveState
	}

}