package de.androbin.collection.util;

import de.androbin.function.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public final class FloatCollectionUtil
{
	private FloatCollectionUtil()
	{
	}
	
	public static float[] fill( final float[] array, final float element )
	{
		Arrays.fill( array, element );
		return array;
	}
	
	public static float[] fill( final float[] array, final IntToFloatFunction function )
	{
		for ( int i = 0; i < array.length; i++ )
		{
			array[ i ] = function.applyAsFloat( i );
		}
		
		return array;
	}
	
	public static float[] fillParallel( final float[] array, final IntToFloatFunction function )
	{
		IntStream.range( 0, array.length ).parallel().forEach( i -> array[ i ] = function.applyAsFloat( i ) );
		return array;
	}
	
	public static IntToFloatFunction func( final float[] array )
	{
		return i -> array[ i ];
	}
	
	public static float randomElement( final float[] array, final Random random )
	{
		return array == null || array.length == 0 ? 0f : array[ ( random == null ? ThreadLocalRandom.current() : random ).nextInt( array.length ) ];
	}
}