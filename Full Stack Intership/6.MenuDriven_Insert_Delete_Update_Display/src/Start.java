import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start
{
	public static void main(String[] args) throws Exception
	{
	    BufferedReader br=new BufferedReader
	                              (new InputStreamReader(System.in));

	    System.out.println("!! DATABASE MANAGEMENT SYSTEM !!");

	    while(true)
	    {
	      System.out.println("\n1. Insert Record ");
	      System.out.println("2. Delete Record ");
	      System.out.println("3. Update Record ");
	      System.out.println("4. Display All Record ");
	      System.out.println("5. Exit ");
	      System.out.println("Enter Your Choice:- ");
	      int id=Integer.parseInt(br.readLine());

	      switch(id)
	      {
	        case 1:InsertIntoDatabase.insert();break;
	        case 2:DeleteFromDatabase.delete();break;
	        case 3:UpdateDatabaseRecords.update();break;
	        case 4:DisplyAllRecords.display();break;
	        case 5:System.exit(0);break;
	        default: System.out.println("Invalid Choice");
	      }
	    }
	}

}
