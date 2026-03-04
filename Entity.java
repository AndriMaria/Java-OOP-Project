
//H Entity antiproswpeuei ena eidos dwreas
public abstract class Entity {
	
	
	//Meloi-Pedia Klasis
	protected  String name;
	protected  String description;
	protected  int id;

	//Constructor
	Entity(){}	
	
	
	//Methodoi
	//Epistrefei tis plhrofories name ,description,id
	 
	String getName() {
		return name;
	}
	
	String getEntityInfo() {
		return "Name:"+name+"\n"+
			   "Description:"+description+"\n"+
			   "Id:"+id+"\n";			
	}
	abstract String getDetails();
	
	//TODO: na ginetai override apo allh klassi
	public String toString() {
		return getEntityInfo()+getDetails();
	}
	
	abstract String getType(); 
	
	
	
}
