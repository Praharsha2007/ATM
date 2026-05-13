package ATM;
import java.io.*;
public class FileManager {
	public void saveData(String data) {
	    try {
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
			FileReader file = new FileReader("atm.txt");
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
