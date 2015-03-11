import javax.swing.JOptionPane;
public class MenuDrivenProject
{
  public static void main(String [] args) //Main Method
  {
   int choice;
   String menuChoice = "";
   while ((menuChoice != null) && (!(menuChoice.equals("0")))) //Allowing the user to quit the program
   {
    menuChoice = getMenuOption(); //Calling the method to give the user the menu of options
    if (menuChoice != null)
    {
     choice = Integer.parseInt(menuChoice);
     if (choice != 0)
     {
      switch(choice) //Deciding which method to start
      {
      case 1: analyzeVowelContent(); break;
      case 2: analyzeConstonantContent(); break;
      case 3: Method3(); break;
      case 4: Anagram(); break;
      case 5: Palindrome(); break;
      case 6: longAndShort(); break;
      }
     }
    }
   }
  }
  
  
  
  public static String getMenuOption() //choosing which method the user wants
  {
  String menuOptions = "1. Analyze vowel content of word/phrase." + //Menu the user sees
    "\n2. Analyze consonant content of word/phrase." +
    "\n3. Analyze the content of a word or phrase." +
    "\n4. Determine if two phrases are anagrams of each other." +
    "\n5. Determine if a word/phrase/sentence is a palindrome." +
    "\n6. Analyze a word/phrases longest and shortest word." +
    "\n0. Exit.";
  boolean validInput = false;
  String selection = "", menuPattern = "[0-6]{1}"; //Making sure that the input is valid
  String errorMessage = "Invalid menu selection.\n\nValid options are 0 to 6 inclusive.\nSelect OK to retry."; //Error Message if the input is invalid
  while (!(validInput))
  {
   selection = JOptionPane.showInputDialog(null,menuOptions, "Choose number of option you wish to have executed",3); //User chooses which option they want
   if (selection == null || selection.matches(menuPattern))
   validInput = true;
   else
    JOptionPane.showMessageDialog(null, errorMessage, "Error in user input",2); //Displaying an error message if user input is invalid
   }
  return selection;
  }
  
  
  
  public static String userInput(String message,String title) //Getting a word/phrase from the user
  {
  boolean Input = false;
  String userInput = "";
  String error = "Invalid input. \nYou must enter an input that is not only numbers.";
  while (!(Input))
  {
  userInput = JOptionPane.showInputDialog(null, message, title, 3);
  if (userInput == null || !(userInput.equals(""))) //checking that the user entered something
  {
  Input = true;
  if (userInput != null)
  {
  if (userInput.contains("0") || userInput.contains("1") ||userInput.contains("2") ||userInput.contains("3") ||userInput.contains("4") ||userInput.contains("5") ||userInput.contains("6") ||userInput.contains("7") ||userInput.contains("8") ||userInput.contains("9"))
  JOptionPane.showMessageDialog(null,"Please do not enter numbers");
  else{
  userInput = userInput.replaceAll("\\s+"," "); //Getting rid of extra spaces
  userInput = userInput.trim();
  }
  }
  }
  else
  JOptionPane.showMessageDialog(null, error, "Error in User Input",2);
  }
  return userInput;
  }
 
 
 
