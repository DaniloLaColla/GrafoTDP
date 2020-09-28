import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graph {

	protected ArrayList<Arco> arcos;
	protected ArrayList<Integer> vertices;
	private static Logger logger;
	
	public Graph() {
		arcos= new ArrayList<Arco>();
		vertices= new ArrayList<Integer>();
		if (logger == null) {
			logger = logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.INFO);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.INFO);
			
			/*Logger rootLogger = logger.getParent();
			for (Handler h: rootLogger.getHandlers())
				h.setLevel(Level.OFF);*/
				
		}
		
	}
	
	public void addNode(int node) {
		if(!existeNode(node)) {
			vertices.add(node);
			logger.info("agrego un nodo");
		}
		else
			logger.warning("no fue posible agregar el nodo");
	}
	
	public void addEdge(int node1, int node2) {
		if(existeNode(node1) && existeNode(node2) && !existeEdge(node1, node2)) {
			Arco arco= new Arco(node1,node2);
			arcos.add(arco);
			logger.info("agrego un arco");
		}		
		else
			logger.warning("no fue posible agregar el arco");
	}
	
	public void removeNode(int node) {
		boolean esta=false;
		for (Integer nodo: vertices) 
			if (nodo==node) {
				vertices.remove(nodo);
				logger.info("removio un nodo");
				esta=true;
				break;
			}
		if (!esta)
				logger.warning("no fue posible remover el nodo");	
	}
	
	public void removeEdge(int node1, int node2) {
		boolean esta=false;
		for (Arco arco: arcos)
			if (arco.getVerticeOrigen() == node1 && arco.getVerticeDestino()  == node2) {
				arcos.remove(arco);
				esta=true;
				logger.info("removio un arco");
				break;
			}
		if (!esta)
			logger.warning("no fue posible remover el arco");
	}
	
	private boolean existeEdge(int node1, int node2) {
		boolean toReturn=false;
		for (Arco a : arcos) {
			if(a.getVerticeOrigen()==node1 && a.getVerticeDestino()==node2) {
				return true;
			}
		}
		return toReturn;
	}
	public boolean existeNode(int node) {
		boolean toReturn=false;
		for (Integer v: vertices) {
			if(v==node) 
				return true;
				break;
			}
		return toReturn;
	}
 }
