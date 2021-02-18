import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Climbing {

    private static List<Integer> ranked = Arrays.asList(100,90,90,80,75,60);
    //private static List<Integer> plays = Arrays.asList(50,65,77,90,102);
    private static List<Integer> plays = Arrays.asList(110,120,130,140,150);

    public static void main(String[] args) {
        List<Integer> result = climbingLeaderboard(ranked, plays);
        System.out.println(result);
    }

    private static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> plays) {
        List<Integer> rankedOrder = ranked.stream()
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
        return plays.stream()
                .map(scorePlay -> retrievePositionInRaked(scorePlay, rankedOrder))
                .collect(Collectors.toList());
    }

    private static Integer retrievePositionInRaked(Integer scorePlay, List<Integer> rankedOrder) {
        int position = Collections.binarySearch(rankedOrder, scorePlay, (Integer o1, Integer o2) -> -o1.compareTo(o2));
        if (position > -1) {
            return position +1;
        }
        position = (position + 1) * -1;
        rankedOrder.add(position, scorePlay);
        return position + 1;
    }
}


/// Ranked 100,90,90,80,75,65,60,50
// 100,90,90,80,75,60,50

// -2  -> -8 + 1 = -7