import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;
import java.lang.Object;
import java.util.Random;
import java.awt.Point;
class shuffleCards{
	public static void main (String[] args){
		String [] cards = {"AK","2K","3K","4K","5K","6K","7K","8K","9K","10K","SoldierK","QueenK","KingK",
			"AD","2D","3D","4D","5D","6D","7D","8D","9D","10D","SoldierD","QueenD","KingD",
			"AP","2P","3P","4P","5P","6P","7P","8P","9P","10P","SoldierP","QueenP","KingP",
			"AG","2G","3G","4G","5G","6G","7G","8G","9G","10G","SoldierG","QueenG","KingG"};
		
		String[] shuffledCards = shuffledCards(cards);
		String[] player= disturbiutCards (shuffledCards);
		String[] showCards = showPlayerCards(player);
		int[] hiddenCards = hiddenCards();
		String[] inTable =  returInTable(shuffledCards);
		Point isPass = new Point();
		isPass.x=0;
		isPass.y=0;
		List <String> table = new ArrayList<>();
                table.add(inTable[0]);
                table.add(inTable[1]);
                table.add(inTable[2]);
                table.add(inTable[3]);
                table.add(inTable[4]);
                table.add(inTable[5]);
                table.add(inTable[6]);
                table.add(inTable[7]);
                table.add(inTable[8]);
                table.add(inTable[9]);
		String[][] cardsInOrder = ordersOfCards();
		String[] playerII = returnPlayerII(shuffledCards);
		String[] playerIIPlayCards = playerIIPlayCards(playerII);
		int a = cardsInOrder.length;
		printCards(showCards , hiddenCards);
		printInTable(inTable[0] ,inTable[5]);
		System.out.println(Arrays.toString(inTable));
		while(true){
			 
			System.out.println("\nplay");
                	Scanner throwCard = new Scanner(System.in);
        	        String played = throwCard.next();
			if (played.equals("exit"))
				break;
			if( check (showCards , cardsInOrder, played, inTable[0], inTable[5], inTable, isPass, table)){			
				removeCard ( showCards, played );
				replaceCard( showCards ,  player , hiddenCards );
			}
			System.out.println("\n playerII");

			index( cardsInOrder , playerIIPlayCards, inTable[0] , inTable[5], playerII, inTable , played, isPass, table);
			

			//System.out.println(Arrays.toString(playerIIPlayCards));
			if(isEnd(playerII))
				break;
			if(isEnd(player))
				break;
		}
		

		//printCards( showCards ,  hiddenCards);
		//System.out.println(a);
	
	}

