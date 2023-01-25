package list.arrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        // 리스트 추가
        list.add(3);
        list.add(50);
        list.add(21);

        // 리스트 인덱스 번호에 추가
        list.add(1,14);

        // 리스트 출력하기
        System.out.println(list);

        // 리스트 인덱스의 값 삭제
        System.out.println("remove: " + list.remove(2));

        // 리스트 길이
        System.out.println("list.size(): "+ list.size());

        // 리스트 값 가져오기
        System.out.println("get idx 0: " +list.get(0));

        // 리스트에 해당 값이 있는지 검색하는 메서드
        System.out.println("indexOf: " + list.indexOf(33));

        // iterator
        // hasNext() and next()
        ArrayList.ListIterator li = list.iterator();
        while(li.hasNext()){
            if((int)li.next() == 14){
               // li.add(34);
                li.remove();
            }
        }
        System.out.println(list);

        // hasPrevious() and previous();
        System.out.println("previous");
        while(li.hasPrevious()){
            System.out.println(li.previous());

        }


    }
}
