import java.util.Arrays;

public class LarrysArray {

    public static void main(String[] args) {
        /**
         * 3
         * 3 1 2
         */
//        int length = 3;
//        int values[] = {3,1,2};

//        int length = 4;
//        int values[] = {1,3,4,2};

//        int length = 5;
//        int values[] = {1,2,3,5,4};

        int length = 6;
        int values[] = {1,6,5,2,3,4};



        System.out.println(validateArray(values));
    }

    private static boolean validateArray(int[] values) {
        int orderedArray[] = createOrderArray(values.length);
        for (int i=0; i<values.length; i ++) {
            if (arraysAreNotEquals(values, orderedArray) && ((i + 2) >= values.length)) return false;
            if (values[i] != i+1) {
                int[][] posibleVariations = searchPosiblesVariations(i, values);
                for (int j= 0; j < posibleVariations.length; j++) {
                    int[] newArray = applyChanges(i, values, posibleVariations[j]);
                    if (newArray[i] == i+1) {
                        values = newArray;
                    }
                }
            }
        }
        if (!arraysAreNotEquals(values, orderedArray)) return true;
        return false;
    }

    private static int[] applyChanges(int i, int[] values, int[] posibleVariation) {
        int[] newArray = new int[values.length];
        newArray = Arrays.copyOf(values, values.length);
        newArray[i] = posibleVariation[0];
        newArray[i+1] = posibleVariation[1];
        newArray[i+2] = posibleVariation[2];
        return newArray;
    }

    private static int[][] searchPosiblesVariations(int i, int[] values) {
        int[][] variations = new int [2][3];
        int [] firstOption = {values[i +1],values[i +2],values[i]};
        int [] secondOption = {values[i +2],values[i],values[i+1]};
        variations[0] = firstOption;
        variations[1] = secondOption;
        return variations;
    }

    private static boolean arraysAreNotEquals(int[] values, int[] orderedArray) {
        for (int i = 0; i < orderedArray.length; i++) {
            if (values[i] != orderedArray[i]) {
                return true;
            }
        }
        return false;
    }

    private static int[] createOrderArray(int length) {
        int[] values = new int[length];
        for (int i = 0; i<length; i++) {
            values[i] = i + 1;
        }
        return values;
    }
}
