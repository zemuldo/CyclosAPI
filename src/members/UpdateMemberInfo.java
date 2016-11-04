package members;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class UpdateMemberInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String request = null;
		
		try {
            URL url = new URL ("http://192.168.43.133:8080/rest/members/me");
            
            //Doing http basic authentication
            String encoding = new String(
            		 org.apache.commons.codec.binary.Base64.encodeBase64   
            		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8("jason:danstan"))
            		  );

            //Creating http connection
            Gson g = new Gson();
    		Map<String, String> expected = new HashMap<>();
    		
    		if (!request.trim().equals("")){
		        System.out.println("mimi"+request);
		        
		        //pass the returned json string
				JsonElement roots = new JsonParser().parse(request);
		        
				//exctract a specific json element from the object(access_token)
				String BusinessID = roots.getAsJsonObject().get("BusinessID")
						.getAsString();
				
				System.out.println("BusinessID "+BusinessID);
				
				//exctract a specific json element from the object(Year)
				String Year = roots.getAsJsonObject().get("Year")
						.getAsString();
				System.out.println("Year "+Year);
				
				//exctract a specific json element from the object(TransactionID)
				String TransactionID = roots.getAsJsonObject().get("TransactionID")
						.getAsString();
				System.out.println("TransactionID "+TransactionID);
				
				//exctract a specific json element from the object(AnnualAmount)
				String AnnualAmount = roots.getAsJsonObject().get("AnnualAmount")
						.getAsString();
				System.out.println("AnnualAmount "+AnnualAmount);
				
				//exctract a specific json element from the object(BillNumber)
				String BillNumber = roots.getAsJsonObject().get("BillNumber")
						.getAsString();
				System.out.println("BillNumber "+BillNumber);
				
				//exctract a specific json element from the object(Building)
				String Building = roots.getAsJsonObject().get("Building")
						.getAsString();
				System.out.println("Building "+Building);
				
				//exctract a specific json element from the object(BillStatus)
				String BillStatus = roots.getAsJsonObject().get("BillStatus")
						.getAsString();
				System.out.println("BillStatus "+BillStatus);
				
				//exctract a specific json element from the object(BusinessName)
				String BusinessName = roots.getAsJsonObject().get("BusinessName")
						.getAsString();
				System.out.println("BusinessName "+BusinessName);
				
				//exctract a specific json element from the object(RegistrationFee)
				String RegistrationFee = roots.getAsJsonObject().get("RegistrationFee")
						.getAsString();
				System.out.println("RegistrationFee "+RegistrationFee);
				
				//exctract a specific json element from the object(Penalty)
				String Penalty = roots.getAsJsonObject().get("Penalty")
						.getAsString();
				System.out.println(".Penalty"+Penalty);
				
		        }
		        
		        else{
		        	
		        	expected.put("command_status", "COMMANDSTATUS_RECEIVER_SERVER_ERROR_PARAMETERS");
					String jsonResult = g.toJson(expected);
		        
					System.out.println(jsonResult);
					
		        }
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            
            InputStream content = (InputStream)connection.getInputStream();
            
            
            //getting response code
            int responseCode = connection.getResponseCode();
    		System.out.println("\nSending 'GET' request to URL : " + url);
    		System.out.println("Response Code : " + responseCode);
            
    		
    		//reading output
            BufferedReader in   = 
                new BufferedReader (new InputStreamReader (content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("The access status is "  +line);}}
           
		    
            catch(Exception e) {
            e.printStackTrace();
        }


 }}
		
		
    		
		
