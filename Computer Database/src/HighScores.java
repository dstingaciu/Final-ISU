import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HighScores {
	int lines=0;
	public void HighScore(String addon) throws IOException{
		try{
			FileWriter txt=new FileWriter(("PastMatches.txt"), true);
			PrintWriter pw=new PrintWriter(txt);
			BufferedReader reader=new BufferedReader(new FileReader("PastMatches.txt"));
			while(reader.readLine()!=null){
				lines++;
			}
			pw.println();
			pw.println(addon);
			pw.close();
			reader.close();
		} catch(IOException e){
			System.out.println("ERROR READING PastMatches FILE! CREATING FILE");
			File file=new File("PastMatches.txt");
		}
	}
}
