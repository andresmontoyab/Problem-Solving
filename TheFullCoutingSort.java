import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheFullCoutingSort {
    public static void main(String[] args) {
        List<List<String>> initial = new ArrayList<>();
        initial.add(Arrays.asList("0", "ab"));
        initial.add(Arrays.asList("2", "cd"));
        initial.add(Arrays.asList("0", "ef"));
        initial.add(Arrays.asList("0", "za"));
        countSort(initial);
    }

    static void countSort(List<List<String>> arr) {
        Map<Integer, StringBuilder> result = new HashMap<>();
        int oc = 0;
        for (int i = 0; i < arr.size(); i++) {
            oc = Integer.parseInt(arr.get(i).get(0));
            StringBuilder value = i < (arr.size()/2) ? new StringBuilder("- ") : new StringBuilder(arr.get(i).get(1)+" ");
            result.compute(oc, (key, val) -> {
                if (val == null) return value;
                return val.append(value);
            });
        }
        result.values().stream()
                .map(x -> x.toString())
                .forEach(x -> System.out.print(x));

    }

}
