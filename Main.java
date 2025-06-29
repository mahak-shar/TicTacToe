import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] matrix = new char[3][3];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            printMatrix(matrix);
            System.out.println("Player " + player + " enter:");
            int row = sc.nextInt(); // put in this row
            int col = sc.nextInt(); // put in this col

            if (matrix[row][col] == ' ') {
                // empty, so place element
                matrix[row][col] = player;
                gameOver = haveWon(matrix, player);
                if (gameOver == true) {
                    System.out.println("Player " + player + " has Win the Game");
                } else {
                    //check whether game is over and its a tie
                    if (isFull(matrix)) {
                        System.out.println("Game is Tie");
                        break;
                    }
                    // another player turn now
                    if (player == 'X')
                        player = '0';
                    else
                        player = 'X';
                }
            } else {
                // alreday filled
                System.out.println("Invalid Move, Try Again");
            }
        }
        printMatrix(matrix);
    }

    public static boolean isFull(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean haveWon(char[][] matrix, char player) {
        // check for rows
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == player && matrix[row][1] == player && matrix[row][2] == player)
                return true;
        }
        // check for col
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == player && matrix[1][col] == player && matrix[2][col] == player)
                return true;
        }
        // check for diagonals
        if (matrix[0][0] == player && matrix[1][1] == player && matrix[2][2] == player)
            return true;

        if (matrix[0][2] == player && matrix[1][1] == player && matrix[2][0] == player)
            return true;

        return false;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " | ");
            }
            System.out.println();
        }
    }

}