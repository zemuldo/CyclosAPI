package access;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.net.URL;

public class GetInitialData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 try {
	            URL url = new URL ("http://192.168.30.105:8080/rest/access/initialData");
	            String encoding = new String(
	            		org.apache.commons.codec.binary.Base64.encodeBase64   
	            		    (org.apache.commons.codec.binary.StringUtils.getBytesUtf8("test1:danstan"))
	            		  );

	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.setDoOutput(true);
	            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
	            InputStream content = (InputStream)connection.getInputStream();
	            
	            int responseCode = connection.getResponseCode();
	    		System.out.println("\nSending 'GET' request to URL : " + url);
	    		System.out.println("Response Code : " + responseCode);
	            
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
