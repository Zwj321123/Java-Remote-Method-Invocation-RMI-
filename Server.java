import java.rmi.Naming;

public class Server {
  public static void main(String[] args) {
	//if (System.getSecurityManager() == null) {
    //    System.setSecurityManager(new SecurityManager());
    //}	  
    try {
      voteImpl remote = new voteImpl();
      Naming.rebind ("Dater1", remote);
      System.out.println("Object bound to name");
    }
    catch(Exception e) {
      System.out.println("Error occurred at server  "+e.getMessage());
    }
 }
}

