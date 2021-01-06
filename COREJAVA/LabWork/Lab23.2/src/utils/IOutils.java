//Created by @AkhilD on 01/01/2021.
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Product;

public interface IOutils {
//static method to store all products in bin file: using serialization

	@SuppressWarnings("unchecked")
	static Map<Integer, Product> restoreProducts(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {

		// validate file: exists, regular data file, read permissions

		File fd = new File(fileName); // only file class instance is created wrapping the filePath

		if (fd.exists() && fd.isFile() && fd.canRead()) {

			// attach i/o streams

			// java App <- OIS <-FIS <-Bin file
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
				// de-serialization
				return (Map<Integer, Product>)in.readObject();

			}

		}

		return null;

	}
}
