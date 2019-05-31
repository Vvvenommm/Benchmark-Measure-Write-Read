package de.fisp;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

import javax.rmi.ssl.SslRMIClientSocketFactory;

// Java Build path -> Libraries -> Access Rules -> Access (com/sun/management/OperatingSystemMXBean)
import com.sun.management.OperatingSystemMXBean;
//import de.calc.prime.*;

//cat /proc/cpuinfo

public class CPUInformation {
	
	
	public static OperatingSystemMXBean mbean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

	
	
	public static void printMemoryInfo()
	{
		Runtime rt = Runtime.getRuntime();
		DecimalFormat df = new DecimalFormat( "###,##0" );
		
		// Gesamter physikalischer Arbeitsspeicher
		long lngTotMemSizeByte = mbean.getTotalPhysicalMemorySize();
		// Freier physikalischer Arbeitsspeicher
		long lngFreMemSizeByte = mbean.getFreePhysicalMemorySize();
		// Verfügbarer Arbeitsspeicher (-Xmx für maximalen Heap Size)
		long lngMaxMemSizeByte = rt.maxMemory();
		// Reservierter Arbeitsspeicher (-Xms für initialen Arbeitsspeicher)
		long lngResMemSizeByte = rt.totalMemory();
		// Aktuell genutzter Arbeitsspeicher
		long lngUseMemSizeByte = rt.totalMemory() - rt.freeMemory();		

		System.out.println("================ Arbeitsspeicher ===========================");
		System.out.println("   ================= System =============================");
		System.out.println("Gesamter Arbeitsspeicher:     " + df.format(lngTotMemSizeByte) + " Byte");
		System.out.println("Freier Arbeitsspeicher:       " + df.format(lngFreMemSizeByte) + " Byte");

		System.out.println("   ================= VM =================================");		
		System.out.println("VerfÃ¼gbarer Arbeitsspeicher:  " + df.format(lngMaxMemSizeByte) + " Byte");
		System.out.println("Reservierter Arbeitsspeicher: " + df.format(lngResMemSizeByte) + " Byte");
		System.out.println("Verbrauchter Arbeitsspeicher: " + df.format(lngUseMemSizeByte) + " Byte");
	}

	public static void printCpuInfo() 
	{
		double dblProcessCpuTimeNs = mbean.getProcessCpuTime();
		double dblProcessCpuTimeS = dblProcessCpuTimeNs / 1000000000d;

		
		System.out.println("================================================================");
		System.out.println("============ Prozess - gesamt - CPU - Info =====================");
		System.out.println("================================================================");
		System.out.println();
		System.out.println("================ Prozessor =================================");
		System.out.println("   ================= System =============================");
		System.out.println("Architektur:                  " + mbean.getArch()); 
		System.out.println("Anzahl CPUs:                  " + mbean.getAvailableProcessors());
		System.out.println("Load Average:                 " + mbean.getSystemLoadAverage());
		System.out.println("OS:                           " + mbean.getVersion());
		System.out.println("   ================= VM =================================");
		System.out.println("Prozess CPU Load:             " + String.format("%1.12f", mbean.getProcessCpuLoad()));
		System.out.println("System  CPU Load:             " + String.format("%1.12f", mbean.getSystemCpuLoad()));
		System.out.println("Verbrauchte CPU-Zeit:         " + String.format("%1.9f", dblProcessCpuTimeNs) + " ns");
		System.out.println("Verbrauchte CPU-Zeit:         " + String.format("%1.9f", dblProcessCpuTimeS) + " s");
	}

	public static double getLoadAverage() 
	{
		return mbean.getSystemLoadAverage();
	}

}
