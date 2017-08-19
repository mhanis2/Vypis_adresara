package sk.maha.vypis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectoryPathValidation {

	private String pathPattern = "[A-Z]\\:\\/([a-zA-z0-9/])*";

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
}
