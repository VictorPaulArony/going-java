public class CountChar {
     public static int count(String s, char c) {
        int res =0;
        int i = 0;
        while ( s.length() > i) { 
            if (s.charAt(i) == c){
                res++;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(CountChar.count("Hello World !    ", ' '));
    }
}