package co.unicauca.parkinglot.domain;
import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;
/**
 *
 * @author Daniel Alejandro Navia
 * 
 */

public class TruckParkingCost implements IParkingCost
{
    //Calcula la tarifa, ingresa vehiculo, fecha, hora y devuelve el costo 
    //que debe pagar los clientes que tengan camiones
    
    @Override
    public long calculateCost(Vehicle vehiculo, LocalDateTime input, LocalDateTime output) 
    {
        int vDiferencia[] = Utilities.Devolver(input, output);
        int horas = vDiferencia[0]*24+vDiferencia[1];
        int minutos = vDiferencia[2];
        long resultado;
        
        if ((horas <= 11 && minutos <= 59) || (horas == 12 && minutos == 0)) 
        {
            return 10000;
        }else if((horas<=23 && minutos<=59) || (horas==24 && minutos==0))
        {
            return 15000;
        }else
        {
            float aux = ((float)(15000*vDiferencia[1]))/24;
            resultado = vDiferencia[0]*15000 + (long)aux;
        }
        return Utilities.redondear(resultado);
    }
}
