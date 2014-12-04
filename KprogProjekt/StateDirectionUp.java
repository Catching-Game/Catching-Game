/**
 * The Direction Up State for our state pattern
 * @author simonhoinkis
 * @version 1.0
 */
public class StateDirectionUp extends State {
	/**
	 * The work method for our State
	 * @param input input of the state
	 * @return the next State
	 */
	public State work(Direction input) {
		State next = null;
		
		if (input.equals(Direction.UP)) {
			output("Der Uhrzeiger-Drehungstrick wurde begonnen");
			next = TurnContext.RIGHT;
		} else {
			next = TurnContext.START;
		}
		
		return next;
	}
}
