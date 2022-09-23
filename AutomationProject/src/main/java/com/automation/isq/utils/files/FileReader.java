package com.automation.isq.utils.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public abstract class FileReader {
	
	private DocumentBuilderFactory documentBuilderFactory ;
	private DocumentBuilder documentBuilder ;
	private Document document;
	private File file;
	private String fileString;
	

	/*
	 * Abstract methods
	 */
	public abstract void readFile(String path) throws Exception;
	public abstract NodeList getNodeList(String nodeName) throws Exception;
	public abstract Map<String, String> getNode(String path, Object json) throws Exception;
	
	/*
	 * Initializing 
	 */
	public ArrayList<String> getParameters() throws Exception{
		String content = this.getFileString();
		ArrayList<String> result = new ArrayList<>();
		
		Pattern pattrn = Pattern.compile("#<\\w+>#");
	    Matcher matcher = pattrn.matcher(content);	    
	    
	    try{
	    	while(matcher.find()) {
	    		result.add(matcher.group());
	    		System.out.println(matcher.group());
	    	}
	    }catch(IllegalStateException e){
	    	e.getStackTrace();
	    	System.out.println(e);
	    }
	    
	    return result;
	}

	public void readFileAsString(String path) throws Exception {
		this.setFileString(FileUtils.readFileToString(this.getFile()));
	}
	
	public void readFileAsString(String path, String[] parameters) throws Exception {
		String content = FileUtils.readFileToString(this.getFile());
			
		Pattern pattrn = Pattern.compile("#<\\w+>#");
	    Matcher matcher = pattrn.matcher(content);
	    
	   
	    for(int i = 0; i < parameters.length; i++){
	    	matcher = pattrn.matcher(matcher.replaceFirst(parameters[i]));
	    	this.setFileString(matcher.replaceFirst(parameters[i]));
	    }
	}
	
	
	
	/*
	 * Getters Setters
	 */
	public DocumentBuilderFactory getDocumentBuilderFactory() {
		return documentBuilderFactory;
	}

	public void setDocumentBuilderFactory(DocumentBuilderFactory documentBuilderFactory) {
		this.documentBuilderFactory = documentBuilderFactory;
	}

	public DocumentBuilder getDocumentBuilder() {
		return documentBuilder;
	}

	public void setDocumentBuilder(DocumentBuilder documentBuilder) {
		this.documentBuilder = documentBuilder;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public String getFileString() {
		return fileString;
	}
	
	public void setFileString(String fileString) {
		this.fileString = fileString;
	}
}
