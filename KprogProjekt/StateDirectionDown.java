/**
 * The state DirectionDown for the State Pattern
 * @author simonhoinkis
 * @version 1.0
 */
public class StateDirectionDown extends State {
	/**
	 * The work method for our State
	 * @param input input of the state
	 * @return the next State
	 */
	public State work(Direction input) {
		State next = null;
		
		if (input.equals(Direction.DOWN)) {
			output("Der Uhrzeiger-Drehungstrick ist fast fertig");
			next = TurnContext.LEFT;
		} else {
			next = TurnContext.START;
		}
		
		return next;
	}
}
