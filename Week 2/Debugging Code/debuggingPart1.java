public class debuggingPart1 {
    public static void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
            if (index == -1 || index >= input.length() - 3) {
                break;
            }
            // System.out.println(index+1);
            // System.out.println(index+4);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
            index = input.indexOf("abc", index+4);
        }
    }
    public static void main(String[] args) {
        findAbc("abcdabc");    
    }
}