package bcc.battleship;
import bcc.battleship.Constants;

public class Player {
    private Ship[] ships;
    private Grid opponentGrid;
    private Grid playerGrid;

    // Constructor: Initialize the grids and the ships.
    public Player() {
        //for (int i; i < (Constants.SHIP_LENGTHS).Length; i++){
        //    ships[i] = Ship(Constants.SHIP_LENGTHS[i]);
        //}
        ships[0] = new Ship(2);
        ships[1] = new Ship(3);
        ships[2] = new Ship(3);
        ships[3] = new Ship(4);
        ships[4] = new Ship(5);
        opponentGrid = new Grid();
        playerGrid = new Grid();
    }
    
    /**
     * This method is used for testing to set a ship's location.
     * It sets the ship's row, column, and direction, then adds it to the player's grid.
     *
     */
    
    public boolean chooseShipLocation(int index, int row, int col, int direction) {
        ships[index].setDirection(direction);
        ships[index].setLocation(row, col);
        return playerGrid.addShip(ships[index]);
    }
   
    /**
     * Record a guess from the opponent.
     * This method checks the player's grid at (row, col). If there is a ship,
     * it marks a hit and returns true; otherwise, it marks a miss and returns false.
     *
     */
    public boolean recordOpponentGuess(int row, int col) {
        if (playerGrid.hasShip(row, col)){
            opponentGrid.markHit(row, col);
            return true;
        }
        else {
            opponentGrid.markMiss(row, col);
            return false;
        }
    }
    
    
    public Grid getMyGrid() {
        return playerGrid;
    }
    
    public Grid getOpponentGrid() {
        return opponentGrid;
    }
}
