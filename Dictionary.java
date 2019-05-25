import java.util.*;
/*========================================================*/
/*Name: Jonathan Molina                                   */
/*CS12B                                                   */
/*PA 3                                                    */
/*jomolina                                                */  
/*This file only describes and adds functionality to the  */
/*dictionary interface                                    */
/*========================================================*/


//class dictionary implementing all methods from Dictionary interface
class Dictionary implements DictionaryInterface{
	//private inner node class 
	private class Node{
		String key, value;
		Node next;
		Node(String pairA, String pairB){
			key = pairA;
			value = pairB; 
			next = null;

		}

          }
    

	public Node head;// makes 
        private int numItems;
	
	//constructor for Dictionary class
	public Dictionary(){
		head = null;
		numItems = 0;
               
	}
        

	//private method helper function 
	private Node findKey(String key){
		Node H;
		for(H = head; H!= null; H = H.next){
	            if(H.key.equals(key)){

                         return H;
                    } 
                             
	        }
		
		return null;
	}//closes findkey
	//ADT METHODS BEGIN HERE!!!!!!
	public boolean isEmpty(){
		return(numItems == 0);

	}

	public int size(){
		return numItems;
	}
	public String lookup(String key){
		Node H = findKey(key);
                if(H != null){
                  return H.value; 
	        }else{
                  return null;
                }
        }//closes lookup method
	public void insert( String key, String value)
	     throws KeyCollisionException{
           Node H;
                
             if(lookup(key) != null ){
                throw new KeyCollisionException("Cannot insert duplicate keys");
             
              }else if( head == null){
                H = new Node(key, value);
                head = H;
                numItems++;
             }else{
               H = head;
               while(H != null){
                 if(H.next == null){
                 break;
                }
                H = H.next;
                }
                H.next = new Node(key, value);
                numItems++;
              }
           }         
	    

                        
	
		     
       
	public void delete(String key)
               throws KeyNotFoundException{
                Node Pre = head;
		if(lookup(key) == null){
			throw new KeyNotFoundException("Cannot delete non-existent key.");
		}
		if(head.key.equals(key)){
			head = head.next;
			
		}
	
               
		for(Node H = head; H != null; H = H.next){
                  
                 
		 if(H.key.equals(key)){ 
		      Pre.next = H.next;
                      H.next = null;                
				 
		}
	        Pre = H;	
		}
                numItems--;
		
               return;
	}
     public void makeEmpty(){	
         head = null;
         numItems = 0;
     }	
  
   
    public String  toString(){
    Node H;
    StringBuffer sb = new StringBuffer();
    
    
    for(H = head; H != null; H = H.next){
    sb.append(H.key).append(H.value).append("\n");

    }
    return new String(sb);
    
    
   
  }

}
