package bcc.battleship;
import bcc.battleship.Constants;

public class Player{
    private Grid myGrid;
    private Grid opponentGrid;
    private Ship[] ships;

    // Constructor: Initialize the grids and the ships.
    public Player(){
        myGrid = new Grid();
        opponentGrid = new Grid();
        for (int index = 0; index < Constants.SHIP_LENGTHS.length; index++){
            ships[index] = new Ship(Constants.SHIP_LENGTHS[index]);
        }
        //ships[0] = new Ship(2);
        //ships[1] = new Ship(3);
        //ships[2] = new Ship(3);
        //ships[3] = new Ship(4);
        //ships[4] = new Ship(5);
    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    
    public boolean chooseShipLocation(int index, int row, int col, int direction){
        ships[index].setDirection(direction);
        ships[index].setLocation(row, col);
        return myGrid.addShip(ships[index]);
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col){
        if (myGrid.hasShip(row, col)){
            opponentGrid.markHit(row, col);
            return true;
        }
        else {
            opponentGrid.markMiss(row, col);
            return false;
        }
    }
    
    
    public Grid getMyGrid(){
        return myGrid;
    }
    
    public Grid getOpponentGrid(){
        return opponentGrid;
    }
}
