package rtu.klokov.labs.lab11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Integer> integers = newArrayList (10, 20);
        System.out.println(integers.get(0) + " " + integers.get(1));
        HashMap<Integer, Integer> hash = newHashMap(integers, integers);
        System.out.println(hash.get(20) + " " + hash.get(10));
        HashSet<Integer>  set = newHashSet(10, 15, 40, 20,18);
        System.out.println(set.contains(10) + " " + set.contains(12) + " " + set.contains(15));
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> res = new ArrayList<>();
        for (T elm : elements)
            res.add(elm);

        return res;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> res = new HashSet<>();
        for (T elm : elements)
            res.add(elm);

        return res;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size())
            throw new IllegalArgumentException();

        HashMap<K, V> res = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            res.put(keys.get(i), values.get(i));
        }

        return res;
    }
}
