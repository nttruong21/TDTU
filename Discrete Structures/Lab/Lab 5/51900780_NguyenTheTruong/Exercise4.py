print(" - Exercise a:")
print(" p = Phong has Visa")
print(" q = Phong can fly")
print(" r = Phong can speak English")
print(" t = Phong goes to America")
print(" S1 = If Phong can fly, Phong will go to America")
print(" S2 = If Phong has Visa, Phong will go to America")
print(" S3 = If Phong can speak English, Phong will go to America")
print("Conclusion: C = Phong goes to America")
S1 = "q -> t"
S2 = "p -> t"
S3 = "r -> t"
P = "p"
C = "t"
print(" %s\n %s\n .%s\n" %(S2, P, C))

print(" - Exercise b:")
print(" p = An wake up late")
print(" q = the traffic is flowing smooth")
print(" ~q = the traffic is heavy")
print(" r = school day")
print("	s = An has go to school")
print(" v = An is late for school")
print(" S1 = The traffic is always heavy on school day")
print(" S2 = If An wake up late, he will be late for school on school day")
print(" S3 = An only have to go to school on school day")
print(" S4 = If An don't have to go to school, An can't be late for school")
print(" Conclusion: C = An is late for school")
P = "p"
Q = "q"
S1 = "~q ^ r"
S2 = "p -> (v^r)"
S3 = "s ^ r"
S4 = "~s -> ~v"
C = "v"
print(" %s\n %s\n .%s" %(P, S2, "v^r"))
print("\n %s\n .%s" %("v^r", C))
