import java.util.*;

public class Level1
{
    public static String [] ShopOLAP(int N, String [] items) {


        HashMap <String, String> soldGoods = new HashMap<>();

        int temp = 0;
        for(int i = 0; i < N; i++) {
            String temp_key = "", temp_value = "";
            for(int j = 0; j < items[i].length(); j++) {
                if(items[i].charAt(j) != ' ') {
                    temp_key += items[i].charAt(j);
                } else {
                    for(int k = j + 1; k <= items[i].length() - 1; k++)
                        temp_value += items[i].charAt(k);
                    break;
                }
            }
            if(soldGoods.containsKey(temp_key)) {
                temp = Integer.parseInt(soldGoods.get(temp_key)) + Integer.parseInt(temp_value);
                soldGoods.put(temp_key, String.valueOf(temp));
            }
            else soldGoods.put(temp_key, temp_value);
        }

        String [] fin = new String[soldGoods.size() * 2];

        int i = 0;

        for (String key : soldGoods.keySet()) {
            fin[i] = key;
            i += 2;
            if(i == (soldGoods.size() * 2 - 1)) break;
        }

        int j = 1;
        for (String value : soldGoods.values()) {
            fin[j] = value;
            j += 2;
            if(j == (soldGoods.size() * 2)) break;
        }

        String num = "", item = "";
        boolean sorted = false;

        while(!sorted) {
            for(int k = 1; k < fin.length - 2; k += 2) {
                sorted = true;
                if(Integer.parseInt(fin[k]) < Integer.parseInt(fin[k + 2])) {
                    num = fin[k];
                    item = fin[k - 1];
                    fin[k] = fin[k + 2];
                    fin[k - 1] = fin[k + 1];
                    fin[k + 2] = num;
                    fin[k + 1] = item;
                    sorted = false;
                }
            }
        }
        String [] fin_arr = new String[fin.length / 2];
        int s = 0;
        for(int k = 0; k < fin.length; k += 2) {
            fin_arr[s] = fin[k] + " " + fin[k + 1];
            s++;
        }

        return fin_arr;
    }
}
