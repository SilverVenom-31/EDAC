Regarding Hashing based Data structures....(eg : HashSet,HashTable,HashMap)

Steps for Creating HashMap 

1.  Key class in HashMap must override : hashCode & equals method both in consistent manner.

Object class API
public int hashCode() ---  rets int : which represents internal  addr where obj is sitting on the heap(typically -- specific to JVM internals)

public boolean equals(Object ref) -- Object class rets true : iff 2 refs are referring to the same copy.

2. Rule to observe while overriding these methods 
If 2 refs are equal via equals method then their hashCode values must be same.
eg : If ref1.equals(ref2) ---> true then ref1.hashCode() = ref2.hashCode()
Converse may not be mandatory.(i.e if ref1.equals(ref2) = false then its not mandatory that ref1.hashCode() != ref2.hashCode() : but recommended for better working of hashing based D.S)

String class , Wrapper classes , Date related classes have already folowed this contract.


How does hashing based data structure ensure constant time performance?

If no of entries > capacity * load factor --- re-hashing takes place ---
New data structure is created --(hashtable) -- with approx double the original capacity --- HM takes all earlier entries from orig map & places them in newly created D.S -- using hashCode & equals. -- ensures lesser hash collisions.

Why there is a guarantee that a duplicate entry / ref can't exist in yet another bucket ?

Answer is thanks to the contract between overriding of hashCode & equals methods

If two keys are the same (equals() returns true when you compare them), their hashCode() method must return the same number. If keys violate this, then keys that are equal might be stored in different buckets, and the hashmap would not be able to find key-value pairs (because it's going to look in the same bucket).

If two keys are different(i.e equals method rets false) , then it doesn't matter if their hash codes are the same or not. They will be stored in the same bucket if their hash codes are the same, and in this case, the hashmap will use equals() to tell them apart.








