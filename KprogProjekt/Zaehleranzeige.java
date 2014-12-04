import java.util.*;

/**
 * Collects lifes from player to make them Observable.
 * @author Heiko & Maximilian Schmidt
 */
public class Zaehleranzeige extends Observable {
	private int anzeige;
	private String spielerNamen;
	private Counter pointViewer;
	public Zaehleranzeige(String name,int lifes, GameWorld gw, PlayerID playerID){
		this.anzeige = lifes;
		this.spielerNamen = name;
		pointViewer = new Counter(name,lifes);
		this.addObserver(pointViewer);
		gw.addObject(pointViewer, XMLMapReader.getCounterPosition(playerID).getX(),XMLMapReader.getCounterPosition(playerID).getY() );
	}
	/**
	 * Change anzeige and notifies observers.
	 */
	public void changeAnzeige(int lifes){
		this.notifyObservers(lifes);
	}
	/**
	 * Define Object as changed and notifies observers.
	 */
	void notifyObservers(int lifes){
		setChanged();
		super.notifyObservers(lifes);
	}
        /**
         * get player name from player.
         * @return 
         */
	public String getPlayerName(){
		return this.spielerNamen;
	}
}
