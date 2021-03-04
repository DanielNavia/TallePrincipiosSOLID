package co.unicauca.parkinglot.access;
/**
 *
 * @author Daniel Alejandro Navia
 * 
 */

public class RepositoryFactory 
{
    private static RepositoryFactory instancia;
    public static RepositoryFactory getInstance()
    {
        if (instancia == null) 
        {
            instancia = new RepositoryFactory();
        }
        return instancia;
    }
    
    public IVehicleRepository getRepository(String type)
    {
        IVehicleRepository result = null;
        switch (type) 
        {
            case "caso base":
                result = new VehicleRepository();
                break;
        }
        return result;
    }
}
