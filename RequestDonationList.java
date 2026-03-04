import java.util.ArrayList;

//Syllogh antikeimenwn RequestDonation
public class RequestDonationList {
	
	//Fields
	public ArrayList<RequestDonation> rdEntities=new ArrayList<RequestDonation>();
	
	
	//Constructors
	RequestDonationList(){
	}
	
	//Methods
	//Epistrefei ena sygkekrimeno antikeimeno RequestDonation
	RequestDonation get(int id) {
		for(int i=0; i<rdEntities.size(); i++) {
			if(rdEntities.get(i).entity.id==id) {
				return rdEntities.get(i);
			}					
		}			
		return null;
	}
	
	void add(RequestDonation rd,Organization org) {
	//Elegxos gia hdh yparxon requestdonation sthn @rdEntities
		for(int i=0; i<rdEntities.size(); i++) {
			if(rdEntities.get(i).equals(rd)) {
				rdEntities.get(i).quantity+=rd.quantity;
				return;
			}				
		}
		//Entity pou den yparxei sth lista
		rdEntities.add(rd);
		
		//TODO:to make entityList()	
		//Elegxos gia hdh yparxon entity sthn @entityList
		for(int i=0; i<org.entityList.size();i++) {
			if(org.entityList.get(i).id==rd.entity.id) {
				return;
			}
		}
		//TODO:  make print  into an exception
		System.out.println("RequestDonation entity was not found in entityList ");
	}
	
	void remove(RequestDonation rd) {
		/*for(int i=0; i<rdEntities.size(); i++) {
			if(rdEntities.get(i).equals(rd)) {
				rdEntities.remove(i);
				return;
			}				
		}*/
		rdEntities.remove(rd);
	}
	//Gia ena antikeimeno tropopoiei to quantity
	void modify(RequestDonation rd,double quant) {
		for(int i=0; i<rdEntities.size(); i++) {
			if(rdEntities.get(i).equals(rd)) {
				rdEntities.get(i).quantity=quant; //rd.quantity
				return;
			}				
		}
	}
	//Emfanizei to synolo twn eidwn pou vrisketai sthn rdEntities dld ta onomata kai tis posothtes
	void monitor() {
		for(int i=0; i<rdEntities.size(); i++) {
			System.out.println(rdEntities.get(i).entity.getEntityInfo()+"Quantity:"+rdEntities.get(i).quantity+"\n");
		}
	}
	//Afairei ola ta antikeimena apo th lista
	void reset() {
		rdEntities.clear();
	}

}
