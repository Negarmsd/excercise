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
		String[] inTable =  returInTable(shuffledCards);
		String[][] cardsInOrder = ordersOfCards();
		String[] playerII = returnPlayerII(shuffledCards);
		String[] playerIIPlayCards = playerIIPlayCards(playerII);
		int a = cardsInOrder.length;

		printCards(showCards , hiddenCards);
		System.out.println("\nplay");
                //Scanner throwCard = new Scanner(System.in);
                //String played = throwCard.next();

		//removeCard ( showCards, played );
		//replaceCard( showCards ,  player , hiddenCards );
		index( cardsInOrder , playerIIPlayCards, inTable[0] , inTable[5]);
		System.out.println(Arrays.toString(playerIIPlayCards));
		//printCards( showCards ,  hiddenCards);
		//System.out.println(a);
		

	
		

	
	}

 

	//finging the index of the bigger or lower card in playerII's cards
	public static int indexBiggerLower (String[] playerIIPlayCards ,String[][] cardsInOrder, int indexInTable ){
		int indexBiggerCard =-1;
		
		if(indexInTable == -1 ) 
				indexInTable = 12;


		if(indexInTable  == 13){
			indexInTable =0;
		}
		if(indexInTable <13 && indexInTable > -1){
			
			for(int i=0 ; i<4 ; i++){
				int index = Arrays.asList(playerIIPlayCards).indexOf(cardsInOrder[indexInTable][i]);
				if(index !=-1){
					indexBiggerCard = index;
				}
		
			//System.out.println(index);
			}
		}
		return indexBiggerCard;
	}
//when we have two cards bigger than table cards we play with cards that we have bigger or smaller of it
	public static boolean twoIndexes( String[] playerIIPlayCards , String[][] cardsInOrder , int indexInTable){
		 int lowerBigger=  indexBiggerLower(playerIIPlayCards , cardsInOrder ,indexInTable);
		 if(lowerBigger != -1){
			 return true ;
		 }else 
			 return false;
	}
                 



//finding and replacing the bigger or lower card in table in playerII's cards
	public static void findBiggerLower(String[] playerIIPlayCards ,String[][] cardsInOrder , int indexInTableI , int indexInTableII){
		int indexBiggerI = -1;
		int indexBiggerII=-1;
		int indexLowerI =-1;
		int indexLowerII= -1;
		int checkI =0;
		int check = 0 ;
		if(indexInTableI != -1){
			indexBiggerI = indexBiggerLower(playerIIPlayCards , cardsInOrder ,(indexInTableI+1) );
			System.out.println("I  " + indexBiggerI);
		}

		if(indexInTableII != -1){
                        indexBiggerII = indexBiggerLower(playerIIPlayCards , cardsInOrder , (indexInTableII+1));
			System.out.println("II " +indexBiggerII);
			
		}
		 //System.out.println(indexBiggerII);

		if(indexBiggerI == -1 && indexBiggerII == -1 ){
			indexLowerI = indexBiggerLower(playerIIPlayCards , cardsInOrder ,(indexInTableI-1));
			indexLowerII = indexBiggerLower(playerIIPlayCards , cardsInOrder ,(indexInTableII-1));




			if(indexLowerI != -1 & indexLowerII != -1){
                        	boolean lowerI = twoIndexes ( playerIIPlayCards , cardsInOrder , indexInTableI-2);
                        	boolean lowerII = twoIndexes ( playerIIPlayCards , cardsInOrder , indexInTableII -2);
				boolean lowI = false;
				boolean lowII = false;

                        	if(lowerI == true || lowerII == true){
                                	lowI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI));
                                	lowII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII));
				}



				if(lowerI== true && lowI ==true){
					playerIIPlayCards[indexLowerI]= null;
					check =1;
				}

				else if(lowerII == true && lowII ==true){
					playerIIPlayCards[indexLowerII] = null;
					check =1;
				}
				else if (lowerI== true || lowI ==true){
                                        playerIIPlayCards[indexLowerI]= null;
					check =1;
                                }
				else if (lowerII == true || lowII ==true){
					playerIIPlayCards[indexLowerII] = null;
					check =1;
                                }

				if( lowerI ==false && lowerII == false ){
					playerIIPlayCards[indexLowerI]= null;
					check =1;
				}
			
			}
			if(check == 0 ){


				if(indexLowerI != -1)
					playerIIPlayCards[indexLowerI]=null;
				else if(indexLowerII != -1)
					playerIIPlayCards[indexLowerII] =null;
			}
			
		}




		if(indexBiggerI != -1 && indexBiggerII != -1){
                        boolean biggerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI +2));
                        boolean biggerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII +2));
			boolean bigI =false;
			boolean bigII =false;
			if(biggerI == true || biggerII == true){
				bigI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));
                        	bigII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));
			}

			if(biggerI == true && bigI ==true){
				playerIIPlayCards[indexBiggerI] = null ;
				checkI = 1;
			}
			else if(biggerII == true && bigII ==true ) {
				playerIIPlayCards[indexBiggerII] = null;
				checkI = 1;
			}
			else if(biggerI == true || bigI ==true){
                                playerIIPlayCards[indexBiggerI] = null ;
                                checkI = 1;
                        }
                        else if(biggerII == true || bigII ==true ) {
                                playerIIPlayCards[indexBiggerII] = null;
                                checkI = 1;
                        }

			else if(biggerI == false && biggerII == false ){
				 playerIIPlayCards[indexBiggerI] = null ;
				 checkI =1;
			}


		}
		if(checkI == 0){
 			if(indexBiggerI!= -1){
				playerIIPlayCards[indexBiggerI] = null;
                                	//System.out.println(indexBiggerI);
                      	 }
			else if (indexBiggerII != -1){
				playerIIPlayCards[indexBiggerII]=null;
			}
		
		}

		if(indexBiggerI != -1 & indexLowerI != -1){
		        boolean lowerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI -2));
                        boolean biggerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI +2));
			boolean low =false ;
			boolean big =false ; 
			//boolean lowerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII -2));
                        //boolean biggerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII +2));

                        if(biggerI != false || lowerI != false ){
                                big = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));
                        //        biggerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));
				low = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));
			//	lowerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));

                        }

                        if(biggerI == true &&  big == true)
                                playerIIPlayCards[indexBiggerI] = null ;
			else if(lowerI == true && low == true)
					playerIIPlayCards[indexLowerI] =null;
                        if (big == false & low == false ){
                                 playerIIPlayCards[indexBiggerI] = null ;
                                 checkI =1;

                        }
			if (biggerI == false & lowerI == false ){
                                 playerIIPlayCards[indexBiggerI] = null ;
                                 checkI =1;

                        }


                }
		 if(indexBiggerI != -1 & indexLowerII != -1){
                        //boolean lowerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI -2));
                        boolean biggerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI +2));
                        boolean lowerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII -2));
                        //boolean biggerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII +2));

                        if(biggerI == false && lowerII == false){
                                biggerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));
                                //biggerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));
                                //lowerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));
                                lowerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));

                        }

                        if(biggerI == true)
                                playerIIPlayCards[indexBiggerI] = null ;
                
                        else if(lowerII == true)
                                playerIIPlayCards[indexLowerII] = null;
                        if (biggerI == false & lowerII == false){
                                 playerIIPlayCards[indexBiggerI] = null ;
                                 checkI =1;
                        }


                }



                        //findBiggerCard( playerIIPlayCards , cardsInOrder , indexInTableI+1 , indexInTableII+1);
		
		//System.out.println(indexBiggerI);
	
		

	}


	


