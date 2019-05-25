/*Joanthan Molina
CS12B
*Lab 5
*jomolina
*
*
*Program looks up words contain in an array
*deletes stuff from array
*adds stuff to list 
*/ 
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Dictionary.h"
unsigned int rotate_left(unsigned int value, int shift);
unsigned int pre_hash(char* input);
int hash(char* key);
const int tableSize = 101;
//private types 
typedef struct NodeObj{
     char* key;
     char* value;
     struct NodeObj* next;
}NodeObj;

//Node 
typedef NodeObj* Node;

//newNode()
//contructor of NodeType
Node newNode(char* A, char* B){
Node Al = malloc(sizeof(NodeObj));
assert(Al != NULL);
Al->key = A;
Al->value = B;
Al->next = NULL;
return(Al);
}

//freenode 
//destructs Node
void freeNode(Node *pAl){
   if(pAl != NULL && *pAl != NULL){
   free(*pAl);
   *pAl = NULL;
   }

}
//DictionaryObj array
typedef struct DictionaryObj{
  Node* head;
  int  numItems;
}DictionaryObj;
//a reference of a Dictionary obj
typedef DictionaryObj* Dictionary; 
//helper function for Dictionary                              
 Node findKey(Dictionary D, char* key){
    int h = hash(key);

     Node Al = D->head[h];
      for(; Al!= NULL; Al = Al->next){
	    if(strcmp(Al->key, key)==0){

                return Al;
            } 
    }	
    return NULL;        
}
//public functions// 
//constructs Dictionary obj
Dictionary newDictionary(void){
   Dictionary  D = malloc(sizeof(DictionaryObj));
   assert(D != NULL);
   D->head = malloc( tableSize*sizeof(Node));
   assert(D->head != NULL);
   for(int i = 0; i < tableSize; i++){
   D->head[i] = NULL;
   D->numItems = 0;
  }
   return D;
}
//free Dictionary
//destructor for Dictionary
void freeDictionary(Dictionary* pD){
   if(pD != NULL && *pD != NULL){
      if( !isEmpty(*pD)) 
      makeEmpty(*pD);
      free(*pD);
      *pD = NULL;
    
   }
}
//isEmpty()
//returns 1(true) if D is empty, 0 (false) otherwise
//pre: none
int isEmpty(Dictionary D){
  if(D == NULL){
    fprintf(stderr, "Stack Error: Calling isEmpty() on Null Dictionary Reference\n");
    exit(EXIT_FAILURE);
   }
   return(D->numItems==0);
}
//size()
//returns the size of the list
//pre: None
int size(Dictionary D){
return(D->numItems);
}
//looks up word
char* lookup(Dictionary D, char* k){

if(findKey(D, k)==NULL){
    return NULL;
  }else{
    Node Al;
    Al = findKey(D, k);
    return Al->value;
  }
}

//inserts keys and values 
void insert(Dictionary D, char* k, char* v){
Node Al;
int h = hash(k);
if( D == NULL){
   fprintf(stderr, "Dictionary Error: Calling Insert on Null Dictionary reference\n");
   exit(EXIT_FAILURE);
  }else if(lookup(D,k)!=NULL){
    fprintf(stderr, "Dictionary Error: Inserting Duplicate key\n");
    exit(EXIT_FAILURE);
  }
   else{
    if(D->head[h]  == NULL){
      Al = newNode(k,v);
      D->head[h] = Al;
      D->numItems++;
    }else{
      Al = newNode(k, v);
      Al->next = D->head[h];
      D->head[h] = Al;
      D->numItems++;
    }
   //free(&Al);
}
}
//deletes keys  
void delete(Dictionary D, char* k){
      
   int h = hash(k);
   Node P = D->head[h];
   if( D == NULL ){
      fprintf(stderr, "Dictionary Error: calling delete() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);

   }else if( lookup(D, k) == NULL ){
      fprintf(stderr, "Dictionary Error: cannot delete none existing key\n");
      exit(EXIT_FAILURE);
   }
   
   if(D->head[h]->key == k){
    D->head[h] = D->head[h]->next;
   }
   for( Node H = D->head[h] ; H != NULL; H = H->next){
    if(H->key == k){
       
        P->next = H->next;
         H->next = NULL;
       } 
       P = H;
       }
       D->numItems--;
      
   // free(&P);
}
//returns everything to an empty state
void makeEmpty(Dictionary D){
 
for( int h = 0; h < tableSize; h++){
 D->numItems = 0;
 freeNode(&D->head[h]);
}
 }

//prints the values and keys 
void printDictionary(FILE* out, Dictionary D){


for(int h = 0; h < tableSize; h++){
Node Al = D->head[h];
  while( Al != NULL){
    fprintf(out,"%s %s \n",Al->key,Al->value);
    Al = Al->next;
     
 }
}
}

 // rotate_left()
 // rotate the bits in an unsigned int
 unsigned int rotate_left(unsigned int value, int shift) {
 int sizeInBits = 8*sizeof(unsigned int);
   shift = shift & (sizeInBits - 1);
    if ( shift == 0 )
      return value;
      return (value << shift) | (value >> (sizeInBits - shift));
 }
      // pre_hash()
      // turn a string into an unsigned int
unsigned int pre_hash(char* input) {
  unsigned int result = 0xBAE86554;        
  while (*input) {
     result ^= *input++;
     result = rotate_left(result, 5);
  }
   return result;
}
// hash()
// turns a string into an int in the range 0 to tableSize-1
int hash(char* key){
return pre_hash(key)%tableSize;
}
             









  
