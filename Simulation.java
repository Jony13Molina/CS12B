//-----------------------------------------------------------------------------
// Jonathan Molina
// jomolina
// CS12B
// PA4
//program calculates times of m jobs 
//-----------------------------------------------------------------------------

import java.io.*;
import java.util.Scanner;

public class Simulation{

//helper functions  
    public static void TrcP( PrintWriter T, Queue[] Sim, int nJ, int tJ ){
    		T.println( "time = " + tJ );
    		for( int i = 0; i < nJ + 1; i++ )
		{
      			T.println( i + ": " + Sim[i] );
    		}
  	}
	
	
	  	public static int itemIndexG( Queue[] Sim ){
    	int SimI = 0;
    	   if( ((Job)Sim[SimI].peek() ).getFinish() == -1 ){
           SimI = 1;
      	   }
           for( int i = 1; i < Sim.length; i++ ){
      	      if( Sim[i].length() < Sim[SimI].length() ){
                if(Sim[i].length() == Sim[SimI].length() ){
                     SimI = SimI;
                }
				else{
                  SimI = i;
                }
      	      }
			  else if( Sim[i].length() < Sim[SimI].length() && ( (Job)Sim[SimI].peek() ).getFinish() != -1 ){
                SimI = SimI;
      	      }
    	   }
    	    return SimI;
  	}  





 public static Job getJob(Scanner in) {
      String[] s = in.nextLine().split(" ");
      int a = Integer.parseInt(s[0]);
      int d = Integer.parseInt(s[1]);
      return new Job(a, d);
   }
   public static int JobN(Scanner in){
    int a;
    String inS = in.nextLine();
    a = Integer.parseInt(inS);
    return a;
  }



//main method

