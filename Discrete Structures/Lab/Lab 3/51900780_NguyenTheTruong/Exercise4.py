def formalConvertIfThen(str):
	list = str.split(",")
	left = list[0].split(" ")
	right = list[1].split(" ")
	temp = []
	D = []
	for item in left:
		if item == "For" or item == "or" or item == "Exist" or item == "every" or item == "all":
			temp.append(item)
		else:
			D.append(item)
	if "then" in right:
		P = [right[i] for i in range(3, right.index("then"))]
		Q = [right[i] for i in range(right.index("then") + 2, len(right))]
	elif "but" in right:
		P = [right[i] for i in range(3, right.index("but"))]
		Q = [right[i] for i in range(right.index("but") + 1, len(right))]
	else:
		tempRight = right.split(",")
		tmpLeft = tempRight[0].split(" ")
		tmpRight = tempRight[1].split(" ")
		P = [tmpLeft[i] for i in range(3, len(tmpLeft))]
		Q = [tmpRight[i] for i in range(2, len(tmpRight))]
		
	F = [temp[i] for i in range(len(temp))]
	if temp == ["For", "all"] or temp == ["For", "every"]:
		F.append("x in D, if P(x) then Q(x)")
	else:
		F.append("x in D such that P(x) and Q(x)")
	return [D, P, Q, F]
		
def printFormalConvertIfThen(D, P, Q, F):
	print("D is \"", end = "")
	for item in D:
		print(item, end = " ")
	print("\"")
	print("P is \"", end = "")
	for item in P:
		print(item, end = " ")
	print("\"")
	print("Q is \"", end = "")
	for item in Q:
		print(item, end = " ")
	print("\"")
	print("Formal form: ", end = "")
	for item in F:
		print(item, end = " ")
	print()
		
D, P, Q, F = formalConvertIfThen("For all people, if they are blond then they are westerners")
print("\na/")
printFormalConvertIfThen(D, P, Q, F)
D, P, Q, F = formalConvertIfThen("Exist a person, whose hair is black but is a westerner")
print("\nb/")
printFormalConvertIfThen(D, P, Q, F)
D, P, Q, F = formalConvertIfThen("For all students, if they study correctly then they have high score")
print("\nc/")
printFormalConvertIfThen(D, P, Q, F)
D, P, Q, F = formalConvertIfThen("For every bird, if they don’t have wings and can swim then they are penguins")
print("\ne/")
printFormalConvertIfThen(D, P, Q, F)
D, P, Q, F = formalConvertIfThen("Exist a bird, who have wing but can’t fly")
print("\nf/")
printFormalConvertIfThen(D, P, Q, F)