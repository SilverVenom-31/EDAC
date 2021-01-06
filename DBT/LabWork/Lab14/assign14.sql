 db.InitialTest.insert( [
 			{"first_name" : "Alex",
 			 "last_name" : "Stanley",
 			  "salary" : 20000, 
 			  "address" : { 
 			  		"street" : 20, 
 			  		"city" : "Mumbai"
 			  	       } 
 			 },
 			 {"first_name" : "John",
 			 "last_name" : "Graham",
 			  "salary" : 25000, 
 			  "address" : { 
 			  		"street" : 21, 
 			  		"city" : "Mumbai"
 			  	       } 
 			 }
 			 
 			] );
 			
   
   
   
   db.users.insert([{user_id: “abc1”, firstName: "Steve", lastName: "Haines", age: 39, gender : “M”},{user_id: “abc2”, firstName: "Michael", lastName: "Obama", age: 25, gender : “M”},{user_id: “abc3”,firstName: "Ram", lastName: "Das", age: 45, gender : “M”},{user_id: “abc4”, firstName: "Chetan", lastName: "Barot", age: 30, gender : “M”},{user_id: “abc5”, firstName: "Jaya", lastName: "Kumari", age: 35, gender : “F”},{user_id: “abc6”, firstName: "Seeta", lastName: "Kumari", age: 22, gender : “F”},{user_id: “abc7”, firstName: "Shiv", lastName: "Patil", age: 57, gender : “M”}, {user_id: “abc8”, firstName: "Rachna", lastName: "Sharma", age: 57, gender : “F”},{user_id: “abc9”, firstName: "Alex", lastName: "Mathew", age: 48, gender : “M”}, {user_id: “abc10”, firstName: "Gracy", lastName: "Abreo", age: 72, gender : “F”},{user_id: “abc11”, firstName: "Ranjan", lastName: "Patil", age: 60, gender : “M”, address:{ street: "Phase1", zipcode: 400049, state: "Maharashtra"}}]);
   		     
   		     
   		    db.users.find().pretty().sort({age:1});
   		    
   		    db.users.find({lastName:"Kumari"}).pretty();
	
	db.users.find({gender:"M"}).pretty(); 
	
	
	db.users.find({age:{$lt:30}},{user_id:0,gender:0}).pretty();
db.users.find({age:{$gt:30}}).pretty();
db.users.find({age:57}).pretty();


db.users.insert([
{
item: "ABC2",
details: { model: "14Q3", manufacturer: "M1 Corporation" },
stock: [ { size: "M", qty: 50 } ],
category: "clothing"
},
{
item: "MNO2",
details: { model: "14Q3", manufacturer: "ABC Company" },
stock: [ { size: "S", qty: 5 }, { size: "M", qty: 5 }, { size: "L", qty: 1 } ],
category: "clothing"
},
{
item: "IJK2", 
details: { model: "14Q2", manufacturer: "M5 Corporation" },
stock: [ { size: "S", qty: 5 }, { size: "L", qty: 1 } ],
category: "houseware"
}
]);

db.users.find({category:"houseware"});

   		     
   		     
 db.users.update({user_id:"abc10"},{$set: {age:73}});
 
 
 db.users.update({user_id: "abc4"},{$inc:{age:3}});
 
 
 db.users.update({user_id: "abc9"},{$unset: {age:""}});
 
 db.users.remove({"firstName":"Steve"});




db.users.insert({
item: "IJK2", 
details: { model: "14Q2", manufacturer: "M5 Corporation" },
stock: [ { size: "S", qty: 5 }, { size: "L", qty: 1 } ],
category: "houseware"
});



db.users.update({item: "ABC2"},{$unset: {category:""}});


db.users.update({item:"MNO2"},{$set: {"details.model":"14P3"}});


db.users.update({item:"IJK2","stock.size":"S"}, {$inc:{"stock.$.qty":1}});








