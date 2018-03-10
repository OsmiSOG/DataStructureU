import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author santo
 *
 */
public class Main {
	
	/**
	 * Class main for run the code
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		bw.write("Enter please the number for experimental readings that you have the file ");
		bw.flush();
		int lines = Integer.parseInt(br.readLine());	
		CreateFiles cf = new CreateFiles(lines);
		
		bw.write("what size you want to find the pattern motif most representative");
		bw.flush();
		SearchMotif sm = new SearchMotif();
		int length = Integer.parseInt(br.readLine());
		sm.GenerateKPatterns(length, "");
		bw.write(sm.toString());
		bw.flush();
		
	}

}
