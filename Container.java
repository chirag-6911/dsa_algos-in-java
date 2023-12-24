import java.util.*;

public class Container{

    public static int StoreWater(ArrayList<Integer> height){
        //brute force-O(n^2).
        
        int mostwater=Integer.MIN_VALUE;
        
        for(int i = 0; i<height.size()-1;i++){
            for(int j=i+1; j<height.size();j++){
                int currheight = Math.min(height.get(i),height.get(j));
                int currwidth = j-i;
                int t_water = currheight*currwidth;
                if(t_water>mostwater){
                    mostwater=t_water;
                }
            }
        }
        return mostwater;
    }

    public static int Waterstore(ArrayList<Integer> height){
        //2 Pointer approach-O(n).
        int mostwater=Integer.MIN_VALUE;

        int lp=0;//left pointer
        int rp=height.size()-1;//right pointer
        while(lp<rp){
            int h=Math.min(height.get(lp),height.get(rp));//height
            int w=rp-lp;//width
            int currwater=h*w;
            mostwater = Math.max(mostwater,currwater);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return mostwater;


    }
    public static void main(String args[]){
        ArrayList<Integer> height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println("most water contained = "+Waterstore(height));
        
        
    }
}