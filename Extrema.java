/*==================================================================*/
/*Jonathan Molina                                                   */
/*jomolina                                                          */   
/*Prgram 1 CS12B                                                    */ 
/*4/5/2015                                                          */ 
/*This Program prints the max and mins of the array using recursion.*/
/*==================================================================*/   


import java.util.*;// imports all utilities we might use 

class Extrema{
         static int max;
         static int min;
         static int tempmaxR;
         static int tempmaxL;
         static int tempminR;
         static int tempminL;
//main method is where all the magic happens the statement are ptinted and the other methods are referenced in the print statements
           public static void main(String args[]){
           int [] B = { -1, 2,6, 3,9, 2, -3, -2, 11, 5, 7};
           System.out.println("max = " + maxArray(B, 0, B.length-1));
           System.out.println("min = " + minArray(B, 0, B.length-1));
}//closes main method 

           static int maxArray( int[] A, int p, int r){
           int q = (p+r)/2;//5
           int s = ((q+1)+r)/2;//8
           int h = ((q+1)+s)/2;//7
           int o = (p+q)/2;//2
           int b = (p+o)/2;//1
           int c = ((o+1)+q)/2;//4
  
//only one element           
           if( p == r){
           max = A[p];
           }
//recursion left and right     
	   if(q < r){
		   if(A[h] > A[q+1]){
			   tempmaxR = A[h];
		   }else{
			   tempmaxR = A[q+1];
		   }
		   if(A[s] > A[h]){
			   tempmaxR = A[s];
		   } else{
			   tempmaxR = A[h];
		   }
		   if(A[r] > A[r-1]){
			   tempmaxR = A[r];
		   }else{
			   tempmaxR = A[r-1];
		   }
		   if(A[s] > A[r-1]){
			   tempmaxR = A[s];
		   }else{
			   tempmaxR = A[r-1];
		   }
		   if(p < q){//this is where the recursion to the left begins 
			   if( A[o] > A[b]){
				   tempmaxL = A[o];
			   } else{
				   tempmaxL = A[b];
			   }
			   if(A[o] > A[p]){
				   tempmaxL = A[o];
			   }else{
				   tempmaxL = A[p];
			   }
			   if(A[c] > A[o+1]){
				   tempmaxL = A[c];
			   }else{
				   tempmaxL  = A[o+1];       
			   }
			   if(A[c] > A[q]){
				   tempmaxL = A[c];
			   }else{
				   tempmaxL    = A[q];
			   } 
			   if(A[c] > A[b]){
				   tempmaxL = A[c];
			   }else{
				   tempmaxL = A[b];

			   }
			   if(tempmaxR > tempmaxL){
				   max = tempmaxR;
			   }else{
				   max =  tempmaxL;
			   }
		   }
	   }
          return max;
	 	     
} //closes max method    

          static int minArray(int [] A, int p, int r){
          int q = (p+r)/2;//5
          int s = ((q+1)+r)/2;//8
          int t = (q+s)/2;//6
          int o = (p+q)/2;//2
          int v = (p+o)/2;//1
          int u = ((o+1)+q)/2;//4
                 
          if(p == r){
          min = A[p];
           } 
//recursion left and right        
	  if( q < r){
		  if(A[s] > A[t]){
			  tempminR = A[t];
		  }else{
			  tempminR = A[s];
		  }
		  if(A[t] < A[t+1]){
			  tempminR = A[t];
		  }else{
			  tempminR = A[t+1];
		  }
		  if(A[r] > A[r-1]){
			  tempminR = A[r-1];
		  }else{
			  tempminR = A[r];
		  }
		  if(A[r-1] > A[t]){
			  tempminR = A[t];
		  }else{
			  tempminR = A[r-1];
		  }
		  if(p < q){// checks left side recursion
			  if(A[o] > A[v]){
				  tempminL = A[v];
			  }else{
				  tempminL = A[o];
			  }
			  if(A[o] > A[p]){
				  tempminL = A[p];
			  }else{
				  tempminL = A[o];
			  } 
			  if(A[u] > A[o+1]){
				  tempminL = A[o+1];
			  }else{
				  tempminL = A[u];
			  }
			  if(A[u] > A[q]){
				  tempminL = A[q];
			  }else{
				  tempminL = A[u]; 
			  }
			  if(A[q] > A[p]){
				  tempminL = A[p];
			  }else{
				  tempminL = A[q];
			  }
		  }
		  if(tempminL > tempminR){
			  min = tempminR;
		  }else{
			  min = tempminL;
		  }
	  }
          return min;  


}//closes min method 



      
}// closes the class called extrema 

//Recursion is pretty cool but takes more lines of code :)


