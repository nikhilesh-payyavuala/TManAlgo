
JCC = javac
GR = jar

JFLAGS = -g
RFLAGS = cvfm

default: 

	$(JCC) $(JFLAGS) *.java
	
	echo Main-class: MainTMAN >manifest.txt
	
	
clean:
	$(RM) *.class
	$(RM) *.jar
	$(RM) *.manifest.txt