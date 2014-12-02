import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TheFrame {

    private JFrame myFrame;
    private JButton loadGame;
    private JButton newGame;
    private JLabel comboBoxName;
    private JComboBox<Integer> combo;
    private Container contentPane;
    private Integer[] playerCounts = {2,3,4}; //The number of players
    private int playerquantity;
    private boolean isNewGame;
    private boolean isLoadGame;

    public TheFrame(){
        init();
    }

    private void init(){
        //Initial Elements
        //SetLoadGameButton
        loadGame = new JButton();
        loadGame.setText("Begonnenes Spiel fortsetzen");
        loadGame.setAlignmentX(Component.LEFT_ALIGNMENT);
        loadGame.setSize(200, 100);
        loadGame.addActionListener(new ButtonListener());
        //Set NewGameButton
        newGame = new JButton();
        newGame.setText("Neues Spiel mit deinen Freunden beginnen");
        newGame.setAlignmentX(Component.LEFT_ALIGNMENT);
        newGame.setSize(200,100);
        newGame.addActionListener(new ButtonListener());
        //Set Combo Box Label
        comboBoxName = new JLabel();
        comboBoxName.setText("Spieleranzahl");
        comboBoxName.setAlignmentX(Component.LEFT_ALIGNMENT);
        //Set Combo Box
        combo = new JComboBox<Integer>();
        combo.setSize(50, 50);
        combo.setAlignmentX(Component.LEFT_ALIGNMENT);
        //Set Frame and Pane
        myFrame = new JFrame();
        contentPane = myFrame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        //Add elements to ComboList
        for(Integer value: this.playerCounts){
            combo.addItem(value);
        }

        //Add elements to the Layout
        Panel functionPanel = new Panel();
        contentPane.add(functionPanel, BorderLayout.CENTER);
        contentPane.add(newGame);
        contentPane.add(comboBoxName);
        contentPane.add(combo);
        contentPane.add(loadGame);


        //Set Frame size and Visible
        myFrame.setSize(400,400);
        myFrame.pack();
        myFrame.setVisible(true);

    } 
    
    private void setPlayerquantitiy(int quantitiy){
        this.playerquantity = quantitiy;
    }
    
    public int getPlayerquantity(){
        return playerquantity;
    }
    
    private void setIsNewGame(boolean newGame){
        this.isNewGame = newGame;
    }
    
    public boolean getIsNewGame(){
        return isNewGame;
    }
    
    public void setIsLoadGame(boolean loadGame){
        this.isLoadGame = loadGame;
    }
    
    public boolean getIsLoadGame(){
        return isLoadGame;
    }
    
    /**
     * Action Listener Class for the Buttons
     * @author Max
     *
     */
    private class ButtonListener implements ActionListener{
        /**
         * Action Listener for the Buttons
         */
        public void actionPerformed(ActionEvent arg0) {
            if(arg0.getSource() == newGame){
                System.out.println("Button neues Spiel gedueckt");
                System.out.println(combo.getSelectedItem());
                setPlayerquantitiy((Integer)combo.getSelectedItem());
                setIsNewGame(true);
                setIsLoadGame(false);
                
            } else if(arg0.getSource() == loadGame){
                System.out.println("Spiel Laden gedrueckt");
                setIsNewGame(false);
                setIsLoadGame(true);
            }

        }
    }
}
