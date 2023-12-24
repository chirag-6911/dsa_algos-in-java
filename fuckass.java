import java.util.*;

public class fuckass{
    public static boolean PairSum1(ArrayList<Integer> list,int t){
        //brute force
        //for(int i=0; i<list.size(); i++){
        //    for(int j=i+1; j<list.size(); j++){
        //        int sum = list.get(i)+list.get(j);
        //        if(sum == t){
        //            return true;
        //        }
        //    }
        //}
        //return  false;



        //2 pointer approach
        int lp = 0;
        int rp = list.size()-1;
        while(lp<rp){
            if(list.get(lp)+list.get(rp)==t){
                return true;
            }else if(list.get(lp)+list.get(rp)<t){
                lp++;
            }else{
                rp--;
            }

        }
        return false;

    }
    public static boolean pairsum2(ArrayList<Integer> list, int t){
        int bp=-1; //breaking point
        int n=list.size();
        for(int i =0; i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        int lp=bp+1;//smallest element
        int rp=bp;//largest element
        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==t){
                return true;
            }
            else if(list.get(lp)+list.get(rp)<t){
                lp=(lp+1)%n;
            }else{
                rp=((n+rp)-1)%n;
            }
        }
        return false;
    }



    public static void main(String args[]){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 5;

        System.out.print(pairsum2(list,target));


    }
}