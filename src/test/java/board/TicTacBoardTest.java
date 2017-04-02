package test.java.board;

import main.java.board.TicTacBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ritvikmathur on 4/1/17.
 */
public class TicTacBoardTest {

    TicTacBoard board;

    final int SIZE = 3;

    @Before
    public void setUp() throws Exception {
        board = new TicTacBoard(SIZE);
    }

    @Test
    public void addMove() throws Exception {
        board.addMove("X",1,1);
        Assert.assertEquals("Should be X","X",board.getBoard()[1][1]);
    }

    @Test
    public void reset() throws Exception {
        board.addMove("X",1,1);
        board.reset();
        for(int i = 0; i<SIZE; i++){
            for(int j = 0; j<SIZE; j++){
                Assert.assertNull(board.getBoard()[i][j]);
            }
        }
        Assert.assertEquals("Total moves should be 0",0,board.getTotalMoves());
    }

    @Test
    public void getBoard() throws Exception {
        Assert.assertArrayEquals(new String[SIZE][SIZE],board.getBoard());
    }

    @Test
    public void getSIZE() throws Exception {
        Assert.assertEquals(SIZE,board.getSIZE());
    }

    @Test
    public void getLastX() throws Exception {
        board.addMove("X",1,2);
        Assert.assertEquals(1,board.getLastX());
    }

    @Test
    public void getLastY() throws Exception {
        board.addMove("X",1,2);
        Assert.assertEquals(2,board.getLastY());
    }

    @Test
    public void getTotalMoves() throws Exception {
        board.addMove("X",1,2);
        board.addMove("O",2,1);
        Assert.assertEquals(2,board.getTotalMoves());
    }

    @Test
    public void getLastPlayer() throws Exception {
        board.addMove("X",1,2);
        board.addMove("O",2,2);
        board.addMove("X",2,0);
        Assert.assertEquals("X",board.getLastPlayer());
    }

}