package ritvik.evaluator;

import ritvik.board.TicTacBoard;

/**
 * Created by ritvikmathur on 4/1/17.
 */
public class TicTacToeEvaluator implements Evaluator {

    TicTacBoard board;
    int x;
    int y;
    int size;

    public String evaluateResult(TicTacBoard board) {

        this.board = board;
        this.x = board.getLastX();
        this.y = board.getLastY();
        this.size = board.getSIZE();
        //this.p = board.getLastPlayer();


        if((x>=0 && y>=0) && (evaluateRow(x) || evaluateCol(y) || evaluateForwardDiagonal(x, y) || evaluateBackwardDiagonal(x,y)))
            return board.getLastPlayer();
        else
            return null;
    }

    protected boolean evaluateBackwardDiagonal(int x, int y) {
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

    protected boolean evaluateForwardDiagonal(int x, int y) {
        if(x+y == size -1){
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

    protected boolean evaluateCol(int y) {
        String p = board.getBoard()[0][y];
        for(int i = 1; i < size; i++){
            if(board.getBoard()[i][y]==null || !board.getBoard()[i][y].equals(p))
                return false;
        }
        return true;
    }

    protected boolean evaluateRow(int x) {
        String p = board.getBoard()[x][0];
        for(int i = 1; i < size; i++){
            if(board.getBoard()[x][i]==null || !board.getBoard()[x][i].equals(p))
                return false;
        }
        return true;
    }
}
