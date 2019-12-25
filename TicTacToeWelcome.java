package TicTacToe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToeWelcome extends JFrame implements ActionListener
{
    JLabel welcome,option;
    JButton three,four,five;
    JPanel p1,p2;
    public TicTacToeWelcome()
    {//Constructor for printing the welcome JPanel
        this.setSize(500,400);
        this.setResizable(false);
        JPanel contentPane = new JPanel(null);//Creating the welcome window
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(192,192,192));

        five = new JButton();//Creating new button
        five.setBounds(181,194,90,40);//Setting location and size of button
        five.setEnabled(true);//Enabling the button
        five.setFont(new Font("SansSerif",0,20));//Setting font style and size
        five.setText("5X5");//Setting text on the button
        five.setVisible(true);//Making the button visible
        five.addActionListener(this);//Adding ActionListener to detect the action performed on it

        four = new JButton();
        four.setBounds(181,148,90,40);
        four.setEnabled(true);
        four.setFont(new Font("SansSerif",0,20));
        four.setText("4X4");
        four.setVisible(true);
        four.addActionListener(this);

        three = new JButton();
        three.setBounds(181,104,90,40);
        three.setEnabled(true);
        three.setFont(new Font("SansSerif",0,20));
        three.setText("3X3");
        three.setVisible(true);
        three.addActionListener(this);

        option = new JLabel();
        option.setBounds(70,32,347,33);
        option.setBackground(new Color(214,217,223));
        option.setForeground(new Color(0,0,0));
        option.setEnabled(true);
        option.setFont(new Font("SansSerif",0,20));
        option.setText("Please choose the preferred grid type");
        option.setVisible(true);

        p1 = new JPanel(null);
        p1.setBorder(BorderFactory.createEtchedBorder(1));
        p1.setBounds(5,5,490,100);
        p1.setBackground(new Color(214,217,223));
        p1.setForeground(new Color(0,0,0));
        p1.setEnabled(true);
        p1.setFont(new Font("sansserif",0,12));
        p1.setVisible(true);

        p2 = new JPanel(null);
        p2.setBorder(BorderFactory.createEtchedBorder(1));
        p2.setBounds(5,106,490,275);
        p2.setBackground(new Color(214,217,223));
        p2.setForeground(new Color(0,0,0));
        p2.setEnabled(true);
        p2.setFont(new Font("sansserif",0,12));
        p2.setVisible(true);

        welcome = new JLabel();
        welcome.setBounds(160,26,169,44);
        welcome.setBackground(new Color(214,217,223));
        welcome.setForeground(new Color(0,0,0));
        welcome.setEnabled(true);
        welcome.setFont(new Font("Helvetica",0,30));
        welcome.setText("WELCOME");
        welcome.setVisible(true);

        p2.add(five);//Adding button to the JPanel
        p2.add(four);
        p2.add(option);
        contentPane.add(p1);//Adding JPanel to another JPanel
        contentPane.add(p2);
        p2.add(three);
        p1.add(welcome);

        this.add(contentPane);//Adding the content panel to the GUI window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//To close window on clicking on the cross button on the top right corner
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {//To be called when any button is clicked or a valid action is performed
        if(e.getSource()==three)
        {//If button clicked is the 3X3 grid one
            TicTacToeGame obj=new TicTacToeGame(3);//Setting function parameter as 3 for 3X3 grid
        }
        else if(e.getSource()==four)
        {//If button clicked is the 4X4 grid one
            TicTacToeGame obj=new TicTacToeGame(4);//Setting function parameter as 4 for 4X4 grid
        }
        else
        {//If button clicked is the 4X4 grid one
            TicTacToeGame obj=new TicTacToeGame(5);//Setting function parameter as 5 for 5X5 grid
        }
    }

    public static void main()
    {//Main method to create an object of this class and call other methods
        TicTacToeWelcome obj=new TicTacToeWelcome();
    }
}
/* Variable Description
 * JLabel welcome - to display the welcome message in the window
 * JLabel option - to show the option choice message in the window
 * JButton three - to create a 3X3 tictactoe grid
 * JButton four - to create a 4X4 tictactoe grid
 * JButton five - to create a 5X5 tictactoe grid
 * JPanel p1 - to place the welcome JLabel
 * JPanel p2 - to place the option JLabel and the three buttons for type of grid
 * JPanel contentPane - to contain the two JPanels p1 and p2 and their sub-components
 */