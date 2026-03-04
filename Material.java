
public class Material extends Entity{
	
	//Meloi-Pedia Klasis
	private double level1,level2,level3;
	
	//Dhmiourgia antikeimenou
	//Material m1=new Material();
	
	//Constructors
	
	Material(String name,String description,int id){
		this.name=name;
		this.description=description;
		this.id=id;
	}
	Material(double level1,double level2,double level3){
		this.level1=level1;
		this.level2=level2;
		this.level3=level3;
	}

	
	//Methods
	String getDetails() {
		return 	"Level1:"+level1+"\n"+
				"Level2:"+level2+"\n"+
				"Level3:"+level3+"\n"+"Type: Material\n";
	}
	
	
	String getType() {
		return "Material";
	}
	
	
	
	
	
	/*void Levels() {
		if(Beneficiary.noPersons==1)
			System.out.println("You belong to level1");
		else if(Beneficiary.noPersons>=2 & Beneficiary.noPersons<=4)
			System.out.println("You belong to level2");
		else if(Beneficiary.noPersons>=5)
			System.out.println("You belong to level3");
		else
			System.out.println("Enter a correct number!");
	}*/
	
	 /*String Material  getDetails() {
		 
		return m1+Entity.name+Entity.description+Entity.id;
	}*/
}
