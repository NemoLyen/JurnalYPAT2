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

//    //���� ����� ����
//      addRole();
//      System.out.println("-------------------");
//        //����� ���� �����
//        getAllRoles();

     //�������� ����
//        updateRole();

//        ������� ����
//        deleteRole();
//        getAllRoles();
//
//        //������� ���� ������
//        Scanner input = new Scanner(System.in);
//        Integer id = input.nextInt();
//        getOneRole(id);
//    //����� �������������
//        getAllUsers();
        //����� ���� �����
//        getAllRoles();
//
////    //����� �������������
//        getAllUsers();
        //getAllDisciplines();

        //addDicipline();
        getAllDisciplines();
        getOneDiscipLines();
    }
}
