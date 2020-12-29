
def formalConvert(str) :
	list = str.split(",")
	left = list[0].split(" ")
	right = list[1].split(" ")
	D = []
	temp = []
	for item in left:
		if item == "Exist" or item == "For" or item == "all" or item == "There" or item == "is":
			temp.append(item)
		else:
			D.append(item)
	P = [right[i] for i in range(2, len(right))]
	if temp == ["Exist"] or temp == ["There", "is"]:
		F = [temp[i] for i in range(len(temp))]
		F.append("x in D such that P(x)")
	else:
		F = [temp[i] for i in range(len(temp))]
		F.append("x in D, P(x)")
	return [D,P,F]

def printFormalConvert(D, P, F):
	print("D is \"", end = "")
	for item in D:
		print(item, end = " ")
	print("\"")
	print("P is \"", end = "")
	for item in P:
		print(item, end = " ")
	print("\"")
	print("Formal form: ", end = "")
	for item in F:
		print(item, end = " ")
	print()
	

D, P, F = formalConvert("For all fishes, they need water to survive")
print(" \na/")
printFormalConvert(D, P, F)	
D, P, F = formalConvert("Exist a person, who is left handed")
print(" \nb/")
printFormalConvert(D, P, F)
D, P, F = formalConvert("Exist an employee in the company, who is late to work everyday")
print(" \nc/")
printFormalConvert(D, P, F)
D, P, F = formalConvert("For all fishes in this pond, they are Koi fish")
print(" \nd/")
printFormalConvert(D, P, F)
D, P, F = formalConvert("There is at least one creature in the ocean, it can live on land")
print(" \ne/")
printFormalConvert(D, P, F)	