import java.util.*;

public class Level1
{
    public static String [] ShopOLAP(int N, String [] items) {
        HashMap <String, String> soldGoods = new HashMap<>();

        int temp = 0;
        for(int i = 0; i < items.length - 1; i += 2) {
            if(soldGoods.containsKey(items[i])) {
                temp = Integer.parseInt(soldGoods.get(items[i])) + Integer.parseInt(items[i + 1]);
                soldGoods.put(items[i], String.valueOf(temp));
            }
            else soldGoods.put(items[i], items[i + 1]);
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
                if(Integer.parseInt(fin[k]) > Integer.parseInt(fin[k + 2])) {
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
        return fin;
    }
}
