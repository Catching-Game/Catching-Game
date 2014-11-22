import java.util.ArrayList;


public class GameInitialisation {

	private GameWorld world;
	private static ArrayList<Wall> wallList;
	
	
	public static void main(String[] args) 
	{
		GameInitialisation gi = new GameInitialisation();
		gi.initMap();
		gi.setWallLocations();

	}
	
	private void initMap()
	{
		world = new GameWorld();
	}
	//Hier war ich !!!! =) 
    public void setWallLocations()
    {
    	wallList = new ArrayList<Wall>();
    	
        for(Position position : XML_Map_Reader.getWallPositions())
        {
            Wall wall = new Wall();
        	wallList.add(wall);
        	wall.setLocation(position.getPosX(),position.getPosY());
        	wall.addedToWorld(world);
        }
    }
}
