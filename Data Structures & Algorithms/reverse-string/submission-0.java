class Solution {
    public void reverseString(char[] s) {
        int front = 0;
        int end = s.length-1;

        while(front < end) {
            char temp = s[front];
            s[front] = s[end];
            s[end] = temp;

            front++;
            end--;
        }
    }
}