package sk.maha.vypis;

import java.io.File;
import java.util.Scanner;

public class Listing {

	/**
	 * Listing directory and its subdirectories with files gained from user.
	 * 
	 * @param filePath
	 * @param degree
	 */
	public void fileListing(String filePath, int degree) {
		File file = new File(filePath);
		File[] fileList = file.listFiles();

		for (File oneFile : fileList) {
			for (int i = 0; i < degree; i++) {
				System.out.print("\t");
			}
			if (oneFile.isDirectory()) {
				System.out.println(oneFile.getName().toUpperCase() + ":");
				fileListing(oneFile.getAbsolutePath(), degree + 1);
			} else if (oneFile.isFile()) {
				for (int i = 0; i < degree; i++) {
					System.out.print("-");
				}
				System.out.println("-" + oneFile.getName());
			} else {
				return;
			}
		}
	}

	/**
	 * Stop or continue with listing of directory.
	 * 
	 * @param s
	 * @return true or false depend on user input
	 */
	public boolean stopListing(Scanner s) {
		char answer;
		do {
			System.out.println();
			System.out.println("Do you want to start new listing?");
			System.out.println("Yes or No? (y/n)");
			System.out.print("Your answer: ");
			answer = s.next().charAt(0);
			System.out.println();
		}while (answer != 'y' && answer != 'n');

		return answer == 'y' ? true : false;
	}

}
