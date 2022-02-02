package de.androbin.collection.util;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

public final class LongCollectionUtil {
  private LongCollectionUtil() {
  }
  
  public static long[] fill( final long[] array, final long element ) {
    Arrays.fill( array, element );
    return array;
  }
  
  public static long[] fill( final long[] array, final IntToLongFunction function ) {
    Arrays.setAll( array, function );
    return array;
  }
  
  public static long[] fillParallel( final long[] array, final IntToLongFunction function ) {
    Arrays.parallelSetAll( array, function );
    return array;
  }
  
  public static IntToLongFunction func( final long[] array ) {
    return i -> array[ i ];
  }
  
  public static long randomElement( final long[] array, final Random random ) {
    return array == null || array.length == 0 ? 0L
        : array[ ( random == null ? ThreadLocalRandom.current() : random )
            .nextInt( array.length ) ];
  }
}