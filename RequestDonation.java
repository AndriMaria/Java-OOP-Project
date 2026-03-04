
public class RequestDonation {
	
//Meloi-Pedia klasis
	
//Apeikonizoun to aitima gia mia ontotha(entity)
//kai thn posothta(quantity)gia auto
	Entity entity;
	double quantity;
	
	//Constructor
	RequestDonation(Entity entity,double quantity){
		this.entity=entity;
		this.quantity=quantity;
	}
	

	//Methods
	
	//Sygkrish tou id dyo antikeimenwn RequestDonation 
	public boolean equals(RequestDonation request) {
		return (this.entity.id==request.entity.id);	
	}
}
