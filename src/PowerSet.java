import java.util.ArrayList;

public class PowerSet
{
    ArrayList<String> set = new ArrayList<>();

    public PowerSet()
    {

    }

    public int size()
    {
        // количество элементов в множестве
        return set.size();
    }


    public void put(String value)
    {
        // всегда срабатывает
        if (!set.contains(value)) {
            set.add(value);
        }
    }

    public boolean get(String value)
    {
        // возвращает true если value имеется в множестве,
        // иначе false

        return set.contains(value);
    }

    public boolean remove(String value)
    {
        // возвращает true если value удалено
        // иначе false

        return set.remove(value);
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        PowerSet powerSet = new PowerSet();

        for (String element : set) {
            if (set2.get(element)) {
                powerSet.put(element);
            }
        }
        return powerSet;
    }

    public PowerSet union(PowerSet set2)
    {
        // объединение текущего множества и set2
        PowerSet powerSet = new PowerSet();

        for (String element : set) {
            powerSet.put(element);
        }

        for (String element : set2.set) {
            powerSet.put(element);
        }
        return powerSet;
    }


    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        PowerSet powerSet = new PowerSet();

        for (String element : set) {
            if (!set2.get(element)) {
                powerSet.put(element);
            }
        }
        
        return powerSet;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        for (String element : set2.set) {
            if (!set.contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {

        return set.toString();
    }

    public static void main(String[] args) {
        PowerSet set1 = new PowerSet();
        set1.put("A");
        set1.put("B");
        set1.put("C");
        set1.put("D");
        set1.put("E");

        PowerSet set2 = new PowerSet();
        set2.put("A");
        set2.put("B");
        //set2.put("F");

        System.out.println(set1.size());
        System.out.println(set1.get("D"));
        System.out.println(set1.remove("O"));

        System.out.println(set1.difference(set2));


    }
}
