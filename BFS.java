import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFS {

    private static Set<Integer> alreadyVisited = new HashSet<>();
    public static void main(String[] args) {
        int[][] edges = new int[6][2];
        edges[0][0] = 3;
        edges[0][1] = 1;

        edges[1][0] = 10;
        edges[1][1] = 1;

        edges[2][0] = 10;
        edges[2][1] = 1;

        edges[3][0] = 3;
        edges[3][1] = 1;

        edges[4][0] = 1;
        edges[4][1] = 8;

        edges[5][0] = 5;
        edges[5][1] = 2;

        int[] bfs = bfs(10, 6, edges, 3);
        for (int i = 0; i < bfs.length; i++) {
            System.out.println(bfs[i]);
        }
    }

    static int[] bfs(int nodes, int edges, int[][] edgesPairs, int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        alreadyVisited = new HashSet<>();
        int[] result = new int[nodes-1];
        queue.addFirst(start);
        alreadyVisited.add(start);
        while(!queue.isEmpty()) {
            Integer currentValue = queue.getFirst();
            int prevValue;
            if (currentValue == start) {prevValue=0;}
            else if (currentValue > start) {prevValue = result[currentValue-2];}
            else {prevValue= result[currentValue-1];}
            Set<Integer> nextMovement = searchPosibleMovement(currentValue, edgesPairs);
            nextMovement.forEach(movement -> {
                if (!alreadyVisited.contains(movement)) {
                    if (movement > start) {
                        result[movement-2] = prevValue + 6;
                    } else if (movement < start) {
                        result[movement -1] = prevValue +6;
                    }
                    alreadyVisited.add(movement);
                    if(!queue.contains(movement)) queue.addLast(movement);
                }
            });
            queue.removeFirst();
        }
        return updateUnreachableNodes(start, result);
    }

    private static int[] updateUnreachableNodes(int start, int[] result) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) result[i] = -1;
        }
        return result;
    }

    private static Set<Integer> searchPosibleMovement(Integer currentValue, int[][] edgesPairs) {
        Set<Integer> nextMovements = new HashSet<>();
        for(int i = 0; i < edgesPairs.length; i++) {
            if (edgesPairs[i][0] == currentValue && !alreadyVisited.contains(edgesPairs[i][1])) {
                nextMovements.add(edgesPairs[i][1]);
            }else if (edgesPairs[i][1] == currentValue && !alreadyVisited.contains(edgesPairs[i][0]))  {
                nextMovements.add(edgesPairs[i][0]);
            }
        }
        nextMovements.remove(currentValue);
        return nextMovements;
    }
}
