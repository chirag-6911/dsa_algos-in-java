?
/*Given an integer array nums, return all the triplets [nums[i], nums[j],  nums[k]] 
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.*/
//unsolved.
public class As2{
    public static void main(String args[]){
        int nums[]={-1,0,1,2,-1,-4};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if ((nums[i]+nums[j]+nums[k]) == 0){
                        System.out.print("["+nums[i]+nums[j]+nums[k]+"],");
                    }
                }  
                
            }
        }
    }
}