//-------------------------------------------------
//Jonathan Molina
//jomolina
//CS12B
//test for Queue
//-------------------------------------------------


class QueueTest{
    


    public static void main(String[] args){
    String S = "5";
    Queue V = new Queue();
    //Object item; 
 /*   V.enqueue(S);
    V.enqueue("king");
    V.enqueue("hi"); 
    V.enqueue(5);
    V.dequeue(7); 
    V.enqueue("p");
    System.out.println(V);
    //V.dequeue();
    V.dequeueAll();*/
    //System.out.println(V.peek()); 
    //System.out.println(V.isEmpty());
//Second test
    V.enqueue("stuff");
    V.enqueue("yo");
    V.enqueue("hello"); 
    V.enqueue(10);
    V.dequeue(); 
    V.enqueue("Hi");

System.out.println(V.isEmpty());
    }  

}















