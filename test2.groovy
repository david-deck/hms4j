import java.sql.*

Connection connection = DriverManager.getConnection('jdbc:postgresql://gcav708:5432/dataflow', 'root', 'rootpw')
connection.close()

return "Hello ${payload}2 !"
