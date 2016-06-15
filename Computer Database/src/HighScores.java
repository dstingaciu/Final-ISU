import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HighScores {
	int lines=0;
	public void HighScore(String addon) throws IOException{
		try{
			FileWriter txt=new FileWriter("HighScores.txt");
			PrintWriter pw=new PrintWriter(txt);
			BufferedReader reader=new BufferedReader(new FileReader("HighScores.txt"));
			while(reader.readLine()!=null){
				lines++;
			}
			pw.write(addon);
			pw.close();
			reader.close();
		} catch(IOException e){
			System.out.println("ERROR READING HIGH SCORES FILE!");
		}
	}
}
