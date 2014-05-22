

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class MainTMan{

	 static char topo;   //O for ring, S for sad smiley and b for b topology
	 static int numOfNodes;  // Number of nodes in the network
	 static int numOfNeighbors;
	 static TNode[] totalNodes; //Array of objects(TNode)
	 static String file; //File name to be used 
	
	public static void main(String[] Args) {
		numOfNodes = Integer.parseInt(Args[0]);
		numOfNeighbors = Integer.parseInt(Args[1]);
		topo = Args[2].charAt(0);
		totalNodes = new TNode[numOfNodes];
		file = topo + "_N" + numOfNodes + "_k" + numOfNeighbors;
		Initialize();
		Iterate();		
		
	}
	
	public static void Initialize() {
		Random rand = new Random();
		int random_no;
		int i;
		
		for(int k=0; k<numOfNodes; k++){ //initialize all nodes with a specific node id 
			totalNodes[k] = new TNode(k);
		}
		
		for (int j = 0; j < numOfNodes; j++) { //selecting random nodes as neighbors 
		i = 0;
			while (i < numOfNeighbors) {
				random_no = rand.nextInt(numOfNodes);
				if (j != random_no){
					totalNodes[j].neigh.add(totalNodes[random_no]);
					i++;
				}
			}
		}
	}

	public static void Iterate(){
		String fileName = file + ".txt"; // to compute total distance in each cycle
		Random rand = new Random();
		int random;
		try {
		PrintStream out = new PrintStream(new FileOutputStream(fileName));

		for(int i=0; i<=50; i++){   // 50 cycles are simulated and for each node in each cycle a neighbor is selected and their neigh lists are exchanged
			for(int j=0; j<numOfNodes; j++){   
				random = rand.nextInt(numOfNeighbors);
				//System.out.println(totalNodes[j].neigh.size()+"       "+j+"    "+random );
				exchange(totalNodes[j], totalNodes[j].neigh.get(random));
			}

			if(i == 1 || i == 5 || i == 10 || i == 15 || i==50){
				Plot.displayNodes(i); //displays all neighbors for all nodes at that particular cycle
				Plot.sketch(i);
			}
			
			out.println("Total Distance at " + i + ": " + Plot.getTotalDistance());
		}
	      out.close(); //closing printstream or memory 
		}
		  catch (FileNotFoundException e) {
			      e.printStackTrace();
			    }
		}
	
	private static void exchange(final TNode tNode, final TNode tNode2) {
		// TODO Auto-generated method stub
		 PriorityQueue<CompareTwoNodes> sort = new PriorityQueue<CompareTwoNodes>(); // sort using distance algos using comparable interface
		
		 ArrayList<TNode> tempNode1NList = tNode.neigh;
		 ArrayList<TNode> tempNode2NList = tNode2.neigh;
		 
		 TNode temp;

		 // For Node1 list changes
		 for (TNode node : tempNode1NList) {
			 sort.add(new CompareTwoNodes(tNode, node));
		 	}
		 for (TNode node : tempNode2NList) {
			 sort.add(new CompareTwoNodes(tNode, node));
		 	}
		 tNode.neigh.clear();
		 temp = null;
		 for(int i=0; i<numOfNeighbors;){
			 temp = sort.remove().other_node;
			 	if (tNode != temp){
			 		tNode.neigh.add(temp);
				 	i++;
			 	}
		 	}
		 
		 sort.clear();
		 
		 // For Node2 list changes
		 for (TNode node : tempNode1NList) {
			 sort.add(new CompareTwoNodes(tNode2, node));
		 	}
		 for (TNode node : tempNode2NList) {
			 sort.add(new CompareTwoNodes(tNode2, node));
		 	} 
		 tNode2.neigh.clear();
		 temp = null;
		 for(int i=0; i<numOfNeighbors;){
		 	temp = sort.remove().other_node;
		 	if (tNode2 != temp){
		 		tNode2.neigh.add(temp);
			 	i++;
		 	}
		 	}
	}


	
}
