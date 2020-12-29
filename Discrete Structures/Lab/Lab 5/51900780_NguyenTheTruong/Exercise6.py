import math
def isOdd(a):
	if a%2 == 0:
		return True
	return False
	
def isPrime(a):
	for i in range(2, math.sqrt(a)):
		if a%i == 0:
			return False
	return True
	

	
def isSquare(a):
	temp = math.sqrt(a)
	return temp.is_integer()
	
def isGreater(a, b):
	return (a>b)
	
def isEqual(a, b):
	return (a==b)
	
def isAbove(a, b):
	
	
def isLeftOf(A[i][j], A[c][d]):
	return column(a) < column(b)
	
	
A = [
	[2, 0, 5, 0, 3, 0],
	[3, 0, 0, 0, 0, 0],
	[0, 6, 2, 0, 5, 0],
	[3, 0, 9, 0, 25, 0],
	[0, 0, 2, 4, 5, 0],
	[0, 0, 0, 0, 0, 5]
	]

row = [A[i] for i in range(len(A))]
column = [A
print(isAbove(A[2][3], A[1,5])) 
	
	
	
	
	
	
	
	
	
	
	
	
	
	