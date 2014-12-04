/**
 * This enumeration represents the directions objects in the game can have
 * @author simonhoinkis
 * @version 1.0
 */
public enum Direction {UP, DOWN, LEFT, RIGHT, NONE;
	

	public boolean equals(Direction dir) {
		return (this.compareTo(dir) == 0);
	}
}; 