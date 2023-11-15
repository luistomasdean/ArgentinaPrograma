package incidentes;

import clases.Cliente;
import clases.Servicio;

import java.util.ArrayList;
import java.util.List;

public class InicioPrograma {
    public static void main(String[] args) throws Exception {
     Servicio servicio = new Servicio("Windows");
        Servicio servicio2 = new Servicio("Tango");
        List<Servicio> listServ = new ArrayList<>();
        listServ.add(servicio);
        listServ.add(servicio2);
        Cliente cliente = new Cliente(102, "luis", "Luis@gmail.com");
        Incidente incidente = new Incidente(cliente, "No me anda el windows ni el tago", listServ);
        MesaAyuda mesaAyuda=new MesaAyuda(incidente);
        mesaAyuda.identificarCliente();



        Servicio servicio3 = new Servicio("Windows");
        Servicio servicio4 = new Servicio("Tango");
        List<Servicio> listServ2 = new ArrayList<>();
        listServ2.add(servicio3);
        listServ2.add(servicio4);
        Cliente cliente2 = new Cliente(1, "Client 1", "client1@example.com");
        Incidente incidente2 = new Incidente(cliente2, "No me anda el windows ni el tago", listServ);
        MesaAyuda mesaAyuda2=new MesaAyuda(incidente2);
        mesaAyuda2.identificarCliente();




    }
}
