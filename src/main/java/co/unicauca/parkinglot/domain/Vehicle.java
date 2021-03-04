package co.unicauca.parkinglot.domain;
/**
 *
 * @author Daniel Alejandro Navia
 * 
 */
public class Vehicle 
{
    private String plate; 
    private TypeEnum type;
    
    //tipo y caracteristica del vehiculo
    //Getters, Setters and constructor
    public Vehicle(String plate, TypeEnum type) 
    {
        this.plate = plate;
        this.type = type;
    }
    
    
    public Vehicle() 
    {
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }
    
    //Informacion Salida
    @Override
    public String toString() 
    {
        return "Vehiculo de placa: " + plate + ", de tipo: " + type;
    }
}
    
    