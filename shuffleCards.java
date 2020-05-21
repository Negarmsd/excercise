import java.util.Arrays;
import java.util.*;
import java.lang.Object;
class shuffleCards{
	public static void main (String[] args){
		String [] cards = {"1K","2K","3K","4K","5K","6K","7K","8K","9K","10K","SoldierK","QueenK","KingK",
			"1D","2D","3D","4D","5D","6D","7D","8D","9D","10D","SoldierD","QueenD","KingD",
			"1P","2P","3P","4P","5P","6P","7P","8P","9P","10P","SoldierP","QueenP","KingP",
			"1G","2G","3G","4G","5G","6G","7G","8G","9G","10G","SoldierG","QueenG","KingG"};
		
		String[] shuffledCards = shuffledCards(cards);
		String[] player= disturbiutCards (shuffledCards);
		String[] showCards = showPlayerCards(player);
		int[] hiddenCards = hiddenCards();
		printCards(showCards , hiddenCards);

		playCard ( showCards, player , hiddenCards);
		replaceCard( showCards ,  player , hiddenCards );	
		//printCards( showCards ,  hiddenCards);
		//System.out.println(Arrays.toString(cards));
		

	
	

	}
	public static void tableCards(String[] inTable){
		String[] playerITable = new String[5];
		String[] playerIITable = new String[5];
		for(int i=0 ; i<5 ; i++){
			playerITable[i] = inTable[i];
			playerIITable[i]= inTable[i+5];
		}
		printInTable(playerITable , playerIITable);
	}


	public static void printInTable(String[] playerITable , String[] playerIITable){
		System.out.println("in table : " + playerITable[0] + "  " +playerIITable[0]);
	}








	public static void playCard (String[] showCards , String[] player , int[] hiddenCards){
		System.out.println("\nplay");
		Scanner throwCard = new Scanner(System.in);
		String played = throwCard.next();
		int indexRemoveCard = Arrays.asList(showCards).indexOf(played);
		showCards[indexRemoveCard] = null;
			
		
			//replaceCard( showCards , player , hiddenCards );
		
		
	}



	public static void replaceCard( String[] showCards , String[] player , int[] hiddenCards ){
		Scanner input = new Scanner(System.in);
		System.out.println("newCard");
		int indexNewCard = input.nextInt();
		int indexRemovedCard = Arrays.asList(showCards).indexOf(null);
		showCards[indexRemovedCard] = player[indexNewCard-1];
		hiddenCards[indexNewCard-5] = 0;
		printCards(showCards , hiddenCards);
		
	}

	public static void printCards(String[] showCards , int[] hiddenCards){
		for (int i=0 ; i<4 ; i++){
                        
                        System.out.print(" " + showCards[i]+" " );

                }
                for(int j=0 ;j <17; j++){
                        System.out.print(" " + hiddenCards[j] + " " );

                }
	}



	public static String[] showPlayerCards( String[] player){
		
		String[] showCards = new String[4];
		for (int i=0 ; i<4 ; i++){
			showCards[i]= player[i];
		}
		return showCards;

	} 	

	public static int[] hiddenCards(){
		int [] hiddenCards = new int [17];
		for(int j=5 ;j <22; j++){
			hiddenCards[j-5] = j;
			//System.out.print(" " + hiddenCards[j-5] + " " );
		}
		return hiddenCards;
	}
	

	public static String[] shuffledCards(String[] cards){
		Collections.shuffle(Arrays.asList(cards));
		return cards;


	}

	public static String[] disturbiutCards (String[] shuffledCards){
		String[] playerI = new String [21];
		String[] playerII = new String [21];
		String[] inTable = new String [10];
		for(int i=0 ; i<21 ; i++){
                	playerI[i]=shuffledCards[i];
			playerII[i]=shuffledCards[i+20];}
		for(int j=0 ; j<10;j++){
			inTable[j] = shuffledCards[j+42];
		}
		//showPlayerCards(playerI);
		tableCards(inTable);
		return playerI;



		//System.out.println(Arrays.toString(playerI));
		//System.out.println(Arrays.toString(playerII));
		//System.out.println(Arrays.toString(inTable));
		
	}





//failed

	public static String[] card(){
		String [] kpdg = {"K" , "P" , "D" , "G"};
		String [] king = { "King" , "Queen" , "Solder"};
		String [] cards = new String[52];
		for(int i=1 ; i <5 ;i++){

			for(int j=1 ; j<14 ; j++){

				cards[(j-1)*i]= kpdg[i-1] + j;
					//System.out.printf("(j =%d )", j);
				
				
			}
		}
		return cards;
	}
}
