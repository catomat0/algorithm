class MyHashMap {

    static class Node {
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    final Node[] nodes = new Node[100000];

    public void put (int key, int value) {

        // 해싱 결과 인덱스 저장
        int index = key % nodes.length;
        // 노드 없으면 생성 후 종료
        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }
        // 인덱스에 노드 존재하면 연결 리스트 처리
        Node node = nodes[index];
        while (node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            // 다음 노드 없으면 종료
            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        node.next = new Node(key, value);

    }

    public int get(int key) {
        int index = key % nodes.length;
        if (nodes[index] == null) {
            return -1;
        }
        Node node = nodes[index];
        while (node != null) {
            if (node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % nodes.length;
        if (nodes[index] == null) {
            return;
        }
        Node node = nodes[index];

        if (node.key == key) {
            if (node.next == null) {
                nodes[index] = null;
            } else {
                nodes[index] = node.next;
            }
        }

        Node prev = node;
        while (node != null) {
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */