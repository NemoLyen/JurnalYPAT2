package Main.ConfigDataBase;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection extends Connect {
    //��������� ���������� ��� ������ � ������ ������ CONNECTION
    static Connection dbConnect; //������� ��������� ������ Connection �� ����� dbConnect


    //����� ������ ��������� ����������� � ���� ������
    public static Connection getDbConnect() throws ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        String connectorString = "jdbc:mysql://"+host+"/"+nameDB+"";
        String connectorString = "jdbc:mysql://192.168.3.211:3306/rybin1_jurYPAT";
        //��������� �������
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        //���� ����������� ����� �����
        dbConnect = DriverManager.getConnection(connectorString,userNameDB, passwordDB);
//        System.out.println("�������� ����������� � ���� ������!!!");
        return dbConnect;
    }

}
