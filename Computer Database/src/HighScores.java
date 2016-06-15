import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HighScores {
	File high=new File("HighScores.txt");
	FileReader in;
	BufferedReader filer;
	public void HighScore(String addon) throws IOException{
		try{
			in=new FileReader(high);
			filer=new BufferedReader(in);
			while((addon=filer.readLine())!=null){
				System.out.println(addon);
			}
		} catch(IOException e){
			System.out.println("ERROR READING HIGH SCORES FILE!");
		}
	}
}
