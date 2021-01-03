package maze;

public class Main {
	private final int CLEAR = 1;
	public final int PATH = 2;
	private int[][] grid;

	public Main(int[][] grid) {
   		this.grid = grid;
   	}

  	public boolean tryNextMove(int row, int column) {
		if ( !valid (row, column) )
			return false; // impossible path
		else if ( solved(row, column) ) {
         	setPath(row, column);
            return true;  // the maze is solved
        }
        else {
         	setPath(row, column);	// mark
            boolean done = tryNextMove (row+1, column);     // down
            if (!done)
               	done = tryNextMove (row, column+1);  // right
            if (!done)
               	done = tryNextMove (row-1, column);  // up
            if (!done)
               	done = tryNextMove (row, column-1);  // left
            if (!done)
            	removePath(row, column); // backtrack
            return done;
		}
	}

   	public boolean tryNextMove(int row, int column, int n) {
      	boolean done = false;

		if ( valid (row, column) ) {
		 	setPath(row, column, n);
         	if ( solved(row, column) )
            	done = true;
         	else {
            	done = tryNextMove(row+1, column, n+1);
            	if (!done)
               		done = tryNextMove(row, column+1, n+1);
            	if (!done)
               		done = tryNextMove(row-1, column, n+1);
            	if (!done)
               		done = tryNextMove(row, column-1, n+1);
            	if (!done)
            		removePath(row, column);
         	}
		}

      	return done;
	}

   	private boolean valid(int row, int column) {
      	boolean result = false;
      	if (row >= 0 && row < grid.length &&
          	column >= 0 && column < grid[row].length)
         	/**  check if cell is not blocked */
         	if (grid[row][column] == CLEAR)
            	result = true;
      	return result;
   	}

	private boolean solved(int row, int column) {
		return row==grid.length-1 && column==grid[0].length-1;
	}

	private void setPath(int row, int column) {
		grid[row][column] = PATH;
	}

	private void setPath(int row, int column, int i) {
		grid[row][column] = i;
	}

	private void removePath(int row, int column) {
		grid[row][column] = CLEAR;
	}

   	public String toString() {
      	StringBuilder result = new StringBuilder("\n");
      	for (int row=0; row < grid.length; row++) {
         	for (int column=0; column < grid[row].length; column++) {
            	result.append(grid[row][column]);
            	if (grid[row][column] < 10)
            		result.append("   ");
            	else if (grid[row][column] < 100)
            		result.append("  ");
            }
         	result.append("\n");
      	}
      	return result.toString();
   	}

   	public static void main(String[] args) {

   	  	// 1 indicates a clear path
   	  	// 0 indicates a blocked path
      	int[][] grid = {{1,1,1,0,1,1,0,0,0,1,1,1,1},
                       	{1,0,1,1,1,0,1,1,1,1,0,0,1},
                       	{0,0,0,0,1,0,1,0,1,0,1,0,0},
                       	{1,1,1,0,1,1,1,0,1,0,1,1,1},
                       	{1,0,1,0,0,0,0,1,1,1,0,0,1},
                       	{1,0,1,1,1,1,1,1,0,1,1,1,1},
                       	{1,0,0,0,0,0,0,0,0,0,0,0,0},
                       	{1,1,1,1,1,1,1,1,1,1,1,1,1} };

      	Main labyrinth = new Main(grid);

      	System.out.println(labyrinth);

      	if (labyrinth.tryNextMove(0, 0, labyrinth.PATH)) // posición inicial válida
      	//if (labyrinth.tryNextMove(0, 0))
         	System.out.println("The maze was successfully traversed!");
      	else
         	System.out.println("There is no possible path.");

      	System.out.println(labyrinth);
   }
}