package co.unicauca.parkinglot.domain.service;
import co.unicauca.parkinglot.access.IVehicleRepository;
import co.unicauca.parkinglot.domain.IParkingCost;
import co.unicauca.parkinglot.domain.ParkingCostFactory;
import co.unicauca.parkinglot.domain.Vehicle;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Alejandro Navia
 * 
 */

public class Service 
{
    IVehicleRepository repository;

    public Service(IVehicleRepository repository) 
    {
        this.repository = repository;
    }
        
    public long calculateParkingCost(Vehicle vehicle,LocalDateTime input,LocalDateTime output)
    {
        if (vehicle==null) 
        {
            return -1;
        }            
        // Se devuelve una instancia de IParkingCost  
        IParkingCost cost = ParkingCostFactory.getInstance().getRepository(vehicle.getType());
        return cost.calculateCost(vehicle, input, output);
    }
    
    //Guarda el vehiculo
    public boolean saveVehicle(Vehicle newVehiculo)
    {
        if (newVehiculo == null || newVehiculo.getPlate().isEmpty() || newVehiculo.getType().toString().isEmpty()) 
            return repository.save(newVehiculo);       
        return false;
    }
    
    //Lista de Vehiculos 
    public List<Vehicle> listaVehiculos()
    {
        List<Vehicle> listauno = new ArrayList<>();
        listauno = repository.list();
        return listauno;
    }  
    
}

















