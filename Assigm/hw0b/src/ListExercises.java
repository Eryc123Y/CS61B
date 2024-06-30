import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum = 0;
        for (var num: L) {
            sum += num;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evenNums = new ArrayList<Integer>();
        for (int num: L) {
            if (num %2 == 0) {
                evenNums.add(num);
            }
        }

        return evenNums;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        var res = new ArrayList<Integer>();

        for (Integer value : L1) {
            for (Integer integer : L2) {
                if (value.equals(integer)) {
                    res.add(value);
                }
            }
        }
        return res;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int totalOccurrences = 0;

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    totalOccurrences++;
                }
            }
        }

        return totalOccurrences;
    }
}
