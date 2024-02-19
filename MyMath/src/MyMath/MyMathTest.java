package MyMath;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;


class MyMathTest {


	/**
	 * Returns the square root (rounded down) of the give nonnegative number.
	 *
	 * @pre The given number must be nonnegative
	 * 	| 0 <= x
	 * @post The result is the smallest nonnegative integer whose square is not greater than the given number
	 * 	| 0 <= result &&
	 * 	| result * result <= x &&
	 * 	| x < (result + 1) * (result + 1)
	 *
	 * */
	int sqrt(int x) {
		return (int)Math.sqrt(x);
		
	}
	
	/**
	 * Returns the largest integer of 3 given integers
	 * 
	 * @pre three given integers
	 * 
	 * @post the returned integer is larger or equal to the other two
	 * 	|result >= x &&
	 * 	|result >= y &&
	 * 	|result >= z
	 * 
	 * */

	int max3(int x, int y, int z) {
		if (x >= y && x >= z ) {
			return x;
		}
		if (y >= x && y >= z ) {
			return y;
		}	
		if (z >= x && z >= y ) {
			return z;
		}
		return 0;
	}
	
	/**
	 *  Geeft de index terug van het eerste voorkomen van 'needle' in 'haystack', of -1 als 'needle' niet voorkomt in 'haystack'.
	 *  
	 *  @pre een array van integers 'haystack' dat mogelijk leeg is en een integer 'needle'
	 *   |haystack != null
	 *  
	 *  @post )
	 *  | !(haystack.length > 0 && haystack[0] == needle) || result == 0
	 *  @post
	 *  | result != -1 || IntStream.range(0, haystack.length).allMatch(i -> haystack[i] != needle)
	 *  
	 *  
	 *  
	 * */
	int find(int[] haystack, int needle) {
		for (int i = 0; i < haystack.length; i++) {
			if (haystack[i] == needle) return i;
		}
		return -1;
	}
	
	
	/**
	 * Sorteert de getallen in de gegeven array van klein naar groot.
	 * 
	 * @pre | tosort != null
	 * 
	 * @mutates | tosort
	 * 
	 * @post tosort has to be a sorted version of the array that was given as the input
	 * 	| IntStream.range(1, tosort.length).allMatch(i -> tosort[i -1] <= tosort[i]) 
	 * 
	 * */
	
	void sort(int[] tosort) { // 
		for (int i = 0; i < tosort.length; i++)	{
			int minIndex = minindex( Arrays.copyOfRange(tosort, i, tosort.length+1));
			int temp = tosort[minIndex];
			tosort[minIndex] = tosort[i];
			tosort[i] = temp;
		}
	}
	
	int minindex(int[] list) {
		int minindex = -10000;
		for (int i = 0; i < list.length; i++) {
			if (list[i] > list[minindex]) {
				minindex = i;
			}
		}
		return minindex;
	}
	
	
	/**
	 * Vervangt elk getal in de gegeven array door zijn negatie
	 * 
	 * @pre
	 * 
	 * @post instream.range(0, )
	 * 
	 * */
	

	void negatie(int[] getallen) {
		for (int i = 0; i < getallen.length; i++) {
			getallen[i] = -getallen[i];
		}
	}
	
	/**
	 * 
	 * @pre argumenten zijn verschillend van elkaar
	 * 	|x!=y && y!=z && x!=z
	 * @post het resultaat is gelijk aan x, y of z
	 * 	|result == x || result == y || result == z
	 * @post het resultaat is kleiner dan x of y of z
	 * 	|result < x || result < y || result < z
	 * @post het resultaat is groter dan x, y of z
	 * 	| result > x || result > y || result > z
	 * 
	 * 
	 * 
	 * */
	
	int mediaan(int x, int y, int z) {
		// hier moet rare code die niet duidelijk is als illustratie dat de pre en post belangrijk zijn
		// ooit implementeren als ik zin heb
		return 0;
	
	}
		
		

	
	void verwissel(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
		
	
	
	/**
	 * @pre |array != null
	 * @pre | 0 <= index && index < array.length
	 * 
	 * @mutates |array
	 * 
	 * @post | array[index] = old(array[index]) + bedrag
	 * @post 
	 * |IntStream.range(0, array.length).allMatch(i->i == index || array[i] == old(array.clone())[i])
	 * 
	 * 
	 * */
	
	void verhoogElement(int[] array, int index, int bedrag) {
		array[index] += bedrag;
	}

		
		

	
	@Test
	void test() {
		assertEquals(3, sqrt(9));
		assertEquals(0, sqrt(0));
		assertEquals(3, sqrt(15));
		assertEquals(4, sqrt(16));
		
		assertEquals(3, max3(1,2,3));
		assertEquals(9, max3(1,9,9));
	}

}
