package project;
import java.io.*;
import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class Orderfile {
	static String directory= "C://users//ayyaj/P1project";
	public static void sort() {
		
		File[] files = new File(directory).listFiles();
		Set<String> s = new TreeSet<>();
		for(File file : files) {
			if (!file.isFile()) {
				continue;
			}
			s.add(file.getName());
		}
		s.forEach(i->System.out.println(i));

	}

}
