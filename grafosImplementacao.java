import java.io.File;	
import java.io.FileNotFoundException;
import java.util.Scanner;

public class grafosImplementacao {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("/Users/Son/eclipse-workspace/grafos/src/grafos/");
		
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}

	}

}
