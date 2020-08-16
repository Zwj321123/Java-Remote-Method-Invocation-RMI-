# Java-Remote-Method-Invocation-RMI-
This is a Java program implementing client-server communication using Remote Method Invocation (RMI).
author@Wenjun Zeng
 ----------------------------------------------------------------------------------
This program contains the following files:
client file:
	castVote.java: holds the interface;
	Client.java holds the client code;
server file:
	castVote.java: holds the interface;
	voteImpl.java: holds the remote object implementing the interface;
	Server.java holds the server code;

How to run:
To run the program, firstly start the RMI registry on the server by:
$> start rmiregistry
Then, compile and run the Server.java and Client.java files respectively.

How to produce the results:
If the RMI connection works, the client node would display the following 4 options:
	1. New ticket
	2. Vote
	3. view vote result
	4. Exit
At first, every new client should request a new ticket (enter 1). Then, the ticket() method 
in the remote object would return a random ticket;
To vote or view vote result, one needs to enter the ticket number first. If the ticket number
does not exist, forward operations will be denied;
The vote result can be saved as long as the server node in on.

