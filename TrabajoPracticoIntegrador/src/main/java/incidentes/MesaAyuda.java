package incidentes;

import clases.Cliente;
import clases.Servicio;
import conexion.AreaComercialImpl;

import java.util.List;

public class MesaAyuda {
    private AreaComercialImpl areaComercial;
    private Incidente incidente;

    public MesaAyuda(Incidente incidente) {
        this.incidente = incidente;
        this.areaComercial = new AreaComercialImpl();
    }

    public boolean identificarCliente() throws Exception {
        List<Cliente> clientes = areaComercial.listar();

        Cliente clienteBuscado = incidente.getCliente();

        boolean resultado = clientes.stream().anyMatch(cliente -> cliente.equals(clienteBuscado));
        System.out.println(resultado);
        if (resultado) {
            ingresarIncidenteAlSistema(incidente.getServicios());
        } else {

            System.out.println("No está en la base de datos: " + clienteBuscado);
        }

        return resultado;
    }

    public void ingresarIncidenteAlSistema(List<Servicio> servicios) {
        System.out.println("Esta en la base de datos cliente" + incidente.getCliente());

        System.out.println("hola ingresarIncidenteAlSistema");
    }
}
