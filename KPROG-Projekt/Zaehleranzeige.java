import java.util.*;


public class Zaehleranzeige extends Observable {
	
	private int anzeige;
	private int posX;
	private int posY;
	private String spielerNamen;
	private Counter count;
	
	public Zaehleranzeige(String name,int leben, int posX, int posY){
		this.anzeige = leben;
		this.spielerNamen = name;
		//count = new Counter(name,leben);
		//this.addObserver(count);
		this.posX = posX;
		this.posY = posY;
		
	}
	
	public int getX(){
		return posX;
	}
	
	public int getY(){
		return posY;
	}
	
	public void setAnzeige(int newValue){
		this.anzeige = newValue;
		count.erhoehen(newValue);
	}
	
	public Counter getCounter(){
		return count;
	}
	
	/*
	 * Change anzeige and notifies observers
	 */
	public void changeAnzeige(){
		this.anzeige++;	
		notifyObservers(this.anzeige);
	}
	
	/*
	 * Define Object as changed and notifies observers
	 */
	void notifyObservers(int life){
		setChanged();
		super.notifyObservers(life);
	}
	
	public String getPlayerName(){
		return this.spielerNamen;
	}
	
	

}
