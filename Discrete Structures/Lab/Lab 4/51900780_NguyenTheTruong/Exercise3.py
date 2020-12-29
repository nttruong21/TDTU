import math
import random

# Exercise a
print("\n - Exercise a:")
print("Negative: Ex in Z, 0 <= x <= 100, x^3 < x")
isFind = False
for x in range(101):
	if x**3 < x:
		isFind = True
		print("The given statement is correct when x equal to ", x)
if isFind == False:
	print("The given statement is incorrect for all values x within the given domain.")
	
# Exercise b 
print("\n - Exercise b:")
print("Negative: Ex in Z, 0 <= x <= 100, and x is even, x * 3 + 1 is not a prime number")
isFind = False
for x in range(0, 101, 2):
	temp = x * 3 + 1
	for i in range(2, int(math.sqrt(temp)) + 1):
		if temp % i == 0:
			isFind = True
			print("The given statement is correct when x equal to ", x)
			break
	if isFind:
		break
if isFind == False:
	print("The given statement is incorrect for all values x within the given domain.")	


# Exercise c 
print("\n - Exercise c:")
print("Negative: Ex in Z, 1 <= x, y <= 100, and x is even, x*5+3 is not a prime number")
isFind = False 
for x in range(0, 101, 2):
	temp = x*5+3
	for i in range(2, int(math.sqrt(temp)) + 1):
		if temp % i == 0:
			isFind = True
			print("The given statement is correct when c equal to ", x)
			break
	if isFind:
		break
if isFind == False:
	print("The given statement is incorrect for all values x within the given domain.")	
	
# Exercise d 
print("\n - Exercise d:")
print("Negative: Ec in Z, 0 < c <= 100, c%4 = 0, Ea, b in Z, c^2 != a^2 + b^2")
isFind = False
a = random.randint(0, 101)
b = random.randint(0, 101)
for c in range(4, 101, 4):
	if c*c != a*a + b*b:
		isFind = True
		print("The given statement is correct when c equal to ", c, ", b equal to ", b, ", a equal to ", a)
		break
if isFind == False:
	print("The given statement is incorrect for all values x within the given domain.")	
	

# Exercise e 
print("\n - Exercise e:")
print("Negative: Vc in Z, 0 < c <= 100, c^2 > c")
isFind = False
for c in range(1, 101):
	if c*c <= c:
		isFind = True
		print("The given statement is incorrect when c equal to ", c)
		break
if isFind == False:
	print("The given statement is correct for all value x within the given domain.")