import java.lang.reflect.Array;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        T [] temp_array = (T[]) Array.newInstance(this.clazz, new_capacity);
        for (int i = 0; i < count - 1; i++) {
            temp_array[i] = array[i];
        }
        array = temp_array;
        capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (index >= 0 && index <= array.length - 1) {
            return array[index];
        } else {
            return null; // add exception here
        }

    }

    public void append(T itm)
    {
        if (count == array.length) {
            makeArray(2 * array.length);
        }

        array[count] = itm;
        count++;

    }

    public void insert(T itm, int index)
    {
        if (index >= 0 && index <= array.length - 1) {
            if (count == array.length) {
                makeArray(2 * array.length);
            }

            for (int i = count - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }

            array[index] = itm;
            count++;
        }
    }

    public void remove(int index)
    {
        if (count > 0) {
            for (int i = index; i <= count - 1; i++) {
                array[i] = array[i + 1];
            }
            count--;
        }

        if ((count * 3) / 2 > 16) {
            makeArray(16);
        }
    }

    /*public static void main(String[] args) {
        DynArray dynArr = new DynArray<Integer>(Integer.class);
        System.out.println(dynArr.capacity);
        dynArr.append(2);
        dynArr.append(10);

        dynArr.remove(1);
        System.out.println(dynArr.getItem(0));

    }*/

}