import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.text.Position;

/**
 * Write a description of class GameWorld here.
 * 
 * @author simonhoinkis
 * @version 0.2
 */
public class GameWorld extends World{    
    private static final int WORLD_WIDTH      = XML_Map_Reader.getWorldWidth();
    private static final int WORLD_HEIGHT      = XML_Map_Reader.getWorldHeight();
    private static final int WORLD_CELLSIZE    = XML_Map_Reader.getWorldCellsize();
    
    public static ArrayList<Zaehleranzeige> zaehleranzeige = new ArrayList<Zaehleranzeige>();
    public static ArrayList<Counter> counteranzeige = new ArrayList<Counter>();

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld(){
        super(GameWorld.WORLD_WIDTH, GameWorld.WORLD_HEIGHT, GameWorld.WORLD_CELLSIZE);

        this.setBackground();
        this.setUpWorld();
        this.setGui();
        this.playSound();
        
        prepare();
    }

    /**
     * Sets the Background
     */
    private void setBackground(){
        this.setBackground(XML_Map_Reader.getWorldBackgroundImage());
    }
    
    /**
     * Play a sound
     */
    private void playSound()
    {
      Sound s = new Sound();
    }

    /**
     * Sets up the World
     */
    private void setUpWorld(){
        this.setWalls();
        this.setPlayer();
        this.setTrees();
        this.setHounds();
        this.setMice();
        //anstatt der 1 muss noch die genaue spieleranzahl eingefgt werden 
        this.setLiveCounter(1);
        this.initObserver();
    }
    
    /**
     * Set up Load world from SaveXML
     */
    private void setUpLoadWorld(){
        
    }

    /**
     * Sets up the walls
     */
    private void setWalls(){
        //Iteration to set up the walls
        for (int i = 0; i < XML_Map_Reader.getWallCount(); i++) {
            this.addObject(new Wall(this.getCellSize()), 
                XML_Map_Reader.getWallPositions().get(i).getX(), 
                XML_Map_Reader.getWallPositions().get(i).getY());
        }
    }

    /**
     * Sets up the player in the Gameworld
     */
    private void setPlayer(){   
        this.addObject(new Player(this.getCellSize(), XML_Map_Reader.getPlayerName(PlayerID.FIRST)), XML_Map_Reader.getPlayerPosition(PlayerID.FIRST).getX(),
            XML_Map_Reader.getPlayerPosition(PlayerID.FIRST).getY());
        //TODO ID System zum Test wurde nur die PlayerID.First eingefuegt
    }

    /**
     * Set up Tree Image from xml
     */
    private void setTrees(){
        for (int i = 0; i < XML_Map_Reader.getTreeCount(); i++){
            int posY = XML_Map_Reader.getTreePositions().get(i).getY();
            int posX = XML_Map_Reader.getTreePositions().get(i).getX();
            int cellSize = this.getCellSize();
            this.addObject(new Tree(cellSize), posX, posY);
        }
    }

    /**
     * Set up the Hounds in the Gameworld
     */
    private void setHounds(){
        for (int i = 0; i < XML_Map_Reader.getHoundCount(); i++){
            int posY = XML_Map_Reader.getHoundPositions().get(i).getY();
            int posX = XML_Map_Reader.getHoundPositions().get(i).getX();
            int cellSize = this.getCellSize();
            this.addObject(new Hound(cellSize),posX,posY);
        }

    }

    /**
     * Set up the Mice in the Gameworld
     */
    private void setMice(){
        for (int i = 0;i < XML_Map_Reader.getMiceCount(); i++){
            int posY = XML_Map_Reader.getMicePositions().get(i).getY();
            int posX = XML_Map_Reader.getMicePositions().get(i).getX();
            Direction dir = XML_Map_Reader.getMicePositions().get(i).getDir();
            int cellSize = this.getCellSize();
            this.addObject(new Mouse(cellSize,dir),posX,posY);
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare(){
    }
    
    private void setLiveCounter(int anzahlSpieler){
        for(int i = 0; i < anzahlSpieler;i = i + 1){
            String name = XML_Map_Reader.getPlayerName(PlayerID.FIRST);
            int posX = XML_Map_Reader.getCounterPosition().get(i).getX();
            int posY = XML_Map_Reader.getCounterPosition().get(i).getY();
            int life = 7; // XML_Gamelogic_Reader.getPlayerLifes();
            Zaehleranzeige zaehler = (new Zaehleranzeige(name,life,posX,posY));
            Counter counter = (new Counter(name, life));
            this.counteranzeige.add(counter);
            this.zaehleranzeige.add(zaehler);
            addObject(counter,zaehler.getX(),zaehler.getY());
                    
            }
        }
    private void initObserver(){
        this.getZaehler().addObserver(this.getCounteranzeige());
    
    }
    
    private Zaehleranzeige getZaehler(){
        Zaehleranzeige player = null;
        for(Zaehleranzeige zaehler : zaehleranzeige){
        //  if(zaehler.getPlayerName().equals(getCounteranzeige().getPlayerName())){
            player = zaehler;
        //  }
            
                
        
        
    }
    return player;
}
    
    private Counter getCounteranzeige(){
        Counter player = null;
        for(Counter counter : counteranzeige){
         //if(counter.getPlayerName().equals(getZaehler().getPlayerName()   )){
                player = counter;
            
                
    //  }        
    }
    
 return player;
}

   private void setGui(){
       TheFrame frame = new TheFrame();
   }
}
