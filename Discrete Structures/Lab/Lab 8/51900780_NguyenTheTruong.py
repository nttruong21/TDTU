import operator
# Exercise 1
Andersen = {"The Emperor's New Clothes", "The Little Mermaid", "The Little Match Girl", "The Snow Queen"}

# Exercise 2
Shakespeare = {"Romeo and Juliet", "Hamlet", "King Lear", "Macbeth", "A Midsummer Night's Dream", "A comedy of Errors"}

# Exercise 3
Tragedy = {"Medea", "Octavia", "Oedipus", "Ur-Hamlet","The Little Mermaid", "The Little Match Girl", "Romeo and Juliet", "Hamlet", "King Lear", "Macbeth"}
Comedy = {"The Three Musketeer", "The Clouds", "A Midsummer Night's Dream", "A comedy of Errors", "The Emperor's New Clothes"}
Uncategory = {"Don Quixote", "Rapunzel", "Cinderella", "The Snow Queen"}

# Exercise 4
Shakespeare_Tragedy = Shakespeare - Tragedy

# Exercise 5
Andersen_Comedy = Andersen & Comedy

# Exercise 6
A = [Shakespeare_Tragedy, Andersen_Comedy]
B = [Tragedy, Comedy, Uncategory, Andersen, Shakespeare]
for i in A:
    for j in B:
        if i.issubset(j):
            print(i, ", ", j, ": issubset")
        if i.issuperset(j):
            print(i, ", ", j, ": issuperset")
        if i.isdisjoint(j):
            print(i, ", ", j, ": isdisjoint")

# Exercise 7
Work = Andersen | Shakespeare | Tragedy | Comedy | Uncategory

# Exercise 8
Author = {"Andersen", "Shakespeare", "Unknown"}

# Exercise 9
Author_Of = {}
for i in Work:
    if i in Andersen:
        Author_Of[str(i)] = "Andersen"
    elif i in Shakespeare:
        Author_Of[str(i)] = "Shakespeare"
    else:
        Author_Of[str(i)] = "Unknown"

# Exercise 10
Writen_By = {}
for i in Work:
    temp = "Not " + str(i)
    if i in Andersen:
        Writen_By[temp] = "Not Andersen"
    elif i in Shakespeare:
        Writen_By[temp] = "Not Shakespeare"
    else:
        Writen_By[temp] = "Unknown"

# Exercise 11
Work_Count = {}
count = 0
B = [Tragedy, Comedy, Uncategory, Andersen, Shakespeare]
for i in Work:
    count = 0
    for j in B:
        if i in j:
            count += 1
    Work_Count.update({str(i):count})
# print(Work_Count)

# Exercise 12
def countWord(string):
    li = string.split(" ")
    return len(li)
# print(countWord("DISCRETE STRUCTURES Lab 8 Sets Trần Hồng Tài Abstract In this Laboratory, we will try to represent sets and their properties."))

#Exercise 13
def countTime(string):
    dic = {}
    li = string.split(" ")
    while li != []:
        temp = li[0]
        count = 1
        li.pop(0)
        for i in range(0, len(li)-1):
            if li[i] == temp:
                count += 1
                li.pop(i)
        dic[temp] = count
    return sorted(dic.items(), key=operator.itemgetter(1))

# print(countTime("Count how many times each words appeared and sorted the word by number of times they appeared descending"))