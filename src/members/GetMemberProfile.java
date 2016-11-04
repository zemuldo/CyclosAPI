package members;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetMemberProfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
            URL url = new URL ("http://192.168.34.133:8080/rest/members/me");
            
            //Doing http basic authentication
            String encoding = new String(
            		 org.apache.commons.codec.binary.Base64.encodeBase64   
            		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8("jason:danstan"))
            		  );

            //Creating http connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
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
                System.out.println("The access status is "  +line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

	}
}


