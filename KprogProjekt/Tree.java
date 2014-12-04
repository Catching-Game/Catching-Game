import greenfoot.*;

/**
 * Tree where players can hide.
 * @author Maximilian Schmidt
 */
public class Tree extends DrawableActor {
	private static final String TREEIMAGEPATH = XMLMapReader.getTreeImage();

        /**
         * contructor for Tree.
         * @param cellSize
         */
	public Tree(int cellSize)
	{
		super(cellSize, XMLMapReader.getTreeImage());
	}
	public void act()
        {
	}
}
