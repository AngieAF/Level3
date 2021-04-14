import java.util.*;

public class Level1
{
        public static String PatternUnlock(int N, int [] hits) {

            double length = 0.0;
            for(int i = 0; i < hits.length - 1; i++) {
                if((hits[i] != (N - 1)) && (hits[i] == 6 && hits[i + 1] == 2) || (hits[i] == 2 && hits[i + 1] == 6))
                    length += 1.41421;
                else if((hits[i] != (N - 1)) && (hits[i] == 9 && hits[i + 1] == 2) || (hits[i] == 2 && hits[i + 1] == 9))
                    length += 1.41421;
                else if((hits[i] != (N - 1)) && (hits[i] == 4 && hits[i + 1] == 2) || (hits[i] == 2 && hits[i + 1] == 4))
                    length += 1.41421;
                else if((hits[i] != (N - 1)) && (hits[i] == 7 && hits[i + 1] == 2) || (hits[i] == 2 && hits[i + 1] == 7))
                    length += 1.41421;
                else length += 1;
            }

            double roundDbl = Math.round(length * 100000.0)/100000.0;
            String str = String.valueOf(roundDbl);

            ArrayList<Character> fin = new ArrayList<>();

            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '.' || str.charAt(j) == '0')
                    continue;
                else fin.add(str.charAt(j));
            }

            String arr[] = new String[fin.size()];

            for(int j =0; j < fin.size(); j++)
                arr[j] = String.valueOf(fin.get(j));

            str = String.join("", arr);

            return str;
        }

}
