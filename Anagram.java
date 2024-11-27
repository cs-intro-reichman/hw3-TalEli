/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "helllo!";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		boolean isAn = true;
		str1 = preProcess(str1); 
		str2 = preProcess(str2);

		str1 = str1.replaceAll(" ", "");
		str2 = str2.replaceAll(" ", "");

		if(!(str1.length() == str2.length())){
			return false;
		}

		for(int i=0; i< str1.length(); i++){
			char current = str1.charAt(i);
			int countInStr1 = 0;
			int countInStr2 = 0;
			
			for (int j = 0; j < str1.length(); j++){
				if (str1.charAt(j) == current){
					countInStr1++;
				}
			}

			for (int j = 0; j < str2.length(); j++){
				if (str2.charAt(j) == current){
					countInStr2++;
				}
			}

			if(countInStr1 != countInStr2) {
				return false;
			}

		}

		return isAn;
	}
	


	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String strN = "";
		for (int i=0; i<str.length(); i++){
			if (!(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') && !(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') && !(str.charAt(i) == ' ')){
				continue;
			}
			else{
				if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				strN += (char) (str.charAt(i)+32);
			    }
				else {
					strN += str.charAt(i);
				}
				
		    }
		}
		return strN;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String word)
     {
        int len=word.length();
        String newWord="";
        while (len>0){
            int rand= (int)(Math.random()*len);
            newWord+=word.charAt(rand);
            word=word.substring(0,rand)+word.substring(rand+1);
            len--;
        }
        return newWord;
	   
}

  }

