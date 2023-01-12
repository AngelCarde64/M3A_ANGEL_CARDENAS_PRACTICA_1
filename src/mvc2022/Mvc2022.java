package mvc2022;

import Vista.*;
import Controlador.*;

public class Mvc2022 {

    public static void main(String[] args) {
        VistaMP vista = new VistaMP();
        ControllerMP controller = new ControllerMP(vista);
        controller.iniciaControl();
//        Diseño_Punto_De_Venta dise= new Diseño_Punto_De_Venta();
//        dise.setVisible(true);
    }
}
