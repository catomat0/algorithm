class MyCircularQueue {
        
        int[] queue;
        int front = 0, rear = -1, len = 0;
        
        
        public MyCircularQueue(int k) {
            this.queue = new int[k];    
        }

        public boolean enQueue(int value) {
            if (!this.isFull()) {

                this.rear = (this.rear + 1) % this.queue.length;
                this.queue[rear] = value;
                this.len++;
                return true;
            } else {
                return false;
            }
        }

        public boolean deQueue() {
            if (!this.isEmpty()) {
                this.front = (this.front + 1) % this.queue.length;
                this.len--;
                return true;
            } else  {
                return false;
            }
        }

        public int Front() {
            return (this.isEmpty()) ? -1 : this.queue[this.front];
        }

        public int Rear() {
            return (this.isEmpty()) ? -1 : this.queue[this.rear];
        }

        public boolean isEmpty() {
            return this.len == 0;
        }
        
        public boolean isFull() {
            return this.len == this.queue.length;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */