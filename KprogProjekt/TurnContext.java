/**
 * Our State Pattern Context, this class holds every state and provides a fully working system.
 * 
 * the player can do a trick which is shown in the terminal if he successfully made this trick
 * he has to walk up, right, down and then left to do this trick.
 * 
 * only for brave players because a hound can eat you when u do this in the center of the map
 * 
 * @author simonhoinkis
 * @version 1.0
 */
public class TurnContext {
	/**
	 * The Up state of the class.
	 */
	public static final State UP = new StateDirectionUp();
	
	/**
	 * The right state of the class.
	 */
	public static final State RIGHT = new StateDirectionRight();
	
	/**
	 * The down state of the class.
	 */
	public static final State DOWN = new StateDirectionDown();
	
	/**
	 * the left state of the class.
	 */
	public static final State LEFT = new StateDirectionLeft();
	
	/**
	 * The start state of the class.
	 */
	public static final State START = UP;
	
	/**
	 * This is holding the current state our state machine is holding.
	 */
	private State currentState = TurnContext.START;
	
	/**
	 * This is a small difference to the do while loops that were shown in the lectures.
	 * It also has a input and the same currentState.work thing but its not a loop it works
	 * step by step when called externally.
	 * 
	 * @param input The Direction a player takes and walks
	 */
	public void step(Direction input) {
		currentState = currentState.work(input);
	}
}
