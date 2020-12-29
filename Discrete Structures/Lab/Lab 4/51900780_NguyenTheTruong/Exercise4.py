#Exercise a 
sumLeft = 0
sumRight = 0
for x in range(11):
	for y in range(11):
		sumLeft += (x+y)**2
		sumRight += (x+2*y)**2
print(" - Exercise a: ", end = "")
if sumLeft > sumRight:
	print("True")
else:
	print("False")
	
# Exercise b 
left = 1
right = 1
for i in range(2, 21):
	left *= i
for x in range(1, 11):
	fac = 1
	for i in range(2, x+1):
		fac *= x
	right += fac
print(" - Exercise b: ", end = "")
if left < right:
	print("True")
else:
	print("False")
	
# Exercise c 
left = 0
right = 10**3
for x in range(11):
	left += 3*x*x
print(" - Exercise c: ", end = "")
if left >= right:
	print("True")
else:
	print("False")
	
# Exercise d 
left = 0
right = 10**4 + 2*10**3 + 10**2 - 5**4 - 2*5**3 - 5**2
for x in range(5, 11):
	left += 4*(x**3) + 6*(x**2) + 2*x
print(" - Exercise d: ", end = "")
if left > right:
	print("True")
else:
	print("False")