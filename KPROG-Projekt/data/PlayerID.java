/**
 * This enum represents the ID of a player
 * @author simonhoinkis
 *
 */
public enum PlayerID {
	FIRST(1), SECOND(2), THIRD(3), FOURTH(4);

    private int value;

    private PlayerID(int value) {
            this.value = value;
    }
};
