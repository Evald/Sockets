package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class DateServer {

    public static void main(String[] args) throws IOException {
    	// initialiserer en serversocket der lytter på port 9090.
        ServerSocket listener = new ServerSocket(9090);
        try {
            while (true) {
            	// initialiserer ny socket til klienten på port 9090.
            	//for at kunne skabe denne forbindelse skal server have 
            	// klientens ip og destinations port.
                Socket socket = listener.accept();
                try {
                	DateFormat df = new SimpleDateFormat("EEEE 'den' d. MMMM 'år' yyyy.", new Locale("da","DK"));
                	//sender dato mm vha. printwriter til klienten.
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    out.println(df.format(new Date()).toString()
                    		+ " Du har nu haft forbindelse til serveren!");
                } finally {
                	// lukker forbindelsen til klienten.
                    socket.close();
                }
            }
        }
        finally {
        		//stopper serveren.
            listener.close();
        }
    }
}
