package kr.ac.kopo.ctc.kopo19.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo19.domain.WifiItem;
// DAO(Data Access Object) -> link DB and service
// for CRUD
public class WifiItemDao {
	public WifiItem create (WifiItem wifiItem) {			
		return null;
	} // Create

	public WifiItem selectOne(int id) {
		return null;
	} // Read(only one row in a file)
		
	public List<WifiItem> selectAll() {
		
		List<WifiItem> ret = new ArrayList<WifiItem>(); // make ArrayList to return
		
		File f = new File("C:\\Users\\kopo19\\Desktop\\coding\\자바 심화\\무료와이파이데이터.txt");
		// set file path and filename 
		
		BufferedReader br;
		String readTxt;
		
		try {
			br = new BufferedReader(new FileReader(f)); // read file using BufferedReader 
			if ((readTxt = br.readLine()) == null) {  
				System.out.printf("Empty File!\n"); // print when file is empty
			}
			while ((readTxt = br.readLine()) != null) { // repeat until there is no text
				WifiItem wifi = new WifiItem(); // create WifiItem object
				String[] field = readTxt.split("\t"); // store file text at String type array
				// split by \t and give to each setter
				wifi.setid(Integer.parseInt(field[0]));
				wifi.setInstallationLocationName(field[1]);
				wifi.setInstallationLocationDetails(field[2]);
				wifi.setInstallationDistrictName(field[3]);
				wifi.setInstallationDistrictName(field[4]);
				wifi.setInstallationFacilityType(field[5]);
				wifi.setServiceProviderName(field[6]);
				wifi.setWifiSsid(field[7]);
				wifi.setDateOfInstallation(field[8]);
				wifi.setRoadNameAddress(field[9]);
				wifi.setLotNumberAddress(field[10]);
				wifi.setManagementAgencyName(field[11]);
				wifi.setManagementAgencyPhoneNumber(field[12]);
				wifi.setLatitude(field[13]);
				wifi.setLongitude(field[14]);
				wifi.setCreated(field[15]);
				ret.add(wifi); // store each row data at ret 
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	} // Read(all text in a file)
	
	public WifiItem update(int id, WifiItem wifiItem) {
		return null;
	} // Update(edit a file)
	
	public WifiItem delete(int id) {
		return null;
	} // Delete
	
}