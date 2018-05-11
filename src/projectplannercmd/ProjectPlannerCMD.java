/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectplannercmd;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.soap.Brugeradmin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author aleks
 */
public class ProjectPlannerCMD {
    Bruger bruger;
    Users user = new Users();
    
    public void runInLoop(){
        while(true){
            try {
                runProgram();
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProjectPlannerCMD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void runProgram() throws MalformedURLException{
        clrscr();
        System.out.println("Velkommen til programmet");
        System.out.println("Heri kan du overføre brugerdata til databasen, eller se en brugers data");
        System.out.println("Indtast et studienummer for at fortsætte");
        while(true){
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        getUserFromJavabog(username);
        try {
            setUserInDb();
        } catch (IOException ex) {
            Logger.getLogger(ProjectPlannerCMD.class.getName()).log(Level.SEVERE, null, ex);
        }
        clrscr();
        System.out.println("Bruger oprettet i databasen");
        System.out.println("Indtast et nyt studienummer for at fortsætte");
        }
    }
    public void getUserFromJavabog(String username) throws MalformedURLException {
         Brugeradmin ba;

            URL url = new URL("http://javabog.dk:9901/brugeradmin?wsdl");
		QName qname = new QName("http://soap.transport.brugerautorisation/", "BrugeradminImplService");
		Service service = Service.create(url, qname);
		ba = service.getPort(Brugeradmin.class);
            bruger = ba.hentBrugerOffentligt(username);
            user.setFirstName(bruger.fornavn);
            user.setSurName(bruger.efternavn);
            user.setEmail(bruger.email);
            user.setUserID(bruger.brugernavn);
            }
    public void setUserInDb() throws MalformedURLException, ProtocolException, IOException{
String url = "http://projectplannerdb.eu-west-2.elasticbeanstalk.com/users";

		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		StringEntity input = new StringEntity("{\"userID\":\""+user.getUserID()+"\",\"surName\":\""+user.getSurName()+"\",\"firstName\":\""+user.getFirstName()+"\",\"email\":\""+user.getEmail()+"\"}");
		input.setContentType("application/json");
                post.setEntity(input);

		HttpResponse response = client.execute(post);
}
    
    public static void clrscr(){
    //Clears Screen in java
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
}
}
