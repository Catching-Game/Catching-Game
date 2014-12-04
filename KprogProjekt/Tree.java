import greenfoot.*;

/**
 * Trees where players can hide.
 * @author simonhoinkis&maximilianschmidt
 * @version 1.0
 */
public class Tree extends DrawableActor{
	private static final String TREEIMAGEPATH = XMLMapReader.getTreeImage();

	/**
	 * constructor for Tree.
	 * @param cellSize the cellsize of the world
	 */
	public Tree(int cellSize)
	{
		super(cellSize, XMLMapReader.getTreeImage());
	}
	
	/**
	 * Greenfoots act method
	 */
	public void act()
	{
		
	}
}
