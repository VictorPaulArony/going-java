public class NextPrime {
    public static Integer nextPrime(Integer n) {
        int res = n +1;
        while (true) {
            if (isPrime(res)){
                return res;
            }
            res++;
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 2) {
            return false;
        }
        for (int i = 2; i*i <= n; i++){
            if (n %i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(NextPrime.nextPrime(11));
    }
}