 public static void analyzeVowelContent() //Analyzing a word/phrase based on its vowel content
  {
  String input = userInput("Enter a word/phrase to analyze its vowels content","Vowels Content");
  
  if (input == null)
  return; //exiting back to the main menu if the user pressed cancel
  else
  {
  input = input.toLowerCase();
  int a = 0,e=0,i=0,o=0,u=0;
  for(int counter = 0;counter<input.length();counter++) //Counting the amount of times each vowel is in the word/phrase
  {
  if(input.charAt(counter)=='a')
  a++;
  if(input.charAt(counter)=='e')
  e++;
  if(input.charAt(counter)=='i')
  i++;
  if(input.charAt(counter)=='o')
  o++;
  if(input.charAt(counter)=='u')
  u++;
  }
  int a2,e2,i2,o2,u2; //checking the order of the vowels by finding their position in the word/phrase
  a2 = input.indexOf('a');
  e2 = input.indexOf('e');
  i2 = input.indexOf('i');
  o2 = input.indexOf('o');
  u2 = input.indexOf('u');
  boolean noVowels = false,anyOrder = false,alphabetical = false, reverse = false;
  if((a==0)&&(e==0)&&(i==0)&&(o==0)&&(u==0)) //checking if there are vowels
  noVowels = true;
  if((a!=0)&&(e!=0)&&(i!=0)&&(o!=0)&&(u!=0)) //checking if every vowel is used
  {
  anyOrder = true;
  if((a2<e2)&&(e2<i2)&&(i2<o2)&&(o2<u2)) //checking if every vowel is used in alphabetical order
  alphabetical = true;
  if((a2>e2)&&(e2>i2)&&(i2>o2)&&(o2>u2)) //checking if every vowel is used in reverse order
  reverse = true;
  }
  String results = ""; //displaying the information found
  if (noVowels)
  results += input + " contains no vowels.\n";
  else results += input + " contains vowels.\n";
  if (anyOrder)
  results += input + " contains all of the vowels in any order.\n";
  else results += input + " doesn't contain all of the vowels in any order.\n";
  if (alphabetical)
  results += input + " contains all of the vowels in alphabetical order.\n";
  else results += input + " doesn't contain all of the vowels in alphabetical order.\n";
  if (reverse)
  results += input + " contains all of the vowels in reverse order.\n";
  else results += input + " doesn't contain all of the vowels in reverse order.\n";
  if (a != 0)
  results += "a appears " + a + " times in " + input + ".\n";
  if (e != 0)
  results += "e appears " + e + " times in " + input + ".\n";
  if (i != 0)
  results += "i appears " + i + " times in " + input + ".\n";
  if (o != 0)
  results += "o appears " + o + " times in " + input + ".\n";
  if (u != 0)
  results += "u appears " + u + " times in " + input + ".\n";
  JOptionPane.showMessageDialog(null,results,"Vowel content results",1);
  }
  }
 
  
  
  
  public static void analyzeConstonantContent() //Analyzing a word/phrase based on its constonant content
  {
  String input = userInput("Enter a word/phrase to analyze its constonant content","Constonant Content");
  if (input == null)
  return; //exiting back to the main menu if the user pressed cancel
  else
  {
  input = input.toLowerCase();
  int [] constonants = new int[21];
  char [] constonant = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
  int [] alphabet = new int[21];
  for (int counter = 0;counter<21;counter++)
  {
  for (int count = 0;count<input.length();count++) //Checking how many times each constonant is used in the word/phrase
  if (input.charAt(count)==(constonant[counter]))
  constonants[counter]++;
  }
  boolean noConstonants = false,allConstonants = false,alphabetical = false,reverse = false;
  if ((constonants[0]==0)&&(constonants[1]==0)&&(constonants[2]==0)&&(constonants[3]==0)&&(constonants[4]==0)&&(constonants[5]==0)&&(constonants[6]==0)&&(constonants[7]==0)&&(constonants[8]==0)&&(constonants[9]==0)&&(constonants[10]==0)&&(constonants[11]==0)&&(constonants[12]==0)&&(constonants[13]==0)&&(constonants[14]==0)&&(constonants[15]==0)&&(constonants[16]==0)&&(constonants[17]==0)&&(constonants[18]==0)&&(constonants[19]==0)&&(constonants[20]==0)) //Checking if there are constonants in the word phrase
  noConstonants = true;
  if ((constonants[0]!=0)&&(constonants[1]!=0)&&(constonants[2]!=0)&&(constonants[3]!=0)&&(constonants[4]!=0)&&(constonants[5]!=0)&&(constonants[6]!=0)&&(constonants[7]!=0)&&(constonants[8]!=0)&&(constonants[9]!=0)&&(constonants[10]!=0)&&(constonants[11]!=0)&&(constonants[12]!=0)&&(constonants[13]!=0)&&(constonants[14]!=0)&&(constonants[15]!=0)&&(constonants[16]!=0)&&(constonants[17]!=0)&&(constonants[18]!=0)&&(constonants[19]!=0)&&(constonants[20]!=0)) //Checking if all constonants are in the word phrase
  {
  allConstonants = true;
  for(int counter = 0;counter<21;counter++)
  alphabet[counter] = input.indexOf(constonant[counter]); //Finding the first position of every constonant
  if ((alphabet[0]<alphabet[1])&&(alphabet[1]<alphabet[2])&&(alphabet[2]<alphabet[3])&&(alphabet[3]<alphabet[4])&&(alphabet[4]<alphabet[5])&&(alphabet[5]<alphabet[6])&&(alphabet[6]<alphabet[7])&&(alphabet[7]<alphabet[8])&&(alphabet[8]<alphabet[9])&&(alphabet[9]<alphabet[10])&&(alphabet[10]<alphabet[11])&&(alphabet[11]<alphabet[12])&&(alphabet[12]<alphabet[13])&&(alphabet[13]<alphabet[14])&&(alphabet[14]<alphabet[15])&&(alphabet[15]<alphabet[16])&&(alphabet[16]<alphabet[17])&&(alphabet[17]<alphabet[18])&&(alphabet[18]<alphabet[19])&&(alphabet[19]<alphabet[20])) //Checking if all constonants are in the word phrase in alphabetical order
  alphabetical = true;
   if ((alphabet[0]>alphabet[1])&&(alphabet[1]>alphabet[2])&&(alphabet[2]>alphabet[3])&&(alphabet[3]>alphabet[4])&&(alphabet[4]>alphabet[5])&&(alphabet[5]>alphabet[6])&&(alphabet[6]>alphabet[7])&&(alphabet[7]>alphabet[8])&&(alphabet[8]>alphabet[9])&&(alphabet[9]>alphabet[10])&&(alphabet[10]>alphabet[11])&&(alphabet[11]>alphabet[12])&&(alphabet[12]>alphabet[13])&&(alphabet[13]>alphabet[14])&&(alphabet[14]>alphabet[15])&&(alphabet[15]>alphabet[16])&&(alphabet[16]>alphabet[17])&&(alphabet[17]>alphabet[18])&&(alphabet[18]>alphabet[19])&&(alphabet[19]>alphabet[20])) //Checking if all constonants are in the word phrase in reverse order
  reverse = true;
  }
  String results = "";
  if (noConstonants) //Displaying the information found
  results += "There are no constonants in this word/phrase.\n";
  else results += "There are constonants in this word/phrase.\n";
  if(allConstonants)
  results += "Every constonant is in this word/phrase.\n";
  else results += "Every constonant is not in this word/phrase.\n";
  if (alphabetical)
  results += "Every constonant is in this word/phrase in alphabetical order.\n";
  else results += "Every constonant is not in this word/phrase in alphabetical order.\n";
  if (reverse)
  results += "Every constonant is in this word/phrase in reverse order.\n";
  else results += "Every constonant is not in this word/phrase in reverse order.\n";
  for(int count = 0;count<constonants.length;count++)
  if (constonants[count]!=0)
  results += constonant[count] + " appears " + constonants[count] + " times in " + input + ".\n";
  JOptionPane.showMessageDialog(null,results,"Constonant content results",1);
  }
  }
  

  
    public static void Method3()
    {
      String reverse = "",results="";
      String word = userInput("Enter your word/phrase/sentence", " The frequency of each letter in the word or phrase "); 
      if (word == null)
    return; //exiting back to the main menu if the user pressed cancel
     else
     {
             int [] letters = new int[26];  
      char [] letter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
      for (int counter = 0;counter<26;counter++)
     {
      for (int count = 0;count<word.length();count++) //Checking how many times each letter is used in the word/phrase
       if (word.charAt(count)==(letter[counter]))
       letters[counter]++;
     }
     int wordCount = 0;
  String aCharacter;
  for (int i = 0; i < word.length(); i++)
  {
   aCharacter = word.substring(i, i + 1);
   if (aCharacter.equals(" "))
    wordCount++;
  }
  results+= "Amount of words: " + (++wordCount * 1) + "\n";
        boolean allLetters = false;
            if ((letters[0] != 0) && (letters[1] != 0) && (letters[2] != 0) && (letters[3] != 0) && (letters[4] != 0) && (letters[5] != 0) && (letters[6] != 0) && (letters[7] != 0) && (letters[8] != 0) && (letters[9] != 0) && (letters[10] != 0) && (letters[11] != 0) && (letters[12] != 0) && (letters[13] != 0) && (letters[14] != 0) && (letters[15] != 0) && (letters[16] != 0) && (letters[17] != 0) && (letters[18] != 0) && (letters[19] != 0) && (letters[20] != 0) && (letters[21] != 0) && (letters[22] != 0) && (letters[23] != 0) && (letters[24] != 0) && (letters[25] != 0) && (letters[26] != 0)); //checking if it contains all of the letters of the alphabet
            allLetters = true; 
            if (allLetters) 
            results += "The word or phrase is a pangram \n"; 
            else results += "The word or phrase is not a pangram \n";
        word = word.replaceAll("\\s","");
      int length = word.length() -1 ;
      char[] words = new char[length]; 
      for ( int counter=0; counter < length; counter++)
      {
	    words[counter] = word.charAt(counter);
      }
        boolean r1=false;
		boolean r2=false;
		boolean r3=false;
		char[]input={'r','e','f'};
		char[]row1={'q','w','e','r','t','y','u','i','o','p'}; // enters keys for each set row
		char[]row2={'a','s','d','f','g','h','j','k','l'};
		char[]row3={'z','x','c','v','b','n','m'};
		int j=0;
		int f=0;
		int b=0;
		while(r1==false && j<row1.length) //checking if the first row is used
		{
		   for(int i=0; i<words.length; i++)
		   {
			   for( j=0; j<row1.length; j++)
			    {
				    if(words[i]==row1[j])
				    r1=true;
				    
			    }
		    }
	    }
	    while(r2==false && f<row2.length) //checking if the second row is used
		{
		   for(int i=0; i<words.length; i++)
		   {
			   for(f=0; f<row2.length; f++)
			    {
				    if(words[i]==row2[f])
				    r2=true;
			    }
		    }
	    }
	    while(r3==false && b<row3.length) //checking if the third row was used 
		{
		   for(int i=0; i<words.length; i++)
		   {
			   for(b=0; b<row3.length; b++)
			    {
				    if(words[i]==row3[b])
				    r3=true;
			    }
		    }
	    }
	   if(r1) //displaying which row is used
	   results += "Row 1 is used\n";
	   else results += "Row 1 is not used\n";
	   if (r2)
	   results += "Row 2 is used\n";
	   else results += "Row 2 is not used\n";
	   if (r3) 
	   results += "Row 3 is used\n";
	   else results += "Row 3 is not used\n";
	   String vowels = "aeiou";
       boolean isAlternating = true; // set up boolean to simplify  
       int count = 0;
       if (vowels.indexOf(word.charAt(0)) == -1)
       	count = 1;
       	for ( ;count < word.length() && isAlternating; )
       	{
	       	if(vowels.indexOf(word.charAt(count)) == -1) // checks every second letter for a vowel
	       		isAlternating = false;
	       	else
	       		count += 2;
       	}
   if (isAlternating) 
   results += "It is alternating\n";
   else   
    results += "It is not alternating\n";
	   for(int counter = 0;counter<letters.length;counter++)
        if (letters[counter]!=0)
        results += letter[counter] + " appears " + letters[counter] + " times in " + word + ".\n"; //displaying the frequency of each letter
       JOptionPane.showMessageDialog(null,results,"The frequency of each letter in the word or phrase ",1);
   }
   }
 

