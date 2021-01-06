setTimeout(f1,how many millisec should elapse before csalling)
this is having nested order function so well call them as higher order function
we can do it in node cause the only two function available are these two 
while executing it takes firrrst two sec wiat and then execute

geoLocation(f1,f2)
geoLocation(succes,failure)
higher order functions

it will try to locate your current coorrdinate and then calls
in jquery how did we handled events
button > oncllick > call some functions .
consol is a kind of global object a javascript object 
it exposes method annd properties 
a method that we studied was .log()

Ignore global object in ppt

Node.js Globals ignoreCase

-Process global object 
Every Node.js script runs in its own process 
to know everything about that process there is a process object created 
whenever process , we can gain whatever info with help of process and methods

String Args in main method 
command line arguments can be accsed from string

In a process following are arranged 

env function returns an object with  current 

char* argv[] --Array contasining the command line argumenytt
 the 1st elemnt is node 2nd elemnt be Javascript file the next will 
be the other element of array 

execPath 
process.execPath where is nodejs intalled in my machine 

cwd()
exit()


Example
ProcessCLA.js
syntax
>|node |processClA.js| kavita| pname=sunita|
   1         2           3          4
   array of command line  arguments  
two arguments being passed 
how to extract these arguments
heere the actual command like argumenbts are starting from second place  

consol.log(process.argv);
process.argv.foreach((val,index)=> {console.log('${index}:${val}')}
const args = process.argv.slice(2);
for slicing 
in ppt


|||||||||||||||||actual impoprtant|||||||||||||||
MODULE SYSTEM Nodejs 
module in node is encapsulation of logic like .js file is a module
module in node are considered as indipedent functionality 

string.h -- library in java script we call it as a module 
string.h - strlen(), strcpy()
functionality as similar in c 
#include<string.h>
 main(){
	 
 }
--------------------

java.util(list,ArrrayLiost,Date);
impoort java.util.*;
classMyClass{
	
}
-----------------
Module1.js(JS code -vars,function,object,class)

first.js
require(./Module1) --for importing like above
whatever module thgeree are we can use it 

-----in languages like typescript angualar/react we use 
import instead of require 

Consider Module to be same as JavaScript libraries


module can contain
-vars,function,object,class

node js Modules 
node provides runtime environment for executing javascript
it also provides few libraries 
these libraries come bundled buit in preinstalled 
these preinstalled libraries installled provide a core  set of 
features we can build upon 
for native modules 
var http=require("http");
var dns=require("dns");

for relative files 
var myFile = require('./myFile'); loads myFile.js


3 types of module
-core modules 
-local modules 
-third party moduyle

-core modules (that we are gonna take look at)
>http ---- we ll see
{this is the one which }
>url
>querystring
>pathname
>fs    - we ll see
>util














