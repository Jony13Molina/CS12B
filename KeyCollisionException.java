/*----------------------------------------*/
/*Jonathan Molina                         */  
/*PA3                                     */
/*CS12B                                   */
/*jomolina                                */ 
/*Exceptions for Dictionary.java          */
/*----------------------------------------*/
public class KeyCollisionException extends RuntimeException{
           public KeyCollisionException(String key){
            super(key);
 }
}
