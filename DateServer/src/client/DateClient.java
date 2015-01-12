package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class DateClient {
	
    public static void main(String[] args) throws IOException {
    	// jframe til brugerinput.
        String serverAddress = JOptionPane.showInputDialog(
            "Skriv host ip adressen");
        
        // initialiserer ny socket til serveren vha. den indtastede ip adresse, samt porten,
        // som serveren lytter på.
        Socket s = new Socket(serverAddress, 9090);
        
        //modtager dato mm. fra serveren vha. InputStreamReader fra serverens socket.
        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        // aflæser input fra BufferedReader og viser indholdet vha. Jframe messageDialog.
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        
        // lukker ned.
        System.exit(0);
    }
}
