import java.util.HashMap;
import java.util.Map;

public class HappyLadyBugs {
    public static void main(String[] args) {
        String example = "RRRR";
        System.out.println(happyLadybugs(example));
    }

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        System.out.println(b);
        Map<String,Integer> ocurrencies = new HashMap<>();
        // At least there is one cell with 1
        for(int i=0; i<b.length(); i++) {
            String currentCharacter = b.substring(i,i+1);
            if(!currentCharacter.equalsIgnoreCase("_")) {
                if (ocurrencies.containsKey(currentCharacter)) {
                    Integer actualOcurrencies = ocurrencies.get(currentCharacter);
                    ocurrencies.put(currentCharacter, actualOcurrencies + 1);
                } else {
                    ocurrencies.put(currentCharacter, 1);
                }
            }
        }
        if (ocurrencies.values().stream().anyMatch(x -> x == 1)) return "NO";


        // There are not empty cells and three cells are not equals
        if (!b.contains("_") && b.length()>2) {
            for(int i=1; i<b.length()-1; i++) { // i <5 -> i++
                if (!b.substring(i, i+ 1).equals(b.substring(i-1,i-1 +1)) && !b.substring(i,i +1).equals(b.substring(i+1,i+1+1))) return "NO";
            }
        }
        return "YES";

    }



}
