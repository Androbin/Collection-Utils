package de.androbin.collection.util;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public final class DoubleCollectionUtil
{
	private DoubleCollectionUtil()
	{
	}
	
	public static double[] fill( final double[] array, final double element )
	{
		Arrays.fill( array, element );
		return array;
	}
	
	public static double[] fill( final double[] array, final IntToDoubleFunction function )
	{
		Arrays.setAll( array, function );
		return array;
	}
	
	public static double[] fillParallel( final double[] array, final IntToDoubleFunction function )
	{
		Arrays.parallelSetAll( array, function );
		return array;
	}
	
	public static IntToDoubleFunction func( final double[] array )
	{
		return i -> array[ i ];
	}
	
	public static double randomElement( final double[] array, final Random random )
	{
		return array == null || array.length == 0 ? 0.0 : array[ ( random == null ? ThreadLocalRandom.current() : random ).nextInt( array.length ) ];
	}
}