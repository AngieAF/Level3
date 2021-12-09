import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    int counter = 0;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);

    }

    public int hashFun(String key)
    {
        // всегда возвращает корректный индекс слота
        byte[] bytes = key.getBytes();
        int sum = 0;

        for (byte b : bytes) {
            sum += b;
            //System.out.println("Sum " + sum);
        }

        //System.out.println((sum % size));
        return sum % size;
    }

    public int seekSlot(String value)
    {
        // находит индекс пустого слота для значения, или -1

        int slotId = hashFun(value);
        int round = 1;
        int step = 3;

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

    public boolean isKey(String key)
    {
        // возвращает true если ключ имеется,
        // иначе false
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == key) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value)
    {
        // гарантированно записываем
        // значение value по ключу key
        int hashId = seekSlot(key);
        if (hashId == -1) {
            throw new RuntimeException("Not enough space");
        }
        slots[hashId] = key;
        values[hashId] = value;

    }

    public T get(String key)
    {
        // возвращает value для key,
        // или null если ключ не найден

        int hashId = hashFun(key);
        if (isKey(key)) {
            return values[hashId];
        }
        return null;
    }



    /*public static void main(String[] args) {
        NativeDictionary<Integer> nativeDictionary = new NativeDictionary<>(1000, Integer.class);
        nativeDictionary.put("Line 1", 1);
        nativeDictionary.put("Line 2", 2);
        System.out.println(nativeDictionary.isKey("Line 4"));
        System.out.println(nativeDictionary.get("Line 35"));

        System.out.println(nativeDictionary);
    }*/
}
