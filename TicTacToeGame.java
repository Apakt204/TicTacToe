package TicTacToe;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
public class TicTacToeGame extends JFrame implements ActionListener
{
    JButton b[];
    JPanel p1, p2, p3;
    MemoryBoard game;
    JButton reset,exit;
    JLabel turn;
    int n1;
    public TicTacToeGame(int n)
    {//Constructor to initialize the game board
        n1=n;//Storing value of n in n1 for use by other methods
        if(n==3)
            b = new JButton[9];//Creating a grid
        else if(n==4)
            b = new JButton[16];
        else
            b = new JButton[25];
        game=new MemoryBoard(n);
        this.setSize(515,440);
        this.setResizable(false);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(550,450));
        contentPane.setBackground(new Color(192,192,192));

        p1 = new JPanel();
        p1.setBorder(BorderFactory.createEtchedBorder(1));
        p1.setBounds(5,5,490,58);
        p1.setEnabled(true);
        p1.setVisible(true);

        p2 = new JPanel();
        p2.setBorder(BorderFactory.createEtchedBorder(1));//Creating an etched border for the panels
        p2.setBounds(5,64,490,273);
        p2.setEnabled(true);
        p2.setVisible(true);
        p2.setLayout(new GridLayout(n,n));//Setting layout to grid layout

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createEtchedBorder(1));
        p3.setBounds(5,338,490,57);
        p3.setEnabled(true);
        p3.setVisible(true);

        exit = new JButton();
        exit.setBounds(323,9,220,40);
        exit.setEnabled(true);
        exit.setFont(new Font("SansSerif",0,20));
        exit.setText("EXIT");
        exit.setVisible(true);
        exit.addActionListener(this);

        reset = new JButton();
        reset.setBounds(80,7,220,40);
        reset.setEnabled(true);
        reset.setFont(new Font("SansSerif",0,20));
        reset.setText("RESET");
        reset.setVisible(true);
        reset.addActionListener(this);

        turn = new JLabel();
        turn.setBounds(138,4,218,49);
        turn.setEnabled(true);
        turn.setFont(new Font("Dialog",0,30));
        turn.setForeground(Color.red);
        turn.setText("Turn: Player 'X'");
        turn.setVisible(true);

        for(int i=0;i<n*n;i++)//To add buttons and ActionListeners for placing mark and playing the game
        {
            b[i] = new JButton();
            b[i].setFont(new Font("Dialog",0,50));
            p2.add(b[i]);
            b[i].addActionListener(this);//To recognize if this button is clicked
        }

        contentPane.add(p1);//Adding panels to main panel contentPane
        contentPane.add(p2);
        contentPane.add(p3);
        p3.add(exit);//Adding buttons and labels to the panels
        p3.add(reset);
        p1.add(turn);
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//To close the window on the click of the cross in the top right corner
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)//If button clicked is exit
        {
            dispose();//CLosing the screen and ending all functions
        }
        else if(ae.getSource()==reset)//If button clicked is reset
        {
            for(int i=0;i<=8;i++)
            {
                b[i].addActionListener(this);
            }
            if(game.getCurrentPlayer()=='O')//If the currentPlayer is 'O', changing it to 'X' as it is the starting player for every new game
            {
                game.changePlayer();
            }
            game.initializeBoard();//Initializing the memory board again with an empty or default memory
            for(int i=0;i<=n1*n1-1;i++)//To clear all the marks from the JButtons for new game
            {
                b[i].setText("");
                b[i].setForeground(Color.black);
            }
            turn.setForeground(Color.red);
            turn.setText("Turn: Player 'X'");//Setting turn to player 'X' as it is always the first player to move
        }
        else
        {
            for(int i=0;i<n1*n1;i++)
            {
                if(ae.getSource()==b[i])//If any grid buttons are placed
                {
                    if(game.placeMark(i/n1,i%n1)==true)//If return value of placeMark is true
                    {
                        if(game.getCurrentPlayer()=='X')
                        {
                            b[i].setForeground(Color.red);//The associated colour with 'X' is red
                        }
                        else if(game.getCurrentPlayer()=='O')
                        { 
                            b[i].setForeground(Color.black);//The associated colour with 'O' is black
                        }
                        b[i].setText(game.getCurrentPlayer()+"");
                        game.changePlayer();
                        if(game.getCurrentPlayer()=='O')
                            turn.setForeground(Color.black);
                        else
                            turn.setForeground(Color.red);
                        turn.setText("Turn: Player '"+game.getCurrentPlayer()+"'");
                    }
                    else//If the row and column value is not valid
                    {
                        JOptionPane.showMessageDialog(this, "Please select an empty box!");//Warning message
                    }
                    break;
                }
            }

            if(game.isWinner()==true)
            {
                game.changePlayer(); 
                JOptionPane.showMessageDialog(this, "WINNER: Player '" + game.getCurrentPlayer()+"'");//Declaring the winner
                reset.setText("PLAY AGAIN");
                for(int i=0;i<=8;i++)
                {
                    b[i].removeActionListener(this);
                }
            }  
            else if(game.isBoardFull()==true)
            {
                JOptionPane.showMessageDialog(this, "\t\t\t TIE \t\t\t");//Declaring a tie
                reset.setText("PLAY AGAIN");
                for(int i=0;i<=8;i++)
                {
                    b[i].removeActionListener(this);
                }
            } 
        }
    }
}
/* Variable Description
 * JButton array b[i] - to create an array with buttons as the tictactoe grid
 * JButton reset - to reset the GUI grid and the memory board for another game
 * JButton exit - to close the current game window to stop playing
 * JPanel p1 - to contain the JLabel turn
 * JPanel p2 - to contain the grid formed with buttons
 * JPanel p3 - to contain the exit and reset buttons
 * JLabel turn - to display which player's move it is
 * JPanel contentPane - to contain the three panels and their sub-components
 * int n1 - to store the value of parameter n and initialized in the constructor, so it can be used by other methods
 */