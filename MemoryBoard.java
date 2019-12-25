package TicTacToe;
import java.lang.*;
public class MemoryBoard
{//The class with all functions of the memory board, which is to be called for any operation
    char currentPlayer;//The value of the current mark to be placed
    char Board[][];//The double dimensional array serving as the memory board for all operations
    int i,j,n1;
    public MemoryBoard(int n)
    {//Constructor to initialize board for actual operations
        if(n==3)//Board of size 3X3
            Board = new char[3][3];
        else if(n==4)//Board of size 4X4
            Board = new char[4][4];
        else//Board of size 5X5
            Board = new char[5][5];
        n1=n;//Storing n in n1 so it can be used in any other method of this class
        currentPlayer='X';//Setting currentPLayer i.e. first player to 'X'
        initializeBoard();//Calling initializeBoard() method 
    }

    public char getCurrentPlayer()
    {//To return the character value of currentPlayer i.e. whether it is X's turn or O's turn
        return currentPlayer;
    }

    public void initializeBoard()
    {//To initialize the memory board and set all cells as default '-'
        for(i=0;i<n1;i++)
        {
            for(j=0;j<n1;j++)
            {
                Board[i][j]='-';
            }
        }
    }

    public boolean placeMark(int row,int column)
    {//To place the mark 'X' or 'O' on the memory board and return true if successful
        if(Board[row][column]=='-')
        {
            Board[row][column]=currentPlayer;
            return true;
        }
        return false;
    }

    public void changePlayer()
    {//To change the value of currentPlayer after every turn
        if(currentPlayer=='X')
        {
            currentPlayer='O';
        }
        else
        {
            currentPlayer='X';
        }
    }

    public boolean isWinner()
    {//To check for the winner and return true if found or false if there is no winner yet
        boolean winner;  
        for(i=0;i<n1;i++)//Checking winner in the three rows
        {
            if(Board[i][0]!='-')//To make sure there is not a sequence of '-', the default cell
            {
                winner=true;//Setting winner to true, which would change if a sequence is not detected
                for(j=0;j<n1;j++)
                {
                    if(Board[i][0]!=Board[i][j])//Checking if all marks in a row are not the same
                    {
                        winner=false;
                        break;
                    }
                }
                if(winner==true)
                {
                    return true;//If winner remains true then some player has definitely won, so returning true at that point itself
                }
            }
        }
        for(i=0;i<n1;i++)//Checking for the winner in all the columns
        {
            if(Board[0][i]!='-')
            {
                winner=true;
                for(j=0;j<n1;j++)
                {
                    if(Board[0][i]!=Board[j][i])//Checking if all marks in a column are not the same
                    {
                        winner=false;
                        break;
                    }
                }
                if(winner==true)
                {
                    return true;
                }
            }
        }

        if(Board[0][0]!='-')//Checking for a winner in the left diagonal
        {
            winner=true;
            for(i=0;i<n1;i++)
            {
                if(Board[0][0]!=Board[i][i])//Generalised logic for all grids
                {
                    winner=false;
                    break;
                }
            }
            if(winner==true)
            {
                return true;
            }
        }

        if(Board[n1-1][0]!='-')//Checking for a winner in the right diagonal
        {
            winner=true;
            for(i=0;i<n1;i++)
            {
                if(Board[n1-1][0]!=Board[i][n1-1-i])
                {
                    winner=false;
                    break;
                }
            }
            return winner;
        }
        return false;
    }

    public boolean isBoardFull()
    {//To check if the board is full and yet there is no winner
        for(i=0;i<n1;i++)
        {
            for(j=0;j<n1;j++)
            {
                if(Board[i][j]=='-')//If even a single cell in the board is empty, the board is not full
                    return false;
            }
        }
        return true;
    }
}
/* Variable Description
 * char currentPlayer - to store the value of the current mark to be placed i.e. 'X' or 'O'
 * char Board[][] - character array to store the postions allotted to the 'X's and 'O's in memory
 * int i - for loop variable
 * int j - for loop variable
 * boolean winner - to store the boolean value of winner, whether there is one or not
 * int row, int column - function parameters to store the values of rows and columns for tictactoe grid
 * int n - constructor parameter for grid size
 * int n1 - to store value of n for use by other methods of this class and to be initiaized at the constructor
 */