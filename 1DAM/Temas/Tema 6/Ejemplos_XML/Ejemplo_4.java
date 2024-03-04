//Crear fichero XML con JAVA

package Ejemplos_XML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ejemplo_4 {

    public static void main(String[] args) {

        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Creo un DOMImplementation. Este método devuelve una instancia de 
            //DOMImplementation, que es una interfaz que proporciona métodos para crear 
            //objetos DOM independientes de la implementación específica. 
            DOMImplementation implementation = builder.getDOMImplementation();

            // Creo un documento e identifico la versión (namespace, elemento raíz y doctype)
            Document documento = implementation.createDocument(null, "concesionario", null);
            documento.setXmlVersion("1.0");
            
            // Creo los elementos (una etiqueta XML) 
            Element coches = documento.createElement("coches");
            Element coche = documento.createElement("coche");

            // Creo el elemento Matrícula y le añado un nodo tipo Texto
            Element matricula = documento.createElement("matricula");
            Text textMatricula = documento.createTextNode("1111AAA");
            matricula.appendChild(textMatricula); //Una vez creado se debe asignar
            coche.appendChild(matricula);

            // Marca
            Element marca = documento.createElement("marca");
            Text textMarca = documento.createTextNode("AUDI");
            marca.appendChild(textMarca);
            coche.appendChild(marca);

            // Precio
            Element precio = documento.createElement("precio");
            Text textPrecio = documento.createTextNode("30000");
            precio.appendChild(textPrecio);
            coche.appendChild(precio);

            // Añado al elemento coches el elemento coche
            coches.appendChild(coche);

            // Añado al elemento raíz el elemento coches
            documento.getDocumentElement().appendChild(coches);

            // Asocio el source con el Document
            Source source = new DOMSource(documento);
            // Creo el Result, indicado que fichero se va a crear
            Result result = new StreamResult(new File("concesionario_output.xml"));

            // Creo un transformer, se crea el fichero XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }

    }

}