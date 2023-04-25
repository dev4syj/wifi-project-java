package kr.ac.kopo.ctc.kopo19;

import java.util.List;
import kr.ac.kopo.ctc.kopo19.dao.WifiItemDao;
import kr.ac.kopo.ctc.kopo19.domain.WifiItem;
import kr.ac.kopo.ctc.kopo19.service.WifiItemService;

public class WifiMain {
	public static void main(String[] args) {
		double minDistance = 1, maxDistance = 0;
		
		
		WifiItem close = null; // store about closest place information, need to initialize in null
		WifiItem far = null; // store farthest place information, need to initialize in null
		
		// make object
		WifiItemService wifiItemService = new WifiItemService();
 		WifiItemDao wifiItemDao = new WifiItemDao();
 			
 		WifiItem me = new WifiItem(); // store coordinate of KOPO_CTC
 		me.setLongitude("127.1214038"); // KOPO_CTC Longitude
 		me.setLatitude("37.3860521"); // KOPO_CTC Latitude
 		
		List<WifiItem> wifiItems = wifiItemDao.selectAll(); // store all file text at wifiItems using selectAll method
		
		for (WifiItem target : wifiItems) { // repeat # of wifiItems size
			double d = wifiItemService.getDistance(me, target);	// get calculation result	
			
			if (minDistance > d) {
				minDistance = d; // set closest distance
				close = target; // store information, both object types are WifiItem
			}
			if (maxDistance < d) {
				maxDistance = d; // set farthest distance
				far = target; // store information, both object types are WifiItem
			}
		}
		
		// print result, get information with getter
		System.out.printf("Closest place: %s\nAddress: %s (distance %f)\n",
							close.getInstallationLocationName(),
							close.getRoadNameAddress(), minDistance);
		System.out.printf("Latitude: %s, Longitude: %s\n\n",
							close.getLatitude(), close.getLongitude());
		System.out.printf("Farthest place: %s\nAddress: %s (distance %f)\n",
							far.getInstallationLocationName(),
							far.getRoadNameAddress(), maxDistance);
		System.out.printf("Latitude: %s, Longitude: %s",
							far.getLatitude(), far.getLongitude());		
	}
}