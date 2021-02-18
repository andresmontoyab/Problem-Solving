import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SwapNodes {

    public static void main(String[] args) {
//        System.out.println("Find the first ");
//        String abcdfddc = findTheFirstUniqueCharacter("abcdfddcaba");
//        System.out.println(abcdfddc);
        System.out.print(" ");
        System.out.print(" ");
        System.out.print("#");
        System.out.println("");

        System.out.print(" ");
        System.out.print("#");
        System.out.print("#");
        System.out.println("");

        System.out.print("#");
        System.out.print("#");
        System.out.print("#");

    }
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] inOrderResult = new int [queries.length][indexes.length];
        for (int i = 0; i< queries.length; i++) {
            int depthLevel = queries[i];
            traverse(1, indexes,0 , depthLevel); // root
            List<Integer> inOrder = new ArrayList<>();
            inorder(indexes, 0, inOrder);
            inOrder.forEach(x -> System.out.println(x));
            inOrderResult[i] = inOrder.stream().mapToInt(x -> x).toArray();
            Map<String,Integer> map = new LinkedHashMap<>();
            Set<String> set = new LinkedHashSet<>();


            /**
            set.size();
            set.contains(key);
            set.add("");
            */

            map.values().stream().mapToInt(x -> x).toArray();
            map.values().stream().collect(Collectors.toList());


            /**map.remove(key);
            map.containsKey(key);
            map.values();

            import java.util.Map;
            */
        }
        long a = 3;
        int c  = (int) a ;
        return inOrderResult;
    }

    public static String findTheFirstUniqueCharacter(String string) {
        Map<String, Integer> characterToOcurrences = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            String character = string.substring(i, i+1);
            if (characterToOcurrences.containsKey(character)) {
                int currentOcurrences = characterToOcurrences.get(character);
                characterToOcurrences.put(character, currentOcurrences  +1);
            } else {
                characterToOcurrences.put(character, 1);
            }
        }
        return characterToOcurrences.keySet() /// all the keys -> LinkedHashSet ->
                .stream()
                .filter(x -> characterToOcurrences.get(x) == 1)
                .findFirst().get();
    }

    private static void inorder(int[][] indexes, int i, List<Integer> inOrder) {
        if (indexes[i][0] != -1) inorder(indexes, indexes[i][0]-1, inOrder);
        inOrder.add(i + 1);
        if (indexes[i][1] != -1) inorder(indexes, indexes[i][1]-1, inOrder);
    }

    private static void traverse(int currentDepth, int[][] indexes, int nodeIndex, int depthLevel) {
        if (currentDepth%depthLevel == 0) {
            traverseNode(indexes, nodeIndex);
        }
        currentDepth = currentDepth +1;
        if (indexes[nodeIndex][0] != -1) {
            traverse(currentDepth, indexes, indexes[nodeIndex][0] -1, depthLevel); // left o the root
        }
        if (indexes[nodeIndex][1] != -1) {
            traverse(currentDepth, indexes, indexes[nodeIndex][1] -1, depthLevel); // Right o the root
        }
    }

    private static void traverseNode(int[][] indexes, int nodeIndex) {
        int aux = indexes[nodeIndex][0]; // Storing left
        indexes[nodeIndex][0] = indexes[nodeIndex][1]; // Replacing Left
        indexes[nodeIndex][1] = aux; // Replacing Right
    }

    private static void printMatrix(int[][] indexes) {
        for (int j = 0; j < indexes.length; j++) {
            System.out.println("Left " + indexes[j][0] + " Right " + indexes[j][1]);
        }
    }
}
