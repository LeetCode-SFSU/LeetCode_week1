import java.util.ArrayList;
import java.util.Collections;
/*  Google code interview question.
    Given a time for a 24-hour clock(HH MM), find ther earliest time that is based on the given time
    Ex input = "20:10" output = "00:12"
 */
public class Main {
    public static void main(String[] args) {
//        parser("23:16");

        System.out.print(parser("20:10"));
    }
    // time complexity for this algorithm 2n + n log n
    // Collection sort using merge sort algorithm.

    //Solution://
    public static String parser(String s) {
        String old_s = s;
        // parser time
        ArrayList<Integer> a = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ':') continue;
            a.add(Integer.parseInt(s.charAt(i) + ""));
        }
        Collections.sort(a);
        // clear s
        s="";
        for (int j = 0; j < a.size(); j++) {
            //last two digits less then 59...
            if ((a.get(2) * 10 + a.get(3) > 59)) {
                return old_s;
            }
            if (j == 2) s += ":";

            s += a.get(j) + "";

        }
        return s;
    }

}
