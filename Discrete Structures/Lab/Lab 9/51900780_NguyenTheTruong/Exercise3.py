import matplotlib.pyplot as plt
import networkx as nx
import numpy as np

#
A1=np.array([[0, 0, 5, 3, 0, 0],
[0, 0, 3, 2, 0, 0],
[5, 3, 0, 1, 3, 0],
[3, 2, 1, 0, 1, 3],
[0, 0, 3, 1, 4, 0],
[0, 0, 0, 3, 4, 0]])
G1 = nx.from_numpy_matrix(A1)
pos=nx.spring_layout(G1)
nx.draw_networkx(G1,pos=pos,with_labels=True,labels={a:b for
a,b in enumerate('abcdef')})
edge_labels = nx.draw_networkx_edge_labels(G1,font_size=6,
pos=pos,label_pos=0.5)
plt.axis('equal')
plt.show()

#
A1=np.array([[0, 0, 2, 3, 3, 0],
[0, 0, 3, 2, 0, 0],
[2, 3, 0, 2, 8, 6],
[3, 2, 2, 0, 0, 5],
[3, 0, 8, 0, 0, 3],
[0, 0, 6, 5, 3, 0]])
G1 = nx.from_numpy_matrix(A1)
pos=nx.spring_layout(G1)
nx.draw_networkx(G1,pos=pos,with_labels=True,labels={a:b for
a,b in enumerate('abcdef')})
edge_labels = nx.draw_networkx_edge_labels(G1,font_size=6,
pos=pos,label_pos=0.5)
plt.axis('equal')
plt.show()