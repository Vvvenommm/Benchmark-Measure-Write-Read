package de.fisp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class Writer 
{
	
	private static PrintWriter pw;
	private static DecimalFormat df;
	private static Reader read = new Reader();
	
	private static long startTime, endTime;
	private static double dateiGroesse;
	
	private static String seconds, file, filerate;
	
	public static String filerateSummeWrite;
	
	public void writeFile(File datei, int mb, String text) throws IOException 
	{
		startTime = System.nanoTime();
		pw = new PrintWriter(new FileWriter(datei));
		for (int zaehler = 0; zaehler < mb * 1024; zaehler++) 
		{
			pw.println(text);
		}
		pw.close();
		endTime = (System.nanoTime() - startTime);
		
		df = new DecimalFormat("#0.00000 s");
		seconds = df.format(endTime / 1e9);
		
		df = new DecimalFormat("#");
		file = df.format(dateiGroesse = (datei.length() >> 20));
		
		df = new DecimalFormat(".###");
		filerate = df.format((datei.length() * 1000.0 / endTime));
		filerateSummeWrite += filerate;
		System.out.println("Write --> " + seconds + " für --> " + file + " MB. Geschwindigkeit: " + filerate + " MB/s");
		
		read.readFile(datei);
	}



}
