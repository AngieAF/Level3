import java.lang.reflect.Array;

public class NativeCache<T> {
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;
    int counter = 0;

    public NativeCache(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[size];
    }

    public int hashFun(String key)
    {
        // всегда возвращает корректный индекс слота
        byte[] bytes = key.getBytes();
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
        int step = 3;

        while (counter <= size && round <= size) {
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
            if (slots[i].equals(key)) {
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
        //int hashId = hashFun(key);
        if (hashId == -1) {
            int min = hits[0];
            int minId = 0;
            for (int i = 1; i < hits.length; i++) {
                if (hits[i] < min) {
                    min = hits[i];
                    minId = i;
                }
            }
            hashId = minId;
        }
        slots[hashId] = key;
        values[hashId] = value;
        hits[hashId] = 0;

    }

    public T get(String key)
    {
        // возвращает value для key,
        // или null если ключ не найден

        int hashId = hashFun(key);
        if (isKey(key)) {
            hits[hashId] += 1;
            return values[hashId];
        }
        return null;
    }

    public static void main(String[] args) {
        NativeCache<Integer> nativeCache = new NativeCache<>(5, Integer.class);
        nativeCache.put("A", 1);
        nativeCache.put("B", 2);
        nativeCache.put("C", 3);
        nativeCache.put("D", 4);
        nativeCache.put("E", 5);
        nativeCache.get("A");
        nativeCache.get("A");
        nativeCache.put("F", 6);
        System.out.println(nativeCache.get("F"));


    }

}
