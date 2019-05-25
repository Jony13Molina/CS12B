//-----------------------------------------------------------------------------
//Jonathan Molina
//jomolina
//CS12B
//DictionaryTest.c
//Test  for the Dictionary ADT
//-----------------------------------------------------------------------------
//import all the stuff we might use or need
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"Dictionary.h"


//tests the insert function
int main(int argc, char* argv[]){
   Dictionary A = newDictionary();
   char* k;
   char* v;
 
/*   char* word1[] = {"hey","perro","twin","california","million","billion","seven"};
   char* word2[] = {"3","5","blah7","7","7","9","O"};
   int i;
//tests the insert function
   for(i=0; i<7; i++){
      insert(A, word1[i], word2[i]);
*///Insert does not work insert does not get called
  // }
 // insert(A, "five", "glow"); // error: duplicate key the error works well exception gets thrown
  // printDictionary(stdout, A);


 delete(A, "one");
   delete(A, "three");
   delete(A, "seven");

   printDictionary(stdout, A);

   for(i=0; i<7; i++){
      k = word1[i];
      v = lookup(A, k);
      printf("key=\"%s\" %s\"%s\"\n", k, (v==NULL?"not found ":"value="), v);
   }

   // delete(A, "one");  // error: key not found error gets thrown functionality works well
   //test for the empty
    /* printf("%s\n", (isEmpty(A)?"true":"false"));
     printf("%d\n", size(A));
     makeEmpty(A);
     printf("%s\n", (isEmpty(A)?"true":"false"));
    */ //empty does not work error when inserting or deleting or in makeempty
//second test for insert
 char* word1[] = {"one","two","three","four","five","six","seven"};
   char* word2[] = {"foo","bar","blah","galumph","happy","sad","blue"};
   int i;

   for(i=0; i<7; i++){
      insert(A, word1[i], word2[i]);
   }

   printDictionary(stdout, A);


//second test for make empty     
     printf("%s\n", (isEmpty(A)?"true":"false"));
     printf("%d\n", size(A));
     makeEmpty(A);
     printf("%s\n", (isEmpty(A)?"true":"false"));
     freeDictionary(&A);
  
     return(EXIT_SUCCESS)



}
