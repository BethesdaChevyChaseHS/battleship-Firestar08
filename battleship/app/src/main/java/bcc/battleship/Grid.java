package bcc.battleship;

public class Grid {
    
    
    
    // Create a new Grid and initialize each Location.
    private Location[][] g;

    public Grid() {
        g = new Location[Constants.NUM_ROWS][Constants.NUM_COLS];
    }
    
    // Mark a hit in the specified location
    public void markHit(int row, int col) {
       g[row][col].markHit();
    }
    
    // Mark a miss in the specified location.
    public void markMiss(int row, int col) {
        g[row][col].markMiss();
    }
    
    // Set the status of the Location at (row, col).
    public void setStatus(int row, int col, int status) {
        g[row][col].setStatus(status);
    }
    
    // Get the status of the Location at (row, col).
    public int getStatus(int row, int col) {
        return g[row][col].getStatus();
    }
    
    // Return whether this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col) {
        return (g[row][col].getStatus() != Constants.UNGUESSED);
    }
    
    // Set whether there is a ship at this location.
    public void setShip(int row, int col, boolean val) {
        g[row][col].setShip(val);
    }
    
    // Return whether there is a ship at this location.
    public boolean hasShip(int row, int col) {
        return g[row][col].hasShip();
    }
    
    // Get the Location object at this row and column.
    public Location get(int row, int col) {
        return g[row][col];
    }
    
    // Return the number of rows.
    public int numRows() {
        return Constants.NUM_ROWS;
    }
    
    // Return the number of columns.
    public int numCols() {
        return Constants.NUM_COLS;
    }
    

    //maybe convert to boolean?
    public boolean addShip(Ship s) {
        if (s.getDirection() == Constants.HORIZONTAL){
            if (s.getCol() + s.getLength() >= Constants.NUM_ROWS){
                return false;
            }
            for (int i = s.getCol(); i < s.getCol() + s.getLength(); i++){
                if (g[s.getRow()][i].hasShip()){
                    return false;
                } 
            }
        }
        else {
            if (s.getRow() + s.getLength() >= Constants.NUM_COLS){
                return false;
            }
            for (int i = s.getRow(); i < s.getRow() + s.getLength(); i++){
                if (g[i][s.getRow()].hasShip()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean allShipsSank(){
        for (int i = 0; i < Constants.NUM_COLS; i++){
            for (int j = 0; j < Constants.NUM_ROWS; j++){
                if (g[i][j].hasShip() && (g[i][j].getStatus() == Constants.UNGUESSED)){
                    return false;
                }
            }
        }
        return true;
    }
}
