package board;

/**
 * Created by ritvikmathur on 4/1/17.
 */
public class TicTacBoard {

    final int SIZE;
    private String[][] board;
    private int totalMoves;
    private int lastX=-1, lastY=-1;
    private String lastPlayer = null;


    public TicTacBoard(int size) {
        SIZE = size;
        board = new String[SIZE][SIZE];
        totalMoves = 0;
    }

    public void addMove(String player, int x, int y){
        board[x][y] = player;
        totalMoves++;
        lastX = x;
        lastY = y;
        lastPlayer = player;
    }

    public void printBoard() {
        for(int i = 0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                String val = board[i][j];
                if(val==null)
                    System.out.print("_"+" ");
                else
                    System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    public void reset(){
        board = new String[SIZE][SIZE];
        totalMoves = 0;
        lastX=-1;
        lastY=-1;
        lastPlayer = null;
    }

    public String[][] getBoard() {
        return board;
    }

    public int getSIZE() {
        return SIZE;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    public String getLastPlayer() {
        return lastPlayer;
    }

    @Override
    public String toString() {
        //printBoard();
        return "TicTacBoard{" +
                "SIZE=" + SIZE +
                ", totalMoves=" + totalMoves +
                ", lastX=" + lastX +
                ", lastY=" + lastY +
                ", lastPlayer='" + lastPlayer + '\'' +
                '}';
    }
}
