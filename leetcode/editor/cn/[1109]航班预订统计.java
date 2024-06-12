
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        int[] diff = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            // bookings的每一个元素都相当于对数组的[first,last]范围的元素增加seats
            int x = bookings[i][0] - 1;
            int y = bookings[i][1] - 1;
            int k = bookings[i][2];
            increase(diff,x,y,k);
        }
        // 根据差分数组还原结果
        answer[0] = diff[0];
        for (int i=1; i<n; i++) {
            answer[i] = answer[i-1] + diff[i];
        }
        return answer;
    }

    // 差分数组思想：数组的[i,j]范围内的元素增加k，相当于diff[i]+k，dff[j+1,dff.length)-k
    public void increase(int[] diff,int i,int j,int k) {
        diff[i] += k;
        if (j+1 < diff.length) {
            diff[j+1] -= k;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
