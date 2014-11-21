 

/**
 * This class is an extended Position that means it also has a direction
 * @author simonhoinkis
 *
 */
public class PositionWithDirection extends Position{
	private Direction dir;
	
	PositionWithDirection(int posX, int posY, Direction dir) {
		super(posX, posY);
		this.setDir(dir);
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
}
