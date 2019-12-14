package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.TextArea;

public class TxtController {

	public TextArea textarea_txt_1;

	public void muestraContenido() throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader("prueba.txt");
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			textarea_txt_1.setText(cadena.toString());
		}
		b.close();

	}

	public TextArea textarea_txt_2;

	public void creartxt() throws IOException {
		String ruta = "prueba.txt";
		File prueba = new File(ruta);
		BufferedWriter bw;
		if (prueba.exists()) {
			bw = new BufferedWriter(new FileWriter(prueba, true));
			bw.write(textarea_txt_2.getText());
		} else {
			bw = new BufferedWriter(new FileWriter(prueba));
			bw.write("El fichero de texto ya esta creado");
		}
		bw.close();

	}

}
