package factory;

//import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author Carlos Alberto Bravo Ismiño
 */
public class ConnectionFactory {
    private DataSource dataSource;

    public ConnectionFactory() {
        var comboPooledDataSource = new ComboPooledDataSource();

        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotelalura?useTimeZone=true&serverTimeZone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("#C@bi19Gamer");
        comboPooledDataSource.setMaxPoolSize(10);
        
        this.dataSource = comboPooledDataSource;
    }
    
    public Connection recuperarConexion(){
        try{
            return this.dataSource.getConnection();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
