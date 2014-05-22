import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.imageio.ImageIO;


public class Plot {

	public static RenderedImage myCreateImage() {
	    int width = 700;
	    int height = 700;

	    																			
	    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // BufferedImage for drawing the topology
	    Graphics2D g = bufferedImage.createGraphics();
	   
	    Graphics2D graphic = bufferedImage.createGraphics(); 
	    g.setColor(Color.white); //set background color to white
        g.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        g.dispose();
	    graphic.setColor(Color.red);
	    double r = 125; // radius for circles in O,b and sad smiley topologies

	     
	  switch (MainTMan.topo) {  //distance algos for various topologies
	  case 'O':
	     for (int i=0; i<MainTMan.numOfNodes; i++){
			for (TNode node: MainTMan.totalNodes[i].neigh){
			      graphic.draw(new Line2D.Double(r * Math.cos(((double)i/(double)MainTMan.numOfNodes) * 2.0 * Math.PI) + 2*r,
			    		  r * Math.sin(((double)i/(double)MainTMan.numOfNodes) * 2.0 * Math.PI) + 2*r,
			    		  r * Math.cos(((double)node.node_id/(double)MainTMan.numOfNodes) * 2.0 * Math.PI) + 2*r,
			    		  r * Math.sin(((double)node.node_id/(double)MainTMan.numOfNodes) * 2.0 * Math.PI) + 2*r));
			}
	      }	  
	     
	     
	      break;
	  case 'b':
	      for (int i=1; i<MainTMan.numOfNodes-1; i++){
	for (TNode node: MainTMan.totalNodes[i].neigh){
	      graphic.draw(new Line2D.Double(
	    		  r * Math.sin(((double)i/((double)MainTMan.numOfNodes-2)) * 1.0 * Math.PI) + r,
	    		  r * Math.cos(((double)i/((double)MainTMan.numOfNodes-2)) * 1.0 * Math.PI) + 3*r,
	    		  r * Math.sin(((double)node.node_id/((double)MainTMan.numOfNodes-2)) * 1.0 * Math.PI) + r,
	    		  r * Math.cos(((double)node.node_id/((double)MainTMan.numOfNodes-2)) * 1.0 * Math.PI) + 3*r));
	   }
	      }
	      for (TNode node: MainTMan.totalNodes[0].neigh){
		      graphic.draw(new Line2D.Double(
		    		   r,
		    		 r,
		    		  r * Math.sin(((double)node.node_id/((double)MainTMan.numOfNodes-2)) * 1.0 * Math.PI) + r,
		    		  r * Math.cos(((double)node.node_id/((double)MainTMan.numOfNodes-2)) * 1.0 * Math.PI) + 3*r));
		   }
	      
		  break;

	  case 'S':
		  for (int i=0; i<(MainTMan.numOfNodes/2); i++){
				for (TNode node: MainTMan.totalNodes[i].neigh){
				      graphic.draw(new Line2D.Double((1*r) * Math.cos(Math.PI*2 - (i)*(2*Math.PI/(MainTMan.numOfNodes/2-1))) +2*r,
				    		  (1*r) * Math.sin(Math.PI*2 - (i)*(2*Math.PI/(MainTMan.numOfNodes/2-1))) + 2*r,
				    		  (1*r) * Math.cos(Math.PI*2 - (node.node_id)*(2*Math.PI/(MainTMan.numOfNodes/2-1))) + 2*r,
				    		  (1*r) * Math.sin(Math.PI*2 - (node.node_id)*(2*Math.PI/(MainTMan.numOfNodes/2-1))) + 2*r));
		}
		
		}
	      
	      for (int i=501 ; i<625; i++){
	    		for (TNode node: MainTMan.totalNodes[i].neigh){
	    		      graphic.draw(new Line2D.Double(
	    		    		  (0.2*r) * Math.cos(1*(i-500)*(Math.PI/124)) + (1.5*r),
	    		    		  (0.2*r) * Math.sin(1*(i-500)*(Math.PI/124)) + (1.75*r),
	    		    		  (0.2*r) * Math.cos(1*(node.node_id-500)*(Math.PI/124))  + (1.5*r),
	    		    		  (0.2*r) * Math.sin(1*(node.node_id-500)*(Math.PI/124)) + (1.75*r)));     
	     			}

	      }
	      for (int i=626 ; i<750; i++){
	    		for (TNode node: MainTMan.totalNodes[i].neigh){
	    		      graphic.draw(new Line2D.Double(
	    		    		  (0.2*r) * Math.cos(1*(i-625)*(Math.PI/124)) + (2.5*r),
	    		    		  (0.2*r) * Math.sin(1*(i-625)*(Math.PI/124)) + (1.75*r),
	    		    		  (0.2*r) * Math.cos(1*(node.node_id-625)*(Math.PI/124)) + (2.5*r),
	    		    		  (0.2*r) * Math.sin(1*(node.node_id-625)*(Math.PI/124)) + (1.75*r)));     
	     			}

	      }
	      for (int i=751 ; i< 1000; i++){
	    		for (TNode node: MainTMan.totalNodes[i].neigh){
	    		      graphic.draw(new Line2D.Double(
	    		    		  (0.2*r) * Math.cos(-(i-3*MainTMan.numOfNodes/4-1)*(Math.PI/(MainTMan.numOfNodes/4-1))) + (2*r),
	    		    		  (0.2*r) * Math.sin(-(i-3*MainTMan.numOfNodes/4-1)*(Math.PI/(MainTMan.numOfNodes/4-1))) + (2.5*r),
	    		    		  (0.2*r) * Math.cos(-(node.node_id-3*MainTMan.numOfNodes/4-1)*(Math.PI/(MainTMan.numOfNodes/4-1))) + (2*r),
	    		    		  (0.2*r) * Math.sin(-(node.node_id-3*MainTMan.numOfNodes/4-1)*(Math.PI/(MainTMan.numOfNodes/4-1))) + (2.5*r)));     
	     			}

	      }
	      
	      break;
	  	}
	    graphic.dispose();
	    return bufferedImage;
	}	
	  public static void sketch(int cycleNumber) {
		  
		  String fileName = MainTMan.file + "_"+ cycleNumber;		
			fileName += ".png";
		  // Creating an image
			RenderedImage rendImage = myCreateImage();
			try {
				java.io.File file = new java.io.File(fileName); // Saving as a PNG Image File.
			    ImageIO.write(rendImage, "png", file);

			} catch (IOException e) {
				e.printStackTrace();
			}
		  
	  }
	
	public static void displayNodes(int cycleNumber) {

		String fileName = MainTMan.file + "_"+ cycleNumber;		
		fileName += ".txt";
		
		try {
		      PrintStream out = new PrintStream(new FileOutputStream(fileName));
		for (int i = 0; i < MainTMan.numOfNodes; i++) {
			out.println("Node number is: "+ i +"       Neighbors are:" );
			for (TNode TNode : MainTMan.totalNodes[i].neigh) {
				out.print(TNode.node_id + ", ");
			}
			out.println("");
		}
	      out.close();
		 } catch (FileNotFoundException k) {
		      k.printStackTrace();
		    }
	}
	public static double getTotalDistance(){
		double totalDistance = 0;
		for(int i=0; i<MainTMan.numOfNodes; i++){
			for (int j = 0; j < MainTMan.totalNodes[i].neigh.size(); j++) {
				totalDistance += MainTMan.totalNodes[i].calculateDistance(MainTMan.totalNodes[i].neigh.get(j));
			}
		}
		return totalDistance;
	}


	
}
