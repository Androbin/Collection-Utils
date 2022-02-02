package de.androbin.collection.util;

import de.androbin.func.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public final class ByteCollectionUtil {
  private ByteCollectionUtil() {
  }
  
  public static byte[] fill( final byte[] array, final byte element ) {
    Arrays.fill( array, element );
    return array;
  }
  
  public static byte[] fill( final byte[] array, final IntToByteFunction function ) {
    for ( int i = 0; i < array.length; i++ ) {
      array[ i ] = function.applyAsByte( i );
    }
    
    return array;
  }
  
  public static byte[] fillParallel( final byte[] array, final IntToByteFunction function ) {
    IntStream.range( 0, array.length ).parallel()
        .forEach( i -> array[ i ] = function.applyAsByte( i ) );
    return array;
  }
  
  public static IntToByteFunction func( final byte[] array ) {
    return i -> array[ i ];
  }
  
  public static byte randomElement( final byte[] array, final Random random ) {
    return array == null || array.length == 0 ? 0
        : array[ ( random == null ? ThreadLocalRandom.current() : random )
            .nextInt( array.length ) ];
  }
}