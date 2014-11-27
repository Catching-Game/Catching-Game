
public class Zaehleranzeige {
	
	private int leben;
	private int posX;
	private int posY;
	private String spielerNamen;
	
	public Zaehleranzeige(String name,int leben, int posX, int posY){
		this.leben = leben;
		this.spielerNamen = name;
		Counter count = new Counter(name);
		
		
	}
	
	public void erhoeheLeben(){
		this.leben = leben -1;
	}
	
	public void reduziereLeben(){
		this.leben = leben +1;
	}
	
	public int getLeben(){
		return leben;
	}
	
	public int getX(){
		return posX;
	}
	
	public int getY(){
		return posY;
	}
}
