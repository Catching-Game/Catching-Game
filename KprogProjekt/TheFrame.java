
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
Generates a start Window where you can choose players and start game.
**/
public class TheFrame {

    private JFrame myFrame;
    private JButton loadGame;
    private JButton newGame;
    private JButton buttonMusic;
    private JLabel comboBoxName;
    private JLabel comboBoxLabelMusic;
    private JComboBox<Integer> combo;
    private JComboBox<String> comboMusic;
    private Container contentPane;
    private Integer[] inhalt = {2, 3, 4};
    private String[] songs;
    private int playerquantity;
    private boolean isNewGame;
    private boolean isLoadGame;
    private boolean buttonPressed;
    Sound s;

    /**
     * This icon represents the stop.gif of buttonMusic inside our frame.
     */
    final Icon STOPICON = new ImageIcon("images/stop128x128.gif");
    /**
     * This icon represents the play.gif of buttonMusic inside our frame.
     */
    final Icon PLAYICON = new ImageIcon("images/play128x128.gif");

    /**
     * Constructor for TheFrame.
     */
    public TheFrame() {
        init();
        s = new Sound();
    }

    /**
     * Init everything the frame needs.
     */
    private void init() {
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
        newGame.setSize(200, 100);
        newGame.addActionListener(new ButtonListener());
        //Create MediaPlayer Button
        buttonMusic = new JButton(STOPICON);
        buttonMusic.setToolTipText("By clicking on this button music will stop!");
        buttonMusic.setForeground(Color.black);
        buttonMusic.setBackground(Color.white);
        buttonMusic.setContentAreaFilled(false);
        buttonMusic.setOpaque(true);
        buttonMusic.setText("Please stop this shit omg!");
        buttonMusic.addActionListener(new ButtonListener());
        //Set Combo Box Label
        comboBoxName = new JLabel();
        comboBoxName.setText("Spieleranzahl");
        comboBoxName.setAlignmentX(Component.LEFT_ALIGNMENT);
        //Set Combo Box
        combo = new JComboBox<Integer>();
        combo.setSize(50, 50);
        combo.setAlignmentX(Component.LEFT_ALIGNMENT);
        //Set Combo Box Label
        comboBoxLabelMusic = new JLabel();
        comboBoxLabelMusic.setText("Songliste");
        comboBoxLabelMusic.setAlignmentX(Component.LEFT_ALIGNMENT);
        //Set Combo Box with Songs
        comboMusic = new JComboBox<String>();
        comboMusic.setSize(50, 50);
        comboMusic.setAlignmentX(Component.LEFT_ALIGNMENT);
        //add items to the Songlist
        comboMusic.addItem("Cantinaband");
        comboMusic.addItem("Gummibärenbande");
        comboMusic.addItem("I3est Song");
        comboMusic.addActionListener(new ComboListener());
       

        //Set Frame and Pane
        myFrame = new JFrame();
        contentPane = myFrame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        //Add elements to ComboList
        for (Integer inhalte : inhalt) {
            combo.addItem(inhalte);
        }

        //Add elements to the Layout
        Panel functionPanel = new Panel();
        contentPane.add(functionPanel, BorderLayout.CENTER);
        contentPane.add(newGame);
        contentPane.add(comboBoxName);
        contentPane.add(combo);
        contentPane.add(loadGame);
        contentPane.add(buttonMusic);
        contentPane.add(comboBoxLabelMusic);
        contentPane.add(comboMusic);

        //Set Frame size and Visible
        myFrame.setSize(310, 300);
        //myFrame.pack();
        myFrame.setVisible(true);

        //This part is for the Song
    }
/**
 * sets playerquantity
 * @param quantitiy 
 */
    private void setPlayerquantitiy(int quantitiy) {
        this.playerquantity = quantitiy;
    }
/**
 * returns playerquantity
 * @return 
 */
    public int getPlayerquantity() {
        return playerquantity;
    }
/**
 * set to a new game.
 * @param newGame 
 */
    private void setisNewGame(boolean newGame) {
        this.isNewGame = newGame;
    }

    public boolean getisNewGame() {
        return isNewGame;
    }

    public void setisLoadGame(boolean loadGame) {
        this.isLoadGame = loadGame;
    }

    public boolean getisLoadGame() {
        return isLoadGame;
    }

    /**
     * Action Listener Class for the Buttons.
     *
     * @author Max
     * @author modified Matthias Köhler
     *
     */
    private class ButtonListener implements ActionListener {

        /**
         * Action Listener for the Buttons.
         */
        public void actionPerformed(ActionEvent arg0) {
            if (arg0.getSource() == newGame) {
                System.out.println("Button neues Spiel gedueckt");
                System.out.println(combo.getSelectedItem());
                setPlayerquantitiy((Integer) combo.getSelectedItem());
                setisNewGame(true);
                setisLoadGame(false);

            } else if (arg0.getSource() == loadGame) {
                System.out.println("Spiel Laden gedrueckt");
                setisNewGame(false);
                setisLoadGame(true);
            } else if (arg0.getSource() == buttonMusic && buttonPressed != true) {
                //stop the music
                s.pauseSong();
                buttonPressed = true;
                buttonMusic.setIcon(PLAYICON);
                buttonMusic.setText("Play!");
            } else if (arg0.getSource() == buttonMusic && buttonPressed == true) {
                //play music again
                s.playSong();
                buttonMusic.setIcon(STOPICON);
                buttonPressed = false;
                buttonMusic.setText("Please stop this shit omg!");
            }

        }
    }
    /**
     * Action Listener Class for Combo Box.
     * @author Matthias Köhler
     */
    private class ComboListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String songName = (String) cb.getSelectedItem();
            s.changeSongWithHashMap(songName);
        }
    }
}
