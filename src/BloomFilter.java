public class BloomFilter
{
    public int filter_len;
    int data = 0;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...

    }

    public void setBit(int pos) {
        data |= 1 << pos;
    }

    // хэш-функции
    public int hash1(String str1)
    {
        // 17
        int sum = 0;
        for(int i = 0; i < str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            sum = sum * 17 + code;
        }
        // реализация ...
        return sum % filter_len;
    }
    public int hash2(String str1)
    {
        // 223
        int sum = 0;
        for(int i = 0; i < str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            sum = sum * 223 + code;
        }
        // реализация ...
        return sum % filter_len;
    }

    public void add(String str1)
    {
        // добавляем строку str1 в фильтр
        setBit(hash1(str1));
        setBit(hash2(str1));

    }

    public boolean isValue(String str1)
    {
        // проверка, имеется ли строка str1 в фильтре
        boolean isSet1 = ((data << (31 - hash1(str1))) < 0);
        boolean isSet2 = ((data << (31 - hash2(str1))) < 0);

        if (!(isSet1 && isSet2)) {
            return false;
        }
        return true;
    }

    /*public static void main(String[] args) {
        BloomFilter filter = new BloomFilter(32);
        filter.setBit(3);
        filter.setBit(4);
        System.out.println(filter.data);
        filter.add("0123456789");
        System.out.println(filter.isValue("0123456789"));
    }*/
}

