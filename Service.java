
public class Service extends Entity {
	
	//Meloi-Pedia klasis
	
	//Constructors
	Service(String name,String description,int id){
		this.name=name;
		this.description=description;
		this.id=id;
	}
	Service(){}
	
	//Methods
	 String getDetails(){
		return "Type: Service\n";
	 }
	 
	 String getType() {
		 return "Service";
	 }
}
