import java.util.*;

public class main {
    
    public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLong()) {
    long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong(), d=sc.nextLong();

    if(a==0 && b==0 && c==0 && d==0){
        
         System.exit(0);
    
    }
    
    long player1_high = a > b ? a:b ;
    long player1_low = a < b ? a:b ;
    
    long player2_high = c > d ? c:d ;
    long player2_low = c < d ? c:d ;
    
    long player1 = player1_high*10+player1_low;
    long player2 = player2_high*10+player2_low;
    
    
    if (player1 == player2){
        System.out.println("Tie.");
    }
    
    else if (player1==21){
        System.out.println("Player 1 wins.");
    }
    
    else if (player2==21){
        System.out.println("Player 2 wins.");
    }
    
    else if (player1_high == player1_low){
        if (player2_high == player2_low) {
            
            if (player1_high > player2_high) {
                 System.out.println("Player 1 wins.");
            }
            
            else{
                System.out.println("Player 2 wins.");
            }
            
        }
        
        else{
            System.out.println("Player 1 wins.");
        }
    }
    else if (player2_high == player2_low){
        System.out.println("Player 2 wins.");
    }
    
    else{
        if (player1 > player2){
            System.out.println("Player 1 wins.");
        }
        else{
            System.out.println("Player 2 wins.");
        }
        
    }
    
    }   
    
    }
}