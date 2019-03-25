# coding: utf-8
import sys

def main():
    
    numbers = list(map(int, input().split()))
    
    if (numbers[0] == 0 and numbers[1] == 0):
        print("Not a moose")
    
    
    if (numbers[0] > numbers[1]):
        result = numbers[0] * 2
        print("Odd ",result)
    
            
    if (numbers[0] < numbers[1]):
        result = numbers[1] * 2
        print("Odd ",result)
    
        
    if (numbers[0] == numbers[1] and numbers[0] > 0):
        result = numbers[0] * 2
        print("Even ",result)
    

if __name__ == "__main__":
    
    sys.exit(main())