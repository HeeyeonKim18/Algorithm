package list.linkedList;

public class Main {
    public static void main(String[] args) {
        // LinkedList 객체 생성
        LinkedList linked = new LinkedList();
        // 첫번째 노드 추가하는 메서드
        linked.addFirst(30);
        linked.addFirst(20);
        linked.addFirst(10);
        linked.addFirst(5);
        // 마지막 노드 추가하는 메서드
        linked.addLast(40);
        // 해당 인덱스에 값을 추가
        linked.add(2, 25);
        // 첫번째 노드 삭제
        System.out.println(linked.removeFirst());
        // 해당 인덱스 노드 삭제
        System.out.println(linked.remove(0));
        // 마지막 인덱스 노드 삭제
        System.out.println(linked.removeLast());
        // toString
        System.out.println(linked);
        // list 사이즈 출력
        System.out.println("size: " + linked.size());
        // 해당 인덱스 값 출력
        System.out.println("get(0): " + linked.get(0));
        // 해당 값을 가진 인덱스 출력
        System.out.println("indexOf(30): " + linked.indexOf(30));

        // iterator 클래스 객체 생성
        LinkedList.ListIterator i = linked.listIterator();
        i.add(5);
        i.add(60);
        System.out.println(linked);
        i.remove();
        while(i.hasNext()){
            System.out.print(i.next() + " ");
        }

    }

}
