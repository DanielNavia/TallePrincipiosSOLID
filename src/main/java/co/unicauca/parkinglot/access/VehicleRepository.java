package co.unicauca.parkinglot.access;
import co.unicauca.parkinglot.domain.TypeEnum;
import co.unicauca.parkinglot.domain.Vehicle;
import java.security.Provider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Daniel Alejandro Navia
 * 
 */
public class VehicleRepository implements IVehicleRepository
{
    private Connection conector;
    public VehicleRepository() 
    {
        initDatabase();
    }
    
    //Guarda Vehiculo
    @Override
    public boolean save(Vehicle newVehicule) 
    {
        try 
        {
            if (newVehicule == null || newVehicule.getPlate().isEmpty()) 
            {
                return false;
            }
            this.connect();
            String sqllite = "Insertar en vehiculos (placa y tipo)";
            PreparedStatement pstmt = conector.prepareStatement(sqllite);
            pstmt.setString(1, newVehicule.getPlate());
            pstmt.setString(2, newVehicule.getType().name());
            pstmt.executeUpdate();
            pstmt.close();
            this.disconnect();
            return true;
        } catch (SQLException ex) 
        {
            Logger.getLogger(Provider.Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Elimina vehiculo 
    public boolean removeVehicle()
    {
        try 
        {
            this.connect();
            String sql = "Eliminar de vehiculp";
            PreparedStatement pstmt = conector.prepareStatement(sql);
            pstmt.executeUpdate();
            this.disconnect();
            return true;
        } catch (SQLException ex) 
        {
            Logger.getLogger(Provider.Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }    
    
    @Override
    public List<Vehicle> list() {
        List<Vehicle> listauno = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Vehicle;";
            this.connect();
            Statement stmt = conector.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) 
            {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("plate"));
                newVehicle.setType(TypeEnum.valueOf(rs.getString("type")));
                listauno.add(newVehicle);
            }
            this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Provider.Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listauno;
    }

    private void initDatabase() 
    {
        String sqllite = "crea una tabla si no exite un vehiculo";
        try 
        {
            this.connect();
            Statement stmt = conector.createStatement();
            stmt.execute(sqllite);
            this.disconnect();
        }catch (SQLException ex) 
        {
            Logger.getLogger(Provider.Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() 
    {
        //Para guardar los datos en un archivo
        String url = "jdbc:sqlite:./mydatabase.db";
        try 
        {
            conector = DriverManager.getConnection(url);
        } catch (SQLException ex) 
        {
            Logger.getLogger(Provider.Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   // cierra sql
    public void disconnect() 
    {
        try {
            if (conector != null) 
            {
                conector.close();
            }
        } catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }   
}
