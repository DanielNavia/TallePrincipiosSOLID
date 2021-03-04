package co.unicauca.parkinglot.infra;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Daniel Alejandro Navia
 * 
 */


public class Utilities 
{
    //Calcula lo que se debe devolver al cliente
    public static int[] Devolver(LocalDateTime input, LocalDateTime output)
    {
        int anio=0;
        int dia=0;
        int hora=0;
        int minutos=0;        
        int [] vDevolver = new int[3];
        
        Date fechaInicial = new Date(input.getYear(), input.getMonthValue(), input.getDayOfMonth(), input.getHour(), input.getMinute());
        Date fechaFinal = new Date(output.getYear(), output.getMonthValue(), output.getDayOfMonth(), output.getHour(), output.getMinute());
        int diferencia = (int)((fechaFinal.getTime()- fechaInicial.getTime())/1000);
                
        if (diferencia >= 86400) 
        {
            dia = (int) Math.floor(diferencia / 86400);
            diferencia = diferencia - (dia * 86400);
        }        
        if (diferencia >= 3600) 
        {
            hora = (int) Math.floor(diferencia / 3600);
            diferencia = diferencia - (hora * 3600);
        }        
        if (diferencia >= 60) 
        {
            minutos = (int) Math.floor(diferencia / 60);
        }
        
        vDevolver[0] = dia;
        vDevolver[1] = hora;
        vDevolver[2] = minutos;
        
        return vDevolver;
    }
    
    //Redondea el coste a pagar por el cliente 
    public static long redondear(long coste)
    {
        if (coste %100 != 0) 
        { 
            long aux = coste %1000 - coste % 100;
            aux += 100;
            coste -= coste %1000;
            coste += aux;
        }
        return coste;
    }
}
