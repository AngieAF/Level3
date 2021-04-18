import java.util.*;

public class Level1
{
    public static int [] WordSearch(int len, String s, String subs) {
        public static void main(String[] args) {
            String s = "1) строка разбивается на набор строк через выравнивание по заданной ширине.";
            WordSearch(12, s, "строк");
        }
        public static int [] WordSearch(int len, String s, String subs) {

            ArrayList<Character> fin = new ArrayList<>();
            int end = len;
            int begin = 0;
            int counter = 0;
            int sub_length = end - begin;
            boolean flag = false;

            if(len > s.length())
                len = s.length();

            while(counter < s.length()) {
                if(end >= s.length()) {
                    end = s.length();
                }

                for(int i = end - 1; i >= begin; i--){
                    if(s.charAt(i) == ' ') {
                        end = i + 1;
                        flag = true;
                        break;
                    }
                }


                for(int j = begin; j < end; j++) {
                    fin.add(s.charAt(j));
                    System.out.println(fin);
                }
                fin.add('\n');

                counter += sub_length;

                begin = end;
                end += len;

            }

            System.out.println(fin);
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
                    System.out.println(output);
                    String subs1 = subs + " ";
                    String subs2 = " " + subs + " ";
                    String subs3 = " " + subs + "\n";
                    String subs4 = subs + "\n";

                    if(output.contains(subs1) || output.contains(subs2) || output.contains(subs3) || output.contains(subs4)
                            || output.equals(subs)){
                        res.add(1);
                    } else res.add(0);
                    line.clear();
                }
            }

            System.out.println(res);

            int [] result = new int [res.size()];
            for(int j = 0; j < res.size(); j++){
                result[j] = res.get(j);
            }

            for(int i = 0; i < result.length; i++)
                System.out.print(result[i]);

            return result;

        }
}
