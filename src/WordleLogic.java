import java.io.FileNotFoundException;
import java.util.*;

public class WordleLogic {
	
	private Boolean solved = false;
	private ArrayList<Character> wordArray;
	private ArrayList<Character> userWordArray;
	private Words words = null;
	
	public WordleLogic() {
		try {
			words = new Words();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.wordArray = toArray(words.getWord());
	}
	
	public Boolean isSolved(){
		return solved;
	}
	
	private ArrayList<Character> toArray(String word) {
		ArrayList<Character> array = new ArrayList<>();
		for(int i = 0; i < word.length(); i++){
			array.add(word.charAt(i));
		}
		return array;
	}
	
	private void status(String correctLetters, String presentLetters) {
		System.out.println("Letters on correct positions: " + correctLetters);
		System.out.println("Letters present in the word: " + presentLetters);
	}
	
	private Boolean isValid(String userWord) {
		if(userWord.length() != wordArray.size()) {
			System.out.println("Input 5 - letter word");
			return false;
		}
		return true;
	}
	
	
	
	public void entry(String userWord) {
		
		if(!isValid(userWord)) {
			return;
		}
		
		userWordArray = toArray(userWord);

		String correctLetters = "";
		String presentLetters = "";
		
		if(userWordArray.equals(wordArray)) {
			solved = true;
			System.out.println("Correct!");
			return;
		}
		
		for(int i = 0; i < wordArray.size(); i++){
			if(wordArray.get(i) == userWordArray.get(i)) {
				correctLetters += wordArray.get(i);
			}
			for(int k = 0; k < wordArray.size(); k++){
				if(wordArray.get(i) == userWordArray.get(k)) {
					presentLetters += wordArray.get(i);
				}
			}
		}
		status(correctLetters, presentLetters);
	}
	
	
}
