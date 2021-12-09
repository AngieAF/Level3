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
            System.out.println(sum);
        }

        return sum % size;
    }

    public boolean isKey(String key)
    {
        // возвращает true если ключ имеется,
        // иначе false

        return slots[hashFun(key)] != null;
    }

    public void put(String key, T value)
    {
        // гарантированно записываем
        // значение value по ключу key
        int hashId = hashFun(key);
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
        if (hashId == -1) {
            return null;
        }
        return values[hashId];
    }

    /*public static void main(String[] args) {
        NativeDictionary<Integer> nativeDictionary = new NativeDictionary<>(5, Integer.class);
        nativeDictionary.put("Line 1", 1);
        nativeDictionary.put("Line 2", 2);
        System.out.println(nativeDictionary.isKey("Line 1"));
        System.out.println(nativeDictionary.get("Line 35"));

    }*/
}
