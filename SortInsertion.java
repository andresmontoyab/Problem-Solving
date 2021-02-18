import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortInsertion {
    public static void main(String[] args) {

        int[] values = {2,3,4,5,6,7,8,9,10,1};
        int[] valuesSolutionTwo = {1,4,3,5,6,2};
        //Arrays.asList(1,2,3).toString().spl;
      //  sortedLastPosition(values.length, values);
        sortedSolutionTwo(valuesSolutionTwo.length, valuesSolutionTwo);

    }

    private static void sortedSolutionTwo(int length, int[] valuesSolutionTwo) {
        for (int i = 2; i<=length; i++) {
            sortedLastPosition(i, valuesSolutionTwo);
            printArray(valuesSolutionTwo);
        }
    }

    private static void sortedLastPosition(int n, int[] values) {
        int valueToSort = values[n-1];
        for (int i = n - 2; i >= 0; i--) {
            if (valueToSort <= values[i]) {
                values[i+1] = values[i];
                if (i == 0) {
                    values[i+1] = values[i];
                    values[i] = valueToSort;
                }
            } else {
                values[i+1] = valueToSort;
                break;
            }
        }
    }

    private static void printArray(int[] values) {
        for (int i =0; i<values.length; i++){
            System.out.print(values[i]+" ");
        }
        System.out.println("");
    }
}

