package application;

import java.io.File;
import java.util.List;

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
import org.w3c.dom.Node;

import com.campusfp.xml.Item;
import com.campusfp.xml.StaXParser;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class XmlController {

	public TextArea mostxml;

	public void mostrarxml() {
		StaXParser read = new StaXParser();
		List<Item> readConfig = read.readConfig("prueba.xml");
		for (Item item : readConfig) {
			mostxml.setText(item.toString());
		}
	}

	public TextField text1;
	public TextField text2;
	public TextField text3;

	public void escribirxml() {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			// Elemento raíz
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("config");
			doc.appendChild(rootElement);

			Node nodoraiz = doc.getDocumentElement();

			Element root2 = doc.createElement("item");
			rootElement.appendChild(root2);

			/****************************************************/

			if (text1.getText().equals("")) {
				Element nombre = doc.createElement("nombre");
				System.out.println("Campos vacios");
				nombre.setTextContent("Vacio");

			} else {
				Element nombre = doc.createElement("nombre");
				nombre.setTextContent(text1.getText());
				root2.appendChild(nombre);
			}

			if (text2.getText().equals("")) {
				Element ciudad = doc.createElement("ciudad");
				System.out.println("Campos vacios");
				ciudad.setTextContent("Vacio");

			} else {
				Element ciudad = doc.createElement("ciudad");
				ciudad.setTextContent(text2.getText());
				root2.appendChild(ciudad);
			}

			if (text3.getText().equals("")) {
				Element salario = doc.createElement("salario");
				System.out.println("Campos vacios");
				salario.setTextContent("Vacio");

			} else {

				Element salario = doc.createElement("salario");
				salario.setTextContent(text3.getText());
				root2.appendChild(salario);

				nodoraiz.appendChild(root2);
			}
			/****************************************************/

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

		text1.setText("");
		text2.setText("");
		text3.setText("");

	}

}