//finding the index of the cards in the Table in cardsInOrder
	public static void index( String[][] cardsInOrder , String[] playerIIPlayCards, String inTableI , String inTableII){
		String[] hold = new String[4];
		int indexInTableI = -1;
                int indexInTableII = -1;
		for(int i =0 ; i<13; i++){
			for(int j=0 ; j<4 ; j++){
				hold[j] = cardsInOrder[i][j];
			}
			indexInTableI = Arrays.asList(hold).indexOf(inTableI);
			if(indexInTableI !=-1)
				indexInTableI=i;
			indexInTableII = Arrays.asList(hold).indexOf(inTableII);
			if(indexInTableII !=-1)
				indexInTableII =i;

			findBiggerLower(playerIIPlayCards , cardsInOrder , indexInTableI , indexInTableII);
			
				//System.out.println(i);
	//			System.out.println(indexInTableI);
	//			System.out.println(indexInTableII);
			
	//			System.out.println(Arrays.toString(hold));
		}
	}
		




	public static String[][] ordersOfCards(){
		String[][] cardsInOrder = { {"AK" ,"AD","AP","AG"},
				            {"2K" ,"2D","2P","2G"},
					    {"3K" ,"3D","3P","3G"},
					    {"4K" ,"4D","4P","4G"},
					    {"5K" ,"5D","5P","5G"} ,
			  		    {"6K" ,"6D","6P","6G"},
				            {"7K" ,"7D","7P","7G"},
					    {"8K" ,"8D","8P","8G"},
					    {"9K" ,"9D","9P","9G"},
					    {"10K" ,"10D","10P","10G"},
					    {"SoldierK","SoldierD","SoldierP","SoldierG"},
					    {"QueenK", "QueenD","QueenP","QueenG"},		  
					    {"KingK" ,"KingD","KingP","KingG"}};
		return cardsInOrder;
	}




	public static String[] playerIIPlayCards(String[] playerII){
		String[] playerIIPlayCards = new String[4];
		for(int i=0 ; i<4 ; i++){
			playerIIPlayCards[i]= playerII[i];
		}
		System.out.println(Arrays.toString(playerIIPlayCards));
		return playerIIPlayCards;
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
		System.out.println("in table :    " + playerITable[0] + "     " +playerIITable[0]);
	}







	
	public static void removeCard (String[] showCards , String played ){
	//	System.out.println("\nplay");
	//	Scanner throwCard = new Scanner(System.in);
	//	String played = throwCard.next();
		int indexRemoveCard = Arrays.asList(showCards).indexOf(played);
		showCards[indexRemoveCard] = null;
			
		
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
		
		for(int i=0 ; i<21 ; i++){
                	playerI[i]=shuffledCards[i];
			playerII[i]=shuffledCards[i+20];}
		
		
		return playerI;
		//System.out.println(Arrays.toString(playerI));
		//System.out.println(Arrays.toString(playerII));
		//System.out.println(Arrays.toString(inTable));
		
	}

	public static String[] returnPlayerII(String[] shuffledCards){
		String[] playerII = new String [21];

                for(int i=0 ; i<21 ; i++){
                         playerII[i]=shuffledCards[i+20];}
		playerIIPlayCards(playerII);
		return playerII;
	}

	public static String[] returInTable( String[] shuffledCards){
		String[] inTable = new String [10];
		for(int j=0 ; j<10;j++){
                        inTable[j] = shuffledCards[j+42];
                
		}
		tableCards(inTable);
		return inTable;
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
