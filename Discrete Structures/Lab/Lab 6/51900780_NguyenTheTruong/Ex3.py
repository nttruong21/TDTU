import math

def printPrime(n):
    for i in range(2, n+1):
        isPrime = True
        for j in range(2, int (math.sqrt(i))+1):
            if i%j == 0:
                isPrime = False
                break
        if isPrime:
            print(i, ",", end = "")

printPrime(100)
