package sk.maha.vypis;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectoryPathValidation {

	private String pathPattern = "[A-Za-z]\\:\\/([a-zA-z0-9/])*";

	/**
	 * Validate path for directory from user.
	 * 
	 * @param path
	 * @return Directory path is valid or not
	 */
	public boolean directoryPathValidation(String path) {

		Pattern pattern = Pattern.compile(pathPattern);
		Matcher matcher = pattern.matcher(path);

		return matcher.matches();
	}

	/**
	 * Obtain path for directory to listing.
	 * 
	 * @param s
	 * @return String with valid path for listing
	 */
	public String getDirectoryPath(Scanner s) {
		// DirectoryPathValidation dpv = new DirectoryPathValidation();
		String directoryPath;
		boolean check;
		do {
			System.out.println("Write path to directory");
			System.out.println("Example:");
			System.out.println("C:/dir/dir/dir");
			System.out.print("Your path: ");
			directoryPath = s.next();
			s.nextLine();
			check = directoryPathValidation(directoryPath);
			if (!check) {
				System.err.println("Directory path name is invalid.");
				System.err.println("Valid format: C:/dir/dir/dir");
				System.out.println();
			}
		} while (!check);

		return directoryPath;
	}

	/**
	 * Check whether gained directory exists.
	 * 
	 * @param path
	 * @return Existence of directory or exception FileNotExistsException
	 */
	public boolean checkDirectoryExistance(String path) {
		File dir = new File(path);
		return dir.exists();
	}
}
