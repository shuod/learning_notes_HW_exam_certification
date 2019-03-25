import java.util.*;

public class JudgingMoose {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        int result;
        
        if (left == 0 && right == 0){
            System.out.println("Not a moose");
        }
        
        if (left > right){
            result = left * 2;
            System.out.println("Odd "+result);
        }
            
        if (left < right){
            result = right * 2;
            System.out.println("Odd "+result);
        }
        
        if (left == right && left > 0){
            result = left * 2;
            System.out.println("Even "+result);
        }
        
    }
}