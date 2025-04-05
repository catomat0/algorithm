class MyQueue {

        Deque<Integer> inputs = new ArrayDeque<>();
        Deque<Integer> outputs = new ArrayDeque<>();
        
        public MyQueue() {
        }

        public void push(int x) {
            inputs.push(x);
        }

        public int pop() {
            
            peek();
            
            return outputs.pop();
        }

        public int peek() {

            if (outputs.isEmpty()) {
                while (!inputs.isEmpty()) {
                    outputs.push(inputs.pop());
                }
            }
            
            return outputs.peek();
        }

        public boolean empty() {
            return inputs.isEmpty() && outputs.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */