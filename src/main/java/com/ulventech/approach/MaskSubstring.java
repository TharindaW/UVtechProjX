package com.ulventech.approach;

import com.ulventech.XProcessApproach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Tharinda Wickramaarachchi
 * @since 9/2/2020 7:06 PM
 */
public class MaskSubstring extends XProcessApproach
{
	private static String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"; //100 char length


	/**
	 * @param x : x can be any number from 1 to 230-1
	 */
	@Override
	public void process( int x ) throws IOException
	{
		File file = initFile( name() );

		int bufferSize = 100 * 1024; //100kb
		try (BufferedWriter writer = new BufferedWriter( new FileWriter( file ), bufferSize ))
		{
			for( int i = 1; i < x + 1; i++ )
			{
				int digits = getDigits( i ); // digits = digits + 1

				String s = i + "-" + mask.substring( digits + 1 );

				writer.write( s );
				writer.newLine();
			}
		}
	}

	int getDigits( int i )
	{
		return (int) Math.log10( i ) + 1;
	}

	@Override
	public String name()
	{
		return "MaskSubstring";
	}
}
