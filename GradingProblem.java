import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GradingProblem {
    public static void main(String[] args) {
        List<Integer> results = gradingStudents(Arrays.asList(73, 67, 38, 33));
        results.forEach(x -> System.out.println(x));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream()
                .map(x -> roundGrades(x))
                .collect(Collectors.toList());
    }

    private static Integer roundGrades(Integer x) {
        int module = x % 5;
        if (module > 2 && !(x < 38)) {
            x = x - module + 5;
        }
        return x;
    }

}
