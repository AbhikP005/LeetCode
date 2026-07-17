class MinStack {
    // taking the datatype long so that if the formula give greater than the value of INTEGER its secured
    Stack<Long> s = new Stack<>();
    Long minVal;

    public MinStack() {
        
    }
    
    public void push(int value) {
        // If stack is Empty
        if(s.isEmpty()) { 
            s.push((long) value); // converting value(int) to long
            minVal = (long) value; 
            return;
        }

        // When the value is lesser than minVal
        if(value < minVal) {
            // 2L is considered when Long is used tho 2 will give same output
            s.push(2L * value - minVal); // FORMULLA
            minVal = (long) value;
        } else {
            s.push((long) value);
        }
    }
    
    public void pop() {
        // If the top element is lesser than minVal
        if(s.peek() < minVal) {
            minVal = 2*minVal - s.peek();
        }
        s.pop();
    }
    
    public int top() {
        // If the top element is lesser than minVal
        if(s.peek() < minVal) {
            return minVal.intValue();
        } else {
            // Normal operation
            return s.peek().intValue(); // the long value is converted into Long bcs return type is int
        }
    }
    
    public int getMin() {
        return minVal.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */