/*====================================================*/ 
/*Jonathan Molina                                     */
/*CS12B PA2                                           */
/*jomolina                                            */
/*4/19/2015                                           */
/*Program serches for word given a file input         */  
/*the user has to type the word it wants to search    */
/*====================================================*/    



//imports utilities we might use
import java.io.*;
import java.util.Scanner;
import java.util.*;     
//class search
class Search{
     static Scanner in;// input file scan
     static String[] word;//array to store input of word
     static int[] lineNumber;    // array to keep track of lines 
    public static void main( String[] args) throws IOException{
    in = null;
    
    word = null;
    lineNumber =  null;    
    String wordline = null;     
     int  i;
     int lineC = 0;//lineCount begins at zero
    //check command line for arguments 
    if(args.length < 2){
     System.out.println("Usage: Search File target1 [target2...]");
     System.exit(1);
   }


//makes a scanner
Scanner in = new Scanner(new File(args[0]));

//takes in input
while(in.hasNextLine()){
   lineC++;
  in.nextLine();
  
}
// another scanner to scan the next line otherwise if I use in.next i will get an error no line found
Scanner scanny = new Scanner(new File(args[0]));

word = new String [lineC];//string array lincount

lineNumber = new int[lineC];//int array linecount
//scans in the next word
for( i =0;  scanny.hasNextLine(); i++){
word[i] = scanny.nextLine();
}
//call to mergeSort
mergeSort(word, lineNumber, 0, word.length-1);
//print the out when the words are found
for( i = 1; i < args.length; i++){
if(word[i].compareTo(args[i]) > 0){//prints the word found
System.out.println(binarySearch(word, 0, word.length-1, args[i])  + " found on line "+lineC);
}
if(word[i].compareTo( args[i]) < 0){//prints words not found 
System.out.println(binarySearch(word, 0, word.length-1, args[i]) + " not found");
 }
 } 
     
    

in.close();

    }// closes main method

static void  mergeSort( String[] word, int[] lineNumber, int p, int r){
int q;


if(r > p){
q = (p+r)/2; //recursion the middle index is calculated
mergeSort(word, lineNumber,  p, q); //gets the middle index from the previous on
mergeSort(word, lineNumber, q+1, r);
merge(word, lineNumber, p, q, r);
   }
                }//closes mergeSort

static void merge(String[] word, int[] lineNumber, int p, int q , int r){
int n1 = q-p+1;
int n2 = r-q;

String[] L = new String[n1];
String[] R = new String[n2];


int i, j, k;
for(i=0; i<n1; i++){
      L[i] = word[p+i];
      }
      for(j=0; j<n2; j++){
      R[j] = word[q+j+1];
      }
      i = 0; j = 0;
      for(k=p; k<=r; k++){
         if( i<n1 && j<n2 ){
            if(j > i ){
               word[k] = L[i];
               i++;
            }else{
               word[k] = R[j];
               j++;
            }
         }else if( i<n1 ){
            word[k] = L[i];
            i++;
         }else{ // j<n2
            word[k] = R[j];
            j++;
         }
       }
     
   
  }//closes merger


public static String binarySearch(String[] word, int p, int r, String s1){
      int q;
      if(p == r) {
         return s1;
      }else{
         q = (p+r)/2;
         if(word[q].compareTo(s1) == 0){
            return s1;
         }else if(word[q].compareTo(s1) < 0){
            return binarySearch(word, p, q, s1);
         }else{ // s1 > word[q]
            return binarySearch(word, q+1, r, s1);
         }
      }
   }//closes binarySearch


 
}//closes the class












       
