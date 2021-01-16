import java.util.NoSuchElementException;

public class LinkedList {
    //node class safety er jonno LinkedList class er vitor liklam
    //jate Node LinkedList class er baire theke Node class ke access kora na jai
    //sobgula data private kore dilam
    private class Node {
       private int value;//Node er value store korbe
       private Node next;//Node er next element er reference rakbe
        private Node(int value){
            this.value = value;
        }
    }
    private Node first;// reference of  head
    private Node last;//reference of tail
    private int size;// reference of the list items exist in the list
  public void addLast(int item){
      // Node node = new Node(); eivabe likhe confused hoar dorkar nai
      // kenona java compiler dan side dekhei buje nibe node kon type er object
      //jodi var use kori
      /*
      var node = new Node();
      node.value =  item;
      */
     var node = new Node(item);
     if(isEmpty())// jodi list empty thake tahole List er first & last node eki
         first=last=node;
     else{
         last.next = node;//existing last node er pore ei notun node boslo
         last = node;//last variable jeta node er tail reference kore seta update korlam
     }
     size++;
  }
  public void addFirst(int item){
      var node = new Node(item);
      if(isEmpty())
          first=last=node; //jodi list empty thake
      else {
          node.next = first;// first e notun node er sathe first ke link
          first = node;// then update the first cause head of the list changes
      }
      size++;
  }
  private boolean isEmpty(){ // this will make the code more clean and readable
      return first==null;// list empty thakle janai dibe
  }
  public int indexOf(int item){
      //pura list traverse korbo ekon oi item ke khuje
  int index = 0;
  var current = first;
  while(current!=null){//list er sesh porjonto na jaoa porjonto loop cholbe
      if(current.value==item) return index; // value mile gele index return korbo
      current = current.next;// na mille current ke update kore porer node e jabo
      index++;//current update korle index o update korte hobe
  }
      return -1;// item ta list e exist na korle -1 return korbe
      // jodi list e same element ek er odhik bar thake tahole first occurence er index return kore dibe
  }
  public boolean contains(int item){// ei method e amra indexof method ke reuse korlam
      return indexOf(item)!=-1;// eikhane item khuje paile true return korbe otherwise false return korbe
  // indexOf method integer return kore
  // se jodi uporer contains method er call e -1 return na kore mane list e
  // oi item ta ase taile contains method true return korbe
  // ar -1 return korle mane item ta list ei nai tai contains method
  // false return korbe
  }
  public void removeFirst(){
      if(isEmpty()) throw new NoSuchElementException();
      if(first==last)  //list e jodi ekta element thake
          first = last = null;
      else{
         /*
      ekon amar onek sabdhane korte hobe remove
      ex [10->20->30]
       ami chailei 20 take first banai diye first.next null
      korte parbo nah ete pura list harai jabe
       */
          var second = first.next;//ex [10->20->30] eikhane 20 er reference save raklam
          first = null;// 10 er sathe 20 er bonding remove korlam
          first = second;// ekon first ke 20 e point korlam ekon list hobe [20->30]
      }
      size--;
  }
  public void removeLast(){
      // list jodi empty hoi tahole remove korar kisui thakbe nah sekehetre exception dekhabo
      if(isEmpty())
          throw new NoSuchElementException();
      //list e only ekta element thakle jevabe remove korbo
      if(first==last)
          first=last=null;
      else {
          // [10,20,30]
          // the logic below written is only working for list with atleast two node
          var previous = getPrevious(last); // previous = 20
          last = previous; // last ekon 30 theke 20 ke point korlo
          last.next = null;// 20 er sathe 30 er bondhon chinno kore dilam (garbage collector)
      }
      size--;
  }
  private Node getPrevious(Node node){
      var current = first; // first node er reference nilam
      while(current!=null){
          if(current.next==node) return current;// previous ta list theke ber kore return
          current = current.next;
      }
      return null;
  }
  public int size(){
      return size;
  }
  public int[] toArray(){
      int [] array = new int[size];//list er size motabek array creation
      Node current  = first;//reference rekhe agabo first theke
      int index = 0;//index er reference labge array er khetre
      while(current!=null){//jotokkon nah list sesh hobe totokkon list er item array te bosbe
          array[index++]=current.value;//list er node er value gula array te bose index post increment hocce auto
          current = current.next;//node er iteration
      }
      return array;// array return korbe
  }
  public void reverseList(){
      //List ta inplace reverse korte hobe
      //[10->20->30]
      //hote hobe [30->20->10]
      //onek somossa
      // 10-> 20-> 30
      // p     c    n
      // n = c.next diye reference rakbo
      // link change korbo ekon c.next = p;
      if(isEmpty()) return;
      var previous = first;// p
      var current = first.next;// c
      while (current!=null){
          var next = current.next;// n
          current.next = previous;// link er direction change
          previous = current;
          current = next;
      }
      last = first;
      last.next = null;
      first = previous;
  }
  public int getKthfromtheEnd(int k){
      if(isEmpty()) throw new IllegalStateException();
      //setting two pointers
      // 10 -> 20 -> 30 -> 40-> 50
      // a
      // b
      // if k = 3
      var a  = first;
      var b = first;
      //for loop simulation
      // 10 -> 20 -> 30 -> 40-> 50
      // a
      //        b
      // 10 -> 20 -> 30 -> 40-> 50
      // a
      //              b
      for(int i=0;i<k-1;i++){// this loop will set the distance between two pointers
          b= b.next;
          if(b==null) throw new IllegalArgumentException();
      }
      // while loop simulation
      // 10 -> 20 -> 30 -> 40-> 50
      //        a
      //                    b
      // 10 -> 20 -> 30 -> 40-> 50
      //             a
      //                         b
      while (b!=last){
          a=a.next;
          b=b.next;
      }
      return a.value;
  }
  public void printMiddle() {
        if (isEmpty())
            throw new IllegalStateException();
        var a = first;
        var b = first;
        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }
        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }
    public boolean hasLoop() {
        var slow = first;
        var fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
