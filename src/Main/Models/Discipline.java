package Main.Models;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static Main.ConfigDataBase.ConstDB.*;
import static Main.ConfigDataBase.DataBaseConnection.getDbConnect;

public class Discipline {
    //поля данных
    private Integer id;
    private String name;

    //конструкторы
    public Discipline() {
    }

    public Discipline(
            Integer id,
            String name
    ) {
        this.id=id;
        this.name=name;
    }

    //методы
    //вывод записей с помощью ArrayList<>
    //ПРИМЕР
    //создам коллекция ArrayList<>
    public ArrayList<Discipline> getTestDisciplines(){
        Discipline disc1 = new Discipline(1, "Математика");
        Discipline disc2 = new Discipline(2, "Физика");
        Discipline disc3 = new Discipline(3, "Астрономия");
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(disc1);
        disciplines.add(disc2);
        disciplines.add(disc3);
        disciplines.add(new Discipline(4,"Информатика"));
        disciplines.add(new Discipline(5,"Английский язык"));
        return disciplines;
    }

    public ArrayList<Discipline> getAll() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ArrayList<Discipline> disciplines = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_DISC;

        Statement statement = getDbConnect().createStatement();

        ResultSet result = statement.executeQuery(query);

        while (result.next()){

            disciplines.add(new Discipline(result.getInt("id"),result.getString("name")));

        }
        return disciplines;

    }
    public void add(String nameDisc) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String query = "INSERT INTO "+ TABLE_DISC + " ("+ TABLE_DISC_NAME + ") VALUES ('" + nameDisc + "')";
        Statement statement = getDbConnect().createStatement();
        statement.executeUpdate(query);
    }
    public void update(Integer id, String newName) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        statement("UPDATE " + TABLE_DISC + " SET "+ TABLE_DISC_NAME + " = " + "'"+newName + " ' WHERE " + TABLE_DISC_ID + " = " + id);
    }
    public void delete(Integer id) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        statement("DELETE FROM "+ TABLE_DISC + " WHERE " + TABLE_DISC_ID + " = " + id);
    }
    public Discipline show(Integer id) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String query = "SELECT * FROM " + TABLE_DISC + " WHERE " + TABLE_DISC_ID + " = " + id;
        Statement statement = getDbConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        Discipline discipline = new Discipline();
        while (resultSet.next()) {
            discipline = new Discipline(resultSet.getInt("id"), resultSet.getString("name"));

        }
        return discipline;
    }

    private static void  statement(String query) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Statement statement = getDbConnect().createStatement();
        statement.executeUpdate(query);
    }

    //геттеры

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
