package ThreadPool;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Some {
	public static void main(String[] args) {
	Files files = new Files;
	Path java = Paths.get("/usr/bin/java");
	java.isAbsolute(); //true;
	java.toString();	// /usr/bin/java
	java.getFileName();	// java
	java.getParent();	// /usr/bin
	java.getNameCount(); // 3

	Files.exists(java); // true;
	Files.isRegularFile(java); // true;
	Files.isReadable(java);	// true;
	try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(java)) {
		for(Path child : dirStream) {
			System.out.println(child);
		}
	}
	
	
	
		for (int i = 0; i < 10; i++) {
		  System.out.println((Integer) i);
		}
	}
}
