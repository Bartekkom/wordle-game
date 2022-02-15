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
		//System.out.println(wordArray);
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

	private Boolean isPresent(Character letter) {
			for(int i = 0; i < wordArray.size(); i++){
				if(wordArray.get(i) == letter) {
					return true;
				}
			}
		return false;
	}
	
	private Boolean isCorrect(Character letter, int index) {
		if(userWordArray.get(index) == wordArray.get(index)) {
			return true;
		}
		return false;
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
		
		this.userWordArray = toArray(userWord);

		
		for(int i = 0; i < wordArray.size(); i++){
			if(isCorrect(userWordArray.get(i), i)) {
				System.out.print(Color.GREEN);
				System.out.print(userWordArray.get(i) + " ");
				System.out.print(Color.RESET);
			} else if (isPresent(userWordArray.get(i))) {
				System.out.print(Color.YELLOW);
				System.out.print(userWordArray.get(i) + " ");
				System.out.print(Color.RESET);
			} else {
				System.out.print(Color.WHITE);
				System.out.print(userWordArray.get(i) + " ");
				System.out.print(Color.RESET);
			}
		}
		System.out.println();
		
		if(userWordArray.equals(wordArray)) {
			solved = true;
			System.out.println("Correct!");
			return;
		}
		
		
	}
	
	
}
