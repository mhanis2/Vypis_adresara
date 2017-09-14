package sk.maha.vypis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListingDemo {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SecurityException {

		Listing directoryListing = new Listing();
		DirectoryPathValidation getPath = new DirectoryPathValidation();

		File file = null;

		String directoryPath;
		boolean directoryPathValidation;
		boolean stopListing;

		for (;;) {
			do {
				try {
					directoryPath = getPath.getDirectoryPath(sc);
					file = new File(directoryPath);
					if (file.exists()) {
						System.out.println("Directory exists.");
						System.out.println();
						directoryListing.fileListing(directoryPath, 0);
						directoryPathValidation = true;
					} else {
						throw new FileNotFoundException();
					}
				} catch (FileNotFoundException e) {
					System.out.println();
					System.err.println("Directory does not exist.");
					System.out.println();
					directoryPathValidation = false;
				}
			} while (!directoryPathValidation);

			stopListing = directoryListing.stopListing(sc);
			if (!stopListing) {
				System.out.println();
				System.out.println("End of Listing !!!");
				sc.close();
				break;
			}
		}
	}
}
