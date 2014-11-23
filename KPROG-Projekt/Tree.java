import greenfoot.*;


public class Tree extends Actor{
	
	private Static final String TREEIMAGEPATH = XML_Map_Reader.getTreeImage();

	public Tree(int cellSize)
	{
		setUpImage(cellSize);
	}
	
	/**
	 * Set up the Image from the Tree in the World
	 * @param cellSize
	 */
	private void setUpImage(int cellSize)
	{
		GreenfoodImage image = new GreenfoodImage(TREEIMAGEPATH);
		image.scale(cellsize,cellsize);
		this.setImage(image);
		
	}
	
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
