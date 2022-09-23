package com.automation.isq.utils.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.NotImplementedException;
import org.w3c.dom.NodeList;

public class XMLReader extends FileReader {

	@Override
	public void readFile(String path) throws Exception {
		this.setFile(new File(path));
		this.setDocumentBuilderFactory(DocumentBuilderFactory.newInstance());
		this.setDocumentBuilder(this.getDocumentBuilderFactory().newDocumentBuilder());
		this.setDocument(this.getDocumentBuilder().parse(this.getFile()));
		this.getDocument().getDocumentElement().normalize();
	}

	public NodeList getNodeList(String nodeName) {
		NodeList nList = getDocument().getElementsByTagName(nodeName);
		return nList;
	}

	@Override
	public Map<String, String> getNode(String path, Object json) throws Exception {
		throw new NotImplementedException();
	}

	public static void main(String[] args) {
		XMLReader xr = new XMLReader();
		try {
			String[] abc = { "REPLACE 1", "REPLACE 2" };
			xr.readFileAsString("test", abc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
