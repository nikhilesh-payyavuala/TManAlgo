
@SuppressWarnings("rawtypes")
public class CompareTwoNodes implements Comparable{
	TNode this_node;
	TNode other_node;


	CompareTwoNodes(TNode this_node, TNode other_node)
{
	this.this_node = this_node;
	this.other_node = other_node;
}




public int compareTo(Object p) //returns value for priority queue
  {
	if(this.this_node == ((CompareTwoNodes)p).this_node)
			{
			 if(this.this_node.calculateDistance(other_node) == ((CompareTwoNodes)p).this_node.calculateDistance(((CompareTwoNodes)p).other_node))
			 {
				 return 0;
			 }
			 else if(this.this_node.calculateDistance(other_node) >= ((CompareTwoNodes)p).this_node.calculateDistance(((CompareTwoNodes)p).other_node))
			 {
				 return 1;
			 }
			 else
			 {
				return -1; 
			 }
			}
	return 1;
  }
}

