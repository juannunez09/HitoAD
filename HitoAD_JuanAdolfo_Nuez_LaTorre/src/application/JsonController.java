package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class JsonController {

	public TextArea mostrarjs;

	static String resultado;
	static ArrayList<String> leerjson = new ArrayList<String>();

	public void mostrarjson() throws java.io.IOException {
		JsonParser parser = new JsonParser();
		FileReader fr = new FileReader("prueba.json");
		JsonElement datos = parser.parse(fr);
		dumpJSONElement(datos);

	}

	public void dumpJSONElement(JsonElement elemento) {
		if (elemento.isJsonObject()) {

			JsonObject obj = elemento.getAsJsonObject();
			java.util.Set<java.util.Map.Entry<String, JsonElement>> entradas = obj.entrySet();
			java.util.Iterator<java.util.Map.Entry<String, JsonElement>> iter = entradas.iterator();
			while (iter.hasNext()) {
				java.util.Map.Entry<String, JsonElement> entrada = iter.next();

				dumpJSONElement(entrada.getValue());
			}
		} else if (elemento.isJsonArray()) {
			JsonArray array = elemento.getAsJsonArray();
			System.out.println("Es array. Numero de elementos: " + array.size());
			java.util.Iterator<JsonElement> iter = array.iterator();
			while (iter.hasNext()) {
				JsonElement entrada = iter.next();
				dumpJSONElement(entrada);
			}

		} else if (elemento.isJsonPrimitive()) {

			JsonPrimitive valor = elemento.getAsJsonPrimitive();
			if (valor.isString()) {
				resultado = valor.getAsString() + " ";
				leerjson.add(resultado);
				System.out.println(leerjson);
				mostrarjs.setText(leerjson.toString());
			}

		}

	}

	public TextField text1;
	public TextField text2;
	public TextField text3;
	static ArrayList<String> almacenarjs = new ArrayList<String>();
	static String almacenar[];

	public void recogerdatos() throws IOException {

		String texto1 = text1.getText();
		String texto2 = text2.getText();
		String texto3 = text3.getText();

		for (String aux : leerjson) {

			System.out.println(aux);

		}

		if (texto1.equals("") || texto2.equals("") || texto3.equals("")) {
			System.out.println("Error");

		} else {

			almacenarjs.add("{Nombre:" + texto1 + ",Apellido2:" + texto2 + ",Apellido3:" + texto3 + "}");
			String ruta = "prueba.json";
			File prueba = new File(ruta);
			BufferedWriter bw;

			String elemento = almacenarjs.toString();
			bw = new BufferedWriter(new FileWriter(prueba));
			bw.write(elemento);

			bw.close();
		}

		System.out.println("*********");
		System.out.println(almacenarjs);

		text1.setText("");
		text2.setText("");
		text3.setText("");

	}

}
