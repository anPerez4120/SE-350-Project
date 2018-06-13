package fp;

/**
 * State interface that is used by several states, taking the checkShip operation
 * and performing specific functionality depending on the state being used.
 * 
 * @author Anthony Perez
 */
public interface State {//Public interface State
	public void checkShip(Context context);//Request that takes a context object and executes based on the state being called.
}