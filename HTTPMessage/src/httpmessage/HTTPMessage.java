package httpmessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class HTTPMessage {

	private boolean isRequest = true;
	private String method;
	private String uri;
	private String status;

	private String contentType;
	private boolean hasContent = false;

	private byte[] content;

	//construtor para receber mensagem
	public HTTPMessage (DataInputStream in) throws IOException {

		String firstLine = HTTP.readLine(in);
		isRequest = !(firstLine.startsWith("HTTP"));

		String[] firstLineComp = firstLine.split(" ");
		if (isRequest) {
			method = firstLineComp[0];
			uri = firstLineComp[1];
		}
		else {
			status = firstLineComp[1] + " " + firstLineComp[2];
		}

		String headerLine;
		contentType = null;

		do {
			headerLine = HTTP.readLine(in);
			if (headerLine.toUpperCase().startsWith(HTTP.CONTENT_TYPE.toUpperCase())) {
				contentType = headerLine.substring(HTTP.CONTENT_TYPE.length()).trim();
			}
			else if (headerLine.toUpperCase().startsWith(HTTP.CONTENT_LENGTH.toUpperCase())) {
				String cLen = headerLine.substring(HTTP.CONTENT_LENGTH.length()).trim();
				int len;
				try {
					len = Integer.parseInt(cLen);
				}
				catch (NumberFormatException ne) {
					throw new IOException();
				}
				content = new byte[len];
				hasContent = (len > 0);
			}
		}
		while (headerLine.isEmpty());

		if (hasContent) {
			in.readFully(content, 0, content.length);
		}
	}

	public HTTPMessage() {

		isRequest = true;
		method = null;
		uri = null;
		hasContent = false;
	}

	public boolean send(DataOutputStream out) throws IOException {

		if (isRequest && (method == null || uri == null)) {
			return false;
		}
		if (isRequest) {
			HTTP.writeLine(method + " " + uri + " " + HTTP.VERSION, out);
		}
		else {
			HTTP.writeLine(HTTP.VERSION + " " + status, out);
		}

		if (hasContent) {
			HTTP.writeLine(HTTP.CONTENT_TYPE + " " + contentType, out);
			HTTP.writeLine(HTTP.CONTENT_LENGTH + " " + content.length, out);
		}
		HTTP.writeLine(HTTP.CONNECTION + " close", out);
		HTTP.writeLine("", out);

		if (hasContent) {
			out.write(content,0,content.length);
		}

		return true;
	}
}
