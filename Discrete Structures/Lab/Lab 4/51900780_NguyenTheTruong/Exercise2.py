import math
import random

# Exercise a
print("\n - Exercise a: ")
isFind = False
for x in range(101):
	if x*x == 15*15 + 16*16:
		isFind = True
		print("The given statement is correct when x equal to ", x)
		break
if isFind == False:
	print("The given statement is incorrect for all values x within the given domain.")
	
# Exercise b
print("\n - Exercise b: ")
isFind = False
for x in range(101):
	if x*x == 12*12 + 16*16:
		isFind = True
		print("The given statement is correct when x equal to ", x)
		break
if isFind == False:
	print("The given statement is incorrect for all values x within the given domain.")

	
# Exercise c
print("\n - Exercise c: ")
isFind = False
for x in range(-50, 51):
	if x*x >= 99*x:
		isFind = True
		print("The given statement is correct when x equal to ", x)
		break
if isFind == False:
	print("The given statement is incorrect for all values x within the given domain.")
	
# Exercise d
print("\n - Exercise d: ")
isFind = False
for x in range(50, 101):
	if x*(x+1)*(x+2) % 6 != 0:
		isFind = True
		print("The given statement is correct when x equal to ", x)
		break
if isFind == False:
	print("The given statement is incorrect for all values x within the given domain.")
	
# Exercise e
print("\n - Exercise e:")
isFind = False
y = random.randint(0, 101)
for x in range(101):
	if math.sqrt(x+y) == math.sqrt(x) + math.sqrt(y):
		isFind = True
		print("The given statement is correct when x equal to ", x, "y equal to ", y)
		break
if isFind == False:
	print("The given statement is incorrect for all values x within the given domain.")