
import java.util.Arrays;
 
public class Sum_of_Subsets {
 
  // prints subset found
  static void printSubset(int[] arr, int size){
      for(int i=0; i<size; i++) System.out.print(arr[i]+" ");
      System.out.println();
  }   
 

  static void subset_sum(int[] arr, int[] result, int arr_size, int result_size, int sum, int nodes_count, int target_sum){
 
    if( target_sum == sum ){
 
      // We found sum
      printSubset(result, result_size);
 
      // constraint check
      if( nodes_count + 1 < arr_size && sum - arr[nodes_count] + arr[nodes_count + 1] <= target_sum ){
 
        // Exclude previous added item and consider next candidate
        subset_sum(arr, result, arr_size, result_size - 1, sum - arr[nodes_count], nodes_count + 1, target_sum);
      }
      return;
    }
    else{
 
      // constraint check
      if( nodes_count < arr_size && sum + arr[nodes_count] <= target_sum ){
 
        // generate nodes along the breadth
        for( int i = nodes_count; i < arr_size; i++ ){
 
          result[result_size] = arr[i];
          if( sum + arr[i] <= target_sum ){
 
            // consider next level node (along depth)
            subset_sum(arr, result, arr_size, result_size + 1, sum + arr[i], i + 1, target_sum);
          }
        }
      }
    }
  }
 

 
  public static void main(String[] args) {
 
    int[] given_array = {15, 22, 14, 26, 32, 9, 16, 8};
    int target_sum = 53;
    Arrays.sort(given_array);
    int size = given_array.length;
    int[] tuplet_vector = new int[size];
    int total = 0;
 
    for(int num: given_array){
      total += num;
    }
 
    if( given_array[0] <= target_sum && total >= target_sum ){
      subset_sum(given_array, tuplet_vector, size, 0, 0, 0, target_sum);
    }

  }
}
 