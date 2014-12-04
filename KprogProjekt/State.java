/**
 * The State of the state pattern
 * @author simonhoinkis
 * @version 1.0
 */
public abstract class State {
	abstract public State work(Direction dir);
	
	/**
	 * prints a text
	 * @param out the text
	 */
    protected void output(String out){  
        System.out.println (out);
    }
}
