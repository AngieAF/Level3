import java.util.*;

public class Level1
{
    private static String str = "";
    private static ArrayList<String> string_state = new ArrayList<String>();
    private static boolean undo_flag = false;
    private static int undo_counter = 0;
    private static String undo_str = "";

    public static String BastShoe(String command) {

        if(command.charAt(0) == '1') {
            if(string_state.isEmpty())
                string_state.add("");

            for(int i = 2; i < command.length(); i++)
                str += command.charAt(i);

            if(undo_flag == true) {
                String temp = "";
                undo_counter = 0;
                temp = undo_str;
                string_state.clear();
                string_state.add(temp);
                undo_flag = false;
            }
            string_state.add(str);
            System.out.println(string_state);
            return str;

        } if(command.charAt(0) == '2') {
            if(string_state.isEmpty()) string_state.add("");
            String temp_str = "";
            String N = "";
            for(int i = 2; i < command.length(); i++) {
                N += command.charAt(i);
            }
            if(Integer.parseInt(N) >= str.length()) {
                str = "";
                return str;
            }
            for(int i = 0; i < str.length() - Integer.parseInt(String.valueOf(command.charAt(2))); i++) {
                temp_str += str.charAt(i);
            }
            if(undo_flag == true) {
                String temp = "";
                undo_counter = 0;
                temp = str;
                string_state.clear();
                string_state.add(temp);
            }
            str = "";
            str = temp_str;
            string_state.add(str);
            undo_flag = false;
            System.out.println(string_state);
            return str;

        } if(command.charAt(0) == '3') {
            if(string_state.isEmpty())
                string_state.add("");

            String temp_str = "";
            if(Integer.parseInt(String.valueOf(command.charAt(2))) >= str.length()) {
                return temp_str;
            }
            temp_str = String.valueOf(str.charAt(Integer.parseInt(String.valueOf(command.charAt(2)))));
            return temp_str;

        } if(command.charAt(0) == '4') {
            if(string_state.isEmpty())
                string_state.add("");

            undo_flag = true;
            undo_counter++;
            if(string_state.size() < undo_counter + 1) undo_counter--;
            str = string_state.get(string_state.size() - 1 - undo_counter);
            System.out.println(string_state);
            undo_str = str;
            return str;

        } if(command.charAt(0) == '5') {
            if(string_state.isEmpty())
                string_state.add("");

            if(undo_counter != 0) undo_counter--;
            str = string_state.get(string_state.size() - 1 - undo_counter);
            System.out.println(string_state);
            return str;
        }
        return str;
    }
}
