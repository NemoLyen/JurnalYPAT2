package Main.Controllers;

import Main.Models.Role;
import Main.Models.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserController extends User {
    //����� �������������
    public static void getAllUsers() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User users = new User();
        System.out.println("��� ������������");
        System.out.println("� | ���� |  ��� | �����  | ������ |");
        System.out.println("------------------------------------");
        for (int i = 0; i< users.getAll().length; i++){
            System.out.println(users.getAll()[i].getIdUser() + " | "
                    + users.getAll()[i].getRoleId() + " | "
                    + users.getAll()[i].getNameUser() + " | "
                    + users.getAll()[i].getLoginUser() + " | "
                    + users.getAll()[i].getPasswordUser()
            );
        }
    }
    //
    public static void addUsers() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User user = new User();
        Scanner input = new Scanner(System.in);

        System.out.println("������� ��� ������������");
        String name = input.nextLine();
        System.out.println("������� ����� ������������");
        String login = input.nextLine();
        System.out.println("������� ������ ������������");
        String password = input.nextLine();
        System.out.println("������� ���� ������������");
        Integer roleId = input.nextInt();

        user.add(roleId,name,login,password);



    }

}
