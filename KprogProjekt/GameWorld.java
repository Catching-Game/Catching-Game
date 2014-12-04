
import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * Write a description of class GameWorld here.
 *
 * @author simonhoinkis & Maximilian Schmidt
 * @version 0.2
 */
public class GameWorld extends World
{

  /**
   * The width of the gameworld.
   */
  private static final int WORLD_WIDTH = XMLMapReader.getWorldWidth();
  /**
   * The height of the gameworld.
   */
  private static final int WORLD_HEIGHT = XMLMapReader.getWorldHeight();
  /**
   * The cellsize of the gameworld.
   */
  private static final int WORLD_CELLSIZE = XMLMapReader.getWorldCellsize();

  /**
   * Constructor for objects of class GameWorld.
   */
  public GameWorld()
  {
    super(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, GameWorld.WORLD_CELLSIZE);
//        System.out.println("");
//        System.out.println("----- Konstruktor Gameworld");
//        Greenfoot.stop(); //Stops Greenfoot until the loading stuff is done
//        System.out.println("-- stoped the gameworld");
    //this.setGui();
//        this.setBackground();
    this.setupStart();
//        this.setUpWorld(playerCount);
    System.out.println("leave Konstruktor Gameworld");
  }

  /**
   * Sets the Background.
   */
  private void setBackground()
  {
    this.setBackground(XMLMapReader.getWorldBackgroundImage());
    Greenfoot.start();
  }

  /**
   * Sets up the World.
   *
   * @param playerCount the number of players that will play this game.
   */
  private void setUpWorld(final int playerCount)
  {
    this.setWalls();
    this.setPlayer(playerCount);
    this.setTrees();
    this.setHounds();
    this.setMice();
  }

  /**
   * Set up Load world from SaveXML.
   */
  private void setUpLoadWorld()
  {
    this.setWalls();
    this.setTrees();
    this.setLoadPlayers();
    this.setLoadHounds();
    this.setLoadMice();
  }

  private void setupStart()
  {

    StartButton playButton = StartButton.createButton(1);
    StartButton twoPlayerButton = StartButton.createButton(2);
    StartButton threePlayerButton = StartButton.createButton(3);
    StartButton fourPlayerButton = StartButton.createButton(4);

    this.addObject(playButton, 5, 5);
    this.addObject(twoPlayerButton, 6, 6);
    this.addObject(threePlayerButton, 7, 7);
    this.addObject(fourPlayerButton, 8, 8);

    setBackground(XMLMapReader.getWorldBackgroundImage());

    //if (Greenfoot.mouseClicked(playButton))
    //{
      //System.out.println("PlayButton");
    //}  
  }

