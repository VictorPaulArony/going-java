public class Factorial {
    public static Integer factorial(Integer n) {
        int res =1;
        while(n > 1){
           res =  res * n;
           n--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Factorial.factorial(3));
    }
}