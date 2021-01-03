package caballo;

import java.util.*;
public class KnightGame 
{
    private int rows;
    private int cols;
    private int [][] array;

    public void initializeArray()
    {
        array = new int [rows][cols];
    }

    public boolean fill (int x, int y, int n)
    {
        if ( x < 0 || x >= rows || y<0 || y >= cols )  //outside of board
            return false;
        else if (array[x][y] != 0)   //location has been visited, array element occupied
            return false;
        else if ( n == (rows * cols))       //have visited all locations
            return true;
        else 
        {   
            array[x][y] = n;
            if ( fill(x+1, y-2, n+1) || fill(x-2, y+1, n+1) || fill(x+1, y+2, n+1)
               || fill(x+2, y+1, n+1) || fill(x-2, y-1, n+1) || fill(x-1, y-2, n+1) || 
               fill(x-1, y+2, n+1) || fill(x+2, y-1, n+1)) 
                return true;
            else{
	        array[x][y] = 0;
                return false;
		}               
        }
    }

    public static void main (String [] args)
    {   
         KnightGame game = new KnightGame();
        int [] st = new int [2];
        int startx, starty;
        Scanner keyIn = new Scanner (System.in); 

        System.out.println("Enter number of rows: ");
        game.rows=keyIn.nextInt();

        System.out.println("Enter number of columns: ");
         game.cols = keyIn.nextInt();

        game.initializeArray();

        System.out.println("Enter starting location: ");
         for (int i=0; i<2; i++)
         {
             st[i] = keyIn.nextInt();
         }

         startx = st[0];
         starty = st[1];

         //testing for correct starting values
         System.out.println("starting values: " + startx + " " + starty);       

        if (game.fill(startx, starty, 1))
        {
            for (int i=0; i<game.rows; i++)
                {
                  for (int j=0; j<game.cols; j++)
                  {
                     System.out.print(game.array[i][j] + " "); 
                  } 
                }
        }

        else
            System.out.println("Board could not be completed!");

    }

}
