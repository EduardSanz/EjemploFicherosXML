package DOM.escritura;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        //Creo el elemento raiz
        Element raiz = doc.createElement("empresa");
        doc.appendChild(raiz);
        //Creamos un hijo texto con salto de linea por estetica
        raiz.appendChild(doc.createTextNode("\n"));

        //Añado el primer elemento a mi arbol
        Element elemento1 = doc.createElement("empleado");
        raiz.appendChild(elemento1);
        raiz.appendChild(doc.createTextNode("\n"));

        //Añadimos atributo al elemento
        Attr atributo = doc.createAttribute("id");
        atributo.setValue("1");
        elemento1.setAttributeNode(atributo);
        elemento1.appendChild(doc.createTextNode("\n"));

        Element nombre = doc.createElement("nombre");
        elemento1.appendChild(nombre);
        nombre.setTextContent("Manolo de los Palotes");
        elemento1.appendChild(doc.createTextNode("\n"));

        Element username = doc.createElement("username");
        elemento1.appendChild(username);
        username.setTextContent("manolito");
        elemento1.appendChild(doc.createTextNode("\n"));

        Element password = doc.createElement("password");
        elemento1.appendChild(password);
        password.setTextContent("1234");
        elemento1.appendChild(doc.createTextNode("\n"));

        //Creamos el archivo XML con el arbol DOM que hemos creado
        //Para ello usaremos la clase transformer
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource fuente = new DOMSource(doc);
        StreamResult result =new StreamResult(new File("escribirXML.xml"));

        transformer.transform(fuente, result);

    }
}