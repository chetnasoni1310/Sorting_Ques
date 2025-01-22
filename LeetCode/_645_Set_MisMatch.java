public class _645_Set_MisMatch{


    public int[] findErrorNums(int[] nums)
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
   
    for(i=0;i<n;i++){
        if(nums[i]!=i+1)
        {
            return new int[]{nums[i],i+1};
        }
    }
    return new int[]{-1,-1};

}
public void swap(int[]nums,int a,int b)
{
    int temp=nums[a];
    nums[a]=nums[b];
    nums[b]=temp;
}
}