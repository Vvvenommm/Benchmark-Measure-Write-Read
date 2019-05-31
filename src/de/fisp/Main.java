package de.fisp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
	
	
	private static FileOutputStream f;
	
	public static int anzahlDurchgänge = 10;
	
	public static void main(String[] args) throws IOException 
	{
		//der Sysout wird in eine Datei umgelenkt
		f = new FileOutputStream("AusgabeAnwendung2.txt");
		for (int zaehler = 0; zaehler < anzahlDurchgänge; zaehler++) 
		{
			
			System.setOut(new PrintStream(f));
			System.out.println("Load-Average Beginn: " + CPUInformation.getLoadAverage());
			createFile.createTempFile();
		
			CPUInformation.printMemoryInfo();
			CPUInformation.printCpuInfo();
		
		}
		
	}


}
