package com.campusfp.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class escribirxml {
	 public static void main(String argv[]) {
		    try {
		      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		      //Elemento raíz
		      Document doc = docBuilder.newDocument();
		      Element rootElement = doc.createElement("config");
		      doc.appendChild(rootElement);
		      //Primer elemento
		      Element nombre = doc.createElement("nombre");
		      rootElement.appendChild(nombre);
		      //Se agrega un atributo al nodo elemento y su valor
		      nombre.setTextContent("Contenido del elemento 2");
		      rootElement.appendChild(nombre);
		      Element ciudad = doc.createElement("ciudad");
		      ciudad.setTextContent("Contenido del elemento 2");
		      rootElement.appendChild(ciudad);
		      //Se escribe el contenido del XML en un archivo
		      
		      Element salario = doc.createElement("salario");
		      salario.setTextContent("Contenido del elemento 2");
		      rootElement.appendChild(salario);
		      
		      TransformerFactory transformerFactory = TransformerFactory.newInstance();
		      Transformer transformer = transformerFactory.newTransformer();
		      DOMSource source = new DOMSource(doc);
		      StreamResult result = new StreamResult(new File("prueba.xml"));
		      transformer.transform(source, result);
		    } catch (ParserConfigurationException pce) {
		      pce.printStackTrace();
		    } catch (TransformerException tfe) {
		      tfe.printStackTrace();
}
	 }
}
