import java.util.*;

public class Level1
{
    private static String str = "";
    private static ArrayList<String> string_state = new ArrayList<String>();
    private static boolean undo_flag = false;
    private static int undo_counter = 0;
    private static String last_action = "";

    public static String BastShoe(String command) {

        if(command.charAt(0) == '1') {
            for(int i = 2; i < command.length(); i++)
                str += command.charAt(i);
            if(undo_flag == true) {
                String temp = "";
                undo_counter = 0;
                temp = string_state.get(string_state.size() - 1);
                string_state.clear();
                string_state.add(temp);
            }
            string_state.add(str);
            last_action = "";
            last_action = command;
            undo_flag = false;
            return str;

        } if(command.charAt(0) == '2') {

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
            last_action = "";
            last_action = command;
            undo_flag = false;
            return str;

        } if(command.charAt(0) == '3') {
            String temp_str = "";
            if(Integer.parseInt(String.valueOf(command.charAt(2))) >= str.length()) {
                return temp_str;
            }
            temp_str = String.valueOf(str.charAt(Integer.parseInt(String.valueOf(command.charAt(2)))));
            return temp_str;

        } if(command.charAt(0) == '4') {
            undo_counter++;
            if(string_state.size() < undo_counter + 1) undo_counter--;
            str = string_state.get(string_state.size() - 1 - undo_counter);
            undo_flag = true;
            return str;

        } if(command.charAt(0) == '5') {
            if(undo_counter != 0) undo_counter--;
            str = string_state.get(string_state.size() - 1 - undo_counter);
            return str;
        }
        return str;
    }

}
