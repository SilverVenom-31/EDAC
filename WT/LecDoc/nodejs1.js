

var http = require("http");
http.createServer(f1);  //nested functions
// craeates a server
//once server is created we need to listen 
//here port concept , my webserver should listen on perticular post 
like listen on port 3000
 http.listen(3000,"127.0.0.1");
 //127.0.0.1" --- local host
 function handleRequest(req,res){
	var body="hellow world \n";
var content_length=body.length;
res.write(200,{"Content-Length" :content_length,"Content-Type": "text/plain"})	
 
 res.end(body);
 }
 
 
  /*
 in ajax we gained info at broweser side 
 but now we area at server end 

 Response 
 1 status code 
 2 respose header 
 3 body
 */