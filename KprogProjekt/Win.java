import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This represents the win condition in our game.
 * 
 * @author simonhoinkis
 * @version 1.0
 */
public class Win extends Actor
{
    /**
     * Act - do whatever the Win wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    	//Is this game finished?
    	if(checkEnd()) {
    		//Yes it is stop the game
    		Greenfoot.stop();
    		//and say who won it
    		this.infoBox(this.checksWhoWon(), "WIN");
    	}
    }   
    
    /**
     * Checks if the game is ending
     * @return	returns true if the game is ending and false if not
     */
    private boolean checkEnd() {
    	
    	//There are no players, okay the game is done
    	if (this.getWorld().getObjects(Player.class).isEmpty()) {
    		return true;
    	}
    	
    	//are there any mice left on the field
    	if (this.getWorld().getObjects(Mouse.class).isEmpty()) {
    		return true;
    	}
    	
    	//none game end condition has triggered, so the game is still running
    	return false;
    }
    
    /**
     * Decides who won the game, the game can also be one by n people
     * its possible that everyone wins, one wins, a few are winning and nobody is winning.
     * @return Who won the game
     */
    private String checksWhoWon() {
    	String win = "Es hat ";
    	
    	List<Object> playerList = this.getWorld().getObjects(Player.class);
    	
    	Player highestScoredPlayer = null;
    	ArrayList<Player> wonPlayerList = new ArrayList<Player>();
    	
    	if (playerList.size() > 0) {
    		highestScoredPlayer = (Player) playerList.get(0);
    	}
    	
    	//search for the player who wins
    	for (int i = 0; i < playerList.size(); i++) {
    			if(highestScoredPlayer != null 
    			&& highestScoredPlayer.getLifes() < ((Player) playerList.get(i)).getLifes()) {
    				highestScoredPlayer = ((Player) playerList.get(i));
    			}
    		}
    	
    	//this will add every player to the won list with the highestScore 
    	//even the highest scored one too
    	for (int i = 0; i < playerList.size(); i++) {
    		if (((Player) playerList.get(i)).getLifes() == highestScoredPlayer.getLifes()) {
    			wonPlayerList.add((Player) playerList.get(i));
    		}
    	}
    	
    	for (Player p : wonPlayerList) {
    		win += p.getPlayerName() + " ";
    	}
    	
    	win += "gewonnen!";
    	
    	if (wonPlayerList.isEmpty()) {
    		win = "Ihr seid alle Verlierer!";
    	}
    	
    	return win;
    }
    
    /**
     * The info box method to show who won.
     * @param infoMessage the message displayed
     * @param titleBar the title of the window
     */
    private static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
