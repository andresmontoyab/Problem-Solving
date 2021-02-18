import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MagicSquare {
    private static List<int[][]> magicSquares = new ArrayList<>();

    public void main(String[] args) {
        System.out.println("Start Seaching Less Cost");
        Integer n = 6;
        createMagicSquares(n);
        int[][] matrix = createMatrixTwo();
        int lowestCost = calculateLowerCost(matrix);
        System.out.println("The lowest cost is :" + lowestCost);
    }

    private static int calculateLowerCost(int[][] matrix) {
        return magicSquares.stream()
                .mapToInt(magicSquare -> calculateCostPerMatrix(matrix, magicSquare))
                .min()
                .getAsInt();
    }

    private static int calculateCostPerMatrix(int[][] matrix, int[][] magicSquare) {
        int cost = 0;
        for(int i = 0; i<magicSquare.length; i++) {
            for(int j = 0; j<magicSquare.length; j++) {
                cost = cost + Math.abs(matrix[i][j] - magicSquare[i][j]);
            }
        }
        return cost;
    }

    private static int[][] createMatrixOne() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 5;
        matrix[0][1] = 1;
        matrix[0][2] = 6;

        matrix[1][0] = 3;
        matrix[1][1] = 5;
        matrix[1][2] = 4;

        matrix[2][0] = 4;
        matrix[2][1] = 8;
        matrix[2][2] = 2;
        return matrix;
    }

    private static int[][] createMatrixTwo() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 4;
        matrix[0][1] = 3;
        matrix[0][2] = 8;

        matrix[1][0] = 9;
        matrix[1][1] = 5;
        matrix[1][2] = 1;

        matrix[2][0] = 2;
        matrix[2][1] = 7;
        matrix[2][2] = 5;
        return matrix;
    }

    private static void createMagicSquares(Integer n) {
        List<Integer> availableNumber = createAvailableNumbers(n);
        int [][] magicSqaure = new int [n][n];
        createPosibleMagicSquares(availableNumber, n, 0 , 0, magicSqaure);
        System.out.println();
    }

    private static void createPosibleMagicSquares(List<Integer> availableNumbers, Integer n, int x, int y, int[][] magicSquare) {
        if (availableNumbers.isEmpty()) {
            if (isAMagicSquare(magicSquare)) {
                addMagicSquareToMemory(magicSquare);
                printMagicSquare(magicSquare, n);
            }
            return;
        }
        for (Integer availableNumber: availableNumbers) {
            magicSquare[x][y] = availableNumber;
            List<Integer> newAvailableNumbers = new ArrayList<>(availableNumbers);
            newAvailableNumbers.remove(availableNumber);
            int[] nextPositon = findNextPosition(x,y,n);
            createPosibleMagicSquares(newAvailableNumbers, n, nextPositon[0] , nextPositon[1], magicSquare);
        }

    }

    private static void addMagicSquareToMemory(int[][] magicSquare) {
        int n = magicSquare.length;
        int[][] magicSquareCopy = new int [n][n];
        for (int i = 0; i < n ; i ++ ) {
            for (int j = 0; j < n ; j ++ ) {
                magicSquareCopy[i][j] = magicSquare[i][j];
            }
        }
        magicSquares.add(magicSquareCopy);
    }

    private static boolean isAMagicSquare(int[][] magicSqaure) {
        List<Integer> sumSides = new ArrayList<>();
        Integer auxSum = 0;
        calculateRowSums(magicSqaure, sumSides);
        calculateColumsSums(magicSqaure, sumSides);
        calculateDiagonalSums(magicSqaure, sumSides);
        return allSideAreEquals(sumSides);
    }

    private static boolean allSideAreEquals(List<Integer> sumSides) {
        return sumSides.stream().distinct().count() == 1;
    }

    private static void calculateDiagonalSums(int[][] magicSqaure, List<Integer> sumSides) {
        Integer auxMainDiagonal = 0;
        Integer otherDiagonal = 0;
        for(int i = 0; i<magicSqaure.length; i++) {
            for(int j = 0; j<magicSqaure.length; j++) {
                if ( i - j == 0) {
                    auxMainDiagonal = auxMainDiagonal + magicSqaure[i][j];
                }
                if ((i+j+1) == magicSqaure.length) {
                    otherDiagonal= otherDiagonal+ magicSqaure[i][j];
                }
            }
        }
        sumSides.add(otherDiagonal);
        sumSides.add(auxMainDiagonal);
    }

    private static void calculateRowSums(int[][] magicSqaure, List<Integer> sumSides) {
        Integer auxSum;
        for(int i = 0; i<magicSqaure.length; i++) {
            auxSum = 0;
            for(int j = 0; j<magicSqaure.length; j++) {
                auxSum = auxSum + magicSqaure[j][i];
            }
            sumSides.add(auxSum);
        }
    }

    private static void calculateColumsSums(int[][] magicSqaure, List<Integer> sumSides) {
        Integer auxSum;
        for(int i = 0; i<magicSqaure.length; i++) {
            auxSum = 0;
            for(int j = 0; j<magicSqaure.length; j++) {
                auxSum = auxSum + magicSqaure[i][j];
            }
            sumSides.add(auxSum);
        }
    }

    private static void printMagicSquare(int[][] magicSqaure, Integer n) {
        for(int i = 0; i<magicSqaure.length; i++) {
            for(int j = 0; j<magicSqaure.length; j++) {
                System.out.print(magicSqaure[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    private static int[] findNextPosition(int x, int y, Integer n) {
        int[] nextPosition = new int[2];
        if (((x+1) == n) && ((y+1) ==n)) {
            nextPosition[0]=-1;
            nextPosition[1]=-1;
            return nextPosition;
        }
        if (((x+1) == n)) {
            nextPosition[0]=0;
            nextPosition[1]=y+1;
            return nextPosition;
        }

        if (x < n) {
            nextPosition[0]=x+1;
            nextPosition[1]=y;
        }
        return nextPosition;
    }

    private static List<Integer> createAvailableNumbers(Integer n) {
        return Stream.iterate(1, i -> i +1)
                .limit(n*n)
                .collect(Collectors.toList());
    }
}

