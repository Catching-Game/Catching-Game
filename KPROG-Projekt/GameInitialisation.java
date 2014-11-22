
public class GameInitialisation {

	private GameWorld world;
	
	
	public static void main(String[] args) 
	{
		GameInitialisation gi = new GameInitialisation;
		gi.initMap();

	}
	
	private void initMap()
	{
		world = new Gameworld();
	}
}
