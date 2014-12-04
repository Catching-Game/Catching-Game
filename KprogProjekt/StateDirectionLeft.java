/**
 * The State Direction Left for our State pattern.
 * 
 * @author simonhoinkis
 * @version 1.0
 */
public class StateDirectionLeft extends State {
	/**
	 * The work method for our State
	 * @param input input of the state
	 * @return the next State
	 */
	public State work(Direction input) {
		State next = null;
		
		if (input.equals(Direction.LEFT)) {
			output("Der Uhrzeiger-Drehungstrick wurde vollzogen");
			next = TurnContext.START;
		} else {
			next = TurnContext.START;
		}
		
		return next;
	}
}
