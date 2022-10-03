package DOM.lectura;

import DOM.modelos.Empleado;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //Utilizamos DocumentBuilder para parsear el XML
        File f = new File("escribirXML.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();

        //Guardo en mi variable documento el xml troceado
        Document doc = db.parse(f);

        //Para darle al texto un formato visual mejor
        doc.getDocumentElement().normalize();

        //Obtenemos la raíz de nuestro árbol DOM
        System.out.println("Elemento raíz: "+ doc.getDocumentElement().getNodeName());
        //Vamos a buscar los nodos con etiqueta empleado y los guardamos en una lista
        NodeList listaEmpleados = doc.getElementsByTagName("empleado");

        for (int i = 0; i < listaEmpleados.getLength(); i++) {
            Node nodo = listaEmpleados.item(i);
            //Una vez tengo el empleado  saco por pantalla su etiqueta
            System.out.println("Elemento: "+nodo.getNodeName());
            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element)nodo;
                //Para leer atributos utilizamos el getAttribute
                System.out.println("id: "+ element.getAttribute("id"));
                //Ahora leemos el contenido de los nodos buscando su nombre y como me devuelve una lista
                //Cojo el primer elemento, 0, y saco su contenido
                System.out.println("Nombre: "+element.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Username: "+element.getElementsByTagName("username").item(0).getTextContent());
                System.out.println("password: "+element.getElementsByTagName("password").item(0).getTextContent());

                int id = Integer.parseInt(element.getAttribute("id"));
                String nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                String userName = element.getElementsByTagName("username").item(0).getTextContent();
                String password = element.getElementsByTagName("password").item(0).getTextContent();

                Empleado empleado = new Empleado(id, nombre, userName, password);
                System.out.println(empleado.toString());
            }
        }

    }
}
