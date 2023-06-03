package Main.Controllers;

import Main.Models.Role;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class RoleController extends Role {

    public static void getAllRoles() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Role role = new Role();

        System.out.println("��� ���� ������������� � �������");
        System.out.println("�  |  ��� ����");
        System.out.println("-----------------------------------");
        //����� HashMap<Integer, String> ��������� � ������� ������ size()
        role.allRoles().forEach((Integer id, String name) ->
                {
                    System.out.println(id + " |  " + name);
                }
        );


    }
    public static void getOneRole(Integer id) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Role role = new Role();
        System.out.println("� | ��� ����");
        System.out.print(role.oneRole(id).getId() + " | " + role.oneRole(id).getName());
        System.out.println();

    }
    public static void addRole() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Role role = new Role();
        Scanner input = new Scanner(System.in);

        System.out.println("������� �������� ����");
        String name = input.nextLine();

        role.add(name);

    }

    public static void updateRole() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Role role = new Role();
        Scanner input = new Scanner(System.in);

        System.out.println("������� ����� �������� ����");
        String newName = input.nextLine();

        System.out.println("�������� � ID ����");
        Integer id = input.nextInt();

        role.update(id,newName);



    }

    public static void deleteRole() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Role role = new Role();
        Scanner input = new Scanner(System.in);

        System.out.println("�������� � ID ����, ������� ���� �������");
        Integer id = input.nextInt();

        role.delete(id);


    }




}
