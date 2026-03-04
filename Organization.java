import java.util.ArrayList;
import java.util.Scanner;

public class Organization {
	//Meloi-Pedia klasis
	String name;
	Admin admin;
	//Dia8esimes prosfores kai posothtes
	RequestDonationList currentDonations=new RequestDonationList();
	//Lista eidwn pou mporoun na dianemi8oun stous Beneficiaries
	ArrayList<Entity> entityList=new ArrayList<Entity>();
	//Lista Dwrhtwn
	ArrayList<Donator> donatorList=new ArrayList<Donator>();
	//Lista Beneficiaries
	ArrayList<Beneficiary> beneficiaryList=new ArrayList<Beneficiary>();
	
	//Constrauctor
	
	Organization(){
	}
	
	Organization(String name,Admin admin){
		this.name=name;
		this.admin=admin;
	}
	
	
	//Methods
	public void setAdmin(Admin admin){
		 this.admin=admin;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	
	void addEntity(Entity entity){
		for(int i=0;i<entityList.size();i++) {
			if(entityList.get(i).equals(entity)) {
				return;
			}
		}
		entityList.add(entity);
	}
	
	private void removeEntity(Entity entity){
		entityList.remove(entity);
	}
	
	void insertDonator(Donator don){
		for(int i=0;i<donatorList.size();i++) {
			if(donatorList.get(i).equals(don)) {
				return;
			}
		}
		donatorList.add(don);
	}
	
	void removeDonator(Donator don){
		donatorList.remove(don);
	}
	
	void insertBeneficiary(Beneficiary ben){
		for(int i=0;i<beneficiaryList.size();i++) {
			if(beneficiaryList.get(i).equals(ben)) {
				return;
			}
		}
		beneficiaryList.add(ben);
	}
	
	void removeBeneficiary(Beneficiary ben){
		beneficiaryList.remove(ben);
	}
	
	/*void listEntities(Service s,Entity entity){
		System.out.print(s.getDetails()+entity.getEntityInfo());
	}*/
	/*void listEntities(Material m,Entity ent) {
		if(t==1)
		for(int i=0; i<entityList.size();i++) {
			entityList.get(i).m.name;
		}
			
	}*/
	void listBeneficiaries(Beneficiary ben){
		for(int i=0;i<beneficiaryList.size();i++){
			for(int j=0; j<ben.receivedList.rdEntities.size();j++){
				System.out.println("Name:"+beneficiaryList.get(i).getName()
						+"\n"+"Phone:"+beneficiaryList.get(i).getPhone()+ben.receivedList.rdEntities.get(i));				
			}
		}
	}
	
	//TODO: make list @listDonators
	void listDonators(){
		for(int i=0;i<donatorList.size();i++){
			System.out.println("Name:"+donatorList.get(i).getName()
					+"\n"+"Phone:"+donatorList.get(i).getPhone());
		}
	}
	
}
