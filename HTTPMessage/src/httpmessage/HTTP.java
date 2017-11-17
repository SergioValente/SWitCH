package httpmessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class HTTP {

	public static final int CR = 13;
	public static final int LF = 10;

	public static final String CONNECTION = "Connection:";
	public static final String VERSION = "HTTP/1.1";
	public static final String CONTENT_TYPE = "Content-type:";
	public static final String CONTENT_LENGTH = "Content-length:";

	public static String readLine(DataInputStream in) throws IOException {
		int val;
		String ret = "";
		do {
			val = in.read();
			if (val != HTTP.CR) {
				ret = ret + (char) val;
			}
		} while (val != HTTP.CR);
		in.read(); //para ler o último line feed
		return ret;
	}

	public static void writeLine(String line, DataOutputStream out) throws IOException {

		out.write(line.getBytes(),0,line.length());
		out.write(HTTP.CR);
		out.write(HTTP.LF);
	}

}
