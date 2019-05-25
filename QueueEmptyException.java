//----------------------------------------------------------
//Jonathan Molina
//CS12B
//Pa4
//just a runtime exception
//----------------------------------------------------------




public class QueueEmptyException extends RuntimeException{
          public QueueEmptyException(String key ){
             super(key);
           }
}
