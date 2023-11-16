package dao;

import entities.MesaDeAyuda;

import java.util.List;

public interface MesaDeAyudaDAO {
    void agregarMesaDeAyuda(MesaDeAyuda mesaDeAyuda);
    MesaDeAyuda obtenerMesaDeAyuda(long id);
    List<MesaDeAyuda> obtenerTodasMesasDeAyuda();
    void actualizarMesaDeAyuda(MesaDeAyuda mesaDeAyuda);
    void eliminarMesaDeAyuda(MesaDeAyuda mesaDeAyuda);
}