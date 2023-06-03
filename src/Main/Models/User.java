package Main.Models;



import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static Main.ConfigDataBase.ConstDB.*;
import static Main.ConfigDataBase.DataBaseConnection.getDbConnect;

public class User {
    //���� ������
    private Integer idUser;
    private Integer roleId;
    private String nameUser;
    private String loginUser;
    private String passwordUser;

    //�����������
    public User() {
    }

    public User(Integer idUser,
                Integer roleId,
                String nameUser,
                String loginUser,
                String passwordUser){

        this.idUser=idUser;
        this.roleId=roleId;
        this.nameUser=nameUser;
        this.loginUser=loginUser;
        this.passwordUser=passwordUser;

    }

    //����� ������ ���� �������
    //������ ����������� ������ User
    public User[] getAll() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //��� ������ �� ��������� ���������� ������� (�����) ������� <-> ����� �������
        String sql = "SELECT COUNT(*) AS count FROM " + TABLE_USERS;

        Statement statement = getDbConnect().createStatement();

        ResultSet countDB = statement.executeQuery(sql);

        Integer countUsers = 0;
        while (countDB.next()){
            countUsers = countDB.getInt("count");
        }

        User[] users =new User[countUsers];
        //��� ������ �� ��������� ������� (�����) �������
        String query = "SELECT * FROM "+TABLE_USERS;
        ResultSet result = statement.executeQuery(query);
        int i =0;
        while (result.next()){
            users[i] = new User(
                    result.getInt("id"),
                    result.getInt("role_id"),
                    result.getString("name"),
                    result.getString("login"),
                    result.getString("password")
            );
            i++;
        }

       return users;
    }

    //����� ������ ����� ������

    //����� ���������� ����� ������
    public void add(Integer roleId, String nameUser, String loginUser, String passwordUser) throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//INSERT INTO `Users` (role_id, name, login, password)
//VALUES (1, 'NewUSER','new-us','111111')
        String query = "INSERT INTO " + TABLE_USERS + " (" + TABLE_USERS_ROLE_ID + ","
                + TABLE_USERS_NAME + ","
                + TABLE_USERS_LOGIN + ","
                + TABLE_USERS_PASSWORD + ") VALUES ("
                + roleId + ",'" + nameUser + "','" + loginUser + "','"+ passwordUser +"')";
        //������������ - ������� ������ � ��������
        System.out.println(query);

        Statement statement = getDbConnect().createStatement();

        statement.executeUpdate(query);

    }
    //����� ���������� ����� ������

    //����� �������� ����� ������


    //�������

    public Integer getRoleId() {
        return roleId;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
}
