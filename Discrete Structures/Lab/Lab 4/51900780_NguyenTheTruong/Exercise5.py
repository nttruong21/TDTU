# Exercise a
G1 = "p -> r"
G2 = "~p -> q"
G3 = "q -> s"
G4 = "G2 + G3 => G4 = ~p -> s, Transitivity"
G5 = "G4 => G5 = ~s -> p, Contrapositive"
G6 = "G5 + G1 => G6 = ~s -> r, Transitivity"
C = "G5 => C = ~r -> s, Contrapositive"
print("\n - Exercise a:")
print("G1 = ", G1)
print("G2 = ", G2)
print("G3 = ", G3)
print("G4 = ", G4)
print("G5 = ", G5)
print("G6 = ", G6)
print("C = ", C)

# Exercise b
G1 = "p -> (q -> r)"
G2 = "p V s"
G3 = "t -> q"
G4 = "~s"
G5 = "G2 + G4 => G5 = p, Elimination"
G6 = "G1 + G5 => G6 = q -> r, Modus Ponens"
G7 = "G3 + G6 => G7 = t -> r, Transitivity"
C = "G7 => C = ~r -> ~t, Contrapositive"
print("\n - Exercise b:")
print("G1 = ", G1)
print("G2 = ", G2)
print("G3 = ", G3)
print("G4 = ", G4)
print("G5 = ", G5)
print("G6 = ", G6)
print("G7 = ", G7)
print("C = ", C)

# Exercise c
G1 = "p -> q"
G2 = "~r V s"
G3 = "p V r"
G4 = "G2 => G4 = r -> s, Negation"
G5 = "G3 => G5 = ~p -> r, Negation"
G6 = "G5 + G4 => G6 = ~p -> s, Transitivity"
G7 = "G6 => G7 = ~s -> p, Contrapositive"
G8 = "G7 + G1 => G8 = ~s -> q, Transitivity"
C = "G8 => C = ~q -> s, Contrapositive"
print("\n - Exercise c:")
print("G1 = ", G1)
print("G2 = ", G2)
print("G3 = ", G3)
print("G4 = ", G4)
print("G5 = ", G5)
print("G6 = ", G6)
print("G7 = ", G7)
print("G8 = ", G8)
print("C = ", C)


# Exercise d
G1 = "p"
G2 = "p -> r"
G3 = "p -> (q V ~r)"
G4 = "~q V ~s"
G5 = "G1 + G2 => G5 = r, Modus Ponens"
G6 = "G1 + G3 => G6 = q V ~r, Modus Ponens"
G7 = "G6 => G7 = ~q -> ~r, Negation"
G8 = "G7 => G8 = r -> q, Contrapositive"
G9 = "G8 + G5 => G9 = q, Modus Ponens"
G10 = "G4 => G10 = q -> ~s, Negation"
C = "G10 + G9 => C = ~s, Modus Ponens"
print("\n - Exercise d:")
print("G1 = ", G1)
print("G2 = ", G2)
print("G3 = ", G3)
print("G4 = ", G4)
print("G5 = ", G5)
print("G6 = ", G6)
print("G7 = ", G7)
print("G8 = ", G8)
print("G9 = ", G9)
print("G10 = ", G10)
print("C = ", C)
