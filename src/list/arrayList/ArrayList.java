package list.arrayList;

public class ArrayList {
    // 리스트 배열 생성하기
    private Object[] elementData = new Object[100];

    // 리스트 사이즈 초기화
    private int size = 0;

    // 리스트 추가
    public boolean add(Object element) {
        elementData[size] = element;
        size++;
        return true;
    }

    // 지정 인덱스에 값 추가
    public boolean add(int idx, Object element) {
        for(int i = size-1; i >= idx; i--){
            elementData[i+1] = elementData[i];
        }
        elementData[idx] = element;
        size++;
        return true;
    }

    // 리스트 출력하기
    public String toString(){
        String str = "[";
        for(int i = 0; i < size; i++){
            str += elementData[i];
            if(i < size-1) str += ",";
        }
        return str + "]";
    }

    // 리스트 값 삭제
    public Object remove(int idx) {
        Object removed = elementData[idx];
        for(int i = idx+1; i <= size -1; i++){
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null;
        return removed;
    }

    // 해당 인덱스 값 가져오기
    public Object get(int idx) {
        return elementData[idx];
    }

    // 리스트 사이즈 가져오기
    public int size() {
        return size;
    }

    // 해당 값이 존재한다면 인덱스 값 가져오고 아니면 -1 출력하기
    public int indexOf(Object element) {
        for(int i = 0; i < size -1; i++){
            if(element.equals(elementData[i])) return i;
        }
        return -1;
    }

    // iterator 라는 메서드 생성
    public ListIterator iterator() {
        return new ListIterator();

    }

    // Iterator 내부 클래스
    class ListIterator{

        // 인덱스 수 증가하는 변수
        private int nextIdx = 0;

        // nextIdx 값을 증가하여 다음 인덱스의 값을 출력하는 메서드
        public Object next() {
            return elementData[nextIdx++];
        }

        // 다음 인덱스의 값이 있는지 확인하여 true, false 값을 출력하는 메서드
        public boolean hasNext() {
            return nextIdx < size;
        }

        // 이전 인덱스의 값을 가져오는 메서드로 nextIdx의 값을 감소시킴
        public Object previous() {
            return elementData[--nextIdx];
        }

        // 이전 인덱스가 존재하는지 여부를 확인하는 메서드, 0보다 크다면 이전 값이 존재한다는 뜻
        public boolean hasPrevious() {
            return nextIdx > 0;
        }

        public void add(Object element) {
            ArrayList.this.add(nextIdx++, element);
        }

        public void remove() {
            ArrayList.this.remove(nextIdx -1);
            nextIdx--;
        }
    }
}
