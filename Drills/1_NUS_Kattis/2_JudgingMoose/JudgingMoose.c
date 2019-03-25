#include <stdio.h>
int main(void){
    
    int result=0, left=0, right=0;
    
    scanf ("%d %d", &left, &right);
    
    if (left == 0 && right == 0) {
        printf("Not a moose");
    }
    
    if (left > right){
        result = left * 2;
        printf("Odd %d",result);
    }
            
    if (left < right){
        result = right * 2;
        printf("Odd %d",result);
    }
        
    if (left == right && left > 0){
        result = left * 2;
        printf("Even %d ",result);
    }
 
}