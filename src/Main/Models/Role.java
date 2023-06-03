package Main.Models;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

import Main.ConfigDataBase.DataBaseConnection.*;

import static Main.ConfigDataBase.ConstDB.*;
import static Main.ConfigDataBase.DataBaseConnection.getDbConnect;

public class Role {
    private Integer id;
    private String name;
    public Role(){}
    public Role(int id, String name) {
        this.id =id;
        this.name=name;
    }

    //����� ������ ���� ������� �������
    //��������� Map - ������� ����� �������������� �������
    public HashMap<Integer, String> allRoles() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //������ � �������� �� ����� ���� ������ �� �������
        String query = "SELECT * FROM Roles";

        //��� �������� ��������� � �� ������������ ����� Statement
        Statement statement = getDbConnect().createStatement();
        //��������� ���������� �������
        ResultSet result = statement.executeQuery(query);

        //������ ������������� ������ � ������� ������ �� �� ��� ���������
        HashMap<Integer, String> array = new HashMap<>();
        //���� while ��� �������� ���������� ������� �� ��
        while (result.next()){
            array.put(result.getInt("id"),result.getString("name"));
        }
        return array;


    }
    //����� ������ ��������� ������
    public Role oneRole(Integer id) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Role role = new Role();
        String query = "SELECT * FROM "+ ROLE_TABLE + " WHERE "+ROLE_TABLE_ID+ " = "+id;
        Statement statement = getDbConnect().createStatement();
        System.out.println(query);
        ResultSet result = statement.executeQuery(query);
        while (result.next()){
            role = new Role(result.getInt("id"),result.getString("name"));
        }
        return role;
    }
    //����� ���������� �������
    public void add(String name) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        //������ � ������� ������� �������� ������
        String query = "INSERT INTO "+ROLE_TABLE+" ("+ROLE_TABLE_NAME+") VALUES ('"+name+"')";

        Statement statement = getDbConnect().createStatement();
        System.out.println(query);
        statement.executeUpdate(query);


    }
    //����� ���������� ����� ������
    public void update(Integer id, String name) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (id!=100 && id!=1) {
            String query = "UPDATE " + ROLE_TABLE + " SET " + ROLE_TABLE_NAME + " = '" + name + "' WHERE " + ROLE_TABLE_ID + " = " + id;
            Statement statement = getDbConnect().createStatement();
            System.out.println(query);
            statement.executeUpdate(query);
        } else {
            System.out.println("����� ������������ ��������� ������");
        }
    }
    //����� �������� ����� ������
    public void delete(Integer id) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(id !=100 && id!=1) {
            String query = "DELETE FROM " + ROLE_TABLE + " WHERE " + ROLE_TABLE_ID + " = " + id;
            Statement statement = getDbConnect().createStatement();
            System.out.println(query);
            statement.executeUpdate(query);
        }else {
            System.out.println("����� ������������ ������� ������");
        }
    }
    //

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
