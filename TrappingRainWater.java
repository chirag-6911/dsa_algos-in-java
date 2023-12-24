public class TrappingRainWater{
    public static int water(int height[]){
        //calculate left max boundry
        int left_max_boundry[]=new int [height.length];
        left_max_boundry[0]=height[0];
        for(int i=1;i<height.length;i++){
            left_max_boundry[i]=Math.max( height[i], left_max_boundry[i-1]);
        }
        //calculate right max boundry
        int right_max_boundry[]=new int [height.length];
        right_max_boundry[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            right_max_boundry[i]=Math.max (height[i],right_max_boundry[i+1]);
        }
        //loop
        int tp=0;//trapped water
        for(int i=0;i<height.length;i++){
            int wl=Math.min(left_max_boundry[i],right_max_boundry[i]);//water level=min(leftmax, rightmax)
            int tp1=wl-height[i];//traped water = waterlevel - height
            tp+=tp1;//traped water + previous traped water
        }
        return tp;
        
        //return traped water
        
            
    }
    public static void main(String args[]){
        int height[]={4,2,0,6,3,2,5};
       System.out.print("trapped water = "+ water(height));
    }
}