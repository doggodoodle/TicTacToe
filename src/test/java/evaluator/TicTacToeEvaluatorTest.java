package test.java.evaluator;

import main.java.evaluator.TicTacToeEvaluator;
import org.junit.*;
import main.java.board.TicTacBoard;

/**
 * Created by ritvikmathur on 4/1/17.
 */
public class TicTacToeEvaluatorTest {
    TicTacToeEvaluator evaluator = new TicTacToeEvaluator();
    int size = 3;
    TicTacBoard board = new TicTacBoard(size);

    @Before
    public void setUp() throws Exception {
        evaluator.evaluateResult(board);
    }

    @After
    public void reset() throws Exception {
        board.reset();
    }

    @Test
    public void evaluateResult() throws Exception {
        board.addMove("O",0,0);
        board.addMove("X",1,0);
        board.addMove("O",1,1);
        board.addMove("X",1,2);
        board.addMove("O",2,2);
        System.out.println(board.toString());
        Assert.assertEquals("O should win","O",evaluator.evaluateResult(board));
    }

    @Test
    public void evaluateBackwardDiagonal() throws Exception {
        board.addMove("X",0,0);
        board.addMove("O",0,1);
        board.addMove("X",1,1);
        board.addMove("O",2,1);
        board.addMove("X",2,2);
        System.out.println(board.toString());
        Assert.assertEquals("X should win","X",evaluator.evaluateResult(board));
    }

    @Test
    public void evaluateForwardDiagonal() throws Exception {
        board.addMove("X",0,2);
        board.addMove("O",0,0);
        board.addMove("X",1,1);
        board.addMove("O",2,2);
        board.addMove("X",2,0);
        System.out.println(board.toString());
        Assert.assertEquals("X should win","X",evaluator.evaluateResult(board));
    }

    @Test
    public void evaluateCol() throws Exception {
        board.addMove("O",0,0);
        board.addMove("X",0,1);
        board.addMove("O",1,0);
        board.addMove("X",0,2);
        board.addMove("O",2,0);
        System.out.println(board.toString());
        Assert.assertEquals("O should win","O",evaluator.evaluateResult(board));
    }

    @Test
    public void evaluateRow() throws Exception {
        board.addMove("O",0,0);
        board.addMove("X",1,2);
        board.addMove("O",0,1);
        board.addMove("X",1,0);
        board.addMove("O",0,2);
        System.out.println(board.toString());
        Assert.assertEquals("O should win","O",evaluator.evaluateResult(board));
    }

    @Test
    public void evaluateNotEnoughMoves() throws Exception {
        board.addMove("O",0,0);
        board.addMove("X",1,2);
        System.out.println(board.toString());
        Assert.assertNull(evaluator.evaluateResult(board));
    }

}