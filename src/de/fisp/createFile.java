package de.fisp;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class createFile 
{
	
	private static Writer write = new Writer();
	
	public static void createTempFile() throws IOException 
	{
		for (int mb : new int[] {125, 250, 500, 1000, 2000}) 
		{
			//es wird eine temporäre Datei erzeugt, die nach dem der Prozess fertig ist gelöscht wird
			File datei = File.createTempFile("temporaereDatei", ".txt");
			datei.deleteOnExit();
			//die Datei wird mit dem Buchstaben A gefüllt
			char[] chars = new char[1024];
			Arrays.fill(chars, 'A');
			String text = new String(chars);
			write.writeFile(datei, mb, text);
		}
		
		
	}
}
