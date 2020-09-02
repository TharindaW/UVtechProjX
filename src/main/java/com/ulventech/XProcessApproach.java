package com.ulventech;

import java.io.File;
import java.io.IOException;

/**
 * @author Tharinda Wickramaarachchi
 * @since 9/2/2020 7:08 PM
 */
public abstract class XProcessApproach
{
	protected File initFile( String name )
	{
		File file = new File( "./out/Approach-" + name + ".txt" );
		try
		{
			// create file if not exists
			if( !file.exists() )
			{
				boolean mkdirs = new File( "./out" ).mkdirs();
				if( mkdirs )
				{
					file.createNewFile();
				}
			}
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		return file;
	}

	public abstract void process( int x ) throws IOException;

	public abstract String name();
}
