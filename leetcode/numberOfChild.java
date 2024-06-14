
class Solution {
    public int numberOfChild(int n, int k) {
        int pos=0;
        int dir =1;
        for(int i=0;i<k;i++){
            pos+=dir;
            if(pos==n-1||pos==0){
                dir=-dir;//reversing the direction if it present in right then it goes to left by decrementing vice versa
            }
        }
        return pos;
    }
}