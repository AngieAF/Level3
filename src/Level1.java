import java.util.*;

public class Level1
{
    public static boolean SherlockValidString(String s) {
        boolean flag = true;
        LinkedHashMap<Character, Integer> symbols = new LinkedHashMap();
        int num = 0;
        for(int i = 0; i < s.length(); i++)
            symbols.put(s.charAt(i), num);

        for(int i = 0; i < s.length(); i++) {
            num = symbols.get(s.charAt(i)) + 1;
            symbols.put(s.charAt(i), num);
        }

        ArrayList<Integer> count_arr = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            count_arr.add(entry.getValue());
        }

        int counter = count_arr.get(0);
        int temp = 0, temp_counter = 0;
        for(int i = 0; i < count_arr.size(); i++) {
            if(count_arr.get(i) != counter) {
                if(temp_counter == 0) {
                    temp = count_arr.get(i) - 1;
                    temp_counter++;
                    if (temp != counter && temp != 0)
                        flag = false;
                } else flag = false;
            }
        }
        ;
        return flag;
    }
}
