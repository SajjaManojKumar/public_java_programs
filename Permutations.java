import java.util.*;

public class Permutations {

    static List<List<Integer>> generatePermutations(List<Integer> al) {
        List<List<Integer>> res = new ArrayList<>();
        int[] a = new int[al.size()];
        Arrays.fill(a, -1);
        HashSet<Integer> hs = new HashSet<>();
        generatePermutationsHelper(res, al, a, hs, 0);
        return res;
    }

    static void generatePermutationsHelper(List<List<Integer>> res, List<Integer> al, int[] a, HashSet<Integer> hs,
            int idx) {
        if (idx == al.size()) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < al.size(); i++) {
                if (a[i] != -1)
                    l.add(a[i]);
            }
            res.add(l);
            return;
        }

        for (int i = 0; i < al.size(); i++) {
            if (!hs.contains(al.get(i))) {

                a[idx] = al.get(i);
                hs.add(al.get(i));
                generatePermutationsHelper(res, al, a, hs, idx + 1);
                hs.remove(al.get(i));
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(generatePermutations(list));
    }
}