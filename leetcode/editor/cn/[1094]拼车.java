
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 构建差分数组 根据差分数组构建原数组
        int[] diff = new int[1001];

        int[] res = new int[1001];
        for(int i=0; i<trips.length; i++){
            int a = trips[i][1];
            int b = trips[i][2]-1;
            int x = trips[i][0];
            increase(diff, a, b, x);
        }


        // 获取原始数组
        res[0] = diff[0];
        for(int i=1;i<diff.length; i++ ){
            res[i] = res[i-1]+diff[i];
        }

        for(int i=0; i<res.length; i++){
            if(res[i]>capacity){
                return false;
            }
        }
        return true;


    }

    public void increase(int[] diff,int i,int j,int k) {
        diff[i] += k;
        if (j+1 < diff.length) {
            diff[j+1] -= k;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
