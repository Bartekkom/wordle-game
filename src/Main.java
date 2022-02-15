
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		WordleLogic wordle = new WordleLogic();
		
		while(!wordle.isSolved()) {
			wordle.entry(scanner.nextLine());
			
		}
		scanner.close();
	}
}
