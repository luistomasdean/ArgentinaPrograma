package incidentes;

import clases.Cliente;
import clases.Servicio;

import java.util.List;

public class Incidente {
    private Cliente cliente;
    private String incidenteCliente;
    private List<Servicio> servicios;

    public Incidente(Cliente cliente, String incidenteCliente, List<Servicio> servicios) {
        this.cliente = cliente;
        this.incidenteCliente = incidenteCliente;
        this.servicios = servicios;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getIncidenteCliente() {
        return incidenteCliente;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }
}
