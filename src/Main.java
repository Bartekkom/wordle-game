import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Words words = null;
		
		try {
			words = new Words();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WordleLogic wordle = new WordleLogic(words.getWord());
		Scanner scanner = new Scanner(System.in);
		
		while(!wordle.isSolved()) {
			wordle.entry(scanner.nextLine());
		}
		System.out.println("You win!");
	}
}
