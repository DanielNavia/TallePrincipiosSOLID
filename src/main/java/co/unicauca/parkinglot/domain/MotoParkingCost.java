package co.unicauca.parkinglot.domain;
import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;

/**
 *
 * @author Daniel Alejandro Navia
 * 
 */

public class MotoParkingCost implements IParkingCost
{  
    //Calcula la tarifa, ingresa vehiculo, fecha, hora y devuelve el costo 
    //que debe pagar los clientes que tengan motos
    @Override
    public long calculateCost(Vehicle vehiculoes, LocalDateTime input, LocalDateTime output) {
        int vDiferecia[] = Utilities.Devolver(input, output);
        int horas = vDiferecia[0]*24+vDiferecia[1];
        int minutos = vDiferecia[2];
        long resultado;        
        if (horas < 1) 
        {
            return 1000;
        }else
        {
            float aux = ((float)minutos/60)*500;
            resultado = 1000 + (horas - 1)*500 + (long)aux ;        
        }
        return Utilities.redondear(resultado);
    }
    
}
