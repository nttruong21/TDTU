import math

def printPrime(n):
    if n < 2:
        return []
    else:
        li = [2]
        for i in range(3, n-2, 2):
            Flag = True
            for j in range(0, len(li)-1):
                if i%li[j] == 0:
                    Flag = False
                    break
            if Flag:
                li.append(i)
        return li    

for item in printPrime(100):
    print(item, ",", end = "")