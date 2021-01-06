

class CarTest{
	public static void main(String args[]){
		// c1 is an object of type Car
		// dot (.) is used to access object members(state & behavour)
		Car c1 = new Car();		
		c1.regNo = "MH12-PH0227";
		c1.color = "blue";
		c1.model = "Suzuki Baleno Delta";
		c1.price = 7.5;
		
		Car c2 = new Car();
		c2.regNo = "MH12-PH12344";
		c2.color = "white";
		c2.model = "Suzuki Baleno Xeta";
		c2.price = 10.5;
		
		System.out.println(c1.regNo);
		System.out.println(c2.regNo);
		
		
	}
	
}