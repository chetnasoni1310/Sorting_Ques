public class _41_First_Missing_Number{
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n)
        {
            int correct=nums[i]-1;
            
            if(nums[i]>0 && nums[i]<=n && nums[i]!=nums[correct])
            {
                swap(nums,i,correct);
            }
            
              else
            {
                i++;
            }
        }
        for(i=0;i<n;i++)
        {
            if(nums[i]!=i+1)
            {
                    return i+1;
            }
        }
        return nums[n-1]+1;
    }
    public void swap(int[]nums,int a,int b)
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}