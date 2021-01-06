//Created by @AkhilD on 01/01/2021.
package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Product;

public interface IOutils {
//static method to store all products in bin file: using serialization
	
	static void saveProducts(Map<Integer, Product> productMap, String fileName) throws FileNotFoundException, IOException  {
		
		
		//java App -> OOS -> FOS->Bin file
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)) ){
				
				out.writeObject(productMap);   //serialization
				
				
			} 
		
	}
}
