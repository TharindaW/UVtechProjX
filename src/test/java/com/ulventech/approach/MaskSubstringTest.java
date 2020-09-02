package com.ulventech.approach;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tharinda Wickramaarachchi
 * @since 9/2/2020 9:33 PM
 */
class MaskSubstringTest
{
	private static final String FILE_PATH = "./out/Approach-MaskSubstring.txt";
	private MaskSubstring approach = null;

	@BeforeEach
	void beforeEach()
	{
		approach = new MaskSubstring();
	}

	@AfterEach
	void tearDown()
	{
	}

	@Test
	void fileTest() throws IOException
	{
		approach.process( 100 );

		File testFile = new File( FILE_PATH );
		assertTrue( testFile.exists() );
	}

	@Test
	void process() throws IOException
	{
		int[] numberArray = new int[]{8, 23, 127, 230 - 1, 999}; // Test for multiple X values

		File testFile = new File( FILE_PATH );
		for( int i : numberArray )
		{
			approach.process( i );

			int bufferSize = 100 * 1024; //100kb
			BufferedReader in = new BufferedReader( new FileReader( testFile ), bufferSize );

			Set<String> lineSet = new HashSet<>();

			for( int j = 0; j < i; j++ )
			{
				String line = in.readLine();

				assertNotNull( line ); // Test not null
				assertEquals( 100, line.length() ); // Test string length

				assertFalse( lineSet.contains( line )); // Test line uniqueness
				lineSet.add( line );
			}

			in.close();
		}
	}

	@Test
	void processException()
	{
		File testFile = new File( FILE_PATH );

		// Test IOException
		assertThrows( IOException.class, () -> {

			RandomAccessFile raFile = new RandomAccessFile( testFile, "rw" );
			raFile.getChannel().lock();

			approach.process( 100 );
		} );
	}

	@Test
	void getDigits()
	{
		int[] numberArray = new int[]{8, 23, 127, 999, 4753};
		int[] digitEqualArray = new int[]{1, 2, 3, 3, 4};
		int[] digitNotEqualArray = new int[]{2, 3, 4, 5, 6};

		for( int i = 0; i < numberArray.length; i++ )
		{
			assertEquals( approach.getDigits( numberArray[i] ), digitEqualArray[i] );
			assertNotEquals( approach.getDigits( numberArray[i] ), digitNotEqualArray[i] );
		}

	}
}