	public static void isIpass(boolean pass, Point isPass){
		if(pass){
			isPass.x=1;
		}else isPass.x=0;
	}
	public static void isIIpass(boolean pass, Point isPass){
                if(pass){
                        isPass.y=1;
                }else isPass.y=0;
        }
	public static boolean pass(Point isPass){
		if(isPass.x == 1 && isPass.y == 1){
			return true ;
		}else return false;
	}

		

	
//this method replaces the cards in the table 
	public static void replaceInTable( String[] inTable, String played , boolean isI, boolean isII, Point isPass,List<String> table){
		System.out.println("\n ***" + isPass);		
		if(!played.equals("pass")){
			table.add(played);
			if(isI || isII){
				if(isI){
					inTable[0] = played;
				}else if(isII) {
					inTable[5] = played;
				}
				printInTable( inTable[0] , inTable[5]);
			}
		
			if(inTable[6] == null){
				Collections.shuffle(table);
				inTable[0] = table.get(0);
				table.remove(0);
				inTable[5] = table.get(0);
				table.remove(0);
				printInTable( inTable[0] , inTable[5]);
			}
		}

		if(pass(isPass)){
			for(int i = 1; i<inTable.length; i++){
				inTable[i-1] = inTable[i];
			}
			inTable [9] = null;
			isIpass(false, isPass);
			isIIpass(false, isPass);
			printInTable( inTable[0] , inTable[5]);
		}
	}		
		
// this method checks whether the played card is allowd.
	public static boolean check (String[] showCards ,String[][] cardsInOrder, String played, String inTableI, String inTableII, String[] inTable, Point isPass, List<String> table){
		String[] hold = new String[4];
                int indexInTableI = -1;
                int indexInTableII = -1;
		int indexPlayed =-1;
		int indexI =-1;
		int indexII =-1;
		int indexPlay = -1;
		boolean check = false;
                for(int i =0 ; i<13; i++){
                        for(int j=0 ; j<4 ; j++){
                                hold[j] = cardsInOrder[i][j];
                        }
                        indexInTableI = Arrays.asList(hold).indexOf(inTableI);
                        if(indexInTableI !=-1)
                                indexI=i;
                        indexInTableII = Arrays.asList(hold).indexOf(inTableII);
                        if(indexInTableII !=-1)
                                indexII =i;
		}
		System.out.println(indexInTableI + " " + indexInTableII);
			for(int i =0 ; i<13; i++){
        	                for(int j=0 ; j<4 ; j++){
   	                             hold[j] = cardsInOrder[i][j];
        	                }
  	                     	indexPlayed = Arrays.asList(hold).indexOf(played);
        	                if(indexPlayed !=-1) 
					indexPlay = i;
				//Sysitem.out.println("p"+indexPlayed);
			}
		 //System.out.println("p"+indexPlayed);
		 if( played.equals("pass")){
                        isIpass(true,isPass);
                        replaceInTable(inTable, played, false, false, isPass, table);
                        check = false;
			return check;
                }
		if(indexPlay == 0 && indexI == 12) {
			isIpass(false, isPass);
			replaceInTable(inTable, played, true,false, isPass, table);
                        check = true;
                        return check;
		}
		if(indexPlay == 0 && indexII == 12){
			isIpass(false ,isPass);
                         replaceInTable(inTable, played,false, true, isPass, table);
                         check = true;
                         return check;
		}
		if(indexPlay == 12 && indexI == 0) {
                        isIpass(false, isPass);
                        replaceInTable(inTable, played, true,false, isPass, table);
                        check = true;
                        return check;
                }
                if(indexPlay == 12 && indexII ==0){
                        isIpass(false ,isPass);
                         replaceInTable(inTable, played,false, true, isPass, table);
                         check = true;
                         return check;
                }
		if (indexPlay == (indexI+1)){
			isIpass(false, isPass);
			replaceInTable(inTable, played, true,false, isPass, table);
			check = true;
			return check;
		}
		else if(indexPlay == (indexII + 1)){
			 isIpass(false ,isPass);
			 replaceInTable(inTable, played,false, true, isPass, table);
			 check = true;
			 return check;
		}
		else if ((indexPlay == indexI - 1)){
			isIpass(false ,isPass);
       		        replaceInTable(inTable, played, true,false, isPass, table);
			check = true;
			return check;
		}
		else if((indexPlay == indexII - 1)){
			isIpass(false ,isPass);
			replaceInTable(inTable, played,false, true, isPass, table);
			 check = true;
			 return check;
		}
		 if( played.equals("pass")){
			isIpass(true,isPass);
			replaceInTable(inTable, played, false, false, isPass, table);
			
			check = false;
		} 

		return check;
	}


	public static boolean isEnd(String[] player){
		boolean isEnd =false;
		for (int i=0; i<player.length ; i++){
			if(player[i] != null){ 
				isEnd=false;
				break;
			} else {
				isEnd=true;
			}
		}
		return isEnd;
	}

	//finding a random card to replace the card that we allready played with.

