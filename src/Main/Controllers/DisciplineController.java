package Main.Controllers;

import Main.Models.Discipline;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DisciplineController extends Discipline {

    public static void getTest(){

        Discipline discipline = new Discipline();

        System.out.println("� | �����������");
        System.out.println("---------------");

        ArrayList<Discipline> array = discipline.getTestDisciplines();

        for (int i = 0; i< array.size();i++){
            System.out.println(array.get(i).getId() + " |  " + array.get(i).getName());
        }

    }
    public static void getAllDisciplines() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Discipline discipline = new Discipline();

        System.out.println("� | �����������");
        System.out.println("---------------");

        ArrayList<Discipline> array = discipline.getAll();

        for (int i=0; i< array.size(); i++){
            System.out.println(array.get(i).getId() + " | " +
                               array.get(i).getName());
        }
    }

    public static void addDicipline() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        getAllDisciplines();

        System.out.println("������� �������� ����� ����������");
        discipline.add(name);
        getAllDisciplines();
    }
    public static void  updateDiscipline() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);

        System.out.println("������� ����� ��������");
        String name = input.nextLine();

        System.out.println("������� ����� ����������");
        Integer id = input.nextInt();



        discipline.update(id,name);

    }
    public static void getOneDiscipLines() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);

        System.out.println("������� ����� ID");
        Integer id = input.nextInt();

        System.out.println(discipline.show(id));
        System.out.println("�: " +discipline.show(id).getId()+ ") ��������: " + discipline.show(id).getName());
    }
    public static void deleteDisciLines() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Discipline discipline = new Discipline();
        Scanner input = new Scanner(System.in);

        getAllDisciplines();
        System.out.println("������� ����� ID");
        Integer id = input.nextInt();

        discipline.delete(id);
        getAllDisciplines();


    }


}
