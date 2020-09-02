package com.ulventech.approach;

import com.ulventech.XProcessApproach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ( Not scalable for large X value )- Computationally Optimum solution avoiding "Base 10 logarithm" and "Substring" computations
 *
 * @author Tharinda Wickramaarachchi
 * @since 9/2/2020 7:05 PM
 */
public class PureMask extends XProcessApproach
{
	private static String mask99 = "-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"; //99 char length
	private static String mask98 = "-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"; //98 char length
	private static String mask97 = "-XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"; //97 char length

	/**
	 * @param x : x can be any number from 1 to 230-1
	 */
	@Override
	public void process( int x )
	{
		MaskSubstring approach = new MaskSubstring();

		approach.getDigits( 1 );
		File file = initFile( name() );

		int bufferSize = 100 * 1024; //100kb
		try (BufferedWriter writer = new BufferedWriter( new FileWriter( file ), bufferSize ))
		{
			for( int i = 1; i < x + 1; i++ )
			{
				if( i < 10 ) // One digit, 1 + 99 == 100
				{
					writer.write( i + mask99 );
				}
				else if( i < 100 ) // two digit ,  2 + 98 == 100
				{
					writer.write( i + mask98 );
				}
				else //three digit ,  3 + 97 == 100
				{
					// since x between  1 to  230-1 =229 , assume that "else" block will only receive i between 100 to 229
					//this will support x up to 999
					writer.write( i + mask97 );
				}

				writer.newLine();
			}

		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
	}

	@Override
	public String name()
	{
		return "PureMask";
	}
}
