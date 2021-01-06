package utils;

import static com.app.core.Category.FRUITS;
import static com.app.core.Category.GRAINS;
import static com.app.core.Category.OIL;
import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.ProdShipDet;
import com.app.core.Product;

public interface CollectionUtils {
	static List<Product> populateData() {
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(100, "mango", FRUITS, parse("2019-01-01"), 500));
		products.add(new Product(10, "rice_bran", OIL, parse("2019-01-01"), 450));
		products.add(new Product(45, "sunflower", OIL, parse("2019-05-11"), 550));
		products.add(new Product(30, "rice", GRAINS, parse("2019-01-13"), 520));
		products.add(new Product(55, "orange", FRUITS, parse("2020-01-01"), 350));
		products.add(new Product(35, "wheat", GRAINS, parse("2018-07-11"), 700));

		// assigning shipment details to the products
		List<ProdShipDet> dets = Arrays.asList(new ProdShipDet("Mumbai", "400092", "9284425490", now()),
				new ProdShipDet("banglore", "400091", "9284465491", now()),
				new ProdShipDet("thane", "400094", "9284425493", now()),
				new ProdShipDet("ujjain", "400095", "9284425494", now()),
				new ProdShipDet("pune", "400096", "9284425495", now()),
				new ProdShipDet("nagpur", "400098", "9284425496", now()));

		for (int i = 0; i < products.size(); i++) {
			products.get(i).linkShipDetails(dets.get(i));
		}

		return products;
	}

	static Map<Integer, Product> populateMap(List<Product> products) {
		HashMap<Integer, Product> map = new HashMap<>();
//		for (Product p : products)
//			map.put(p.getId(), p);
//		
		products.stream().forEach(p -> map.put(p.getId(), p));
		return map;
	}

}
