import math

def nextPrime(n):
    temp = n+1
    isPrime = False
    
    while isPrime == False:
        count = 0
        for i in range(2, (int)(math.sqrt(temp))+1):
            if temp%i == 0:
                count = 1
                break
        if count == 0:
            return temp
        else:
            temp += 1

print("Next prime of 8 is", nextPrime(8))