package org.example;
import java.sql.*;

public class StuDao {
    static Connection conn;

    static void getAllStudents() {
        conn = DBConnection.createConnection();
        String query = "select * from students";
        try {
            Statement st=conn.createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getInt(2)+
                        " "+rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    static void getStudentbyID(int id){
        conn = DBConnection.createConnection();
        String query = "select * from students where id="+id;
        try{
            Statement st=conn.createStatement();
        ResultSet rs= st.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getInt(2)+
                    " "+rs.getInt(3));
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static void updateStudentbyID(int id,String updatedName){
        conn=DBConnection.createConnection();
        String query="update students set name=? where id=?";
                try {
                    PreparedStatement pr = conn.prepareStatement(query);
                    pr.setString(1, updatedName);
                    pr.setInt(2, id);
                    int a = pr.executeUpdate();
                    if (a != 0) System.out.println("Updated Successfully!");
                }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static void deleteStudentbyID(int id) {
        conn = DBConnection.createConnection();
        String query = "Delete from students where id=?";
        try {
PreparedStatement pr=conn.prepareStatement(query);
pr.setInt(1,id);
int a=pr.executeUpdate();
if(a!=0) System.out.println("deleted Successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
