import java.util.ArrayList;

public class Requests extends RequestDonationList{
	
	//Meloi-Pedia Klasis
	
	
	
	//Constructor
	Requests(){	
	}

	
	//Methods
	
	//Kanei add efoson h posothta einai dia8esimh ston oragnismo kai an o beneficiary th dikaioutai
	void add(Organization org,Beneficiary benefic,
			RequestDonation rd,String eidos,
			double level1,double level2,double level3){
		for(int i=0; i<org.currentDonations.rdEntities.size(); i++){
			if(org.currentDonations.rdEntities.get(i).equals(rd)){
				if(rd.quantity<=org.currentDonations.rdEntities.get(i).quantity &
					validRequestDonation(benefic,rd,eidos,
					 level1, level2, level3)){
					super.add(rd, org);
					return;
				}
			}	
		}
		
		//TODO: Make exceptions for a and b
		System.out.println("Requests:Both or one of conditions failed");
		return; 
	}
	
	void modify(Organization org,Beneficiary benefic,
			RequestDonation rd,double quant,String eidos,
			double level1,double level2,double level3){
		for(int i=0; i<org.currentDonations.rdEntities.size(); i++){
			if(org.currentDonations.rdEntities.get(i).equals(rd)){
				if(rd.quantity<=org.currentDonations.rdEntities.get(i).quantity &
					validRequestDonation(benefic,rd,eidos,
					 level1, level2, level3)){
					super.modify(rd,quant);
					return;
				}
			}	
		}
		//TODO: Make exceptions for a and b
		System.out.println("Requests:Both or one of conditions failed");
		return; 
	}
	
	boolean validRequestDonation(Beneficiary benefic,
			RequestDonation rd,String eidos,
			double level1,double level2,double level3){
		
		if(eidos.equals("Material")){
			double receivedQuantity=0;
			for(int i=0; i<benefic.receivedList.rdEntities.size();i++) {
				if(benefic.receivedList.rdEntities.get(i).equals(rd)){
					receivedQuantity=benefic.receivedList.rdEntities.get(i).quantity;
				}
			}
			//Posothta pou zhteitai
			double requestQuantity=rd.quantity;
			double sumQuantity=receivedQuantity+requestQuantity;
			//Elegxos gia orio
			if(benefic.noPersons==1) {
				return level1>=sumQuantity;
			}
			else if(benefic.noPersons>=2 & benefic.noPersons<=4){
				return level2>=sumQuantity;
			}
			else { 
				return level3>=sumQuantity;
			}
		}
		else if(eidos.equals("Service")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	void commit(Organization org,Beneficiary benefic,
			RequestDonation rd,String eidos,
			double level1,double level2,double level3){
		for(int i=0; i<org.currentDonations.rdEntities.size(); i++){
			if(org.currentDonations.rdEntities.get(i).equals(rd)){
				if(rd.quantity<=org.currentDonations.rdEntities.get(i).quantity &
					validRequestDonation(benefic,rd,eidos,
					 level1, level2, level3)){
					org.currentDonations.rdEntities.get(i).quantity-=rd.quantity;
					rdEntities.remove(rd);
					benefic.receivedList.rdEntities.add(rd);
					return;
				}
			}
		}
		//TODO: Make exceptions for a and b
				System.out.println("Requests:Both or one of conditions failed");
				return;
	}
	
}