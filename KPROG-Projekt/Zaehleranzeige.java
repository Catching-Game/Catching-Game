import java.util.*;


public class Zaehleranzeige {
	
	private int anzeige;
	private int posX;
	private int posY;
	private String spielerNamen;
	private Counter count;
	
	public Zaehleranzeige(String name,int leben, int posX, int posY){
		this.anzeige = leben;
		this.spielerNamen = name;
		count = new Counter(name,leben);
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
	

}
