import java.util.HashMap;
import java.util.Map;

public class TimeInWords {

    public static void main(String[] args) {
        System.out.println(timeInWords(3, 00));
        System.out.println(timeInWords(7, 15));
        System.out.println(timeInWords(5, 47));
        System.out.println(timeInWords(6, 35));
        System.out.println(timeInWords(1, 1));
    }

    private static String timeInWords(int h, int m) {
        StringBuilder timeInWords  = new StringBuilder("");
        if (m == 0) {
            timeInWords.append(MapNumberToWord.retrieveHourWordByNumber(h) + " o' clock");
        } else if (m > 0 && m <= 30) {
            String minutes = findMinutesInWord(m);
            timeInWords.append(minutes +" past " + MapNumberToWord.retrieveHourWordByNumber(h));
        } else if (m > 30){
            Integer minutes = 60 - m;
            String minutesInWord = findMinutesInWord(minutes);
            timeInWords.append(minutesInWord +" to " + MapNumberToWord.retrieveHourWordByNumber(h + 1));
        }
        return timeInWords.toString();
    }

    private static String findMinutesInWord(int m) {
        if (m == 30) return "half";
        if (m > 0 && m < 20) {
            return MapNumberToWord.retrieveMinutesWordByNumber(m);
        } else {
            Integer firstDigit = Integer.valueOf(String.valueOf(m).substring(0,1).concat("0"));
            Integer secondDigit = Integer.valueOf(String.valueOf(m).substring(1,2));
            return MapNumberToWord.retrieveHourWordByNumber(firstDigit) + " " + MapNumberToWord.retrieveMinutesWordByNumber(secondDigit);
        }
    }

}

class MapNumberToWord {
    public static Map<Integer, String> mapNumberToWord = new HashMap<>();
    static {
        mapNumberToWord.put(1, "One");
        mapNumberToWord.put(2, "Two");
        mapNumberToWord.put(3, "Three");
        mapNumberToWord.put(4, "Four");
        mapNumberToWord.put(5, "Five");
        mapNumberToWord.put(6, "Six");
        mapNumberToWord.put(7, "Seven");
        mapNumberToWord.put(8, "Eight");
        mapNumberToWord.put(9, "Nine");
        mapNumberToWord.put(10, "Ten");
        mapNumberToWord.put(11, "Eleven");
        mapNumberToWord.put(12, "TWELVE");
        mapNumberToWord.put(13, "THIRTEEN");
        mapNumberToWord.put(14, "FOURTEEN");
        mapNumberToWord.put(15, "quarter");
        mapNumberToWord.put(16, "SIXTEEN");
        mapNumberToWord.put(17, "SEVENTEEN");
        mapNumberToWord.put(18, "EIGHTEEN");
        mapNumberToWord.put(19, "NINETEEN");
        mapNumberToWord.put(20, "TWENTY");
        mapNumberToWord.put(30, "THIRTY");
        mapNumberToWord.put(40, "FOURTY");
        mapNumberToWord.put(50, "FIFTY");
    }

    public static String retrieveMinutesWordByNumber(int number){
        String specialTime = "quarter";
        String numberInWord = mapNumberToWord.get(number).toLowerCase();
        if ("One".equalsIgnoreCase(numberInWord)) return "one minute";
        if (specialTime != numberInWord) {
            return numberInWord + " minutes";
        }
        return numberInWord;
    }

    public static String retrieveHourWordByNumber(int number){
        return mapNumberToWord.get(number).toLowerCase();
    }
}
