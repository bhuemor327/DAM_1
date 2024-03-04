package Ejemplos_XML;
//Eliminar elementos en DOM

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Ejemplo_5 {
    public static void main(String[] args) {
        try {
            // Cargar el documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder Builder = factory.newDocumentBuilder();
            Document doc = Builder.parse( new File("concesionario_eliminar.xml"));
            
            // Obtener el elemento raíz
            Element raiz = doc.getDocumentElement();
            
            //Vamos a borrar todas las etiquetas "Marca". Primero creamos una lista con las etiquetas que coincidan con ese nombre
            NodeList elementos = raiz.getElementsByTagName("marca");
            
            for (int i=elementos.getLength()-1; i>=0; i--) {
            	Element elemento = (Element) elementos.item(i); 
            	Element padre = (Element) elemento.getParentNode(); //Tomo el padre de ese elemento para poder hacer el removeChild
            	padre.removeChild(elemento);
            }
            
            // Guardar el documento modificado
            OutputStream outputStream = new FileOutputStream("concesionario_modificado.xml");
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(outputStream));
            outputStream.close();
            
            System.out.println("Documento modificado guardado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
