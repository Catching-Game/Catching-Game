/**
 * This class is an extended Position that means it also has a direction
 * @author simonhoinkis
 * @version 1.0
 */
public class PositionWithDirection extends Position{
	private Direction dir;
	
	/**
	 * Constructor of PositionWithDirection
	 * @param posX x position 
	 * @param posY y position
	 * @param dir direction
	 */
	PositionWithDirection(int posX, int posY, Direction dir) {
		super(posX, posY);
		this.setDir(dir);
	}

	/**
	 * Returns the direction
	 * @return The direction
	 */
	public Direction getDir() {
		return dir;
	}

	/**
	 * Sets a direction
	 * @param dir The direction to be set
	 */
	public void setDir(Direction dir) {
		this.dir = dir;
	}

	/**
	 * Returns the Status of the PositionWithDirection Object
	 * @return Status of the object
	 */
	@Override
	public String toString() {
		return "PositionWithDirection [dir=" + dir + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
