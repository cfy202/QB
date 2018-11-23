package com.chinatour.util;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class test {

	public static void main(String[] args) throws Exception {  
        SSLContext context = SSLContext.getInstance("TLS");  
        context.init(null, null, null);  
        java.lang.System.setProperty("https.protocols", "TLS1.2");
        SSLSocketFactory factory = (SSLSocketFactory) context.getSocketFactory();  
        SSLSocket socket = (SSLSocket) factory.createSocket();  
  
        String[] protocols = socket.getSupportedProtocols();  
  
        System.out.println("Supported Protocols: " + protocols.length);  
        for (int i = 0; i < protocols.length; i++) {  
            System.out.println(" " + protocols[i]);  
        }  
  
        protocols = socket.getEnabledProtocols();  
  
        System.out.println("Enabled Protocols: " + protocols.length);  
        for (int i = 0; i < protocols.length; i++) {  
            System.out.println(" " + protocols[i]);  
        }  
  
    }  
}
