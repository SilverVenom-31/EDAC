package dao;

import pojos.Location;
import pojos.Vendors;

public interface IVendorDao {
String registerVendor(Vendors v);
String assignVendorLocation(int vId,Location location);
 Vendors fetchVendorDetails(String email);
 String registerVendorWithLoc(Location location);
 Vendors getVendorDetByPhone(String phoneNo);
}
