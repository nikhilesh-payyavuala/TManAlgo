Running environemt:

Eclipse IDE for Java Developers
Release 4.2.0
Version: Kepler Service Release 1
Build id:  20130919-0819

Operating System used:
Windows 8

Language written:
Java

Software Needed - 
Eclipse IDE

Source Code - 
Distributed into four different .java files namely 

MainTMAN.java: file consisting of the main() method, the Initialize() and the Iterate() methods, etc for initializing all nodes with random neighbors and then proceeding to select a random node in the neighbors list and exchanging information for all 50 cycles

TNode.java: Has a node id property along with a arraylist of all neighbors associated with that node.Also file has the calculateDIstance() method that finds out the distance between two nodes.

CompareTwoNodes.java: Implements comparable interface. Override the compareto method to properly sort according to distance.

Plot.java: Taking care of all 2d plots.

make clean
make
java MainTMAN 1000 30 S   (//available topologies are O b and S)
