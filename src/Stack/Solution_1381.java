package Stack;

public class Solution_1381 {
    class CustomStack {

        int[] array;
        int size = 0;
        int maxSize;

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            array = new int[maxSize];
        }

        public void push(int x) {
            if (size + 1 > maxSize) return;
            array[size++] = x;
        }

        public int pop() {
            if (size == 0) return -1;
            size--;
            return array[size];
        }

        public void increment(int k, int val) {
            if(size == 0)
                return;
            int m = k - 1;
            if (k >= size)
                m = size - 1;
            for (int i = 0; i <= m; i++) {
                array[i] += val;
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
