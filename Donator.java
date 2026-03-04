import java.util.Scanner;

public class Donator extends User{
	
//Lista eidwn pou epi8ymei na prosferei o Donator
 
Offers offersList=new Offers();

	//Constructors
Donator(){}

	Donator(String name,String phone){
		this.setName(name);
		this.setPhone(phone);	
	}
	
	//Methods

	//TODO:Make wrappers for the methods of @offersList
	
	void add(RequestDonation r,Organization org1) {
		offersList.add(r, org1);
	}
	
	void remove(RequestDonation r,Organization org1) {
		offersList.remove(r);
	}
		
	void monitor() {
		/*for(int i=0; i<offersList.rdEntities.size(); i++) {
			System.out.println(offersList.rdEntities.get(i).entity.getEntityInfo()+"\t"+"Quantity: "+offersList.rdEntities.get(i).quantity);
		}*/
		offersList.monitor();
	}
	
	void reset() {
		offersList.reset();
	}
	void modify(RequestDonation r,double quant) {
		offersList.modify(r,quant);
	}
	
	void commit(Organization org) {
		offersList.commit(org.currentDonations, org);
	}
	
	
}
