package ritvik.evaluator;

import org.junit.*;
import ritvik.board.TicTacBoard;

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
        board.addMove("O",1,1);
        board.addMove("O",2,2);
        System.out.println(board.toString());
        Assert.assertEquals("O should win","O",evaluator.evaluateResult(board));
    }

    @Test
    public void evaluateBackwardDiagonal() throws Exception {
        board.addMove("X",0,0);
        board.addMove("X",1,1);
        board.addMove("X",2,2);
        System.out.println(board.toString());
        Assert.assertTrue("Should return True",evaluator.evaluateBackwardDiagonal(0,0));
    }

    @Test
    public void evaluateForwardDiagonal() throws Exception {
        board.addMove("X",0,2);
        board.addMove("X",1,1);
        board.addMove("X",2,0);
        System.out.println(board.toString());
        Assert.assertTrue("Should return True",evaluator.evaluateForwardDiagonal(2,0));
    }

    @Test
    public void evaluateCol() throws Exception {
        board.addMove("O",0,0);
        board.addMove("O",1,0);
        board.addMove("O",2,0);
        System.out.println(board.toString());
        Assert.assertTrue("Should return True",evaluator.evaluateCol(0));
        Assert.assertFalse("Should return False",evaluator.evaluateCol(1));
        Assert.assertFalse("Should return False",evaluator.evaluateCol(2));
    }

    @Test
    public void evaluateRow() throws Exception {
        board.addMove("O",0,0);
        board.addMove("O",0,1);
        board.addMove("O",0,2);
        System.out.println(board.toString());
        Assert.assertTrue("Should return True",evaluator.evaluateRow(0));
        Assert.assertFalse("Should return False",evaluator.evaluateRow(1));
        Assert.assertFalse("Should return False",evaluator.evaluateRow(2));
    }


}