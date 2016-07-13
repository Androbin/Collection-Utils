package de.androbin.collection.util;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public final class ObjectCollectionUtil
{
	private ObjectCollectionUtil()
	{
	}
	
	public static <T> T[] fill( final T[] array, final T element )
	{
		Arrays.fill( array, element );
		return array;
	}
	
	public static <T> T[] fill( final T[] array, final IntFunction<T> function )
	{
		Arrays.setAll( array, function );
		return array;
	}
	
	public static <T> T[] fillParallel( final T[] array, final IntFunction<T> function )
	{
		Arrays.parallelSetAll( array, function );
		return array;
	}
	
	public static <T> IntFunction<T> func( final T[] array )
	{
		return i -> array[ i ];
	}
	
	public static <T> T randomElement( final T[] array, final Random random )
	{
		return array == null || array.length == 0 ? null : array[ ( random == null ? ThreadLocalRandom.current() : random ).nextInt( array.length ) ];
	}
	
	public static <T> T randomElement( final List<T> list, final Random random )
	{
		return list == null || list.isEmpty() ? null : list.get( ( random == null ? ThreadLocalRandom.current() : random ).nextInt( list.size() ) );
	}
}