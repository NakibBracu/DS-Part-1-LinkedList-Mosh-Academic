import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // LinkedList <int> = new LinkedList<int>; //this will give error cause it is primitive we have to write the whole class
        LinkedList list = new LinkedList(); // kisu nah khali create holo list
        list.addLast(10);// [ 10 ]
        list.add(20); // [ 10, 20 ]
        list.addLast(10); // [ 10 , 20 , 10 ]
        list.add(30);// [ 10 , 20 , 10 , 30 ]
        list.addFirst(50); // [ 50 , 10 , 20 , 10 , 30 ]
        System.out.println(list);
        System.out.println(list.size()); // return size of the array means 5
        System.out.println(list.indexOf(10));// find the first occurance of the given element which is 1
        System.out.println(list.contains(10)); // return true if found the item in the list , false otherwise
        var array = list.toArray();// eikhane variable er jaigai onno kisu dile kaj korbe nah, var runtime e datatype automatically niye nei
        System.out.println(Arrays.toString(array)); // array ta list na niye print korlam
    }

}
