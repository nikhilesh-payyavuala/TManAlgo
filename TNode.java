import java.util.ArrayList;


public class TNode {

 int node_id;
	ArrayList<TNode> neigh = new ArrayList<TNode>();
	
	TNode(int id){
		this.node_id=id;
	}

	public int calculateDistance(TNode tNode) {
		// TODO Auto-generated method stub
		switch (MainTMan.topo) {
		case 'O':
			//System.out.println("Ring Topology");
			return Math.min((MainTMan.numOfNodes-Math.abs(tNode.node_id-this.node_id)),Math.abs(tNode.node_id-this.node_id));
		case 'b':
		return bdistance(tNode);
		
		case 'S':
			return sdistance(tNode);
		
		default:
			break;
		}
		return node_id;
		
	}

	public int sdistance(TNode tNode) {
		// TODO Auto-generated method stub
		if ((tNode.node_id <= MainTMan.numOfNodes/2 ) && (this.node_id <=MainTMan.numOfNodes/2))
		{
				return Math.min(Math.abs(this.node_id-tNode.node_id),(MainTMan.numOfNodes-Math.abs(this.node_id-tNode.node_id))); //same as that of 'O'
		}		
		else if((this.node_id > 501 && this.node_id <= 625) && ((tNode.node_id > 501) && (tNode.node_id <= 625)))
		{
			return Math.min(Math.abs(this.node_id-tNode.node_id),625-Math.abs(this.node_id-tNode.node_id));
		}
		else if((this.node_id>625) && (this.node_id <= 750) && ((tNode.node_id >625) && (tNode.node_id <= 750)))
		{
			return Math.min(Math.abs(this.node_id-tNode.node_id),(750 - Math.abs(this.node_id-tNode.node_id)));
		}
		else if((this.node_id>750) && (this.node_id <= 1000) && ((tNode.node_id >750) && (tNode.node_id <= 1000)))
		{
			return Math.min(Math.abs(this.node_id-tNode.node_id), (1000 - Math.abs(this.node_id-tNode.node_id)));
		}
		else
		{
			return MainTMan.numOfNodes;
		}
		
	}

	public int bdistance(TNode tNode) {
		// TODO Auto-generated method stub
		if(((0<= this.node_id) && (this.node_id <= MainTMan.numOfNeighbors)) && ((tNode.node_id == MainTMan.numOfNodes))){
			return 1;
		}
		else{
		
		return Math.abs(this.node_id-tNode.node_id);
		}
	}
}
