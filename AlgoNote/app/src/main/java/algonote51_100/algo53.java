package algonote51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class algo53 {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> re = new ArrayList<>();
        for(int i= n-1;i>=2;i--){
            if(nums[i]<0){
                break;
            }else{
                if(i>0 &&nums[i] == nums[i-1]){
                    continue;
                }
                int x = 0;
                int y = i-1;
                while(x<y){
                    int sum = nums[x] + nums[y]+nums[i];
                    if(sum==0){
                        List<Integer> list = new ArrayList();
                        list.add(nums[x]);
                        list.add(nums[y]);
                        list.add(nums[i]);
                        re.add(list);
                        x++;
                        while(x<y&&nums[x] == nums[x+1] ){
                            x++;
                        }
                        y--;
                        while(x<y&&nums[y] == nums[y-1]){
                            y--;
                        }
                    }else if(sum<0){
                        x++;
                    }else{
                        y--;
                    }
                }
            }
        }
        return re;
    }
}
