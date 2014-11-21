/**
 * this class handles positions in or project (X_Position and Y_Position)
 * @author simonhoinkis
 * @version 1.0
 */
public class Position {
	private int posX;
	private int posY;
	
	/**
	 * Constructor of class position
	 * @param posX the y position of the object
	 * @param posY the y position of the object
	 */
	Position (int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * Returns the x position
	 * @return The x position
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Sets a new x position
	 * @param posX New x position
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Returns the y position
	 * @return The y position
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Sets the y position
	 * @param posY the y position
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Returns the status of an position object
	 * @return Status of the object
	 */
	@Override
	public String toString() {
		return "Position [posX=" + posX + ", posY=" + posY + "]";
	}
}
