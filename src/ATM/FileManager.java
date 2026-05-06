package ATM;
import java.io.*;
public class FileManager {
	private static final String name = "atm.txt";
	public void saveData(String data) {
	    try {
	        File debug = new File("debug.txt");
	        FileWriter dbg = new FileWriter(debug, true);
	        dbg.write("saveData called\n");
	        dbg.close();

	        File file = new File("atm.txt");
	        FileWriter writer = new FileWriter(file, true);
	        writer.write(data + "\n");
	        writer.close();

	    } catch(IOException e) {
	        e.printStackTrace();
	    }
	}
	public void readData() {
		try {
			FileReader file = new FileReader(name);
			BufferedReader reader = new BufferedReader(file);
			String line;
			while ((line = reader.readLine()) != null){
				System.out.println(line);
			}
			reader.close();
		} catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}
