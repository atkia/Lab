import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of parameter");
        n = s.nextInt();
        int[] minimum = new int[10];
        int[] maximum = new int[10];
        System.out.println("Enter min & max value: ");
        for(int i=0; i<n; i++)
        {
            minimum[i]=s.nextInt();
            maximum[i]=s.nextInt();
        }

        BVC bvc =new BVC(n,minimum,maximum);
        bvc.BVCFunction();
        bvc.robust();
        bvc.worstCase();

    }
}
