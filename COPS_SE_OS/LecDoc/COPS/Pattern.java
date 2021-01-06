//* 
//* * * 
//* * * * * 
//* * * * * * * 
//* * * * * * * * *

//*
//* *
//* * *
//* * * *

public class PrintPattern1 {

	public static void main(String[] args) {
		int rows = 9;
		
		for(int i=1,k=1;i<=rows;i++,k=k+2){
			
			for(int j=1;j<=k;j++){
				System.out.print("* ");
			}
			
			System.out.println();
		}
	}

}




