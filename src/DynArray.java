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
        for (int i = 0; i <= count - 1; i++) {
            temp_array[i] = array[i];
        }
        array = temp_array;
        capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[index];
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
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == count) {
            append(itm);
        } else {

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
        if (index < 0 || index > count || count <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (count > 0) {
            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1];
            }
            array[count - 1] = null;
            count--;

            int new_capacity = 0;
            if (count <= (capacity / 2)) {
                new_capacity = capacity * 2 / 3;
                if (new_capacity < 16) {
                    new_capacity = 16;
                }
                makeArray(new_capacity);
            }
        }
    }

    public String arrayPrint() {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += array[i];
            if (i < array.length - 1) {
                str += ", ";
            }
        }
        return "[" + str + "]";
    }

    /*public static void main(String[] args) {
        DynArray dynArr = new DynArray<Integer>(Integer.class);
        int itm = 30;
        dynArr.append(0);
        dynArr.append(1);
        dynArr.append(2);
        dynArr.append(3);
        dynArr.append(4);
        dynArr.append(5);
        dynArr.append(6);
        dynArr.append(7);
        dynArr.append(8);
        dynArr.append(9);
        dynArr.append(10);
        dynArr.append(11);
        dynArr.append(12);
        dynArr.append(13);
        dynArr.append(14);
        dynArr.append(15);

        dynArr.insert(itm, 40);

    } */

}