   public static void main(String[] args) throws IOException{
          Scanner in = null;
          PrintWriter Rpt = null;
          PrintWriter Trc = null;
          Queue QueS = new Queue();

          int  nJob, mJob, timeJ, FinishJ, nextJ;
          int MwaitT = 0;
          int Twt =0 ;  
          int Mx = 0; 
          float AvgT = 0;
//check command line arguments 
      if (args.length < 1){
        System.err.println("Usage: Simulation in out");
        System.exit(1);
      }
      
//opens files for reading 
       in  = new Scanner(new File(args[0]));
       Rpt = new PrintWriter( new FileWriter(args[0]+".rpt"));
       Trc = new PrintWriter( new FileWriter(args[0]+ ".trc")); 
//read in m jobs/ run simulation with n processors/declare and initialize array
mJob = JobN(in);

while(in.hasNext()){
      QueS.enqueue((Job)getJob(in));
    }
    Trc.println("Trace file: " + args[0] +".trc");
    Trc.println(mJob + " Jobs:");
    Trc.println(QueS+"\n");
    
    for( nJob = 1; nJob < mJob; nJob++){
      timeJ = 0;
      
      Queue[] Sml = new Queue[nJob+1];
      for(int i=0; i < nJob +1; i++){
        Sml[i]= new Queue();	
      }
      Sml[0] = QueS;
      if(nJob == 1){
      	Rpt.println( "REPORT FILE: " + args[0] + "rpt." );
	Rpt.println( mJob + " Jobs:" );
	Rpt.println( Sml[0] + "\n" );
	Rpt.println( "********************************************" );

        Trc.println( "*****************************" );
      	Trc.println( nJob + " PROCESSOR: " );
      	Trc.println( "*****************************" );
      } 
      if( nJob > 1 ){
	Trc.println( "*****************************" );
	Trc.println( nJob + " PROCESSORS: " );
	Trc.println( "*****************************" );
       }
//while loop 
      while( ( (Job)Sml[0].peek()).getFinish() == -1  || Sml[0].length()!= mJob ){
       if( timeJ == 0 ){
	TrcP( Trc, Sml, nJob, timeJ );
        timeJ = ( (Job)Sml[0].peek() ).getArrival();
        Sml[1].enqueue( Sml[0].dequeue() );
        Job Tjob = (Job)Sml[1].peek();
        Tjob.computeFinishTime( timeJ );
	    }
		else if( ( (Job)Sml[0].peek() ).getFinish() != -1 ){
        nextJ  = itemIndexG( Sml );
        timeJ  = ( (Job)Sml[nextJ].peek() ).getFinish();
        Sml[0].enqueue( Sml[nextJ].dequeue() );
        TrcP( Trc, Sml, nJob, timeJ );
        }
		else{
        TrcP( Trc, Sml, nJob, timeJ );
        nextJ = itemIndexG( Sml );
        
       if( Sml[nextJ].length() == 0 ){
          
           timeJ = ( (Job)Sml[0].peek() ).getArrival();
           Sml[nextJ].enqueue( Sml[0].dequeue());
           Job Tjob = (Job)Sml[nextJ].peek();
           Tjob.computeFinishTime( timeJ );
           TrcP( Trc, Sml, nJob, timeJ );
            					
	   nextJ = itemIndexG(Sml);
           timeJ = ( (Job)Sml[nextJ].peek() ).getFinish();
           Sml[0].enqueue( Sml[nextJ].dequeue() );
           TrcP(Trc, Sml, nJob, timeJ); 
           
           nextJ = itemIndexG( Sml );
           timeJ = ( (Job)Sml[0].peek() ).getArrival();
           Sml[nextJ].enqueue( Sml[0].dequeue() );
           Tjob = (Job)Sml[nextJ].peek();
           Tjob.computeFinishTime( timeJ);
           TrcP( Trc, Sml, nJob, timeJ ); 
           
           timeJ = ( (Job)Sml[nextJ+1].peek() ).getFinish();
           Sml[0].enqueue( Sml[nextJ+1].dequeue() );
           TrcP( Trc, Sml, nJob, timeJ );
       
           nextJ = itemIndexG( Sml );
           timeJ = ( (Job)Sml[nextJ-1].peek() ).getFinish();
           Sml[0].enqueue( Sml[nextJ-1].dequeue() );
           TrcP( Trc, Sml, nJob, timeJ );
        } 
		else if( ( (Job)Sml[0].peek() ).getArrival() <= ( (Job)Sml[nextJ].peek() ).getFinish() ){
            timeJ = ( (Job)Sml[0].peek() ).getArrival();
            Sml[nextJ].enqueue( Sml[0].dequeue() );
            TrcP( Trc, Sml, nJob, timeJ);
            
            timeJ = ( (Job)Sml[nextJ].peek() ).getFinish();
            Sml[0].enqueue( Sml[nextJ].dequeue() );
            Job Tjob = (Job)Sml[nextJ].peek();
            Tjob.computeFinishTime( timeJ );
            TrcP( Trc, Sml, nJob, timeJ);  
           }
		   else{
            Job Tjob = (Job)Sml[nextJ].peek();
            Tjob.computeFinishTime( timeJ );
            TrcP( Trc, Sml, nJob, timeJ );
            
            timeJ = ( (Job)Sml[nextJ].peek() ).getFinish();
            Sml[0].enqueue( Sml[nextJ].dequeue() );
            TrcP( Trc, Sml, nJob, timeJ );
           }
          }//closes else
       }//close while
           Queue tempQ = new Queue();
      	   while( Sml[0].length() != 0 ){
            Mx= ( (Job)Sml[0].peek() ).getWaitTime();
            if( MwaitT < Mx ){
               MwaitT = Mx;
            }
            Twt += ( (Job)Sml[0].peek() ).getWaitTime();
        	tempQ.enqueue( (Job)Sml[0].dequeue() );
      	     }
      	     AvgT = ((float)Twt/Mx);
      	     Rpt.println( nJob + " PROCESSOR: totalWait = " + Twt + " maxWait = " + MwaitT + " averageWait = " + AvgT );
      
      	    while( tempQ.length() != 0 ){
        			( (Job)tempQ.peek() ).resetFinishTime();
        			 QueS.enqueue( (Job)tempQ.dequeue() );
      	    }
      	    Trc.println();
            }
            in.close();
    	    Rpt.close();
            Trc.close();
    
  }//closes main

}//closes class
