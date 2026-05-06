package ATM;
import java.io.*;
public class FileManager {
	public void saveData(String data) {
		try {
			FileWriter writer = new FileWriter("atm.txt", true);
			writer.write(data + "\n");
			writer.close();
		}catch(IOException e) {
			System.out.println("Error writing file");
		}
	}
	public void readData() {
		try {
			FileReader file = new FileReader("atx.txt");
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
