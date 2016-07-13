package de.androbin.collection.util;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public final class IntegerCollectionUtil
{
	private IntegerCollectionUtil()
	{
	}
	
	public static int[] fill( final int[] array, final int element )
	{
		Arrays.fill( array, element );
		return array;
	}
	
	public static int[] fill( final int[] array, final IntUnaryOperator function )
	{
		Arrays.setAll( array, function );
		return array;
	}
	
	public static int[] fillParallel( final int[] array, final IntUnaryOperator function )
	{
		Arrays.parallelSetAll( array, function );
		return array;
	}
	
	public static IntUnaryOperator func( final int[] array )
	{
		return i -> array[ i ];
	}
	
	public static int randomElement( final int[] array, final Random random )
	{
		return array == null || array.length == 0 ? 0 : array[ ( random == null ? ThreadLocalRandom.current() : random ).nextInt( array.length ) ];
	}
}