	 public static void replaceCardPlayerII( String[] playerIIPlayCards, String[] playerII){
		int indexRemovedCard = Arrays.asList(playerIIPlayCards).indexOf(null);
		if(indexRemovedCard != -1){
			int random =checkRandom();
			if(random != -1){
				if(playerII[random] != null){
                			playerIIPlayCards[indexRemovedCard] = playerII[random];
					playerII[random]=null;
				}else  replaceCardPlayerII(playerIIPlayCards, playerII);
			System.out.println(Arrays.toString(playerIIPlayCards)+"   random   " + random);
		//	System.out.print(Arrays.toString(playerIIPlayCards));
		
			}
		}
        }
	public static int checkRandom(){

		List<Integer> count = new ArrayList<Integer>();
		count.add(4);
		count.add(5);
		count.add(6);
		count.add(7);
		count.add(8);
		count.add(9);
		count.add(10);
		count.add(11);
		count.add(12);
		count.add(13);
		count.add(14);
		count.add(15);
		count.add(16);
		count.add(17);
		count.add(18);
		count.add(19);
		count.add(20);
		Collections.shuffle(count);			
		int num =0;
		if(count.size() != 0)
		{	num = count.get(0);
			count.remove(0);
		} else num = -1;

		return num;
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
                 



//finding and replacing the bigger or lower card in table in playerII's cards missing conditions a>card and b<card you shuld fix it later.
	public static void findBiggerLower(String[] playerIIPlayCards ,String[][] cardsInOrder , int indexInTableI , int indexInTableII, String[] playerII, String[] inTable, Point isPass,List<String> table){
		int indexBiggerI = -1;
		int indexBiggerII=-1;
		int indexLowerI =-1;
		int indexLowerII= -1;
		//System.out.print("*********************************" + indexInTableI);
		if(indexInTableI != -1){
			indexBiggerI = indexBiggerLower(playerIIPlayCards , cardsInOrder ,(indexInTableI+1) );
			indexLowerI = indexBiggerLower(playerIIPlayCards , cardsInOrder ,(indexInTableI-1));
			System.out.println("I  " + indexBiggerI);
		}

		if(indexInTableII != -1){
                        indexBiggerII = indexBiggerLower(playerIIPlayCards , cardsInOrder , (indexInTableII+1));
			indexLowerII = indexBiggerLower(playerIIPlayCards , cardsInOrder ,(indexInTableII-1));
			System.out.println("II " +indexBiggerII);
			
		}
		 //System.out.println(indexBiggerII);

		if(indexBiggerI == -1 && indexBiggerII == -1 ){
			isIIpass(false, isPass);
			System.out.println("I" +indexLowerII + "I" + indexLowerI );
			if(indexLowerI != -1 ^ indexLowerII != -1){
				isIIpass(false, isPass);
				if(indexLowerII != -1){
					replaceInTable(inTable, playerIIPlayCards[indexLowerII] , false, true, isPass, table);
                                 	playerIIPlayCards[indexLowerII] = null;
                                        replaceCardPlayerII( playerIIPlayCards, playerII);
				}
				if(indexLowerI != -1){
					 replaceInTable(inTable, playerIIPlayCards[indexLowerI] , true, false , isPass, table);
                                         playerIIPlayCards[indexLowerI]= null;
                                         replaceCardPlayerII( playerIIPlayCards, playerII);
				}
			}

			if(indexLowerI != -1 && indexLowerII != -1){
				isIIpass(false, isPass);
                        	boolean lowerI = twoIndexes ( playerIIPlayCards , cardsInOrder , indexInTableI-2);
                        	boolean lowerII = twoIndexes ( playerIIPlayCards , cardsInOrder , indexInTableII -2);
				

                        	if(lowerI == true || lowerII == true){
                                	boolean lowI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI));
                                	boolean lowII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII));
				



					if(lowerI== true && lowI ==true){
					
						replaceInTable(inTable, playerIIPlayCards[indexLowerI] , true, false , isPass, table);
						playerIIPlayCards[indexLowerI]= null;
						replaceCardPlayerII( playerIIPlayCards, playerII);
					}

					else if(lowerII == true && lowII ==true){
						replaceInTable(inTable, playerIIPlayCards[indexLowerII] , false, true , isPass, table);
						playerIIPlayCards[indexLowerII] = null;
						 replaceCardPlayerII( playerIIPlayCards, playerII);
					}
					else if (lowerI== true || lowI ==true){
						replaceInTable(inTable, playerIIPlayCards[indexLowerI] , true, false , isPass, table);
                                        	playerIIPlayCards[indexLowerI]= null;
						replaceCardPlayerII( playerIIPlayCards, playerII);
					}
					else if (lowerII == true || lowII ==true){
						replaceInTable(inTable, playerIIPlayCards[indexLowerII] , false, true , isPass, table);
						playerIIPlayCards[indexLowerII] = null;
						replaceCardPlayerII( playerIIPlayCards, playerII);
					}
				} else {
					replaceInTable(inTable, playerIIPlayCards[indexLowerI] , true, false , isPass, table);
					playerIIPlayCards[indexLowerI]=null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
				}
				isIIpass(false, isPass);
			}

			if(indexLowerI == -1 && indexLowerII == -1){
				isIIpass(true, isPass);
				replaceInTable(inTable, "pass" ,false, false , isPass, table);
			}

			
		}

		if(indexBiggerI != -1 ^ indexBiggerII != -1){
			isIIpass(false, isPass);
			if(indexBiggerI != -1 ){
				replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
                                playerIIPlayCards[indexBiggerI] = null ;
                                replaceCardPlayerII( playerIIPlayCards, playerII);
			}else if( indexBiggerII != -1){
				 replaceInTable(inTable,  playerIIPlayCards[indexBiggerII], false , true, isPass, table);
                                 playerIIPlayCards[indexBiggerII] = null;
                                 replaceCardPlayerII( playerIIPlayCards, playerII);
			}
			isIIpass(false, isPass);
		}
		

		
		if(indexBiggerI != -1 && indexBiggerII != -1){
			 isIIpass(false, isPass);
                        boolean biggerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI +2));
                        boolean biggerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII +2));
			if(biggerI == true || biggerII == true){
				boolean bigI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));
                        	boolean bigII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));
			
	
				if(biggerI == true && bigI ==true){
					replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
					playerIIPlayCards[indexBiggerI] = null ;
					replaceCardPlayerII( playerIIPlayCards, playerII);

				}	
				else if(biggerII == true && bigII ==true ) {
					replaceInTable(inTable,  playerIIPlayCards[indexBiggerII], false , true, isPass, table);
					playerIIPlayCards[indexBiggerII] = null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
					
				}
				else if(biggerI == true || bigI ==true){
					replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
                                	playerIIPlayCards[indexBiggerI] = null ;
					replaceCardPlayerII( playerIIPlayCards, playerII);
                               		
	                        }
        	                else if(biggerII == true || bigII ==true ) {
					replaceInTable(inTable,  playerIIPlayCards[indexBiggerII] ,false, true, isPass, table);
                        	        playerIIPlayCards[indexBiggerII] = null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
        	                        
                	        }

			}else{
				replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
				playerIIPlayCards[indexBiggerI] = null;
				 replaceCardPlayerII( playerIIPlayCards, playerII);
                                	//System.out.println(indexBiggerI);
                      	}
			isIIpass(false, isPass);
			
		}

		if(indexBiggerI != -1 & indexLowerI != -1){
			isIIpass(false, isPass);
		        boolean lowerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI -2));
                        boolean biggerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI +2));
			

                        if(biggerI ==true || lowerI ==true ){
                                boolean big = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));
                        	boolean low = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));

	
        	                if(biggerI == true &&  big == true){
					replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
                        	        playerIIPlayCards[indexBiggerI] = null ;
					 replaceCardPlayerII( playerIIPlayCards, playerII);
				}
				else if(lowerI == true && low == true){
					replaceInTable(inTable,  playerIIPlayCards[indexLowerI]  , true, false, isPass, table);
					playerIIPlayCards[indexLowerI] =null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
				}
                        	if (big == true || biggerI == true ){
					replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
	                                playerIIPlayCards[indexBiggerI] = null ;
					replaceCardPlayerII( playerIIPlayCards, playerII);
                	                
                        	}
				if (lowerI == true || low ==true ){
					replaceInTable(inTable,  playerIIPlayCards[indexLowerI]  , true, false, isPass, table);
                        	        playerIIPlayCards[indexLowerI] = null ;
					replaceCardPlayerII( playerIIPlayCards, playerII);
				}
			}else {
				 replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
                                 playerIIPlayCards[indexBiggerI] = null ;
                                replaceCardPlayerII( playerIIPlayCards, playerII);
			}
			isIIpass(false, isPass);
		}

		 if(indexBiggerI != -1 & indexLowerII != -1){
			  isIIpass(false, isPass);
                        boolean biggerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI +2));
                        boolean lowerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII -2));
                        
                        if(biggerI == true || lowerII == true){
                                boolean big = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));
                                boolean low = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));

                        

   	                     if(biggerI == true && big == true){
					replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
                	                playerIIPlayCards[indexBiggerI] = null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
				}
        	                else if(lowerII == true && low == true){
					replaceInTable(inTable,  playerIIPlayCards[indexLowerII], false, true, isPass, table);
                        	        playerIIPlayCards[indexLowerII] = null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
				}
        	                if (biggerI == true || big == true){
					replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
                        	        playerIIPlayCards[indexBiggerI] = null ;
					replaceCardPlayerII( playerIIPlayCards, playerII);
				
				}
				if( lowerII == true || low == true){
					replaceInTable(inTable,  playerIIPlayCards[indexLowerII], false, true, isPass, table);
                        	        playerIIPlayCards[indexLowerII] = null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
	                        }
			}else {
				replaceInTable(inTable,  playerIIPlayCards[indexBiggerI]  , true, false, isPass, table);
                                playerIIPlayCards[indexBiggerI] = null;
                              	replaceCardPlayerII( playerIIPlayCards, playerII);
			}
			isIIpass(false, isPass);
                }

		if(indexBiggerII != -1 & indexLowerII != -1){
                         isIIpass(false, isPass);
                        boolean biggerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII +2));
                        boolean lowerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII -2));
                        

                        if(biggerII == true || lowerII == true){
                                boolean big = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));
				boolean low = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));	
	                        if(biggerII == true && big == true){	
        	                        replaceInTable(inTable,  playerIIPlayCards[indexBiggerII]  , false,true, isPass, table);
                        	        playerIIPlayCards[indexBiggerII] = null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
	                        }
        	                else if(lowerII == true && low == true ){
                	                replaceInTable(inTable,  playerIIPlayCards[indexLowerII], false, true, isPass, table);
                        	        playerIIPlayCards[indexLowerII] = null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
	                        }else if (low ==true || lowerII == true){
					replaceInTable(inTable,  playerIIPlayCards[indexLowerII], false, true, isPass, table);
                        	        playerIIPlayCards[indexLowerII] = null;
					replaceCardPlayerII( playerIIPlayCards, playerII);
				}else if (big ==true || biggerII == true){
                               		replaceInTable(inTable,  playerIIPlayCards[indexBiggerII], false, true, isPass, table);
                	                playerIIPlayCards[indexBiggerI] = null ;
                        	        replaceCardPlayerII( playerIIPlayCards, playerII);
				}
			} else{
				 replaceInTable(inTable,  playerIIPlayCards[indexBiggerII]  , false,true, isPass, table);
                                 playerIIPlayCards[indexBiggerII] = null;
                                 replaceCardPlayerII( playerIIPlayCards, playerII);
			}
			isIIpass(false, isPass);

                }

		if(indexBiggerII != -1 & indexLowerI != -1){
			 isIIpass(false, isPass);
                        boolean lowerI = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI -2));
                        boolean biggerII = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII +2));
                        
                        if(biggerII == true || lowerI == true ){
                                boolean big = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableII ));
                                boolean low = twoIndexes ( playerIIPlayCards , cardsInOrder , (indexInTableI ));
	                        if(biggerII == true &&  big == true){
        	                       	replaceInTable(inTable,  playerIIPlayCards[indexBiggerII] ,false,  true, isPass, table);
                	                playerIIPlayCards[indexBiggerII] = null ;
					replaceCardPlayerII( playerIIPlayCards, playerII);
				}
				else if(lowerI == true && low == true){
					replaceInTable(inTable,  playerIIPlayCards[indexLowerI]  , true, false, isPass, table);
					playerIIPlayCards[indexLowerI] =null;
                                	replaceCardPlayerII( playerIIPlayCards, playerII);
				}
        	                if (biggerII == true || big == true  ){
                	                replaceInTable(inTable,  playerIIPlayCards[indexBiggerII] ,false , true, isPass, table);
					playerIIPlayCards[indexBiggerII] = null ;
                                	replaceCardPlayerII( playerIIPlayCards, playerII);
				}
	                        if (low == true || lowerI == true ){
					replaceInTable(inTable,  playerIIPlayCards[indexLowerII], true, false, isPass, table);
                	                playerIIPlayCards[indexLowerII] = null ;
					replaceCardPlayerII( playerIIPlayCards, playerII);
				}
			}else {

				replaceInTable(inTable,  playerIIPlayCards[indexBiggerII] ,false,  true, isPass, table);
                                playerIIPlayCards[indexBiggerII] = null ;
				replaceCardPlayerII( playerIIPlayCards, playerII);
			}
			isIIpass(false, isPass);

                }


		if((indexBiggerI == -1 && indexLowerII == -1) && (indexLowerI == -1 && indexLowerII == -1)){
			isIIpass(true, isPass);
			replaceInTable(inTable, "pass" ,false, false, isPass, table);
		}
	
		

	}


	


