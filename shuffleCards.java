import java.util.Arrays;
import java.util.*;
class shuffleCards{
	public static void main (String[] args){
		String [] cards = {"1K","2K","3K","4K","5K","6K","7K","8K","9K","10K","SoldierK","QueenK","KingK",
			"1D","2D","3D","4D","5D","6D","7D","8D","9D","10D","SoldierD","QueenD","KingD",
			"1P","2P","3P","4P","5P","6P","7P","8P","9P","10P","SoldierP","QueenP","KingP",
			"1G","2G","3G","4G","5G","6G","7G","8G","9G","10G","SoldierG","QueenG","KingG"};
		
		String[] shuffledCards = shuffledCards(cards);
		disturbiutCards (shuffledCards);

		//System.out.println(Arrays.toString(cards));
		

	
	}
	

	public static String[] shuffledCards(String[] cards){
		Collections.shuffle(Arrays.asList(cards));
		return cards;


	}

	public static void disturbiutCards (String[] shuffledCards){
		String[] playerI = new String [21];
		String[] playerII = new String [21];
		String[] inTable = new String [10];
		for(int i=0 ; i<21 ; i++){
                	playerI[i]=shuffledCards[i];
			playerII[i]=shuffledCards[i+20];}
		for(int j=0 ; j<10;j++){
			inTable[j] = shuffledCards[j+42];
		}
		System.out.println(Arrays.toString(playerI));
		System.out.println(Arrays.toString(playerII));
		System.out.println(Arrays.toString(inTable));
		
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
