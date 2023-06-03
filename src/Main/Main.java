package Main;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static Main.ConfigDataBase.DataBaseConnection.getDbConnect;
import static Main.Controllers.DisciplineController.*;
import static Main.Controllers.RoleController.*;
import static Main.Controllers.UserController.addUsers;
import static Main.Controllers.UserController.getAllUsers;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

//    //ввод одной роли
//      addRole();
//      System.out.println("-------------------");
//        //вывод всех ролей
//        getAllRoles();

     //обновить роль
//        updateRole();

//        удалить роль
//        deleteRole();
//        getAllRoles();
//
//        //вывести одну запись
//        Scanner input = new Scanner(System.in);
//        Integer id = input.nextInt();
//        getOneRole(id);
//    //вывод ѕќЋ№«ќ¬ј“≈Ћ≈…
//        getAllUsers();
        //вывод всех ролей
//        getAllRoles();
//
////    //вывод ѕќЋ№«ќ¬ј“≈Ћ≈…
//        getAllUsers();
        //getAllDisciplines();

        //addDicipline();
        getAllDisciplines();
        getOneDiscipLines();
    }
}
