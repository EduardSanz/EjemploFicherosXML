package xtream;

import DOM.modelos.Empleado;
import com.thoughtworks.xstream.XStream;

public class Escritor {
    public static void main(String[] args) {
        Empleado empleado = new Empleado(1, "edu", "esanz", "1234");
        XStream xs = new XStream();

        xs.allowTypesByWildcard(new String[] {
                "DOM.modelos.*"
        });

        System.out.println(xs.toXML(empleado));

        Empleado emp1 =new Empleado();
        xs.fromXML(xs.toXML(empleado), emp1);

        System.out.println(emp1);
    }
}
