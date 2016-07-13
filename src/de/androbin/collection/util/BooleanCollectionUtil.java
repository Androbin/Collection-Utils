package de.androbin.collection.util;

import de.androbin.function.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public final class BooleanCollectionUtil
{
	private BooleanCollectionUtil()
	{
	}
	
	public static boolean[] fill( final boolean[] array, final boolean element )
	{
		Arrays.fill( array, element );
		return array;
	}
	
	public static boolean[] fill( final boolean[] array, final IntToBooleanFunction function )
	{
		for ( int i = 0; i < array.length; i++ )
		{
			array[ i ] = function.applyAsBoolean( i );
		}
		
		return array;
	}
	
	public static boolean[] fillParallel( final boolean[] array, final IntToBooleanFunction function )
	{
		IntStream.range( 0, array.length ).parallel().forEach( i -> array[ i ] = function.applyAsBoolean( i ) );
		return array;
	}
	
	public static IntToBooleanFunction func( final boolean[] array )
	{
		return i -> array[ i ];
	}
	
	public static boolean randomElement( final boolean[] array, final Random random )
	{
		return array == null || array.length == 0 ? false : array[ ( random == null ? ThreadLocalRandom.current() : random ).nextInt( array.length ) ];
	}
}