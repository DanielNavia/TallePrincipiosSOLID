package co.unicauca.parkinglot.domain;
import java.time.LocalDateTime;

/*
 *
 * @author Daniel Alejandro Navia
 * 
 */

//Interfaz para calcular el costo del parqueadero de cualquier tipo de
//vehiculo: carro, moto, camión
public interface IParkingCost 
{
    long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output);
}