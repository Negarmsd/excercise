import java.util.Scanner;
import java.util.Random;
import java.lang.* ;
import java.util.Arrays;

class blatt02{
	


	public static void main (String[] args){
		//Aufgabe5();
		//Aufgabe6();
		//Aufgabe7();
	  	//Aufgabe8();
		
		//Aufgabe9(args);
		boolean println , true ;
		 char ab c, de , f^g;
		 int a = 0xf7 , b = 0xg7 , c = 12e3 , d = 017 , 2e;
		 double s_ , t$u , v_$w ;
		 System . out . println ("a: " , a);
		
	}

	public static void Aufgabe9(String[] args){
		int zahl = Integer.parseInt(args[0]);
		System.out.println(zahl);
		int count=0;
		int random=0;
		while(true){
			
			random =(int) (Math.random()*100);
			if(zahl==random){
				break;
			}else count++;
		}
		System.out.printf("trys %d ,and the number was %d \n" , count , zahl);

	}

	public static void Aufgabe8(){


		Scanner input = new Scanner (System.in);
		while(true){
			 System.out.println("enter the word \n ");

			 String word = input.next();
			 System.out.println("enter '1' for continue '0' for exit");
			 int exit = input.nextInt();
			 switch(exit){

				 case 0:
					 break;
				 case 1:{

						switch(word){
							case "hoch":
								System.out.printf("%s <--> tief \n" , word);
								break;
							case "klein":
								System.out.printf("%s <--> gross\n" , word);
								break;
							case "stark":
								System.out.printf("%s <--> schwach \n" , word);
								break;
							case"null":
								break;
							default:
								System.out.println("try again");
							}
						break;
				 }
				
				default:
					System.out.println("please enter a valid number");

			 }
			 if(exit == 0)
				 break;
		}
		
	}










	public static void Aufgabe7(){
		 Scanner input = new Scanner(System.in);
                while(true){
                        System.out.println("enter numbers ");
                        int num1 = input.nextInt();
                        int num2 = input.nextInt();
                        System.out.println("for * enter '1' for / enter '2' for + enter '3' for - enter '4' \n '0' for exit");
                        int operator = input.nextInt();
			switch(operator){
				case 1:
				 	System.out.printf(" %d * %d = %d \n", num1 , num2 , num1 * num2 );
				 	break;

				case 2:{
					        System.out.printf(" %d / %d = %d \n", num1 , num2 , num1 / num2 );
						break;
				}
				case 3:{
					       System.out.printf("sum %d + %d = %d \n", num1 , num2 , num1 + num2 );
					       break;
				}
				case 4:{
					       System.out.printf(" %d - %d = %d \n", num1 , num2 , num1 - num2 );
					       break;
				}
				case 0:{
					       break;
				}
				default:{
						System.out.println("your number is not valid \n please try again");
				}
			}
			if(operator == 0 )
				break;

		}
	}







	public static void Aufgabe6 (){

		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("enter numbers ");
			int num1 = input.nextInt();
			int num2 = input.nextInt();
			System.out.println("for * enter '1' for / enter '2' for + enter '3' for - enter '4' \n '0' for exit");
			int operator = input.nextInt();
			if(operator == 1)
				 System.out.printf(" %d * %d = %d \n", num1 , num2 , num1 * num2 );
			
			if(operator ==2)
				 System.out.printf(" %d / %d = %d \n", num1 , num2 , num1 / num2 );
			if(operator == 3)
				 System.out.printf("sum %d + %d = %d \n", num1 , num2 , num1 + num2 );
			if(operator == 4)
				 System.out.printf(" %d - %d = %d \n", num1 , num2 , num1 - num2 );
			if(operator==0 )
				break;
		}
	
	}

		public static void Aufgabe5(){
		 Scanner sc =new Scanner(System.in);
                System.out.println("please enter the number");
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                System.out.printf("sum %d + %d = %d \n", num1 , num2 , num1 + num2 );
		}

}	
