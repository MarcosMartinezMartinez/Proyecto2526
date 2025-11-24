package es.ieslavereda.proyectospringboot2526.Connector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

@Configuration
public class MyDataSource {
    @Bean(name = "fuenteDeDatosMySQL")
    public static DataSource getDataSource(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/proyecto2526");
        dataSource.setUser("marcos");
        dataSource.setPassword("1111");
        return dataSource;
    }
}
