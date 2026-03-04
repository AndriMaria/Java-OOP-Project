import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		//Dhmiourgia antikeimenwn
		Donator d=new Donator("Donator","0123456789");
		Beneficiary b1=new Beneficiary("Beneficiary1","1234567890");
		Beneficiary b2=new Beneficiary("Beneficiary2","2345678901");
		
		Donator d5=new Donator();
		Beneficiary b5=null;
		RequestDonationList re=new RequestDonationList();
		
		
		Admin admin=new Admin("MariaJohn","1070910533");
		Organization o=new Organization("Ontokentrikos",admin);
		
		//Organization ot=new Organization();
		
		//Kanei insert ton Donator kai tous Beneficiaries stis listes
		o.insertDonator(d);
		o.insertBeneficiary(b1);
		o.insertBeneficiary(b2);
		
		Material m1=new Material("milk","liquid food",0);
		Material m2=new Material("sugar","solid food",1);
		Material m3=new Material("rice","solid food",2);
		
		
		o.addEntity(m1);
		o.addEntity(m2);
		o.addEntity(m3);
		
		
		Service s1=new Service("MedicalSupport","Large amount of medicines and qualified staff",3);
		Service s2=new Service("NurserySupport","Staff which care for the patients",4);
		Service s3=new Service("BabySitting","Baby care",5);
		o.addEntity(s1);
		o.addEntity(s2);
		o.addEntity(s3);
		//Dhmiourgia stream(rois eisodou)
		Scanner cn=new Scanner(System.in);
		
		//Eisodos phone
		
		System.out.print("Enter the phone:"); 
		//d5.phone=cn.next();
	    d5.setPhone(cn.next());
	    
	    boolean checkDon=false;
	    boolean checkBen=false;
	    String n="";
	    String p="";
	    //Elegxos kinhtou sth Lista Donators
		for(int i=0; i<o.donatorList.size();i++) {
			if(o.donatorList.get(i).getPhone().equals(d5.getPhone())) {
				
				checkDon=true;
				n=o.donatorList.get(i).getName();
				p=o.donatorList.get(i).getPhone();
				/*System.out.println("\n Ontokentrikos");
				System.out.println("\n Hello Donator");
				System.out.print("Your name:" +o.donatorList.get(i).getName());
				System.out.print("\t \tYour phone:"+o.donatorList.get(i).getPhone());
				System.out.println("\n ");*/
			}	
		}
		 //Elegxos kinhtou sth Lista Beneficiaries
		for(int i=0; i<o.beneficiaryList.size();i++) {
			if(o.beneficiaryList.get(i).getPhone().equals(d5.getPhone())) {
				checkBen=true;
				n=o.beneficiaryList.get(i).getName();
				p=o.beneficiaryList.get(i).getPhone();
				/*System.out.println("\n Ontokentrikos");
				System.out.println("\n Hello Beneficiary");
				System.out.print("Your name:" +o.beneficiaryList.get(i).getName());
				System.out.print("\t \tYour phone:"+o.beneficiaryList.get(i).getPhone());
				System.out.println("\n ");*/
			}	
		}
		
		if(checkDon==true) {
			//Menou epilogwn Donator
			System.out.println("\n Ontokentrikos");
			System.out.println("\n Hello Donator");
			System.out.print("Your name:" +n);
			System.out.print("\t \tYour phone:"+p);
			System.out.println("\n ");
			
			label:
			do {
			System.out.println("Enter: 1(AddOffer) \t 2(ShowOffer) \t 3(LogOut) ");
			int a;
			do {
				a=cn.nextInt();
				if(a==1) {
					int numOfMaterial=0;
					int numOfService=0;
					for(int i=0; i<o.entityList.size();i++) {					
						if(o.entityList.get(i).getType().equals("Material")) {
							numOfMaterial+=1;
						}
						else if(o.entityList.get(i).getType().equals("Service")) {
							numOfService+=1;
						}
					}
					label1:
					do {
					//Epilogh AddOffer
					System.out.print("1.Material("+numOfMaterial+")");
					System.out.println("\t 2.Service("+numOfService+")"+"\t 3.LogOut \t4.GoBack");
					System.out.print("Enter 1 or 2 or 3 or 4:");
					int t;
					do {
						t=cn.nextInt();
						if(t==1) {
						//Epilogh Material
							int u=0;
							//label1:
							for(int i=0; i<o.entityList.size();i++) {					
								if(o.entityList.get(i).getType().equals("Material")) {
									u++;
									System.out.println(u+". "+o.entityList.get(i).getName());
								}
							}
							System.out.println("Choose one Material: 1 or 2 or 3");
							int input;
							Entity entm=null;
							do {
								input=cn.nextInt();
								u=0;							
								for(int i=0; i<o.entityList.size();i++) {					
									if(o.entityList.get(i).getType().equals("Material")) {
										u+=1;
										if(u==input) {
											System.out.println(o.entityList.get(i).getEntityInfo());
										 //Pairnw to entity
											entm=o.entityList.get(i);	
											break;
										}
									}
								}								
							}while(input!=1 & input!=2 & input!=3);
							
							System.out.println("Do you want add this food");
							//label2:	
							do {
								System.out.print("Enter \n 1.Add this food \n 2.LogOut \n 3.GoBack");
								int r;										
								do {
									r=cn.nextInt();
									if(r==1){
										//Epilogh gia add food
										System.out.print("Give a quantity:");
										double quan;
										quan=cn.nextDouble();
										RequestDonation req=new RequestDonation(entm,quan);
										d5.add(req, o);
										d5.commit(o);
										System.out.println("Enter: \n 1.LogOut 2.GoBack");
										int y;						
										do {
											y=cn.nextInt();
											if(y==1)
												User.logout();
											else if(y==2)
												continue label1;
											else 
												System.out.println("Enter 1 or 2");										
										}while(y!=1 & y!=2);										
									}
									else if(r==2)
										//Epilogh gia logOut
										User.logout();
									else if(r==3)
										//Epilogh gia GoBack
										continue label1;
									else
										System.out.println("Please enter 1 or 2 or 3!");									
								}while(r!=1 & r!=2 & r!=3);			
								}while(0!=5);						
						}
						else if(t==2) {
						//Epilogh Service
							int u=0;
							for(int i=0; i<o.entityList.size();i++) {					
								if(o.entityList.get(i).getType().equals("Service")) {
									u++;
									System.out.println(u+". "+o.entityList.get(i).getName());
								}
							}
							System.out.println("Choose one Service: 1 or 2 or 3");
							
							int input;
							Entity ents=null;
							do {
								input=cn.nextInt();
								u=0;
								for(int i=0; i<o.entityList.size();i++) {					
									if(o.entityList.get(i).getType().equals("Service")) {
										u+=1;
										if(u==input) {
											System.out.println(o.entityList.get(i).getEntityInfo());
											ents=o.entityList.get(i);
											break;
										}
									}
								}
								//label3:	
									do {
										System.out.print("Enter \n 1.Add hour for this Service \n 2.LogOut \n 3.GoBack");
										int r;										
										do {
											r=cn.nextInt();
											if(r==1){
												//Epilogh gia add food
												System.out.print("Give a quantity:");
												double quan;
												quan=cn.nextDouble();
												RequestDonation req=new RequestDonation(ents,quan);
												d5.add(req, o);
												
												System.out.println("Enter: \n 1.LogOut 2.GoBack");
												int y;						
												do {
													y=cn.nextInt();
													if(y==1)
														User.logout();
													else if(y==2)
														continue label1;
													else 
														System.out.println("Enter 1 or 2");										
												}while(y!=1 & y!=2);										
											}
											else if(r==2)
												//Epilogh gia logOut
												User.logout();
											else if(r==3)
												//Epilogh gia GoBack
												continue label1;
											else
												System.out.println("Please enter 1 or 2 or 3!");	
										}while(r!=1 & r!=2 & r!=3);			
										}while(0!=5);
								
							}while(input!=1 & input!=2 & input!=3);
						}
						else if(t==3) {User.logout();}
						
						else if(t==4) {continue label;}
						
						else{System.out.println("Please enter one number 1 or 2 or 3 or 4!");}
					}while(t!=1 & t!=2 & t!=3 & t!=4);
					}while(0!=5);
				}
				else if(a==2) {
					//Epilogh gia ShowOffer
					label3:
					do {
					d5.monitor();
					if(d5.offersList.rdEntities.isEmpty()) {
						System.out.println("There are no offers!");
						System.out.println("Enter \n 1.LogOut \t 2.Goback ");
						int n2;
						do {
						n2=cn.nextInt();
						if(n2==1)
							User.logout();
						else if(n2==2)
							continue label;
						else
							System.out.println("Enter 1 or 2!");
						}while(n2!=1& n2!=2);
					}
					else{
					System.out.println("Enter\n1.Clear all donation 2.Choose one to remove or to change the quantity \n3.GoBack");
					int t1;
					do {
					t1=cn.nextInt();
					if(t1==1) {
						d5.reset();
						System.out.println("Enter \n 1.LogOut \t 2.Goback ");
						int n2;
						do {
						n2=cn.nextInt();
						if(n2==1)
							User.logout();
						else if(n2==2)
							continue label;
						else
							System.out.println("Enter 1 or 2!");
						}while(n2!=1& n2!=2);
					}
					else if(t1==2) {
					System.out.println("Choose one donation to remove or to change the quantity");
					int num;
					num=cn.nextInt();
					int u=0;
						for(int i=0; i<d5.offersList.rdEntities.size();i++) {
							u+=1;
							if(u==num) {
								//H prosfora pou epilex8hke
								RequestDonation nOf=d5.offersList.rdEntities.get(i);
									
								System.out.println("Enter:\n1.Remove \n2.Change quantity \n3.GoBack");
								int n1;
								do {
								n1=cn.nextInt();
								if(n1==1) {
									d5.remove(nOf, o);
									System.out.println("Enter \n1.LogOut \t 2.Goback ");
									int n2;
									do {
									n2=cn.nextInt();
									if(n2==1)
										User.logout();
									else if(n2==2)
										continue label;
									else
										System.out.println("Enter 1 or 2!");
									}while(n2!=1& n2!=2);
								}
								else if(n1==2) {
									System.out.print("Give a quantity:");	
									double quan;
									quan=cn.nextDouble();
								
									//d5.offersList.rdEntities.get(i).quantity=cn.nextDouble();
									d5.modify(d5.offersList.rdEntities.get(i),quan);
									System.out.println("Enter \n1.LogOut \t 2.Goback ");
									int n2;
									do {
									n2=cn.nextInt();
									if(n2==1)
										User.logout();
									else if(n2==2)
										continue label;
									else
										System.out.println("Enter 1 or 2!");
									}while(n2!=1& n2!=2);
								}
								else if(n1==3)
									continue label3;
								else
									System.out.println("Please enter 1 or 2 or 3!");
								}while(n1!=1 & n1!=2 & n1!=3);
							}
								
						}
					}
					else if(t1==3)
						continue label;
					else
						System.out.println("Enter 1 or 2 or 3!");
					}while(t1!=1 & t1!=2 & t1!=3);
					}
					}while(0!=5);
				}
				else if(a==3) {
					//Epilogh gia LogOut
					User.logout();
				}
				else 
					System.out.println("Please enter one number 1 or 2 or 3!");
				//a=cn.nextInt();		
			}while(a!=1 & a!=2 & a!=3);
			}while(0!=5);
		}
		
		else if(checkBen==true) {
			//Menou epilogwn Beneficiary
			System.out.println("\n Ontokentrikos");
			System.out.println("\n Hello Beneficiary");
			System.out.print("Your username:" +n );
			System.out.print("\t \tYour phone:"+p);
			System.out.println("\n ");
			

			
			
			
			
			
			
			label:
			do {
			System.out.println("Enter: 1(AddRequest) \t 2(ShowRequest) \t 3(LogOut) ");
			int a;
			do {
				a=cn.nextInt();
				if(a==1) {
					int numOfMaterial=0;
					int numOfService=0;
					for(int i=0; i<o.entityList.size();i++) {					
						if(o.entityList.get(i).getType().equals("Material")) {
							numOfMaterial+=1;
						}
						else if(o.entityList.get(i).getType().equals("Service")) {
							numOfService+=1;
						}
					}
					label1:
					do {
					//Epilogh AddRequest
					System.out.print("1.Material("+numOfMaterial+")");
					System.out.println("\t 2.Service("+numOfService+")"+"\t 3.LogOut \t4.GoBack");
					System.out.print("Enter 1 or 2 or 3 or 4:");
					int t;
					do {
						t=cn.nextInt();
						if(t==1) {
						//Epilogh Material
							int u=0;
							//label1:
							for(int i=0; i<o.entityList.size();i++) {					
								if(o.entityList.get(i).getType().equals("Material")) {
									u++;
									System.out.println(u+". "+o.entityList.get(i).getName());
								}
							}
							System.out.println("Choose one Material: 1 or 2 or 3");
							int input;
							Entity entm=null;
							do {
								input=cn.nextInt();
								u=0;							
								for(int i=0; i<o.entityList.size();i++) {					
									if(o.entityList.get(i).getType().equals("Material")) {
										u+=1;
										if(u==input) {
											System.out.println(o.entityList.get(i).getEntityInfo());
										 //Pairnw to entity
											entm=o.entityList.get(i);	
											break;
										}
									}
								}								
							}while(input!=1 & input!=2 & input!=3);
						
							
							
							System.out.println("Do you want add request for this food");
							//label2:	
							do {
								System.out.print("Enter \n 1.Add a request \n 2.LogOut \n 3.GoBack");
								int r;										
								do {
									r=cn.nextInt();
									if(r==1){
										//Epilogh gia request
										System.out.print("How many people are in your family?");
										int numFam;
										numFam=cn.nextInt();
										b5.noPersons=numFam;
										
										System.out.print("Give the quantity for your request: ");
										double quanti;
										quanti=cn.nextDouble();
										
										RequestDonation re1=new RequestDonation(entm,quanti);
										Requests requ=new Requests();
										requ.add(o, b5, re1, "Material", 10, 20, 30);
										
										
										
										
										
										
										
										
										
										/*System.out.print("Give a quantity:");
										double quan;
										quan=cn.nextDouble();
										RequestDonation req=new RequestDonation(entm,quan);
										d5.add(req, o);*/
										
										System.out.println("Enter: \n 1.LogOut 2.GoBack");
										int y;						
										do {
											y=cn.nextInt();
											if(y==1)
												User.logout();
											else if(y==2)
												continue label1;
											else 
												System.out.println("Enter 1 or 2");										
										}while(y!=1 & y!=2);										
									}
									else if(r==2)
										//Epilogh gia logOut
										User.logout();
									else if(r==3)
										//Epilogh gia GoBack
										continue label1;
									else
										System.out.println("Please enter 1 or 2 or 3!");									
								}while(r!=1 & r!=2 & r!=3);			
								}while(0!=5);						
						}
						else if(t==2) {
						//Epilogh Service
							int u=0;
							for(int i=0; i<o.entityList.size();i++) {					
								if(o.entityList.get(i).getType().equals("Service")) {
									u++;
									System.out.println(u+". "+o.entityList.get(i).getName());
								}
							}
							System.out.println("Choose one Service: 1 or 2 or 3");
							
							int input;
							Entity ents=null;
							do {
								input=cn.nextInt();
								u=0;
								for(int i=0; i<o.entityList.size();i++) {					
									if(o.entityList.get(i).getType().equals("Service")) {
										u+=1;
										if(u==input) {
											System.out.println(o.entityList.get(i).getEntityInfo());
											ents=o.entityList.get(i);
											break;
										}
									}
								}
								//label3:	
									do {
										System.out.print("Enter \n 1.Add a request \n 2.LogOut \n 3.GoBack");
										int r;										
										do {
											r=cn.nextInt();
											if(r==1){
												//Epilogh gia  request
												
												System.out.print("Give the quantity for your request: ");
												double quanti;
												quanti=cn.nextDouble();
												
												RequestDonation re1=new RequestDonation(ents,quanti);
												Requests requ=new Requests();
												requ.add(o, b5, re1, "Service", 1, 3, 5);
												
												
												/*System.out.print("Give a quantity:");
												double quan;
												quan=cn.nextDouble();
												RequestDonation req=new RequestDonation(ents,quan);
												d5.add(req, o);*/
												
												System.out.println("Enter: \n 1.LogOut 2.GoBack");
												int y;						
												do {
													y=cn.nextInt();
													if(y==1)
														User.logout();
													else if(y==2)
														continue label1;
													else 
														System.out.println("Enter 1 or 2");										
												}while(y!=1 & y!=2);										
											}
											else if(r==2)
												//Epilogh gia logOut
												User.logout();
											else if(r==3)
												//Epilogh gia GoBack
												continue label1;
											else
												System.out.println("Please enter 1 or 2 or 3!");	
										}while(r!=1 & r!=2 & r!=3);			
										}while(0!=5);
								
							}while(input!=1 & input!=2 & input!=3);
						}
						else if(t==3) {User.logout();}
						
						else if(t==4) {continue label;}
						
						else{System.out.println("Please enter one number 1 or 2 or 3 or 4!");}
					}while(t!=1 & t!=2 & t!=3 & t!=4);
					}while(0!=5);
				}
				else if(a==2) {
					//Epilogh gia ShowRequest
					
					
				
				}
				else if(a==3) {
					//Epilogh gia LogOut
					User.logout();
				}
				else 
					System.out.println("Please enter one number 1 or 2 or 3!");
				//a=cn.nextInt();		
			}while(a!=1 & a!=2 & a!=3);
			}while(0!=5);
			
		}
		else if(d5.getPhone().equals("1070910533")) {		
			
			//Epilogh Admin
			//Menou epilogwn Admin
			System.out.println("\n Ontokentrikos");
			System.out.println("\n Hello Admin");
			System.out.print("Your username:" +admin.getName());
			System.out.print("\t \tYour phone:"+admin.getPhone());
			System.out.println("\n ");
			
			label:
				do {
				System.out.println("Enter: \n1.View(Material & Service) \n2.Monitor Organization \n3.LogOut");
				int a;
				do {
					a=cn.nextInt();
					if(a==1) {
						int numOfMaterial=0;
						int numOfService=0;
						for(int i=0; i<o.entityList.size();i++) {					
							if(o.entityList.get(i).getType().equals("Material")) {
								numOfMaterial+=1;
							}
							else if(o.entityList.get(i).getType().equals("Service")) {
								numOfService+=1;
							}
						}
						label1:
						do {
						//Epilogh AddOffer
						System.out.print("1.Material("+numOfMaterial+")");
						System.out.println("\t 2.Service("+numOfService+")"+"\t 3.LogOut \t4.GoBack");
						System.out.print("Enter 1 or 2 or 3 or 4:");
						int t;
						do {
							t=cn.nextInt();
							if(t==1) {
							//Epilogh Material
								int u=0;
								//label1:
								for(int i=0; i<o.entityList.size();i++) {					
									if(o.entityList.get(i).getType().equals("Material")) {
										u++;
										System.out.println(u+". "+o.entityList.get(i).getName());
									}
								}
								System.out.println("Choose one Material: 1 or 2 or 3");
								int input;
								Entity entm=null;
								do {
									input=cn.nextInt();
									u=0;							
									for(int i=0; i<o.entityList.size();i++) {					
										if(o.entityList.get(i).getType().equals("Material")) {
											u+=1;
											if(u==input) {
												System.out.println(o.entityList.get(i).getEntityInfo());
											 //Pairnw to entity
												entm=o.entityList.get(i);	
												break;
											}
										}
									}								
								}while(input!=1 & input!=2 & input!=3);
																						
							}
							else if(t==2) {
							//Epilogh Service
								int u=0;
								for(int i=0; i<o.entityList.size();i++) {					
									if(o.entityList.get(i).getType().equals("Service")) {
										u++;
										System.out.println(u+". "+o.entityList.get(i).getName());
									}
								}
								System.out.println("Choose one Service: 1 or 2 or 3");
								
								int input;
								Entity ents=null;
								do {
									input=cn.nextInt();
									u=0;
									for(int i=0; i<o.entityList.size();i++) {					
										if(o.entityList.get(i).getType().equals("Service")) {
											u+=1;
											if(u==input) {
												System.out.println(o.entityList.get(i).getEntityInfo());
												ents=o.entityList.get(i);
												break;
											}
										}
									}							
								}while(input!=1 & input!=2 & input!=3);
							}
							else if(t==3) {User.logout();}
							
							else if(t==4) {continue label;}
							
							else{System.out.println("Please enter one number 1 or 2 or 3 or 4!");}
						}while(t!=1 & t!=2 & t!=3 & t!=4);
						}while(0!=5);
					}
					else if(a==2) {
						//Epilogh gia Monitor Organization
						System.out.println("Enter \n1.List Beneficiaries \n2.List Donators \n3.Reset Beneficiaries Lists \n4.GoBack \n5.LogOut");
						int epil;
						do {
						epil=cn.nextInt();
						if(epil==1) {
							//Epilogh List Beneficiaries
							Beneficiary b6=null;
							for(int i=0;i<o.beneficiaryList.size();i++) {
								b6=o.beneficiaryList.get(i);
								o.listBeneficiaries(b6);
							}
							
						}
						else if(epil==2) {
							//Epilogh List Donators
							o.listDonators();
							System.out.println("Choose one donator:");
							int numdonlist;
							numdonlist=cn.nextInt();
							int u=0;
							Donator don=null;
							for(int i=0;i<o.donatorList.size();i++) {
								u+=1;
								if(u==numdonlist) {
									o.donatorList.get(i).monitor();
									don=o.donatorList.get(i);
								}
							}
							System.out.println("Enter \n 1.LogOut \t 2.Goback \t3.Remove this Donator");
							int n2;
							do {
							n2=cn.nextInt();
							if(n2==1)
								User.logout();
							else if(n2==2)
								continue label;
							else if(n2==3)
								o.removeDonator(don);
							else
								System.out.println("Enter 1 or 2 or 3!");
							}while(n2!=1& n2!=2 & n2!=3);
						}
						else if(epil==3) {
							// Epilogh Reset Beneficiaries Lists
						}
						else if(epil==4) {
							//Epilogh GoBack
							continue label;
						}
						else if(epil==5) {
							//Epilogh LogOut
							User.logout();
						}
						else
							System.out.println("Enter 1 or 2 or 3 or 4 or 5");
					
						}while(epil!=1 & epil!=2 & epil!=3 & epil!=4 & epil!=5);
					}
					else if(a==3) {
						//Epilogh gia LogOut
						User.logout();
					}
					else 
						System.out.println("Please enter one number 1 or 2 or 3!");
					//a=cn.nextInt();		
				}while(a!=1 & a!=2 & a!=3);
				}while(0!=5);
			
			
		}
		else {
			//Epilogh gia ton xrhsth an 8elei na eggrafei h oxi
			System.out.println("Want to register?");
			System.out.print("Enter 1.(yes) or 2.(no): ");
			 
			int c;			
			do {
				c=cn.nextInt();
			if(c==2)
				main.main(null);
			else if(c==1){
				System.out.println("Do you want register as Donator or as Beneficiary?");
				System.out.print(" Answer 1.(Donator) or 2.(Beneficiary)");
				//Eisodos apanthsh apo plhktrologio gia to an 8elei na eggrafei
				//ws Donator h Beneficiary
				int e;
				
				do {
				e=cn.nextInt();
				//Epilogh eggrafhs ws Donator
				if(e==1) {
				System.out.print("Enter a name: ");
				String b=cn.next();
				d.setName(b);
				System.out.print("Enter a phone: ");
				String f=cn.next();
				d.setPhone(f);
				//Donator d1=new Donator(d.getName(),d.getPhone());
				//o.donatorList.add(d1);
				o.insertDonator(d);
				//Menou epilogwn Donator
				System.out.println("\n Ontokentrikos");
				System.out.println("\n Hello Donator");
				System.out.print("Your username:" +d.name );
				System.out.print("\t \tYour phone:"+d.phone);
				System.out.println("\n ");
				
				label:
					do {
					System.out.println("Enter: 1(AddOffer) \t 2(ShowOffer) \t 3(LogOut) ");
					int a;
					do {
						a=cn.nextInt();
						if(a==1) {
							int numOfMaterial=0;
							int numOfService=0;
							for(int i=0; i<o.entityList.size();i++) {					
								if(o.entityList.get(i).getType().equals("Material")) {
									numOfMaterial+=1;
								}
								else if(o.entityList.get(i).getType().equals("Service")) {
									numOfService+=1;
								}
							}
							label1:
							do {
							//Epilogh AddOffer
							System.out.print("1.Material("+numOfMaterial+")");
							System.out.println("\t 2.Service("+numOfService+")"+"\t 3.LogOut \t4.GoBack");
							System.out.print("Enter 1 or 2 or 3 or 4:");
							int t;
							do {
								t=cn.nextInt();
								if(t==1) {
								//Epilogh Material
									int u=0;
									//label1:
									for(int i=0; i<o.entityList.size();i++) {					
										if(o.entityList.get(i).getType().equals("Material")) {
											u++;
											System.out.println(u+". "+o.entityList.get(i).getName());
										}
									}
									System.out.println("Choose one Material: 1 or 2 or 3");
									int input;
									Entity entm=null;
									do {
										input=cn.nextInt();
										u=0;							
										for(int i=0; i<o.entityList.size();i++) {					
											if(o.entityList.get(i).getType().equals("Material")) {
												u+=1;
												if(u==input) {
													System.out.println(o.entityList.get(i).getEntityInfo());
												 //Pairnw to entity
													entm=o.entityList.get(i);	
													break;
												}
											}
										}								
									}while(input!=1 & input!=2 & input!=3);
									
									System.out.println("Do you want add this food");
									//label2:	
									do {
										System.out.print("Enter \n 1.Add this food \n 2.LogOut \n 3.GoBack");
										int r;										
										do {
											r=cn.nextInt();
											if(r==1){
												//Epilogh gia add food
												System.out.print("Give a quantity:");
												double quan;
												quan=cn.nextDouble();
												RequestDonation req=new RequestDonation(entm,quan);
												d5.add(req, o);
												d5.commit(o);
												System.out.println("Enter: \n 1.LogOut 2.GoBack");
												int y;						
												do {
													y=cn.nextInt();
													if(y==1)
														User.logout();
													else if(y==2)
														continue label1;
													else 
														System.out.println("Enter 1 or 2");										
												}while(y!=1 & y!=2);										
											}
											else if(r==2)
												//Epilogh gia logOut
												User.logout();
											else if(r==3)
												//Epilogh gia GoBack
												continue label1;
											else
												System.out.println("Please enter 1 or 2 or 3!");									
										}while(r!=1 & r!=2 & r!=3);			
										}while(0!=5);						
								}
								else if(t==2) {
								//Epilogh Service
									int u=0;
									for(int i=0; i<o.entityList.size();i++) {					
										if(o.entityList.get(i).getType().equals("Service")) {
											u++;
											System.out.println(u+". "+o.entityList.get(i).getName());
										}
									}
									System.out.println("Choose one Service: 1 or 2 or 3");
									
									int input;
									Entity ents=null;
									do {
										input=cn.nextInt();
										u=0;
										for(int i=0; i<o.entityList.size();i++) {					
											if(o.entityList.get(i).getType().equals("Service")) {
												u+=1;
												if(u==input) {
													System.out.println(o.entityList.get(i).getEntityInfo());
													ents=o.entityList.get(i);
													break;
												}
											}
										}
										//label3:	
											do {
												System.out.print("Enter \n 1.Add hour for this Service \n 2.LogOut \n 3.GoBack");
												int r;										
												do {
													r=cn.nextInt();
													if(r==1){
														//Epilogh gia add food
														System.out.print("Give a quantity:");
														double quan;
														quan=cn.nextDouble();
														RequestDonation req=new RequestDonation(ents,quan);
														d5.add(req, o);
														
														System.out.println("Enter: \n 1.LogOut 2.GoBack");
														int y;						
														do {
															y=cn.nextInt();
															if(y==1)
																User.logout();
															else if(y==2)
																continue label1;
															else 
																System.out.println("Enter 1 or 2");										
														}while(y!=1 & y!=2);										
													}
													else if(r==2)
														//Epilogh gia logOut
														User.logout();
													else if(r==3)
														//Epilogh gia GoBack
														continue label1;
													else
														System.out.println("Please enter 1 or 2 or 3!");	
												}while(r!=1 & r!=2 & r!=3);			
												}while(0!=5);
										
									}while(input!=1 & input!=2 & input!=3);
								}
								else if(t==3) {User.logout();}
								
								else if(t==4) {continue label;}
								
								else{System.out.println("Please enter one number 1 or 2 or 3 or 4!");}
							}while(t!=1 & t!=2 & t!=3 & t!=4);
							}while(0!=5);
						}
						else if(a==2) {
							//Epilogh gia ShowOffer
							label3:
							do {
							d5.monitor();
							if(d5.offersList.rdEntities.isEmpty()) {
								System.out.println("There are no offers!");
								System.out.println("Enter \n 1.LogOut \t 2.Goback ");
								int n2;
								do {
								n2=cn.nextInt();
								if(n2==1)
									User.logout();
								else if(n2==2)
									continue label;
								else
									System.out.println("Enter 1 or 2!");
								}while(n2!=1& n2!=2);
							}
							else{
							System.out.println("Enter\n1.Clear all donation 2.Choose one to remove or to change the quantity \n3.GoBack");
							int t1;
							do {
							t1=cn.nextInt();
							if(t1==1) {
								d5.reset();
								System.out.println("Enter \n 1.LogOut \t 2.Goback ");
								int n2;
								do {
								n2=cn.nextInt();
								if(n2==1)
									User.logout();
								else if(n2==2)
									continue label;
								else
									System.out.println("Enter 1 or 2!");
								}while(n2!=1& n2!=2);
							}
							else if(t1==2) {
							System.out.println("Choose one donation to remove or to change the quantity");
							int num;
							num=cn.nextInt();
							int u=0;
								for(int i=0; i<d5.offersList.rdEntities.size();i++) {
									u+=1;
									if(u==num) {
										//H prosfora pou epilex8hke
										RequestDonation nOf=d5.offersList.rdEntities.get(i);
											
										System.out.println("Enter:\n1.Remove \n2.Change quantity \n3.GoBack");
										int n1;
										do {
										n1=cn.nextInt();
										if(n1==1) {
											d5.remove(nOf, o);
											System.out.println("Enter \n1.LogOut \t 2.Goback ");
											int n2;
											do {
											n2=cn.nextInt();
											if(n2==1)
												User.logout();
											else if(n2==2)
												continue label;
											else
												System.out.println("Enter 1 or 2!");
											}while(n2!=1& n2!=2);
										}
										else if(n1==2) {
											System.out.print("Give a quantity:");	
											double quan;
											quan=cn.nextDouble();
										
											//d5.offersList.rdEntities.get(i).quantity=cn.nextDouble();
											d5.modify(d5.offersList.rdEntities.get(i),quan);
											System.out.println("Enter \n1.LogOut \t 2.Goback ");
											int n2;
											do {
											n2=cn.nextInt();
											if(n2==1)
												User.logout();
											else if(n2==2)
												continue label;
											else
												System.out.println("Enter 1 or 2!");
											}while(n2!=1& n2!=2);
										}
										else if(n1==3)
											continue label3;
										else
											System.out.println("Please enter 1 or 2 or 3!");
										}while(n1!=1 & n1!=2 & n1!=3);
									}
										
								}
							}
							else if(t1==3)
								continue label;
							else
								System.out.println("Enter 1 or 2 or 3!");
							}while(t1!=1 & t1!=2 & t1!=3);
							}
							}while(0!=5);
						}
						else if(a==3) {
							//Epilogh gia LogOut
							User.logout();
						}
						else 
							System.out.println("Please enter one number 1 or 2 or 3!");
						//a=cn.nextInt();		
					}while(a!=1 & a!=2 & a!=3);
					}while(0!=5);
				
				
				
				
				
				
				
				}
				//Epilogh eggrafhs ws Beneficiary
				else if(e==2){
					System.out.print("Enter a name: ");
					String b=cn.next();
					b1.setName(b);
					System.out.print("Enter a phone: ");
					String f=cn.next();
					b1.setPhone(f);
					//Beneficiary b3=new Beneficiary(b1.getName(),b1.getPhone());
					//o.beneficiaryList.add(b1);
					o.insertBeneficiary(b1);
					//Menou epilogwn Beneficiary
					System.out.println("\n Ontokentrikos");
					System.out.println("\n Hello Beneficiary");
					System.out.print("Your username:" +d.name );
					System.out.print("\t \tYour phone:"+d.phone);
					System.out.println("\n ");
					
					
					
					
					
				
				
				
				}
				else 
					System.out.println("Please enter 1.(Donator) or 2.(Beneficiary)");											
				}while(e!=1 & e!=2);
			}	
			else 
				System.out.println("Please enter 1.(yes) or 2.(no)!");			   
			}while(c!=1 & c!=2);
			
			//Ektypwnei to onoma kai to thlefwno twn Donator ths listas
			/*for(int i=0;i<o.donatorList.size();i++)
				System.out.println("Name:"+o.donatorList.get(i).getName()
						+"\n"+"Phone:"+o.donatorList.get(i).getPhone());*/
			
		}
		
		
		
		
		
		//Kleinw to stream	
		cn.close();
	}			
}		

		
			
		
//Grhgores allages	
/*o.donatorList.contains(d5.getPhone())*/
//Pairnei to thlefwno apo enan donator
//o.donatorList.get(i).getPhone()
