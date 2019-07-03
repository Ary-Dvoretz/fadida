package sample;

public class RecursionQ1_1 {

    private String addAt(String orig, int pos, char c) {
        StringBuilder sb = new StringBuilder();
        if (pos < 0) {
            return sb.append(c).append(orig).toString();
        }
        if (pos > orig.length() - 1) {
            return sb.append(orig).append(c).toString();
        }
        return sb.append(orig.substring(0, pos + 1)).append(c).append(orig.substring(pos + 1)).toString();
    }

    private String removeAt(String orig, int pos) {
        StringBuilder sb = new StringBuilder();
        if (pos < 0) pos = 0;
        if (pos > 0) {
            sb.append(orig.substring(0, pos));
        }
        if (pos <= orig.length() - 2 ) {
            sb.append(orig.substring(pos + 1));
        }
        return sb.toString();
    }

    private Character get(String s, int pos) {
        if (pos >= 0)
            return s.charAt(pos);
        return null;
    }

    public int edit (String str1, String str2) {
        return findMinEdits(str1, str1.length() - 1, str2, str2.length() - 1);
    }

    private int findMinEdits(String str1, int pos1, String str2, int pos2) {
        if (str1.equals(str2)) return 0;
        else {
            Character c1 = get(str1, pos1);
            Character c2 = get(str2, pos2);
            if (c1 == null && c2 != null) {
                return 1 + findMinEdits(addAt(str1, pos1, c2), pos1, str2, pos2 - 1);
            }
            if (c2 == null) {
                return 1 + findMinEdits(removeAt(str1, pos1), pos1 - 1 , str2, pos2);
            }
            if (c1.equals(c2)) {
                return findMinEdits(str1, pos1 - 1, str2, pos2 - 1);
            }
            return Math.min(
                1 + findMinEdits(removeAt(str1, pos1), pos1 - 1, str2, pos2),
                1 + findMinEdits(addAt(str1, pos1, c2), pos1, str2, pos2 - 1)
            );
        }
    }
}
