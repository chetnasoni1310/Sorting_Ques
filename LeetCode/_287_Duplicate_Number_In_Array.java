import java.util.*;

 /* If modifying the array is allowed: Cyclic Sort or Marking Indices is best O(n) O(1)
If modifying the array is not allowed: Floyd's Cycle Detection is optimal 
HashSet is simple but not space-efficient.
Binary Search is slower but may be used for conceptual clarity.
        */
public class _287_Duplicate_Number_In_Array {
      /*
     * The problem statement says that all the integers in array are in the range of
     * 1 to n , and only one number is repeated. But the problem doesn't say that
     * the integer that is repeated, is repeated only twice, so the repeated integer
     * can be repeated more than twice .
     * 
     * 
     * 
     * 1. Cyclic sort ka use krke karlo                                               =Accepted
     * 2. Floyd's Cycle Detection                                                     =Accepted
     * 3.HashSet for tracking                                                         =Accepted
     * 4.Binary Search on value range                                                 =Accepted
     * 5.Modifying the array visited mark krke                                        =Accepted
     * 6.Using XOR                                                                =NOT Accepted
     */
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int correct = arr[i] - 1;
            if (arr[i] != i +1) {
                if (arr[i] < n && arr[i] != arr[correct]) {
                    swap(arr, i, correct);
                } else {
                    return arr[i];
                }

            } else {
                i++;
            }
        }
        return -1;
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
      
    public static void main(String[] args) {
        int[]arr={1,3,4,2,2};
       
    }
}






                                    /*  6.Using XOR********************************

// public int findDuplicate_6(int[] arr) {
    /*  6.Using XOR
      iski length hai n
      but due to duplicate element ismai number n-1 tk honge
      ex= 1,3,4,2,2
      length=5
      but elements present only till length-1 =5-1 =4
      so XOR all the elements of range 1 to n-1
    then XOR -------------------arr from 0 till length 
    the remaining element will be the duplicate number and
    as bczz >>>>>>>
    harr ek number double ho jayega 2 baar xor krne se 
    Lekin jo pehle se duplicate hai voh 3 times ho jayega 
    toh sirf vahin bachega
    */
//         int xor=0;
//isse krenge toh vhi rhega element
//  only works when there is only 1 time repetition
//         int n=arr.length;
//         for(int i=1;i<n;i++)
//         {
//             xor^=i;
//         }
//         for(int i:arr)
//         {
//             xor^=i;
//         }
//         return xor;
// }




                 // 5.Modifying the array visited mark krke********************************
//  int n=arr.length;
//  for(int i=0;i<n;i++)
//  {
//    int index=Math.abs(arr[i])-1;
   /*yeh krke humne index ki value nikaali jaha pe
     arr[i] ko hona chahiye tha according to 0th based indexing
     this is same like we do in cyclic sort

   -- fir hum dekhenge ki jaha usko hona chahiye tha
     kya voh element negative hai 
   -- (agar negative hai toh iska mtlb hum pehle ek element ko
     check kr chuke hai jiski position same hai mtlb voh dono number bhi 
     same hue)
   -- agar voh negative nahi hai toh mtlb hum 
     pehli baar uss index ke number pe poche hai

   -- toh uss index ke number ko negative bana do  
   -- ki bhai dekh mai terse hoke gujar chuka hu tu ek jane ki seat pe
      baitha hai
   -- agar mai dobara tere tak aaya matlab ki voh element jiske 
      through mai aaya hu voh duplicate hai .
   */

//    if(arr[index]<0)
//    {
//        return Math.abs(arr[i]);
//    }

//    arr[index]= -arr[index];  //Negative kr dia
//  }
//  return -1;




                 /*   4.Binary Search on value range********************************
                //  leverage the pigeonhole principle to find the duplicate.
//                 If you have  𝑛 n "pigeons" (items) and  𝑚 m "pigeonholes" (containers), and 
//             𝑛 > 𝑚  n>m, then at least one pigeonhole must contain more than one pigeon.
toh ismai hum kya karenge ki 
if n=5 i.e. length of arrays 
hum n-1 i.e. jaha tak uss array mai number hai 
kyunki ek toh duplicate hna
udhr binary lagayenge for 
ex: 1,3,4,2,2 this is array
ab [1,4] mai BS
1,2,3,4
s      e
fir 
        
       int start=1;
       int end=n-1;
       while(start<end) {
        int mid=start +(end-start)/2;
        int count=0;    //for counting numbers less than mid
        for(int i:arr)
        {
            if(i<=mid)
            {
                count++;
            }
        }

        if(count<=mid)
        {
            start=mid+1;
        }
        else{
            end=mid;
        }
        
       }
       return start;
*/





       /* 3.HashSet for tracking *****************************
HashMap<Integer , Integer> map=new HashMap<>();
        for(int i:arr)
        {
            map.put(i , map.getOrDefault(i,0)+1);
        }
        for(HashMap.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>1)
            {
                return entry.getKey();
            }
        }
        return -1; */




           /* 2. Floyd's Cycle Detection************************************************** 
        int slow=arr[0];
        int fast=arr[0];
        do{
             slow=arr[slow];
             fast=arr[arr[fast]];
        }while(slow != fast);
   //CyCLE DETECTED
   //NOW find Meeting point
   //That will be the answer
        slow=arr[0];
        while(slow!=fast)
        {
            slow=arr[slow];
            fast=arr[fast];
        }
        return slow;
        */



 /*       --------------------------------1. Cyclic sort ka use krke karlo
 */
