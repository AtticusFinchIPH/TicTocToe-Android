package com.example.mytictoctoe.noyaufonction;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<Square> squares;
    private char winner;

    public Grid() {
        squares = new ArrayList<Square>(9);
        winner = ' ';
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public List<Square> getSquares() {
        return squares;
    }

    public char checkWinner() {
        // Check each row
        for(int i = 0; i < 9; i=i+3){
            if(squares.get(i).getCharacter() != ' ' &&
                    squares.get(i).getCharacter() == squares.get(i+1).getCharacter() &&
                    squares.get(i+1).getCharacter() == squares.get(i+2).getCharacter())
                winner = squares.get(i).getCharacter();
            return winner;
        }
        // Check each column
        for (int i = 0; i < 3; i++){
            if(squares.get(i).getCharacter() != ' ' &&
                    squares.get(i).getCharacter() == squares.get(i+3).getCharacter() &&
                    squares.get(i+3).getCharacter() == squares.get(i+6).getCharacter())
                winner = squares.get(i).getCharacter();
            return winner;
        }
        // Check diagonal lines
        if(squares.get(0).getCharacter() != ' ' &&
                squares.get(0).getCharacter() == squares.get(4).getCharacter() &&
                squares.get(0).getCharacter() == squares.get(8).getCharacter()){
            winner = squares.get(0).getCharacter();
            return winner;
        }
        if(squares.get(2).getCharacter() != ' ' &&
                squares.get(2).getCharacter() == squares.get(4).getCharacter() &&
                squares.get(2).getCharacter() == squares.get(6).getCharacter()){
            winner = squares.get(2).getCharacter();
            return winner;
        }
        // The game continues if there is still at least one empty square
        for(Square square : squares){
            if(square.getCharacter() == ' ') return winner = ' ';
        }
        // If not, we have a draw game ('N'o one is winner)
        return winner = 'N';
    }
}
