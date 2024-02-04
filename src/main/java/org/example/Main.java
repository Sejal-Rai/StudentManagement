package org.example;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM");
        do{
            System.out.println("Enter 1 for creating student\n"+
                    "Enter 2 for fetching all the students\n"+
                    "Enter 3 for fetching student by ID\n"+
                    "Enter 4 for updating student by ID\n"+
                    "Enter 5 for deleting student by ID\n"+
                    "Enter 6 for exiting the program");
            int n=sc.nextInt();
            switch(n){
                case 1-> {
                    System.out.println("Enter Student Name");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter student age");
                    int age = sc.nextInt();
                    System.out.println("Enter Student ID");
                    int id = sc.nextInt();
                    StuInfo student = new StuInfo(name, age, id);
                    try {
                        String query="insert into students values(?,?,?)";
                        StuDao.conn= DBConnection.createConnection();
                        PreparedStatement pr= StuDao.conn.prepareStatement(query);
                        pr.setString(1, student.getName());
                        pr.setInt(2, student.getAge());
                        pr.setInt(3, student.getId());
                        int res=pr.executeUpdate();
                        if(res!=0) System.out.println("insert successfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                case 2 -> StuDao.getAllStudents();
                case 3->{
                    System.out.println("Enter Id of student which you have to fetch");
                    int id=sc.nextInt();
                    StuDao.getStudentbyID(id);
                }
                case 4->{
                    System.out.println("Enter ID no. of Student which you want to update");
                    int id= sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter updated name");
                    String name= sc.nextLine();
                    StuDao.updateStudentbyID(id,name);
                }
                case 5->{
                    System.out.println("Enter ID of student which you want to delete");
                    int id=sc.nextInt();
                    StuDao.deleteStudentbyID(id);
                }
                case 6 ->System.exit(0);
            }
        }while(true);
    }
}