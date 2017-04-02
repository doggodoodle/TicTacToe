package main.java.evaluator;

import main.java.board.TicTacBoard;

/**
 * Created by ritvikmathur on 4/1/17.
 */
public class TicTacToeEvaluator implements Evaluator {

    private TicTacBoard board;
    private int x;
    private int y;
    private int size;

    public String evaluateResult(TicTacBoard board) {

        this.board = board;
        this.x = board.getLastX();
        this.y = board.getLastY();
        this.size = board.getSIZE();

        if( ((board.getTotalMoves()>=size*2-1) && x>=0 && y>=0) && (evaluateRow(x) || evaluateCol(y) || evaluateForwardDiagonal(x, y) || evaluateBackwardDiagonal(x,y)))
            return board.getLastPlayer();
        else
            return null;
    }

    private boolean evaluateBackwardDiagonal(int x, int y) {
        if(x==y){
            String p = board.getBoard()[0][0];
            for(int i = 1; i < size; i++){
                if(board.getBoard()[i][i]==null || !board.getBoard()[i][i].equals(p))
                    return false;
            }
            return true;
        }
        else
            return false;
    }

    private boolean evaluateForwardDiagonal(int x, int y) {
        if(x+y == size-1){
            String p = board.getBoard()[0][size-1];
            for(int i = 1, j = size-2; i<size; i++, j--){
                if(board.getBoard()[i][j]==null || !board.getBoard()[i][j].equals(p))
                    return false;
            }
            return true;
        }
        else
            return false;
    }

    private boolean evaluateCol(int y) {
        String p = board.getBoard()[0][y];
        for(int i = 1; i < size; i++){
            if(board.getBoard()[i][y]==null || !board.getBoard()[i][y].equals(p))
                return false;
        }
        return true;
    }

    private boolean evaluateRow(int x) {
        String p = board.getBoard()[x][0];
        for(int i = 1; i < size; i++){
            if(board.getBoard()[x][i]==null || !board.getBoard()[x][i].equals(p))
                return false;
        }
        return true;
    }
}
