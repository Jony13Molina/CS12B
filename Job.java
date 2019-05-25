//================================================
//Jonathan Molina
//jomolina
// Job.java
//PA4 CS12B
//
//================================================
 import java.io.*;
public class Job{
public static final int UNDEF = -1;
private int arrival;
private int duration;
private int finish;
// constructor
 public Job(int arrival, int duration){
this.arrival = arrival;
this.duration = duration;
this.finish = UNDEF;
}// accessfunctions
public int getArrival(){return arrival;
}
public int getDuration(){return duration;
}
public int getFinish(){return finish;
}
public int getWaitTime(){
if( finish==UNDEF ){
System.err.println("Job: getWaitTime(): undefinedfinish time");
System.exit(1);
}
return finish-duration-arrival;
}
// manipulation procedures
public void computeFinishTime(int timeNow){
finish = timeNow + duration;
}
public void resetFinishTime(){
finish = UNDEF;
}// toString(): overrides Object's toString() method
public String toString(){
return "("+arrival+", "+duration+", "+(finish==UNDEF?"*":String.valueOf(finish))+")";
    }

}
