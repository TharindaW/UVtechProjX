package com.ulventech;

import com.ulventech.approach.MaskSubstring;
import com.ulventech.approach.PureMask;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Approach runner class, Support for -Xmx10M
 *
 * This project has two different solution for the given problem
 *
 * MaskSubstring ( Scalable )- Optimum solution under given conditions but this contain "Base 10 logarithm" and "Substring" computations
 * PureMask ( Not scalable for large X value )- Computationally Optimum solution avoiding "Base 10 logarithm" and "Substring" computations
 *
 * @author Tharinda Wickramaarachchi
 * @since 9/2/2020 7:14 PM
 */
public class XProcessor
{
	public static void main( String[] args ) throws InterruptedException, IOException
	{
		//Thread.sleep( 10000 );
		System.out.println( "Starting..." );

		//Each element of this array contain different solution for the given problem
		List<XProcessApproach> approaches = Arrays.asList( new MaskSubstring(), new PureMask() );

		int x = 230-1; // x max for pure mask = 999

		for( XProcessApproach approach : approaches )
		{
			long millis = System.currentTimeMillis();

			approach.process( x );

			System.out.println( "X=" + x + " processed successfully with : " + approach.name() + " approach : " + ( System.currentTimeMillis() - millis ) + "ms" );
		}
	}
}
