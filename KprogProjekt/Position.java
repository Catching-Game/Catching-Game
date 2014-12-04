/**
 * this class handles positions in or project (X_Position and Y_Position).
 * 
 * @author simonhoinkis
 * @version 1.0
 */
public class Position {
	
	private int x;
	private int y;
	
	/**
	 * Constructor of class position.
	 * @param y the y position of the object
	 * @param y the y position of the object
	 */
	Position (int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the x position.
	 * @return The x position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets a new x position.
	 * @param x New x position
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the y position.
	 * @return The y position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y position.
	 * @param posY the y position
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns the status of an position object.
	 * @return Status of the object
	 */
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
}
