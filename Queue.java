/*--------------------------------------------------*/
/*Jonathan Molina
/*jomolina@ucsc.edu 
/*CS12B Pa4 
/*methods to be used by Simulation.java
/*---------------------------------------------------*/  


//class Queue 
class Queue implements QueueInterface{
//contructor for Queue  
 private class Node{
       Object cashier; 
       Node next;
       Node(Object B){
       cashier = B;
       next = null;    
       }  
   }
//global variables for Queue
   public Node top, tail;
   private int numItems;

//constructor for Queue class
  public Queue(){
   top  = null;
   tail =  null;
   numItems = 0;
  }

//interface methods
  public boolean isEmpty(){
    return(numItems == 0);
  }
  public int length(){
  return numItems;
  }

//insert at tail
  public void enqueue(Object newItem){
  if( top == null ){
      	top = new Node( newItem );
      		numItems++;
   }else{
      Node B = top;
     while( B.next != null ){
        B = B.next;
     }
      B.next = new Node( newItem );
      	tail = B.next;
      	numItems++;
    } 
  
 } 
//delete at head
  public Object dequeue() throws QueueEmptyException{
  if(top == null){
  throw new QueueEmptyException("cannot dequeue() empty queue");
  } else{
 
  Node B = top;
  top = B.next;
  numItems--;
  return B.cashier;
   }
  }
//look up variables
  public Object peek() throws QueueEmptyException{
  if(top == null){
     throw new QueueEmptyException(" Cannot peek() empty Queue");
  }else{
   

  return top.cashier;
  }
 }
//returns Queue to an empty state
  public void dequeueAll() throws QueueEmptyException{
    if( numItems==0 ){
         throw new QueueEmptyException("cannot dequeueAll() empty queue");
      }else{
      numItems = 0;
      top = null;
      tail = null;
   }
 }
//prints the stack
public String  toString(){
    

    Node B;
    StringBuffer sb = new StringBuffer();
    
    
    for(B = top; B != null; B = B.next){
    sb.append(B.cashier).append("\n");

    }
    return new String(sb);
    }  

}
