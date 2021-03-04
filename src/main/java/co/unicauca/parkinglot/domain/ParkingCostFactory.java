package co.unicauca.parkinglot.domain;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Daniel Alejandro Navia
 * 
 */

public class ParkingCostFactory 
{
    
    private Map<TypeEnum,IParkingCost> costDictionary;
    private static ParkingCostFactory instancia;

    //Diccionario y valores a objetos
    private ParkingCostFactory() 
    {
        costDictionary = new EnumMap <> (TypeEnum.class);
        costDictionary.put(TypeEnum.MOTO, new MotoParkingCost());
        costDictionary.put(TypeEnum.CAR, new CarParkingCost());
        costDictionary.put(TypeEnum.TRUCK, new TruckParkingCost());
    }
    
    //instanciamos
    public static ParkingCostFactory getInstance()
    {
        if (instancia==null) {
            instancia = new ParkingCostFactory();
        }
        return instancia;
    }
    
    //tipo de vehiculo
    public IParkingCost getRepository(TypeEnum type)
    {
        IParkingCost resultado = null;
        if (costDictionary.containsKey(type)) 
        {
            resultado = costDictionary.get(type);
        }
        return resultado;
    }
    
}
