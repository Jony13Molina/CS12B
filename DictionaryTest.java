import java.util.*;//imports utilities we might use
/*===========================================*/
/*Jonathan Molina                            */    
/*PA 3 CS12B                                 */
/*jomolina                                   */
/* This Assignment checks all functions work */
/*===========================================*/   
public class DictionaryTest{

   public static void main(String[] args){
      
      String v;
      Dictionary A = new Dictionary();
     // A.insert("1","word");
     // A.insert("2","face");
     // A.insert("3","dog");
     // A.insert("4","hair");
     // A.insert("5","hi");
     // A.insert("6","hello");
     // A.insert("7","why");
      
     // v = A.lookup("1");
     //Prints keys found and not found correctly. 
     // System.out.println("Key = 1" +( v == null? "not found" :(" Value = " +v)));
     // v = A.lookup("3");
     // System.out.println("Key = 3" +( v == null? "not found" :(" Value = " +v)));
     // v = A.lookup("7");
     // System.out.println("Key = 7" +( v == null? "not found" :(" Value = " +v)));
     //  v = A.lookup("8");
     // System.out.println("key=8 "+(v==null?"not found":("value="+v)));
     // System.out.println();      
     System.out.println(A.size());//size works but check the if output is correct     
     //System.out.println(A.isEmpty());//works correctly it prints false when it is empty
    // System.out.println(A);//prints the values 7, 6, 5, 4, 3, 2, 1; 
    // A.makeEmpty();//empties correctly
    // System.out.println(A.isEmpty());//correctly checks if is empty after the function makeEmpty is called
   
    System.out.println(A);// keys get printed backwards
  

     
//properly deletes stuff from the Node list
//A.delete("1");
//System.out.println(A.size());
//A.delete("3");
//System.out.println(A.size());
//A.delete("7");
//System.out.println(A.size());
//System.out.println(A);
//System.out.println(A.size());
//checks error exceptions
//A.insert("2","f");
//A.delete("8"); they work out properly
//
//checks found and not found with different keys values
//v = A.lookup("7");
//System.out.println("Key = 7" +( v == null? "not found" :(" Value = " +v)));
//v = A.lookup("3");
//System.out.println("Key = 3" +( v == null? "not found" :(" Value = " +v)));
//v = A.lookup("5");
//System.out.println("Key = 5" +( v == null? "not found" :(" Value = " +v)));
//System.out.println(A);


//checks if size is being subtracted correctly after deleting keys and checks if deletes still works correctly
//A.delete("1");
//System.out.println(A.size());
//A.delete("3");
//System.out.println(A.size());
//A.delete("7");
//System.out.println(A.size());
System.out.println(A);



//checks if insert is working properly
      A.insert("1","a");
      A.insert("2","b");
      A.insert("3","c");
      A.insert("4","d");
      A.insert("5","e");
      A.insert("6","f");
      A.insert("7","g");
      System.out.println(A);// prints in correct order 
       }
}
