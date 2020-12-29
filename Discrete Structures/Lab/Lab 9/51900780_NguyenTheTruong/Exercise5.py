import matplotlib.pyplot as plt
import networkx as nx
import numpy as np

def getGraph(A):
    G1 = nx.from_numpy_matrix(A)
    pos=nx.spring_layout(G1)
    nx.draw_networkx(G1,pos=pos,with_labels=True,labels={a:b for
    a,b in enumerate(["Primates", "Rodents", "Mammals", "Reptiles", "Animals", "Plant", "Mushrooms", "Molds", "Multicellular", "Yeasts", "Unicellular"])})
    plt.figure(figsize=(30, 30))
    return plt

A=np.array([[0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
[0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0],
[1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0],
[0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0],
[0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
[0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
[0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0]])
getGraph(A).show()
