public class Main2 {
    public static void main(String[] args) {
//        LinkedList<String> list=new LinkedList<String>();
//        list.addFirst("10");
//        list.addFirst("20");
//        list.addFirst("30");
//        System.out.println(list);
        LinkedList list = new LinkedList();
    list.addLast(10);// [10]
    list.addLast(20);//[10,20]
    list.addLast(20);//[10,20,20]
    list.addFirst(4);//[4,10,20,20]
//        System.out.println(list.size());
//        System.out.println(list.indexOf(20));
//        System.out.println(list.contains(4));
//        list.removeFirst();//[10,20,20]
//        list.removeLast();//[10,20]
//        System.out.println(list.size());
//        System.out.println(list);
//        list.reverseList();
//        var array = list.toArray();
//        System.out.println(Arrays.toString(array));
        System.out.println(list.getKthfromtheEnd(4));
        list.printMiddle();

    }
}
