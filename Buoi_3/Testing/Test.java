public class Test{
    public static void main (String [] a) {
        int n = 12, k = 2;
        while(k<n){
            for (k = 2; k <=n; k++){
                if(n%k==0){
                    System.out.print(k + " ");
                    n = n/k;
                    break;
                }
                // Khi n%k != 0 => k++ và không set k=2 lần nữa
            }
        }
    }
    
}
