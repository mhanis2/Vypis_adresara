package sk.maha.vypis;

import java.io.File;
import java.util.Scanner;

import sk.maha.vypis.exceptions.FileNotExistsException;

public class ListingDemo {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SecurityException {

		Listing directoryListing = new Listing();
		GetDirectoryPath getPath = new GetDirectoryPath();

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
						directoryListing.fileListing(directoryPath, 0);
						directoryPathValidation = true;
					} else {
						throw new FileNotExistsException("Directory does not exist.");
					}
				} catch (FileNotExistsException e) {
					System.out.println();
					e.toString();
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
