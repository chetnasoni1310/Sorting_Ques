import java.util.ArrayList;
import java.util.List;

public class _442_Duplicate_Number_All_In_Array_1_2_N {
        public List<Integer> findDuplicates_1st_Method(int[] nums) {
//    487 mai 5 approach ki thi usmai se 2 apply hoti h idhr 
//    Mark indices visited
//    and Cyclic Sort 
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            return list;
        }
        if (n == 2) {
            if (nums[0] == nums[1]) {
                list.add(nums[0]);
                return list;
            } else {
                return list;
            }
        }
        for(int i=0;i<n;i++)
        {
            int index= Math.abs(nums[i])-1;
            if(nums[index]<0)
            {
                list.add(Math.abs(nums[i]));
            }
            else{
                nums[index]= -nums[index];
            }
        }
        return list;
    }
     
      public List<Integer> findDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int i=0;
        while(i<n)
        {
                int correct=arr[i]-1;               
                if(arr[i]!=arr[correct])
                {
                    swap(arr,i,correct);
                }
            else
            {
                i++;
            }
        }
        for(i=0;i<n;i++)
        {
            if(arr[i]!=i+1)
            {
                list.add(arr[i]);
            }
        }
        return list;
      }
      public void swap(int[]arr,int a,int b)
      {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
      }
}
