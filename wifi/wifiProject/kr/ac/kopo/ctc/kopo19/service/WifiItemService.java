package kr.ac.kopo.ctc.kopo19.service;

import kr.ac.kopo.ctc.kopo19.domain.WifiItem;

public class WifiItemService {

	public double getDistance(WifiItem wifiItem1, WifiItem wifiItem2) { 
		double dist = 0;	
		dist = Math.sqrt(Math.pow(Double.parseDouble(wifiItem2.getLongitude()) - 
														Double.parseDouble(wifiItem1.getLongitude()), 2)
				 + Math.pow(Double.parseDouble(wifiItem2.getLatitude()) - 
														Double.parseDouble(wifiItem1.getLatitude()), 2));
		// calculate distance between two place using coordinates
		// getter type is String -> can change type String to double using parse
		return dist;
	}
}