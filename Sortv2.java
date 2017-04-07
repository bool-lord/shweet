import java.util.Arrays;
import java.util.List;

/**
 * A collection of sorting algorithms.
 * 
 * @author A. Jacoby (20 March 2017)
 */
public class Sortv2 {
  /** Sorts vals (in increasing order) using a bubble sort algorithm. */
  public static int[] bubble(int[] vals) {
    /* Two optimizations included here:
     * 1. Stops after first pass in which no swaps occur, and
     * 2. stops each pass once it reaches the sorted section at the end. */
    
    StdDraw.setXscale(0.0, 2.0);
    StdDraw.setPenRadius(.01);
    StdDraw.enableDoubleBuffering();
    
    boolean unsorted = true;
    while (unsorted) {
      unsorted = false;
      int sorted = 0; // # elements which have bubbled up to end of array
      for (int i = 0; i < vals.length-1-sorted; i++) {
        if (vals[i] > vals[i+1]) {
          ArrayUtils.swap(vals, i, i+1);
          
          /**drawing*/
          for (int j = 0; j < vals.length; j++) {
            StdDraw.line(.1 + (.05 * j), 0, .1 + (.05 * j), vals[j] * .03);
            if (j == vals.length - 1) {
              StdDraw.show(); //show each step of sort
              StdDraw.pause(50);
            }
          }
          unsorted = true; 
        }
        StdDraw.clear(); //clear image
      }
      sorted++;
    } return vals; //added own return
  }
  
  /**
   * Tests the bubble() method with a variety of arrays.
   * You should try a variety of lengths (including 0 and 1), and some that are
   * already sorted (or sorted in reverse), as well as random ones.
   */
  public static void testBubble() {
    int[][] testArrays = {
      {}, // empty array
      {1}, // 1 element
      {1, 2}, {2, 1}, {1, 1}, // all 2 element varieties
      {1, 2, 3}, {1, 3, 2}, {1, 1, 0}, // a few 3 element varieties
      ArrayUtils.randInts(100, 1, 1000) // a largish random one
    };
    for (int[] vals : testArrays) {
      bubble(vals);
      if (!isSorted(vals)) { System.err.println("Failed to sort: " + Arrays.toString(vals)); }
    }
  }
  
  /** Bubble sort on List of integers. */
  public static List bubble(List<Integer> vals) {
    /** Clone of array version. */
    boolean unsorted = true;
    while (unsorted) {
      unsorted = false;
      int sorted = 0; // # elements which have bubbled up to end of array
      for (int i = 0; i < vals.size()-1-sorted; i++) {
        if (vals.get(i) > vals.get(i+1)) {
          // swap elements at i and i+1
          int tmp = vals.get(i+1);
          vals.set(i+1, vals.get(i));
          vals.set(i, tmp);
          unsorted = true;
        }
      }
      sorted++;
    } return vals; //added own return
  }
  
  public static void testBubbleList() {
    List<Integer> vals = Arrays.asList(new Integer[] {4, 2, 2, 10, 5, 0});
    bubble(vals);
    if (!isSorted(vals)) { System.err.println("Failed to sort: " + vals); }
  }
  
  
  
  public static boolean isSorted(int[] vals) {
    for (int i = 0; i < vals.length - 1; i++) {
      if (vals[i] > vals[i+1]) { return false; }
    }
    return true;
  }
  
  public static boolean isSorted(List<Integer> vals) {
    for (int i = 0; i < vals.size() - 1; i++) {
      if (vals.get(i) > vals.get(i+1)) { return false; }
    }
    return true;
  }
  
  public static void main(String[] args) {
    int[] r = {5, 3, 1, 13, 6, 4, 3, 2, 4, 2, 15, 1, 3, 6, 2, 4, 5, 6, 8, 9, 9, 3, 4, 2, 23, 2, 4, 6, 1, 4, 6, 8, 11, 3, 21};
    bubble(r);
  }
}