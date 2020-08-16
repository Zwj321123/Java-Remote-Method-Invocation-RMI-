/*
 * We define four things in this interface. First, is the vote
 * method, which will return a long value. 
 * 
 * Second, is the getVotingResults method which will return a string of the vote result.
 *  
 * Third, is the ticket method, which will generate a random ticket for the client. 
 * 
 * The final method is the contains method, which will return a boolean telling whether a ticket
 * entered by the client exists.
 */
import java.rmi.*;

public interface castVote extends Remote 
{	
	/*
    long getMilliSeconds() throws RemoteException;
    TimeTeller getTimeTeller() throws RemoteException;
    */
	public void vote(int choice) throws java.rmi.RemoteException;
	public String getVotingResults() throws java.rmi.RemoteException;
	public int ticket() throws RemoteException;
	public boolean contains(int t) throws RemoteException;
}

