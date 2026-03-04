//import java.util.Scanner;

// Synolo eidwn pou proti8etai na synisferei o Donator

public class Offers extends RequestDonationList{
	
	//Meloi -Pedia
	/*static int m1,m2,m3;//metavlites pou kratane thn twrinh posothta tou fagitou
	static int hour1,hour2,hour3;*/
	
	//Constructors
	Offers(){	
	}
	
	//Dhmiourgia stream(rois eisodou)
	//Scanner cn=new Scanner(System.in);

	
	//Methods
	
	//Enhmerwnei ta currentDnoations tou organismou
	
	void commit(RequestDonationList currentDonations,Organization org) {			
		for(int i=0; i<rdEntities.size();i++) {
			currentDonations.add(rdEntities.get(i),org );
		}
		rdEntities.clear();
	}
	
	
	
	
	
	
	
	
	
	

	
	/*void addquantityM() {
		//
		Organization.getid();
		System.out.print("Add quantity(Enter an integer):");
			if(Organization.getid()==0) {
				int r1=cn.nextInt();
				m1=m1+r1;
				Donator.offerslist.add("0.milk"+"(liquid food)\tId:"+0+"\tQuantity:"+Offers.m1);
				
			}
			else if(Organization.getid()==1) {
				int r1=cn.nextInt();
				m2=m2+r1;
				Donator.offerslist.add("1.sugar"+"(additive food)\tId:"+ 1+"\tQuantity:"+Offers.m2);
			}
			else if(Organization.getid()==2) {
				int r1=cn.nextInt();
				m3=m3+r1;
				Donator.offerslist.add("2.rice"+ "(solid food)\tId:"+ 2+"\tQuantity:"+Offers.m3);
			}
		//Donator.offerslist.add(Organization.entityListM.get(Organization.getid()));	
	}
	void addquantityS() {
		Organization.getid();
		System.out.print("Add quantity(Enter an integer):");
		if(Organization.getid()==0) {
			int r1=cn.nextInt();
			hour1=hour1+r1;
			Donator.offerslist.add("3.MedicalSupport "+"(Large amount of medicines and qualified staff) \tId:"+0+"\tHours:"+Offers.hour1);
		}
		else if(Organization.getid()==1) {
			int r1=cn.nextInt();
			hour2=hour2+r1;
			Donator.offerslist.add("4.NurserySupport "+"(Staff which care for the patients) \tId:"+ 1+"\tHours:"+Offers.hour2);
		}
		else if(Organization.getid()==2) {
			int r1=cn.nextInt();
			hour3=hour3+r1;
			Donator.offerslist.add("5.BabySitting "+"(Baby Care) \tId:"+ 2+"\tHours:"+Offers.hour3);
		}
		//Donator.offerslist.add(Organization.entityListS.get(Organization.getid()));	
	}
	void remove() {
		Donator.offerslist.remove(Donator.u);
	}
	*/
	/*void commit() {
		if(Donator.t==0){
			System.out.print("Put a quantity:");
			int r1=cn.nextInt();
			m1=r1;
		}
		else if(Donator.t==1){
			System.out.print("Put a quantity:");
			int r1=cn.nextInt();
			m2=r1;
		}
		else if(Donator.t==2){
			System.out.print("Put a quantity:");
			int r1=cn.nextInt();
			m3=r1;
		}
		else if(Donator.t==3){
			System.out.print("Put hours:");
			int r1=cn.nextInt();
			hour1=r1;
		}
		else if(Donator.t==4){
			System.out.print("Put hours:");
			int r1=cn.nextInt();
			hour2=r1;
		}
		else if(Donator.t==3){
			System.out.print("Put hours:");
			int r1=cn.nextInt();
			hour3=r1;
		}
		
	}*/
}
