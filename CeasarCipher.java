import java.util.Arrays; 
class CeasarCipher{
	 public static void main (String[] args ){
		 String theSentence = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
		 CeasarSentence(theSentence);

	 }







	 public static void CeasarSentence (String sentence){
		 int lengthOfSentence = sentence.length();
		 //String [] words= sentence.split(" ");
		 //
		 
		 //int lengthOfWords = words.length;
		 char [] words= sentence.toCharArray();
		 int lengthofwords= words.length;
		 //System.out.print(words);
		 char [] ceasarwords =new char [lengthofwords];
		 int[]CeasarCode = new int [lengthofwords];
		 //char [] word =new char [lengthOfWords];
		
		 for (int i=0;i<lengthofwords;i++){
		
			 CeasarCode[i]=words[i]+5;
			 //System.out.printf("%d",CeasarCode[i]);
			 words[i]=(char)CeasarCode[i];
			 System.out.print(words[i]);

		 }

	 }
						
		 
 }