//finding the index of the cards in the Table in cardsInOrder
	public static void index( String[][] cardsInOrder , String[] playerIIPlayCards, String inTableI , String inTableII, String[] playerII,String[] inTable , String played,Point isPass,List<String> table){
		String[] hold = new String[4];
		int indexInTableI = -1;
                int indexInTableII = -1;
		int indexI = -1;
		int indexII = -1;
		for(int i =0 ; i<13; i++){
			for(int j=0 ; j<4 ; j++){
				hold[j] = cardsInOrder[i][j];
			}
			indexInTableI = Arrays.asList(hold).indexOf(inTableI);
			if(indexInTableI !=-1){
				indexI=i;
				//findBiggerLower(playerIIPlayCards , cardsInOrder , indexInTableI , indexInTableII, playerII ,inTable );
				
			}

			indexInTableII = Arrays.asList(hold).indexOf(inTableII);
			if(indexInTableII !=-1){
				indexII = i;
				//findBiggerLower(playerIIPlayCards , cardsInOrder , indexInTableI , indexInTableII, playerII ,inTable );
			}
		}	
		findBiggerLower(playerIIPlayCards , cardsInOrder , indexI , indexII, playerII ,inTable, isPass, table );
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


	public static void printInTable(String playerITable , String playerIITable){
		System.out.println("\nin table :    " + playerITable + "     " +playerIITable);
	}







	
	public static void removeCard (String[] showCards , String played ){
	//	System.out.println("\nplay");
	//	Scanner throwCard = new Scanner(System.in);
	//	String played = throwCard.next();
		int indexRemoveCard = Arrays.asList(showCards).indexOf(played);
		showCards[indexRemoveCard] = null;
			
		
	}



	public static void replaceCard( String[] showCards , String[] player , int[] hiddenCards ){
		if(!checkHiddenCrds(hiddenCards)){
			Scanner input = new Scanner(System.in);
			System.out.println("newCard");
			int indexNewCard = input.nextInt();
			if(indexNewCard < 5 || indexNewCard > 21) replaceCard(showCards, player, hiddenCards);
			if(hiddenCards[indexNewCard-5] == 0){
				System.out.println("you already played with this card");
				replaceCard(showCards, player, hiddenCards );
			}else{
				int indexRemovedCard = Arrays.asList(showCards).indexOf(null);
				showCards[indexRemovedCard] = player[indexNewCard-1];
				hiddenCards[indexNewCard-5] = 0;
				player[indexNewCard-1] = null;
				System.out.println(Arrays.toString(player));
				printCards(showCards , hiddenCards);
			}
		}
	
	}
	// check if the hiddenCards are all played
	public static boolean checkHiddenCrds(int[] hiddenCards) {
		boolean allPlayed = false;
		int count = 0;
		for(int i = 0; i < hiddenCards.length; i++) {
			if(hiddenCards[i] == 0) count++;
		}
		if (count == 17)
			allPlayed =true;
		else allPlayed = false;
		return allPlayed;
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
