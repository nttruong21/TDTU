public class Exercise8 {

    // Exercise b

    public static int countEven(LinkedList<Integer> list) {
        int count = 0;
        for(Node<Integer> temp = list.getHead(); temp != null; temp = temp.getNext()) {
            if(temp.getData() % 2 == 0) {
                count ++;
            }
        }
        return count;
    }
    
    public static int comSum(LinkedList<Integer> list) {
        int sum = list.getHead().getData();
        for(Node<Integer> temp = list.getHead().getNext(); temp != null; temp = temp.getNext()) {
            sum += temp.getData();
        }
        return sum;
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(10);
        list.addFirst(-20);
        list.addFirst(5);
        list.printList();
        System.out.println(" Total even number in linked list: " + countEven(list));
        System.out.println(" Sum all number in linked list: " + comSum(list));
    }
}
