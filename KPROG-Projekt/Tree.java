import greenfoot.*;


public class Tree extends Actor{
	
	private static final String TREEIMAGEPATH = XML_Map_Reader.getTreeImage();

	public Tree(int cellSize)
	{
	//	setUpImage(cellSize);
	}
	
	/**
	 * Set up the Image from the Tree in the World
	 * @param cellSize
	 *
	private void setUpImage(int cellSize)
	{
		GreenfootImage image = new GreenfootImage(TREEIMAGEPATH);
		image.scale(cellSize,cellSize);
		this.setImage(image);
		
	}
	*/
	
	/**
	 * 
	 * @return String ImagePath
	 */
	public String getTreeImagePath()
	{
		return TREEIMAGEPATH;
	}
	
	public void act()
	{
		
	}
}