  /**
   * Loads the number of players into the game.
   */
  private void setLoadPlayers()
  {
    int playerCount = XMLSavestateReader.getPlayerCount();
    PlayerID p;

    if (playerCount == 4)
    {
      p = PlayerID.FOURTH;
      this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "5", "8", "7", "9"), XMLSavestateReader.getPlayerPosition(p).getX(),
              XMLSavestateReader.getPlayerPosition(p).getY());
    }
    if (playerCount >= 3)
    {
      p = PlayerID.THIRD;
      this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "t", "g", "f", "h"), XMLSavestateReader.getPlayerPosition(p).getX(),
              XMLSavestateReader.getPlayerPosition(p).getY());
    }
    if (playerCount >= 2)
    {
      p = PlayerID.SECOND;
      this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "w", "s", "a", "d"), XMLSavestateReader.getPlayerPosition(p).getX(),
              XMLSavestateReader.getPlayerPosition(p).getY());

      p = PlayerID.FIRST;
      this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "up", "down", "left", "right"), XMLSavestateReader.getPlayerPosition(p).getX(),
              XMLSavestateReader.getPlayerPosition(p).getY());
    }
  }

  /**
   * Load hounds.
   */
  private void setLoadHounds()
  {
    for (int i = 0; i < XMLSavestateReader.getHoundCount(); i++)
    {
      int posY = XMLSavestateReader.getHoundPositions().get(i).getY();
      int posX = XMLSavestateReader.getHoundPositions().get(i).getX();
      int cellSize = this.getCellSize();
      this.addObject(new Hound(cellSize), posX, posY);
    }
  }

  /**
   * Set up the Load Mice in the Gameworld.
   */
  private void setLoadMice()
  {
    for (int i = 0; i < XMLSavestateReader.getMiceCount(); i++)
    {
      int posY = XMLSavestateReader.getMicePositions().get(i).getY();
      int posX = XMLSavestateReader.getMicePositions().get(i).getX();
      Direction dir = XMLSavestateReader.getMicePositions().get(i).getDir();
      int cellSize = this.getCellSize();
      this.addObject(new Mouse(cellSize, dir), posX, posY);
    }
  }

  /**
   * Sets up the walls.
   */
  private void setWalls()
  {
    //Iteration to set up the walls
    for (int i = 0; i < XMLMapReader.getWallCount(); i++)
    {
      this.addObject(new Wall(this.getCellSize()),
              XMLMapReader.getWallPositions().get(i).getX(),
              XMLMapReader.getWallPositions().get(i).getY());
    }
  }

  /**
   * Sets up the player in the Gameworld.
   *
   * @param playerCount the number of players
   */
  private void setPlayer(final int playerCount)
  {
    PlayerID p;

    if (playerCount == 4)
    {
      p = PlayerID.FOURTH;
      this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "5", "8", "7", "9"), XMLMapReader.getPlayerPosition(p).getX(),
              XMLMapReader.getPlayerPosition(p).getY());
    }
    if (playerCount >= 3)
    {
      p = PlayerID.THIRD;
      this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "t", "g", "f", "h"), XMLMapReader.getPlayerPosition(p).getX(),
              XMLMapReader.getPlayerPosition(p).getY());
    }
    if (playerCount >= 2)
    {
      p = PlayerID.SECOND;
      this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "w", "s", "a", "d"), XMLMapReader.getPlayerPosition(p).getX(),
              XMLMapReader.getPlayerPosition(p).getY());

      p = PlayerID.FIRST;
      this.addObject(new Player(this.getCellSize(), XMLMapReader.getPlayerName(p), this, p, "up", "down", "left", "right"), XMLMapReader.getPlayerPosition(p).getX(),
              XMLMapReader.getPlayerPosition(p).getY());
    }

    //this.addObject(new Pause(), 0, 0);
  }

  /**
   * Set up Tree Image from xml
   */
  private void setTrees()
  {
    for (int i = 0; i < XMLMapReader.getTreeCount(); i++)
    {
      int posY = XMLMapReader.getTreePositions().get(i).getY();
      int posX = XMLMapReader.getTreePositions().get(i).getX();
      int cellSize = this.getCellSize();
      this.addObject(new Tree(cellSize), posX, posY);
    }
  }

  /**
   * Set up the Hounds in the Gameworld.
   */
  private void setHounds()
  {
    for (int i = 0; i < XMLMapReader.getHoundCount(); i++)
    {
      int posY = XMLMapReader.getHoundPositions().get(i).getY();
      int posX = XMLMapReader.getHoundPositions().get(i).getX();
      int cellSize = this.getCellSize();
      this.addObject(new Hound(cellSize), posX, posY);
    }

  }

  /**
   * Set up the Mice in the Gameworld.
   */
  private void setMice()
  {
    for (int i = 0; i < XMLMapReader.getMiceCount(); i++)
    {
      int posY = XMLMapReader.getMicePositions().get(i).getY();
      int posX = XMLMapReader.getMicePositions().get(i).getX();
      Direction dir = XMLMapReader.getMicePositions().get(i).getDir();
      int cellSize = this.getCellSize();
      this.addObject(new Mouse(cellSize, dir), posX, posY);
    }
  }

    //    /**
  //     * Sets up the graphical user interface.
  //     */
  //    private void setGui() {
  //        TheFrame frame = new TheFrame();
  //        boolean isLoadGame = false;
  //        boolean isNewGame = false;
  //
  //        /*       while (isLoadGame == isNewGame) {
  //         isLoadGame = frame.getIsLoadGame();
  //         isNewGame  = frame.getIsNewGame();
  //         }
  //
  //         if(isLoadGame) {
  //
  //         } else if (isNewGame) {*/
  //        Greenfoot.start();
  //        this.setBackground();
  //        this.setUpWorld(/*frame.getPlayerquantity()*/2);
  //        //}
  //    }
}
