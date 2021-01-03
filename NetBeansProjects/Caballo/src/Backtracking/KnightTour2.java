package Backtracking;

import java.text.DecimalFormat;

public class KnightTour2 {

    int[][] solution;
    int path = 0;

    public KnightTour2(int N) {
        solution = new int[N][N];
        for (int[] row : solution) {
            for (int column : row) {
                column = 0;
            }
        }
    }

    public void resolver() {
        if (findPath(0, 0, 0, solution.length)) {
            print();
        } else {
            System.out.println("NO SE ENCONTRO UN CAMINO");
        }
    }

   public boolean findPath(int row, int column, int index, int N) {
                           	// check if current is not used already
                           	if (solution[row][column] != 0) {
                                           	return false;
                           	}
                           	// mark the current cell is as used
                           	solution[row][column] = path++;
                           	// if (index == 50) {
                           	if (index == N * N - 1) {
                                           	// if we are here means we have solved the problem
                                           	return true;
                           	}
                           	// try to solve the rest of the problem recursively
 
                           	// go down and right
                           	if (canMove(row + 2, column + 1, N)
                                                           	&& findPath(row + 2, column + 1, index + 1, N)) {
                                           	return true;
                           	}
                           	// go right and down
                           	if (canMove(row + 1, column + 2, N)
                                                           	&& findPath(row + 1, column + 2, index + 1, N)) {
                                           	return true;
                           	}
                           	// go right and up
                           	if (canMove(row - 1, column + 2, N)
                                                           	&& findPath(row - 1, column + 2, index + 1, N)) {
                                           	return true;
                           	}
                           	// go up and right
                           	if (canMove(row - 2, column + 1, N)
                                                           	&& findPath(row - 2, column + 1, index + 1, N)) {
                                           	return true;
                           	}
                           	// go up and left
                           	if (canMove(row - 2, column - 1, N)
                                                           	&& findPath(row - 2, column - 1, index + 1, N)) {
                                           	return true;
                           	}
                           	// go left and up
                           	if (canMove(row - 1, column - 2, N)
                                                           	&& findPath(row - 1, column - 2, index + 1, N)) {
                                           	return true;
                           	}
                           	// go left and down
                           	if (canMove(row + 1, column - 2, N)
                                                           	&& findPath(row + 1, column - 2, index + 1, N)) {
                                           	return true;
                           	}
                           	// go down and left
                           	if (canMove(row + 2, column - 1, N)
                                                           	&& findPath(row + 2, column - 1, index + 1, N)) {
                                           	return true;
                           	}
                           	// if we are here means nothing has worked , backtrack
                           	solution[row][column] = 0;
                           	path--;
                           	return false;
 
            	}

    public boolean canMove(int row, int col, int N) {
        if (row >= 0 && col >= 0 && row < N && col < N) {
            return true;
        }
        return false;
    }

    public void print() {
        DecimalFormat twodigits = new DecimalFormat("00");
        for (int[] row : solution) {
            for (int column : row) {
                System.out.print("   " + twodigits.format(column));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8;
        KnightTour2 i = new KnightTour2(N);
        i.resolver();
    }

}
