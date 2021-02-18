public class QueenAttacksTwoTwo {
    public static void main(String[] args) {
        /**
         * 5 3
         * 4 3
         * 5 5
         * 4 2
         * 2 3
         */
        int[][] obstacles_position = new int[3][2];
        obstacles_position[0][0] = 5;
        obstacles_position[0][1] = 5;

        obstacles_position[1][0] = 4;
        obstacles_position[1][1] = 2;

        obstacles_position[2][0] = 2;
        obstacles_position[2][1] = 3;

        int queensAttack = queensAttack(100 , 0, 48 , 81, null);
        System.out.println(queensAttack );
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int amountOfposibleAttacks = 0;
        int[][] matrix = new int [n][n];
        placeObstacleAndQueens(obstacles, r_q,c_q, matrix);
        int[][] availableMovement = createAvailableMovements();
        for (int i = 0; i < availableMovement.length; i ++){
            int queenNextRow = r_q  - 1+ availableMovement[i][0];
            int queenNextColumn = c_q -1 + availableMovement[i][1];
            amountOfposibleAttacks = amountOfposibleAttacks  + countPosibleMovements(queenNextRow, queenNextColumn, availableMovement[i], obstacles, n);
        }
        printMatrix(matrix);
        return amountOfposibleAttacks;
    }

    private static void placeObstacleAndQueens(int[][] obstacles, int r_q, int c_q, int[][] matrix) {
        matrix[r_q-1][c_q-1] = 1;
        if (obstacles != null) {
            for (int i = 0; i < obstacles.length; i++) {
                matrix[obstacles[i][0] - 1][obstacles[i][1] - 1] = 2;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static int countPosibleMovements(int queenNextRow, int queenNextColumn, int[] direction, int[][] obstacles, int boardSize ) {

        int amount = 0;
        while(!(isStillInTheBoard(queenNextRow, queenNextColumn, boardSize) || isNotAnObstacule(queenNextRow,queenNextColumn, obstacles)))  {
            System.out.println("Row :" + queenNextRow + " and Column " + queenNextColumn );
            amount=amount+1;
            queenNextRow = queenNextRow + direction[0];
            queenNextColumn = queenNextColumn + direction[1];
        }
        return amount;
    }

    private static boolean isNotAnObstacule(int queenNextRow, int queenNextColumn, int[][] obstacles) {
        if (obstacles == null) return false;
        for (int i=0; i <obstacles.length; i++){
            if (queenNextRow == (obstacles[i][0]-1) && queenNextColumn == (obstacles[i][1]-1)) return true;
        }
        return false;
    }

    private static boolean isStillInTheBoard(int queenNextRow, int queenNextColumn, int boardSize) {
        return (queenNextColumn >= boardSize
                || queenNextRow >= boardSize
                || queenNextRow < 0
                || queenNextColumn < 0);
    }

    private static int[][] createAvailableMovements() {
        int[][] queenMovements = new int[8][2];
        // Down
        queenMovements[0][0] = 1;
        queenMovements[0][1] = 0;

        // Down Right Diagonal
        queenMovements[1][0] = 1;
        queenMovements[1][1] = 1;

        // Right
        queenMovements[2][0] = 0;
        queenMovements[2][1] = 1;

        // Up Right Diagonal
        queenMovements[3][0] = -1;
        queenMovements[3][1] = 1;

        // Up
        queenMovements[7][0] = -1;
        queenMovements[7][1] = 0;

        // Up Left Diagonal
        queenMovements[4][0] = -1;
        queenMovements[4][1] = -1;

        // Left
        queenMovements[5][0] = 0;
        queenMovements[5][1] = -1;

        // Left down Diagonal
        queenMovements[6][0] = 1;
        queenMovements[6][1] = -1;
        return queenMovements;
    }
}
