import java.io.*;
import java.util.*;

public class Words {
	
	private ArrayList<String> words;
	private File file;
	private Scanner scan;
	private Random random;
	
	public Words() throws FileNotFoundException{
		this.file = new File("wordsData.txt");
		this.scan = new Scanner(file);
		this.random = new Random();
		this.words = new ArrayList<>();
		scan();
	}
	
	private void scan() {
		while(scan.hasNextLine()) {
			this.words.add(scan.nextLine());
		}
	}
	
	public String getWord() {
		return words.get(random.nextInt(words.size() - 1));
	}

}
