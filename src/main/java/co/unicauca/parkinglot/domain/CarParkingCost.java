package co.unicauca.parkinglot.domain;
import co.unicauca.parkinglot.infra.Utilities;
import java.time.LocalDateTime;
/**
 *
 * @author Daniel Alejandro Navia
 * 
 */
public class CarParkingCost implements IParkingCost 
{
    //Calcula la tarifa, ingresa vehiculo, fecha, hora y devuelve el costo 
    //que debe pagar los clientes que tengan motos
    @Override
    public long  calculateCost(Vehicle vehiculo, LocalDateTime input, LocalDateTime output) 
    {
        int vDiferencia[] = Utilities.Devolver(input, output);
        int horas = vDiferencia[0]*24+vDiferencia[1];
        int minutos = vDiferencia[2];
        long resultado;
        if (horas <1 ) 
        {
            return 2000;
        }else
        {
            float aux = ((float)minutos/60)*1000;
            resultado = 2000 + (horas - 1)*1000 + (long)aux;
        }       
        return Utilities.redondear(resultado);
    }
}