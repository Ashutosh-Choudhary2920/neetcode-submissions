class Pair {
    int min;
    int val;
}
class MinStack {
    Stack<Pair> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        Pair pair = new Pair();
        pair.val = val;
        pair.min = stack.isEmpty() ? val : Math.min(val, getMin());
        stack.push(pair);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
