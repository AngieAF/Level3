import java.util.Arrays;

public class HashTable
{
    public int size;
    public int step;
    public String [] slots;
    int counter = 0;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];

        for(int i = 0; i < size; i++) {
            slots[i] = null;
        }
    }

    public int hashFun(String value)
    {
        // всегда возвращает корректный индекс слота

        byte[] bytes = value.getBytes();
        int sum = 0;

        for (byte b : bytes) {
            sum += b;
        }

        return sum % size;
    }

    public int seekSlot(String value)
    {
        // находит индекс пустого слота для значения, или -1

        int slotId = hashFun(value);
        int round = 1;

        while (counter <= size) {
            step = step * round;
            if (step >= size) {
               step = 1;
            }

            for (int i = slotId; i < slots.length; i += step) {
                if (slots[i] == null) {
                    counter++;
                    return i;
                }
                if (slots[i] == value) {
                    return i;
                }
            }

            for (int i = 0; i < slotId; i += step) {
                if (slots[i] == null) {
                    counter++;
                    return i;
                }
                if (slots[i] == value) {
                    return i;
                }
            }
            round++;
        }
        return -1;
    }

    public int put(String value)
    {
        // записываем значение по хэш-функции
        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить

        int slotId = seekSlot(value);
        if (slotId == -1) {
            return -1;
        }
        slots[slotId] = value;

        return slotId;
    }

    public int find(String value)
    {
        // находит индекс слота со значением, или -1

        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /*public static void main(String[] args) {
        HashTable hashTable = new HashTable(17, 3);
            System.out.println(hashTable.put("Ddddd"));
    }*/
}
