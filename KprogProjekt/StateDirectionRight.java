/**
 * The Direction Right State for our State Pattern.
 * 
 * @author simonhoinkis
 * @version 1.0
 */
public class StateDirectionRight extends State {
	/**
	 * The work method for our State
	 * @param input input of the state
	 * @return the next State
	 */
	public State work(Direction input) {
		State next = null;

		if (input.equals(Direction.RIGHT)) {
			output("Der Uhrzeiger-Drehungstrick naehert sich dem Ende");
			next = TurnContext.DOWN;
		} else {
			next = TurnContext.START;
		}
		
		return next;
	}
}
