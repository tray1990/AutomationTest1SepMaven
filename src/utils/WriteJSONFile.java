package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.*;

import start.StartingAutomation;

public class WriteJSONFile {
	
	Utility utils = new Utility();
	

	public void jsonWrite(ArrayList<String> alPhoneName, ArrayList<String> alPhonePrice) throws IOException, JSONException {

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("Site","Flipkart");
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObjMobile = new JSONObject();
		for (int i=0; i<(alPhoneName.size()-1); i++) {
			for (int j=0; j<alPhonePrice.size()-1; j++) {
				System.out.println(alPhoneName.get(i)+ " Price is : "+ alPhoneName.get(j));
//				jsonArray.put(alPhoneName.get(i)+ " Price is : "+ alPhoneName.get(j));
//				jsonObjMobile.put(alPhoneName.get(i)+ " Price is : ", alPhoneName.get(j));
				jsonObjMobile.put(alPhoneName.get(i), alPhoneName.get(j));
			}
		}
		jsonArray.put(jsonObjMobile);
		jsonObj.put("Mobiles", jsonArray);

		// Write JSON file

		utils.currentDate();
		String sPathToWrite = System.getProperty("user.dir") + "\\AutoGenOutput\\" + utils.sCurrentDate + "\\Output\\";
		Files.createDirectories(Paths.get(sPathToWrite));

		System.out.println("Json Output path is : " + sPathToWrite);
		System.out.println(sPathToWrite + "JsonOutput_" + StartingAutomation.sStartTime);
		try (FileWriter file = new FileWriter(sPathToWrite + "JsonOutput_" + StartingAutomation.sStartTime + ".json")) {

			file.write(jsonObj.toString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
