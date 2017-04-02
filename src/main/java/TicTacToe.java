package main.java;

import main.java.evaluator.Evaluator;
import main.java.evaluator.TicTacToeEvaluator;
import main.java.board.TicTacBoard;

import java.util.Scanner;

/**
 * Created by ritvikmathur on 4/1/17.
 */
public class TicTacToe {

    Evaluator evaluator;

    private TicTacBoard board;

    static final int SIZE = 3;

    public TicTacToe(Evaluator evaluator) throws Exception{
        if(evaluator==null)
            throw new Exception("Evaluator is null!");
        this.evaluator = evaluator;
        init();
    }

    public TicTacToe() throws Exception {
        this(new TicTacToeEvaluator());
    }

    static boolean running = true;

    public static void main(String[] args) {
        try {
            //TicTacToeEvaluator evaluator = new TicTacToeEvaluator();
            //TicTacToe ticTacToe = new TicTacToe(evaluator);
            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init(){
        board = new TicTacBoard(SIZE);
    }

    private void printBanner(){
        System.out.println("******** Tic Tac Toe********");
        System.out.println();
        System.out.println("----Player X plays first----");
    }

    public void play() {
        String[] players = {"X", "O"};
        printBanner();
        while (running){
            for (String player : players){
                if(!running)
                    return;
                board.printBoard();
                boolean played = getInput(player);
                while (!played){
                    board.printBoard();
                    played = getInput(player);
                }
                checkWin();
            }
        }
    }

    private void checkWin() {
        String result = evaluator.evaluateResult(board);
        if(result!=null || (result == null && board.getTotalMoves() == SIZE*SIZE)){
            printResult(result);
            endGame();
        }
    }

    private void printResult(String result) {
        board.printBoard();
        System.out.println(".....GAME OVER.....");
        System.out.println("WINNER="+(result==null?"No Winner":result));
    }

    void endGame(){
        running = false;
    }

    boolean getInput(String player){
        try {
            System.out.println("Enter input for player "+player+" as x y:");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                Scanner sc = new Scanner(scanner.nextLine());
                int x = sc.nextInt();
                if(x>SIZE || x<1) {
                    System.out.println("Invalid Input!");
                    return false;
                }
                int y = sc.nextInt();
                if(y>SIZE || y<1 || board.getBoard()[x-1][y-1]!=null) {
                    System.out.println("Invalid Input!");
                    return false;
                }
                else {
                    board.addMove(player, x-1, y-1);
                    return true;
                }
            }
            return true;
        } catch (Exception e){
            //e.printStackTrace();
            System.out.println("Invalid Input!");
            return false;
        }
    }
}
