package me.RickyBGamez.main;

public class SudoKiller {

    private SudokuBoard sb; // Puzzle to solve;
    public SudokuBoard finishedSB = sb;
    
    public SudoKiller(SudokuBoard sb){ //Initializes the game board
        this.sb = sb;
    }
    
    /**
     * Check if a number is, according to Sudoku rules, a legal candidate for
     * the given cell.
     * @param num Number to check.
     * @param row Cell's row.
     * @param col Cell's column.
     * @return <code>false<code> if <code>num<code> already appears in the row,
     *         column or box the cell belongs to or <code>true<code> otherwise.
     */
    private boolean check(int num, int row, int col){
        int r = (row / sb.box_size) * sb.box_size;
        int c = (col / sb.box_size) * sb.box_size;
        
        for (int i = 0; i < sb.size; i++){
            if (sb.getCell(row, i) == num || sb.getCell(i, col) == num || sb.getCell(r + (i % sb.box_size), c + (i / sb.box_size)) == num){
                return false;
            }
        }
        return true;
    }
    
    public boolean guess(int row, int col){ //Test all candidate numbers for a given cell until the board is completed
        int nextCol = (col + 1) % sb.size;
        int nextRow = (nextCol == 0) ? row + 1 : row;
        
        try{
            if (sb.getCell(row, col) != sb.EMPTY){
            	return guess(nextRow, nextCol);
            }
        }catch (ArrayIndexOutOfBoundsException e){
                return true;
        }

        for(int i = 1; i <= sb.size; i++){
            if (check(i, row, col)){
                sb.setCell(i, row, col);
                if(guess(nextRow, nextCol)){
                    return true;
                }
            }
        }
        sb.setCell(sb.EMPTY, row, col);
        return false; //Return false if no legal numbers cant be found for this cell
    }
	
}
