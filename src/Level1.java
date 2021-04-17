import java.util.*;

public class Level1
{
    public static int [] WordSearch(int len, String s, String subs) {
        ArrayList<Character> fin = new ArrayList<>();
        int end = len - 1;
        int begin = 0;
        int counter = 0;
        int sub_length = end - begin;

        if(len > s.length())
            len = s.length();
        
        while(counter < s.length()) {
            if(end + len > s.length()) {
                end = s.length() - 1;
            }

            for(int i = end; i >= begin; i--){
                if(s.charAt(i) == ' ') {
                    end = i + 1;
                    break;
                }
            }
            for(int j = begin; j < end; j++)
                fin.add(s.charAt(j));
            fin.add('\n');

            counter += sub_length;

            begin = end;
            end += len;

            if(end + len > s.length()) {
                end = s.length() - 1;
            }

        }

        ArrayList<Integer> res = new ArrayList<>();

        ArrayList<Character> line = new ArrayList<>();
        for(int i = 0; i < fin.size(); i++){
            if(fin.get(i) != '\n') {
                line.add(fin.get(i));
            }
            else {

                StringBuilder result = new StringBuilder(line.size());
                for (Character c : line) {
                    result.append(c);
                }
                String output = result.toString();

                String subs1 = subs + " ";
                String subs2 = " " + subs + " ";
                String subs3 = " " + subs + "\n";

                if(output.contains(subs1) || output.contains(subs2) || output.contains(subs3)){
                    res.add(1);
                } else res.add(0);
                line.clear();
            }
        }

        int [] result = new int [res.size()];
        for(int j =0; j < res.size(); j++){
            result[j] = res.get(j);
        }

        return result;

    }
}
