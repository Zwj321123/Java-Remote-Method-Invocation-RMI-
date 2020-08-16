/*
 * The security manager is not being used in this example, hence, no security
 * control. Note that RMI will not download classes (other than from the local
 * class path) for objects received as parameters, return values, or exceptions
 * in remote method calls. This restriction ensures that the operations
 * performed by downloaded code go through a set of security checks.
*/

import java.rmi.*;
import java.util.Scanner;


public class Client {
  public static void main(String[] args) {
    try {
    	Scanner clientInput = new Scanner(System.in);
    	castVote vgen = (castVote) Naming.lookup("rmi://localhost/Dater1");
    	while(true) {
    		int choice =0;
    		System.out.println("------------------\n\t1.New ticket\n\t2.Vote\n"
    				+ "\t3.view vote result\n\t4.Exit");
    		System.out.println("------------------");
    		try {
    			choice = clientInput.nextInt();
    			//issue a ticket
    			if(choice == 1) {
    				int clientTicket = vgen.ticket();
    				System.out.println("New ticket: "+ clientTicket);
    			}
    			//vote
    			else if (choice == 2) {
    				//log in before voting
    				System.out.println("Please enter your ticket: ");
    				int ticketNum = clientInput.nextInt();
    				if (vgen.contains(ticketNum )) {
    					System.out.println("Pleas vote:");
    					System.out.println("\t1.\t A\n\t2.\t B\n\t3.\t C");
    					try {
    						int voteChoice = clientInput.nextInt();
    						vgen.vote(voteChoice);
    					}catch(Exception e) {
    						System.out.println("Please enter a valid number");
    					}
    				}
    				else {
    					System.out.println("Please enter a valid tocket number");
    				}
    			}
    			//view vote results
    			else if (choice == 3) {
    				//log in before voting
    				System.out.println("Please enter your ticket: ");
    				int ticketNum = clientInput.nextInt();
    				if (vgen.contains(ticketNum)) {
    					System.out.println(vgen.getVotingResults());
    				}
    				else {
    					System.out.println("Please enter a valid tocket number");
    				}
    			}
    			//Exit
    			else if (choice == 4) {
    				System.exit(0);
    			}
    		}catch(Exception e) {
    			System.out.println("Please enter a valid number");
    		}
    	}
		
    }
    catch(Exception e) {
      System.out.println("Problem encountered accessing remote object "+e);
    }	
  }
}
