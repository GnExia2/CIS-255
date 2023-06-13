


public class test {

  public static int frequency(int[] nums, int target){

     int index;

     int count = 0;

     for(index = 0; index < nums.length; ++index) {

        if(nums[index] == target) {

           ++count;

        }

     }

     return count;

  }
}
