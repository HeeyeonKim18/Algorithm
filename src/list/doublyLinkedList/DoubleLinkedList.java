package list.doublyLinkedList;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    // 첫번째 노드 값 추가하는 메서드
    public void addFirst(Object input) {
        Node newNode = new Node(input); // 새로운 값을 담을 Node 객제 생성
        newNode.next = head;    // 기존의 헤드 값을 newNode.next 값으로 담아줌
        if(head != null) head.prev = newNode;    // head가 참조하고 있는 노드의 이전 값은 newNode
        head = newNode; // newNode는 이제 새로운 head 값이 됨
        size++; // 사이즈 추가하기
        if (head.next == null) tail = head; // head.next가 없다면 다른 값이 존재하지 않는다는 뜻으로 tail 값 보다 head 값
    }

    // 해당 인덱스에 새로운 노드 값 추가
    public void add(int idx, Object input) {
        if (idx == 0) addFirst(input);  // 인덱스가 0이면 첫 번째 값이니까 addFirst 메서드 실행
        else {
            Node temp1 = node(idx - 1); // temp1에는 추가되는 인덱스 이전 노드 값을 가져오기
            Node temp2 = temp1.next;    // temp2는 새로운 노드의 next의 값으로 설정해줘야 하기 때문에 현재 temp1의 다음 값을 넣어주기
            Node newNode = new Node(input); // 새로운 노드 객체 생성
            temp1.next = newNode;   // temp1의 next 값은 새로운 노드 값으로 넣기
            newNode.next = temp2;   // 새로운 노드의 next값은 temp2 지정
            if(temp2 != null) temp2.prev = newNode; // temp2가 존재한다면 temp2의 이전 값은 newNode
            newNode.prev = temp1;   // newNode의 이전 값은 temp1
            size++; // 새로운 노드 값이 들어왔으니 사이즈 증가
            if (newNode.next == null) tail = newNode;   // 새로운 노드 값의 next가 null일 때는 tail이 새로운 노드 값임
        }
    }

    // 마지막 노드 추가하는 메서드
    public void addLast(Object input) {
        Node newNode = new Node(input); // 새로운 노드 객체 생성
        if (size == 0) addFirst(input); // 사이즈가 0이라는 것은 노드가 존재하지 않는다는 뜻으로 새로운 노드가 첫 번째 값이 됨
        else {
            tail.next = newNode; // 현재 마지막 노드의 next 값으로 newNode 지정
            newNode.prev = tail;    // newNode의 이전 값은 현재 tail이 참조하고 있는 노드
            tail = newNode; // tail값은 newNode로 변경
            size++; // 새로운 노드 삽입으로 사이즈 증가
        }
    }

    // 리스트를 출력하는 메서드
    public String toString() {
        if (head == null) return "[]";
        Node temp = head;
        String str = "[";
        while (temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        str += temp.data;
        return str + "]";
    }

    // 해당 인덱스의 노드가 무엇인지 조회하는 메서드, 내부에서만 사용된다. get과 같은 역할
    Node node(int idx) {
        if(idx < size / 2){
            Node x = head;
            for (int i = 0; i < idx; i++) x = x.next;
            return x;
        }else{
            Node x = tail;
            for(int i = size -1; i > idx; i--) x = x.prev;
            return x;
        }
    }

    // 첫 번째 노드를 삭제하는 메서드
    public Object removeFirst() {
        Node temp = head;   // temp에 현재 첫 번째 값 삽입
        head = head.next;   // head를 첫 번째 다음 값인 두 번째 노드 값을 설정
        Object returnData = temp.data;  // 삭제할 첫 번째 노드 값 저장
        temp = null;    // temp 값 삭제
        if(head != null) head.prev = null;  // head가 존재한다면 head의 이전 값 없애기
        size--; // 하나 제거됐으니 사이즈 감소
        return returnData;  // 제거된 값 출력
    }

    // 해당 인덱스 값 삭제
    public Object remove(int idx) {
        if(idx == 0) return removeFirst();  // 인덱스가 0이라는 것은 첫 번째 노드 값으로 removeFirst메서드 사용
        else{
            Node tmp = node(idx -1);    // tmp 값에 이전 인덱스 값을 찾아서 넣기
            Node todoDeleted = tmp.next;    // tmp.next 값은 삭제될 노드 값으로 변수에 저장
            tmp.next = tmp.next.next;   // tmp.next의 값을 tmp.next.next로 설정
            if(tmp.next != null) tmp.next.prev = tmp;    // tmp 다음 값의 이전 값은 tmp값이 되도록 설정
            Object returnData = todoDeleted.data;   // 삭제될 데이터 값을 변수에 저장
            if(todoDeleted == tail) tail = tmp; // 삭제데이터가 마지막 노드라면 tmp가 tail이 되게 설정
            todoDeleted = null; // 삭제 값 제거
            size--; // 삭제되었으니 사이즈도 감소
            return returnData;
        }
    }

    // 마지막 노드 값 제거하는 메서드
    public Object removeLast() {
        return remove(size-1);
    }

    // 리스트 사이즈 출력하는 메서드
    public int size() {
        return size;
    }

    // 해당 인덱스 노드 값 출력하는 메서드
    public Object get(int idx) {
        Node tmp = node(idx);
        return tmp.data;
    }

    // 해당 값을 가지고 있는 인덱스를 출력하는 메서드
    public int indexOf(Object data) {
        Node tmp = head;    // 첫 번째 노드 값을 tmp에 담기
        int idx = 0;    // 인덱스 세는 변수
        while(tmp.data != data){    // 노드의 데이터가 입력된 데이터와 같지 않다면 반복
            tmp = tmp.next; // tmp는 그 다음 값으로 변경
            idx++;  // 인덱스는 증가됨
            if(tmp == null) return -1;  // 해당 데이터 값이 없다면 tmp가 마지막 노드 값까지 갈 것이고 -1 출력
        }
        return idx;
    }

    // iterator 객체 생성하는 메서드
    public ListIterator listIterator() {
        return new ListIterator();
    }

    // ListIterator 내부 클래스
    class ListIterator{
        private Node next;
        private Node lastReturned;
        private int nextIdx;
        ListIterator(){
            next = head;
        }

        // 다음 노드 값을 출력하는 메서드
        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIdx++;
            return lastReturned.data;
        }

        // 출력할 next가 있는지 없는지 알려주는 메서드
        public boolean hasNext() {
            return nextIdx < size();
        }

        public Object previous(){
            if(next == null) lastReturned = next = tail;
            else lastReturned = next = next.prev;
            nextIdx--;
            return lastReturned.data;
        }

        public boolean hasPrevious(){ return nextIdx > 0; }
        // 해당 인덱스에 노드 값을 삽입하는 메서드
        public void add(Object input) {
            Node newNode = new Node(input);
            if(lastReturned == null){
                head = newNode;
                newNode.next = next;
            }else{
                lastReturned.next = newNode;
                newNode.prev = lastReturned;
                if(next != null) {
                    newNode.next = next;
                    next.prev = newNode;
                }else{
                    tail = newNode;
                }
            }
            lastReturned = newNode;
            nextIdx++;
            size++;
        }

        // 해당 인덱스에 노드 값을 제거하는 메서드
        public void remove() {
            if(nextIdx == 0)
                throw new IllegalStateException();
            Node n = lastReturned.next;
            Node p = lastReturned.prev;

            if(p == null){
                head = n;
                head.prev = null;
                lastReturned = null;
            }else{
                p.next = next;
                lastReturned.prev = null;
            }

            if(n == null){
                tail = p;
                tail.next = null;
            }else n.prev = p;

            if(next == null) lastReturned = tail;
            else lastReturned = next.prev;
            size--;
            nextIdx--;
        }
    }

    // 데이터와 다음 노드 값을 저장하는 변수를 가진 Node 클래스
    private class Node {
        private Object data;    // 데이터 값 저장
        private Node next;  // 다음 데이터 값을 가지고 있는 노드 값을 담는 역할
        private Node prev;  // 이전 데이터 값을 가짐

        // 생성자를 통해 data 값을 담기
        public Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }

    }
}
