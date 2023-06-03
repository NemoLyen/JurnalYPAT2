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

    //метод Вывода всех записей Таблицы
    //коллекция Map - выводит ввиде Ассоциативного массива
    public HashMap<Integer, String> allRoles() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //строка с запросом на вывод всех данных из таблицы
        String query = "SELECT * FROM Roles";

        //для отпарвки запрпосов в БД используется пакет Statement
        Statement statement = getDbConnect().createStatement();
        //результат выполнения запроса
        ResultSet result = statement.executeQuery(query);

        //создам Ассоциативный массив и присвоб данные из БД его элементам
        HashMap<Integer, String> array = new HashMap<>();
        //цикл while для перебора полученных записей из БД
        while (result.next()){
            array.put(result.getInt("id"),result.getString("name"));
        }
        return array;


    }
    //метод вывода указанной записи
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
    //метод добавления Записей
    public void add(String name) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        //строка с текстом запроса Добавить запись
        String query = "INSERT INTO "+ROLE_TABLE+" ("+ROLE_TABLE_NAME+") VALUES ('"+name+"')";

        Statement statement = getDbConnect().createStatement();
        System.out.println(query);
        statement.executeUpdate(query);


    }
    //метод обновления одной записи
    public void update(Integer id, String name) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (id!=100 && id!=1) {
            String query = "UPDATE " + ROLE_TABLE + " SET " + ROLE_TABLE_NAME + " = '" + name + "' WHERE " + ROLE_TABLE_ID + " = " + id;
            Statement statement = getDbConnect().createStatement();
            System.out.println(query);
            statement.executeUpdate(query);
        } else {
            System.out.println("Этого пользователя обновлять нельзя");
        }
    }
    //метод удаления одной записи
    public void delete(Integer id) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if(id !=100 && id!=1) {
            String query = "DELETE FROM " + ROLE_TABLE + " WHERE " + ROLE_TABLE_ID + " = " + id;
            Statement statement = getDbConnect().createStatement();
            System.out.println(query);
            statement.executeUpdate(query);
        }else {
            System.out.println("Этого пользователя удалять нельзя");
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
