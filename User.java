import java.util.Scanner;

public abstract class User {
	
	//Meloi Klasis
	protected String name;
	protected String phone;
	
	
	
	
   //Constructor 
	User(){	}
	
	
	//Methods getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public  void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	
	//TODO: need move this to "Organization"
	static void logout() {
		//Dhmiourgia stream(rois eisodou)
		Scanner cn=new Scanner(System.in);
		
		System.out.println("Do you want to log out?");
		System.out.println("Please enter y(yes) or n(no)!");
		String in=cn.next();
	 do{
		if(in.equals("n"))
			break;
		else if(in.equals("y")) {
			//Epilogh Aposyndeshs
			System.out.println("Do you want to log in with other user?");
			System.out.print("Enter y(yes) or n(no): ");
			
			
			String p=cn.next();
			do {
			if(p.equals("n"))
			 System.exit(0);
			else if(p.equals("y")) {
			//Epilogh aposyndeshs kai syndeshs me allo xrhsth				
				main.main(null);
			}else System.out.println("Please enter y(yes) or n(no)!");
			p=cn.next();
		 }while(p!=("y")|| p!=("n"));
		}
		else System.out.println("Please enter y(yes) or n(no)!");
		in=cn.next();
	 }while(in!=("y")|| in!=("n"));
  }
	

}
