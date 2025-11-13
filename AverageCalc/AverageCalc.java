public class AverageCalc {
    public static int average(int start, int end, int step) {
        int sum=0;
        int count=0;
        for (int i = start; i <= end; i+=step){
            sum+=i;
            count++;
        }
        return sum/count;
        
    }
    public static void main(String[] args) {
        System.out.println(AverageCalc.average(1,5,1));
    }
}