   public static void Anagram()
	{
		String p = "", comparison = "", inputFromUser1 = "", inputFromUser2 = "", inputAfterTrim1 = "", inputAfterTrim2 = "";
		char aChar;
		boolean firstWordOrPhrase = false, secondWordOrPhrase = false;
		while (!firstWordOrPhrase)
		{
			inputFromUser1 = userInput("Enter the first word/phrase","Checking for anagrams");  //take input from user
			if (inputFromUser1 == null) //if cancel is pressed it should return the user back to the menu.
			return;			 
			else
			{
				for(int i = 0;i < inputFromUser1.length(); i++)//remove all spaces and punctuation from inputFromUser1
				{
					aChar = inputFromUser1.charAt(i);			
					if(Character.isLetterOrDigit(aChar))
						inputAfterTrim1 += aChar;
				}
				if(inputAfterTrim1 == "")//if after being trimmed, the string is empty it should return this error message.
					JOptionPane.showMessageDialog(null, "Please Enter a word/phrase to be checked if the are an anagram.");
				else
					firstWordOrPhrase = true;
			}
		}		
		while (!secondWordOrPhrase)
		{
			inputFromUser2 = userInput("Enter the second word/phrase","Checking for anagrams"); //take input from user
			if (inputFromUser2 == null) //if cancel is pressed it should return the user back to the menu.
			return;
			else
			{
				for(int i = 0;i < inputFromUser2.length(); i++)//remove all spaces and punctuation from inputFromUser2.
				{
					aChar = inputFromUser2.charAt(i);			
					if(Character.isLetterOrDigit(aChar))
						inputAfterTrim2 += aChar;
				}
				if(inputAfterTrim1 == "")//if after being trimmed, the string is empty it should return this error message.
					JOptionPane.showMessageDialog(null, "Please Enter a word/phrase to be checked if the are an anagram.");
				else
					secondWordOrPhrase = true;
			}
		}		
		String notTheSame = "First entry and second entry are not anagrams of each other.";
		String areTheSame = "First entry and second entry are anagrams of each other.";
		if (inputAfterTrim1.length() != inputAfterTrim2.length())//lengths are not equal, can't be anagrams.
			JOptionPane.showMessageDialog(null, notTheSame);
		else
		{
			if(inputFromUser1.equalsIgnoreCase(inputFromUser2))//If words are equal, they are anagrams and the same.
				JOptionPane.showMessageDialog(null, areTheSame + " They are also the same.");
			else //when the both words/phrases are checked and are still not the same we continue checking.
			{
			boolean anagram = true;
			inputAfterTrim1 = inputAfterTrim1.toLowerCase();		//changes everything to lower case
			inputAfterTrim2 = inputAfterTrim2.toLowerCase();
			for(int i = 0; i < inputAfterTrim1.length() && anagram; i++)//takes character from String and converts to string.
				{
					p = Character.toString(inputAfterTrim1.charAt(i));
					if (inputAfterTrim2.contains(p))//if contained in second string
						inputAfterTrim2= inputAfterTrim2.replaceFirst(p, "#");//take letter, replace with "#"
					else
					{
						anagram = false;
					}
				}
				if (!anagram)
					JOptionPane.showMessageDialog(null, notTheSame);
				else
				{
					for(int i = 0; i < inputAfterTrim1.length(); i++)//If anagrams, comparison will = ########
					{
						comparison += "#";
					}
					if (inputAfterTrim2.equals(comparison))
						JOptionPane.showMessageDialog(null, areTheSame);
					else
						JOptionPane.showMessageDialog(null, notTheSame);
				}
			}
		}
	}
	
	
   public static void Palindrome()
  {
	String results ="";
	String input = userInput("Enter a word/phrase to check if its a palindrome","Check for a palindrome"); //Getting user input
	if (input == null)
    return; //exiting back to the main menu if the user pressed cancel
    else
    {
	String extra = input.toLowerCase(); //getting rid of capitals
	extra = extra.replaceAll("[\\W-_]",""); //getting rid of characters
	char aChar, bChar;
   	int i = 0;
    int j = extra.length() - 1; //checking if its a palindrome
    while (j > i) 
    {
	    aChar = extra.charAt(i);
	    bChar = extra.charAt(j);
        if (aChar != bChar) 
        {
            results = input + "\n" + "is not a Palindrome";; //displaying if its not a palindrome
        }
        ++i;
        --j;
    }
    results = input + "\n" + "is a Palindrome"; ; //displaying if it is a palindrome
	JOptionPane.showMessageDialog(null, results);
  }
  }
  
  
  public static void longAndShort()
	{
		String trimmedInput = "", result = "", words[] = new String[0], maxWords = "", minWords = "", input = "",userInput = "";
		String maxList[], minList[];
		char aChar;
		int max, min, duplicate;
		boolean correctInput = false;
		while(!correctInput)
		{	
			userInput = userInput("Enter a word/phrase","Determining longest and shortest word"); //Taking input from the user.
			trimmedInput = "";
			if(userInput == null) //Returns to the main method if the user clicks "x" or cancel.
				return;		
			if(userInput.length() < 1 || userInput.replaceAll("[\\t\\s]", "").equals("")) //Checks if the user input is empty or just white space.
				JOptionPane.showMessageDialog(null,"You have not entered a sentence.");
			else
			{
				for(int i = 0;i < userInput.length(); i++) //makes the trimmedInput String with the input String but replaces all punctuation with a space char and replaces "'" with an empty char.
				{
					aChar = userInput.charAt(i);
					if(Character.isSpaceChar(aChar) || Character.isLetterOrDigit(aChar))
						trimmedInput += aChar;
					else if(aChar == '\'')
						trimmedInput += "";
					else
						trimmedInput += " ";
				}
				trimmedInput = trimmedInput.replaceAll("[\\t\\s]{1,}"," ");//Removes all excess spaces from the trimmedInput String.
				trimmedInput = trimmedInput.trim();  				
				trimmedInput = trimmedInput.toLowerCase();			
				words = trimmedInput.split(" ");//splits each word from the string into an array.				
				if(words.length <= 1)
					JOptionPane.showMessageDialog(null,"You have only entered a single word, not a sentence.");//I assumed that the user isnt supposed to type in only one word.
				else
				correctInput = true;
			}
	}
		max = words[0].length();//This determines the maximum length.            
		for(int i = 0; i < words.length; i++)
		{
			if(words[i].length() > max)
			max = words[i].length();	
		}			
		min = max;//the minimum is set to max to initialise it before finding the minimum length.		
		for(int i = 0; i < words.length; i++)
		{
			if(words[i].length() < min && words[i].length() != 0)//determines minimum length excluding 0. (just to have a safegaurd).
				min = words[i].length();		
			duplicate = 0;	
			for(int j = 0; j < words.length; j++)//checks every other word with the current word to find duplicates.
			{
				if(words[i].equals(words[j]))
					duplicate++;			
			}	
			if(duplicate > 1)//if a word has a duplicate the word is replaced with an empty string.
				words[i] = "";	
		}
		for(int i = 0; i < words.length; i++)//Creates two strings containing the max and min word list respectivley.
		{
			if(words[i].length() == max)
				maxWords += words[i] + " ";
			if(words[i].length() == min)
				minWords += words[i] + " ";
		}
		maxList = maxWords.split(" ");	//makes two arrays split at the spaces containing each word.
		minList = minWords.split(" ");
		maxWords = "";//these Strings are emptied to be refilled with correct punctuation.
		minWords = "";
			
		for(int i = 0; i < maxList.length; i++)//fills the maxWords string with the word list with correct punctuation and grammar.
		{
			if(i < maxList.length - 1)
		    {
				if(i == maxList.length -2)
					maxWords += "\"" + maxList[i] + "\" and ";
				else
					maxWords += "\"" + maxList[i] + "\", ";
			}
			else
				maxWords += "\"" + maxList[i] + "\". ";
		}		
		for(int i = 0; i < minList.length; i++)//fills the minWords string with the word list with correct punctuation and grammar.
		{
			if(i < minList.length - 1)
			{
				if(i == minList.length -2)
					minWords += "\"" + minList[i] + "\" and ";
				else
					minWords += "\"" + minList[i] + "\", ";
			}
			else
				minWords += "\"" + minList[i] + "\". ";
		}	
		if(max == min)//If the max and min lengths are the same this puts them together as one list.
		{
			result += ("For the sentence \"" + input + "\",\nThe maximum length and the minimum length are the same and their length is " + max + ".\nThe ");	
			if(minList.length == 1)
					result += "word matching this length is ";
			else
				result += "words matching this length are ";
			result += minWords;
		}
		else
		{	
			result += ("\nThe maximum length is " + max + " and the ");				
			if(maxList.length == 1)//just using an if else statement to ensure correct grammar and punctuation for both lists of words.
				result += "word matching this length is ";
			else
				result += "words matching this length are ";
			result += maxWords;
				
			result += ("\nThe minimum length is " + min + " and the ");
				
			if(minList.length == 1)
						result += "word matching this length is ";
			else
				result += "words matching this length are ";
			result += minWords;
		}	
		JOptionPane.showMessageDialog(null, result); 
	}
}      