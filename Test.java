
public class Test {

	public static void main (String [] args) {
		Graph grafo=new Graph();
		int node1, node2, node3, node4, node5;
		node1=100;
		node2=200;
		node3=300;
		node4=400;
		node5=500;
		grafo.addNode(node1);
		grafo.addNode(node1);
		grafo.addNode(node2);
		grafo.addEdge(node4, node5);
		grafo.addEdge(node1, node2);
		grafo.addEdge(node1, node2);
		grafo.removeEdge(node1, node2);
		grafo.addEdge(node1, node2);
		grafo.removeNode(node1);
		grafo.removeNode(node1);
		grafo.removeEdge(node3, node2);
		grafo.removeEdge(node5, node4);
	}

}
