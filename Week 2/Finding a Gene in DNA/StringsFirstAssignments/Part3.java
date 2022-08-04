public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        int count = 0;
        int index = stringb.indexOf(stringa);
        if (index > 0) {
            count++;
        }
        while (count <= 2 && index != -1) {
            index = stringb.indexOf(stringa, index + 1);
            if (index >= 0) {
                count++;
            }
        }
        if (count >= 2) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Part3 p3 = new Part3();
        System.out.println(p3.twoOccurrences("by", "A story by Abby Long"));
        System.out.println(p3.twoOccurrences("a", "banana"));
        System.out.println(p3.twoOccurrences("atg", "ctgtatgta"));
    }
}
