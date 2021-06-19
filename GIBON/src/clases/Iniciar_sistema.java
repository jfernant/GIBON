package clases;

import Gibon.frm_Login;
import Gibon.frm_error_conexion;

/*
Clase: Iniciar_sistema
Autor: Katering Milagro
Version 1.0   05/03/2020

Clase que permite dar incio al sistema, validando la conexión
exitosa con la base de datos. 
*/

public class Iniciar_sistema {
    public static void main(String[] args) {
        frm_Login GBN = new frm_Login();
        GBN.setVisible(true);
    }
    
}
