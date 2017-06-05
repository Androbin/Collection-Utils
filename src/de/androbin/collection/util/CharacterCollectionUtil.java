package de.androbin.collection.util;

import de.androbin.function.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public final class CharacterCollectionUtil {
  private CharacterCollectionUtil() {
  }
  
  public static char[] fill( final char[] array, final char element ) {
    Arrays.fill( array, element );
    return array;
  }
  
  public static char[] fill( final char[] array, final IntToCharFunction function ) {
    for ( int i = 0; i < array.length; i++ ) {
      array[ i ] = function.applyAsChar( i );
    }
    
    return array;
  }
  
  public static char[] fillParallel( final char[] array, final IntToCharFunction function ) {
    IntStream.range( 0, array.length ).parallel()
        .forEach( i -> array[ i ] = function.applyAsChar( i ) );
    return array;
  }
  
  public static IntToCharFunction func( final char[] array ) {
    return i -> array[ i ];
  }
  
  public static char randomElement( final char[] array, final Random random ) {
    return array == null || array.length == 0 ? (char) Character.UNASSIGNED
        : array[ ( random == null ? ThreadLocalRandom.current() : random )
            .nextInt( array.length ) ];
  }
}