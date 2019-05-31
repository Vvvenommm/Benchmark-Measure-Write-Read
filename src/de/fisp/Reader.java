package de.fisp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Reader 
{
	
	private static BufferedReader br;
	private static DecimalFormat df;
	
	private static long startTime, endTime;
	private static double dateiGroesse;
	
	private static String seconds, file, filerate, line;
	
	public static String filerateSummeRead;
	
	public void  readFile(File datei) throws IOException 
	{
		startTime = System.nanoTime();
		br = new BufferedReader(new FileReader(datei));
		for (String line; (line = br.readLine()) != null; ) 
		{
			
		}
		br.close();
		endTime = System.nanoTime() - startTime;
		
		df = new DecimalFormat("#0.00000 s");
		seconds = df.format(endTime / 1e9);
		
		df = new DecimalFormat("#");
		file = df.format(dateiGroesse = (datei.length() >> 20));
		
		df = new DecimalFormat(".###");
		filerate = df.format((datei.length() * 1000.0 / endTime));
		filerateSummeRead += filerate;
		System.out.println("Read --> " + seconds + " für --> " + file + " MB. Geschwindigkeit: " + filerate + " MB/s");	
		datei.delete();
	}

}
