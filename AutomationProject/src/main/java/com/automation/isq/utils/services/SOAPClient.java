package com.automation.isq.utils.services;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.soap.*;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;


public class SOAPClient extends CallWebService{

	SOAPConnectionFactory soapConnectionFactory;
	SOAPConnection soapConnection;

	String url;
	String xml;
	SOAPMessage soapResponse;

	public SOAPClient(String url) throws Exception{
		soapConnectionFactory = SOAPConnectionFactory.newInstance();
		soapConnection = soapConnectionFactory.createConnection();

		this.url = url;
	}

	public SOAPClient(String url, String xml) throws Exception{
		soapConnectionFactory = SOAPConnectionFactory.newInstance();
		soapConnection = soapConnectionFactory.createConnection();

		this.url = url;
		this.xml = xml;
	}

	@Override
	public void addHeader(String key, String value) throws Exception {
		throw new NotImplementedException();
	}

	@Override
	public void addParameter(String key, String value) throws Exception {
		if(key.equalsIgnoreCase("xml")) {
			this.xml = value;
		} else {
			throw new Exception("InvalidParameter");
		}
	}

	@Override
	public void addBasicAuth(String username, String password) throws Exception {
		throw new NotImplementedException();
	}

	@Override
	public void send() throws Exception {
		soapResponse = soapConnection.call(createSOAPRequestFromString(xml), url);

/*		ByteArrayOutputStream out = new ByteArrayOutputStream();
		soapResponse.writeTo(out);
		String strMsg = new String(out.toByteArray());
		this.setResponseStr(strMsg);*/




		final StringWriter sw = new StringWriter();

		TransformerFactory.newInstance().newTransformer().transform(
				new DOMSource(soapResponse.getSOAPPart()),
				new StreamResult(sw));


		this.setResponseStr(sw.toString());
		soapConnection.close();
	}

	/*
	 * Helper methods
	 */
	/*private static SOAPMessage createSOAPRequest(String url) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		//String serverURI = "http://ws.cdyne.com/";
		String serverURI = url;

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("example", serverURI);

        *//*
        Constructed SOAP Request Message:
        <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
            <SOAP-ENV:Header/>
            <SOAP-ENV:Body>
                <example:VerifyEmail>
                    <example:email>mutantninja@gmail.com</example:email>
                    <example:LicenseKey>123</example:LicenseKey>
                </example:VerifyEmail>
            </SOAP-ENV:Body>
        </SOAP-ENV:Envelope>
         *//*

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("VerifyEmail", "example");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("email", "example");
		soapBodyElem1.addTextNode("mutantninja@gmail.com");
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("LicenseKey", "example");
		soapBodyElem2.addTextNode("123");

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI  + "VerifyEmail");

		soapMessage.saveChanges();

		System.out.print("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println();

		return soapMessage;
	}*/

	public static SOAPMessage createSOAPRequestFromString(String xml) throws Exception{
		InputStream is = new ByteArrayInputStream(xml.getBytes());
		return MessageFactory.newInstance().createMessage(null, is);
	}
}
