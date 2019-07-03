package sample;

public class RecursionQ1_3 {

    private Character get(String s, int pos) {
        if (pos < s.length())
            return s.charAt(pos);
        return null;
    }

    public int edit (String str1, String str2) {
        return findMinEdits(str1, 0, str2, 0);
    }

    private int findMinEdits(String str1, int pos1, String str2, int pos2) {
        if (str1.equals(str2)) return 0;
        Character c1 = get(str1, pos1);
        Character c2 = get(str2, pos2);
        if (c1 == null && c2 == null) return 0;
        if (c1 == null && c2 != null) {
            return 1 + findMinEdits(/* add */ str1, pos1, str2, pos2 + 1);
        }
        if (c2 == null) {
            return 1 + findMinEdits(/* remove */str1, pos1 + 1, str2, pos2);
        }
        if (c1.equals(c2)) {
            return findMinEdits(str1, pos1 + 1, str2, pos2 + 1);
        }
        return Math.min(
            1 + findMinEdits(/* remove */str1, pos1 + 1, str2, pos2),
            1 + findMinEdits(/* add */str1, pos1, str2, pos2 + 1)
        );
    }
}
