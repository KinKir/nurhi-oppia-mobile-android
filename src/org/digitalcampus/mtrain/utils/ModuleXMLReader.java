package org.digitalcampus.mtrain.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.util.Log;

public class ModuleXMLReader {

	public static final String TAG = "ModuleXMLReader";
	private Document document;

	public ModuleXMLReader(String filename) {

		File moduleXML = new File(filename);
		if (moduleXML.exists()) {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				document = builder.parse(moduleXML);

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void getMeta(){
		Node m = document.getFirstChild().getFirstChild();
		NodeList meta = m.getChildNodes();
		for (int j=0; j<meta.getLength(); j++) {
			Log.v(TAG, meta.item(j).getNodeName() + ": " + meta.item(j).getTextContent());
		}
	}
}