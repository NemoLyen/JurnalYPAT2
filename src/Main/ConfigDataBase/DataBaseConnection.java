package Main.ConfigDataBase;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection extends Connect {
    //использую библиотеку для работы с Базами данных CONNECTION
    static Connection dbConnect; //Объявил экземпляр класса Connection по имени dbConnect


    //Метод вывода результат подключения к Базе данных
    public static Connection getDbConnect() throws ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        String connectorString = "jdbc:mysql://"+host+"/"+nameDB+"";
        String connectorString = "jdbc:mysql://192.168.3.211:3306/rybin1_jurYPAT";
        //подключаю драйвер
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        //само подключение через метод
        dbConnect = DriverManager.getConnection(connectorString,userNameDB, passwordDB);
//        System.out.println("Успешное подключение к Базе Данных!!!");
        return dbConnect;
    }

}
