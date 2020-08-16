/*
 * This is the actual implementation of the castVote interface. It implements 
 * both approaches defined in the interface.
 * 
 * The security manager is not being used in this example, hence, no security
 * control. Note that RMI will not download classes (other than from the local
 * class path) for objects received as parameters, return values, or exceptions
 * in remote method calls. This restriction ensures that the operations
 * performed by downloaded code go through a set of security checks.
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject; 
   
public class voteImpl extends UnicastRemoteObject implements castVote
{
	//hold current client's vote
	private int clientVoteResult;
	
	//ArrayList stores votes
	private ArrayList<Integer> voteResults = new ArrayList<Integer>();
	//ArrayList stores tickets
	private ArrayList<Integer> tickets = new ArrayList<Integer>();
	
      public voteImpl() throws RemoteException {
    	  //key = 1;
    	  voteResults.add(0);//total votes A received (initially 0)
    	  voteResults.add(0);//total votes B received (initially 0)
    	  voteResults.add(0);//total votes C received (initially 0)
      };
	
	private Scanner clientInput = new Scanner(System.in);  // Create a Scanner object
	
	//generate a random new ticket
	public int ticket() throws RemoteException{
		int i = (int) (Math.random()*100);
		tickets.add(i);
		System.out.println("New ticket is "+ i);
		return i;
	}
	
	@Override
	public void vote(int choice) throws RemoteException {
		
		int currentResult=voteResults.get(choice-1);
		voteResults.set(choice-1, currentResult+1);
		System.out.println("You vote :"+choice);
		clientVoteResult = choice;
	}
	
	@Override
	public String getVotingResults() throws RemoteException {

		String Results = "\tA: "+Integer.toString(voteResults.get(0))+"\n"
				+"\tB: "+Integer.toString(voteResults.get(1))+"\n"
				+"\tC: "+Integer.toString(voteResults.get(2));

		return (Results);
	}
	
	//check whether the ticket exists
	public boolean contains(int t)throws RemoteException{
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i)==t)
				return true;
		}
		return false;
	}
}

