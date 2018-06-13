package fp;

/**
 * Context which holds the current State and also allows for setting and getting
 * of different states
 * 
 * @author Anthony Perez
 */
public class Context {//Context class that handles states
	private State state;//initial state

	/**
	 * Context constructor
	 */
	public Context() {//Context constructor
		state = null;//sets initial state to null
	}

	/**
	 * Method that takes a state and makes it the context's current state
	 * 
	 * @param state State to have actions performed on
	 */
	public void setState(State state) {//setState method
		this.state = state;//sets the context state to the given state to this method
	}

	/**
	 * Method that gets and returns the current state in context
	 * 
	 * @return current state
	 */
	public State getState() {//gets current state in context
		return state;//returns current state in context
	}
}
