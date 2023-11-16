package entities;

import dao.TecnicoDAO;
import impl.TecnicoDAOImpl;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TecnicoTest {

    @Test
    public void testGetId() {

        // Crear una instancia de TecnicoDAOImpl
        TecnicoDAO tecnicoDAO = new TecnicoDAOImpl();

        // Crear un objeto Tecnico para probar los métodos
        Tecnico nuevoTecnico = new Tecnico();
        nuevoTecnico.setNombre("Nombre del Técnico");
        nuevoTecnico.setEspecialidad("Especialidad del Técnico");

        // Agregar el técnico
        tecnicoDAO.agregarTecnico(nuevoTecnico);
        System.out.println("Técnico agregado con éxito");

        // Obtener un técnico por ID
        long tecnicoId = 1; // Reemplaza con el ID que deseas obtener
        Tecnico tecnicoObtenido = tecnicoDAO.obtenerTecnico(tecnicoId);
        if (tecnicoObtenido != null) {
            System.out.println("Técnico obtenido: " + tecnicoObtenido);
        } else {
            System.out.println("No se pudo encontrar el técnico con ID: " + tecnicoId);
        }

        // Obtener todos los técnicos
        List<Tecnico> tecnicos = tecnicoDAO.obtenerTodosTecnicos();
        System.out.println("Lista de todos los técnicos:");
        for (Tecnico t : tecnicos) {
            System.out.println(t);
        }

        // Actualizar un técnico
        // (Asegúrate de tener el ID correcto y de haber modificado los atributos del técnico)
        tecnicoObtenido.setNombre("Nuevo Nombre");
        tecnicoObtenido.setEspecialidad("Nueva Especialidad");
        tecnicoDAO.actualizarTecnico(tecnicoObtenido);
        System.out.println("Técnico actualizado con éxito");

        // Eliminar un técnico
        // (Asegúrate de tener el ID correcto)
        tecnicoDAO.eliminarTecnico(tecnicoObtenido);
        System.out.println("Técnico eliminado con éxito");
    }
}

