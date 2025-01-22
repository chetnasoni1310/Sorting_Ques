import java.util.ArrayList;
import java.util.List;

public class _448_Missing_ALL_Number_1_to_N_Range{

public List<Integer> findDisappearedNumbers(int[] nums) {

        /*
         * GOOGLE QUESS
         * Implement cyclic sort fist
         * Then store them in the List
         */

        cyclicSort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= i+1) {
                list.add(i+1);
            }
        }
        return list;

    }
    
public void cyclicSort(int[]nums)
{
    int n=nums.length;
    int i=0;
    while(i<n)
    {
        int correct=nums[i]-1;
        if(nums[i]!=nums[correct] && nums[i]<=n)
        {
          swap(nums,i,correct);
        }
        else{
            i++;
        }
    }
}
public void swap(int[]nums,int a,int b)
{
    int temp=nums[a];
    nums[a]=nums[b];
    nums[b]=temp;
}
}


       