public class _268_Missing_Number_0_to_N_Range{
public int missingNumber(int[] nums) {
    /*    *************************MISTAKES********************
       1.maine for each loop use krlia nahi kr skti thi index retrieve
         krna tha 
        2.OVERCONFIDENCEEEEEE
        3.EDGE CASES MISS karr diye  

   /*    *************************MISTAKES********************


    //Pehle cyclic sort ki help se sort krlenge
    //sab apni jgh aajayenge
    //fir check krlenge appn ki konsi jgh pe
    // uska expected element nahi h voh return krdenge  */
   cyclicSort(nums,0);
   for(int i=0;i<nums.length;i++)
   {
       if(nums[i]!=i)
       {
        return i;
       }
   }
     return nums.length;
}
public void cyclicSort(int[]nums,int start)
{
    int n=nums.length;
    for(int i=0;i<n;i++)
    {
        while(nums[i]<n && nums[i]-start !=i)
        {
            swap(nums,i,nums[i]-start);
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