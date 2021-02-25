package phoneDirectory;

import java.util.Scanner;

//Create a HashTable
class Hashtable {
		Scanner sc=new Scanner(System.in);
		int i;
		String num,name,add,choice;
		hashLinkedList[] table; // This array stores each linked list
		int size; // Used to initialize the array 
		public Hashtable(int size){
			this.size=size;
    // The size defined here creates an array space of size that can be stored in the hashLinkedList type
			table = new hashLinkedList[size];
    // Here is to store an instantiated empty linked list for each space(array cell)		
			for(i=0;i<table.length;i++) {
				table[i]=new hashLinkedList();
			}
		}
   
		// Put this node into the corresponding array linked list according to Telephone number
		public void in() {
			System.out.print("Name : ");
			name=sc.next();
			System.out.print("telephone number :  ");
			num=sc.next();
			System.out.print("Address : ");
			add=sc.next();
			table[mod(num)].inhash(name,num,add);
			System.out.println("Entry Successful!!!");
		}
		
		public void list() {
			for (int i = 0; i < size; i++) {
				table[i].list(i);
			}
		}
		
		
		public void find() {
			System.out.println("Search By Name: 1");
			System.out.println("Search by telephone: 2");
			choice=sc.next();
			if(choice.equals("1")) {
				System.out.print("Enter the Name to search: ");
				name=sc.next();
				for(i=0;i<table.length;i++) {
					if(table[i].findname(name)!=null) {
						System.out.println("Name: "+table[i].t.name+" telephone number: "+table[i].t.num+" Address: "+table[i].t.add);
						choice="";
					}
				}
				if(choice.equals("1")) {
					System.out.println("No such person!");
				}
			}else if(choice.equals("2")) {
				System.out.print("Enter the Phone Number to search: ");
				num=sc.next();
				i=mod(num);
				if(table[i].findnum(num)!=null) {				
					System.out.println("Name: "+table[i].t.name+" telephone number: "+table[i].t.num+" Address: "+table[i].t.add);
					choice="";
				}
				if(choice.equals("2")) {
					System.out.println("No such person!");
				}
			}else {
				System.out.println("No such person!");
			}
			
		}
		
		public void delete() {
			System.out.print("Enter the user number :");
			num=sc.next();
			 i=mod(num);
				if(table[i].deletehash(num)) {
					System.out.println("successfully deleted!");
				}				
			if(i>table.length) {
				System.out.println("No such person!");
			}
		}
		
	// Hash function, there are many different kinds of hash functions, here we use the common modulo method
	public int mod(String num) {
			int a=0;
			for(int i=0;i<num.length();i++) {
				a+=Integer.parseInt(num.charAt(i)+"");
			}
			return a%table.length;
		}
		
	}

	//Create a linked list 
	class hashLinkedList{
		node head;
		node tail;
		node t; //Auxilliary node for traversal
		
		public hashLinkedList() {
			head=null;
			tail=null;
		}
		
		// node of the linked list
		class node{ 
			String num,name,add;
			node next;  // store the next instance
			public node(String name,String num,String add) {
				this.num=num;
				this.name=name;
				this.add=add;
				next=null;
			}
			
			@Override
			public String toString() {
				return "User Details : User-Name = " + name + ", Telephone Number= " + num + ",  Address= " + add + "]";
			}
			
			
		}
		
		public void inhash(String name,String num,String add) {
			node userNode=new node(name,num,add);
			if(head==null) {
				head=userNode;
				tail=userNode;
			}
			else  {
					tail.next=userNode;
					tail=userNode;
				}
			}
		
		
		public node findname(String name) {
			 t=head; //Auxilliary node for traversal
			while(t!=null) {
				if(t.name.equals(name)) {
					return t;
				}else {
					t=t.next;
				}
			}
			return null;
		}
		
		public node findnum(String num) {
			 t=head; //Auxilliary node for traversal
			while(t!=null) {
				if(t.num.equals(num)) {
					return t;
				}else {
					t=t.next;
				}
			}
			return null;
		}
		
		public boolean deletehash(String num) {
			node user=findnum(num);
			if(user!=null) {
				node t=head; //Auxilliary node for traversal
				node q=null;
				if(t==user && t==head) {
					head=null;
					return true;
				}
				else {
				while(t!=user && t!=null) {
					q=t;
					t=t.next;
				    }
				if(t!=tail && t==user) {
					 q.next=t.next;
					 return true;
				    }
				else {
					if(t==tail && t==user) {
					tail=q;
					q.next=null;
					return true;
				       }
			         }
				  }
			}
			return false;
		}
		
		// Traverse the linked list
		public void list(int no) {
			t=head; //Auxilliary node for traversal
			if (head == null) {// The linked list is empty
				System.out.println(" "+(no+1)+ "-The linked list is empty.");
				return;
			}
			System.out.print(" "+(no+1)+"-The linked list information is:");
			while (t!= null) {
				System.out.print(t+ " ");
				t= t.next;
			}
			System.out.println();
		}
	}


