package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Cliente;
import com.curso.model.Vehiculo;
/**
 * Repositorio para realizar operaciones de base de datos relacionadas con la
 * entidad Vehículo
 * Extiende de JpaRepository para aprovechar las operaciones CRUD básicas
 */
public interface VehiculoDao extends JpaRepository<Vehiculo, Integer> {
	
	
	/**
	 * Consulta personalizada para obtener todos los vehículos que tienen
	 * un fabricante específico
	 * 
	 * @param nombreFabricante  Nombre del fabricante del vehículo
	 * @return					Lista de vehículos del fabricante especificado
	 */
	
	@Query("SELECT v FROM Vehiculo v WHERE v.fabricante = :nombreFabricante")
	public List<Vehiculo> getVehiculosByFabricante(String nombreFabricante);

    @Query("SELECT v FROM Vehiculo v WHERE v.matricula = :matricula")
    public Vehiculo getVehiculoByMatricula(@Param("matricula") String matricula);


    @Query("SELECT c FROM Cliente c JOIN c.vehiculos v WHERE v.id = :id")
    public Cliente getClienteByVehiculoID(@Param("id") int id);


}
