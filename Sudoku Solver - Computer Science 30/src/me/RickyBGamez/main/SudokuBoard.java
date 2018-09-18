package me.RickyBGamez.main;

public class SudokuBoard {

	final int EMPTY = 0; //Empty cells marker
    final int size; //Size of the board (number of rows and columns)
    final int box_size; //Size of the inner boxes

    private int[][] board; //2D array representing the game board

    public SudokuBoard(int size){ //Creates an empty board, size is number of rows and columns
        board = new int[size][size];
        this.size = size;
        this.box_size = (int) Math.sqrt(size);
    }
    
    public SudokuBoard(int[][] board){ //Initializes the board, and array to initialize the board content
        this(board.length);
        this.board = board;
    }
    
    public void setCell(int number, int row, int column){ //Puts a number into a certain cell
        board[row][column] = number;
    }

    public int getCell(int row, int column){ //Returns the number in that specific cell
        return board[row][column];
    }
	
}
