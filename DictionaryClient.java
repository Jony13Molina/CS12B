/*====================================================*/
/*Jonathan Molina                                     */
/*CS12B PA3                                           */  
/*jomolina                                            */
/*This file prints the size of the linked list deletes*/
/*contents and inserts contents to the linked list    */
/*====================================================*/  

 class DictionaryClient{

	 public static void main(String[] args){
//inserts contents
		 String v;
		 Dictionary A = new Dictionary();
		 A.insert("1","a");
		 A.insert("2","b");
		 A.insert("3","c");
		 A.insert("4","d");
		 A.insert("5","e");
		 A.insert("6","f");
		 A.insert("7","g");
		 System.out.println(A);//prints keys and values 
//looks up string in link list and reports if found or not
		 v = A.lookup("1");
		 System.out.println("key=1 "+(v==null?"not found":("value="+v)));
		 v = A.lookup("3");
		 System.out.println("key=3 "+(v==null?"not found":("value="+v)));
		 v = A.lookup("7");
		 System.out.println("key=7 "+(v==null?"not found":("value="+v)));
		 v = A.lookup("8");
		 System.out.println("key=8 "+(v==null?"not found":("value="+v)));
		 System.out.println();

		 //A.insert("2","f");  // causes KeyCollisionException
//deletes contents
		 A.delete("1");
		 A.delete("3");
		 A.delete("7");
		 System.out.println(A);

		//A.delete("8");  // causes KeyNotFoundException
//empties list and prints is current size and reports wether is full or not true/false
		 System.out.println(A.isEmpty());
		 System.out.println(A.size());
		 A.makeEmpty();
		 System.out.println(A.isEmpty());
		 System.out.println(A);

          }                                                        
 }
