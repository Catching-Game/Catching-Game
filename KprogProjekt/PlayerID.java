/**
 * This enum represents the ID of a player.
 * 
 * @author simonhoinkis
 * @version 1.0
 */
public enum PlayerID {
	
	FIRST(1), SECOND(2), THIRD(3), FOURTH(4);

    private int value;

    /**
     * set player id.
     * @param value value of this playerid
     */
    private PlayerID(int value) {
            this.value = value;
    }
    
    /**
     * Get value.
     * @return the value of playerid
     */
    public int getValue() {
    	return this.value;
    }
};

