package com.beginsecure;

import java.io.*;
import java.util.ArrayList;

public class app {
    static void CreateUser(String FirstNama, String LastName, String UserName){
        ArrayList<users> arrayList = new ArrayList<>();
        arrayList.add(new users(FirstNama,LastName,UserName,0));
        try {
            FileOutputStream fs = new FileOutputStream("file.bin");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(arrayList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void AddTask(String UserName, String TaskTitle, String taskDescription) throws IOException, ClassNotFoundException {
        ArrayList<tasck> arrayList = new ArrayList<>();
        arrayList.add(new tasck(UserName,TaskTitle,taskDescription));

        AdjustTask(UserName);

        try {
            FileOutputStream fs = new FileOutputStream("fileTask.bin");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(arrayList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void AdjustTask(String userName) throws IOException, ClassNotFoundException {

        FileInputStream fs = new FileInputStream("file.bin");
        ObjectInputStream ob = new ObjectInputStream(fs);

        FileOutputStream fss = new FileOutputStream("file.bin");
        ObjectOutputStream os = new ObjectOutputStream(fss);

        users obj =null;
        while ( ob.available() != 0 ) {
            obj = (users) ob.readObject();
            if (obj.UserName.equals(userName))
            {
                obj.setCountTasck(obj.CountTasck);
                try {
                    os.writeObject(obj);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

   public static void ShowAllUsers()throws IOException, ClassNotFoundException{


            FileInputStream fs = new FileInputStream("file.bin");
            ObjectInputStream ob = new ObjectInputStream(fs);

            users obj =null;
       while ( ob.available() != 0 ) {
           obj = (users) ob.readObject();
           System.out.println(obj.FirstName);
           System.out.println(obj.LastName);
           System.out.println(obj.CountTasck);
       }
       fs.close();
       ob.close();
    }

    public static void ShowAllTask()throws IOException, ClassNotFoundException{


        FileInputStream fs = new FileInputStream("fileTask.bin");
        ObjectInputStream ob = new ObjectInputStream(fs);

        tasck obj =null;
        while ( ob.available() != 0 ) {
            obj = (tasck) ob.readObject();
            System.out.println(obj.Title);
            System.out.println(obj.Description);
        }
        fs.close();
        ob.close();
    }

    public static void main(String[] args) throws Exception {
        String first = "";
        String second = "";
        String third = "";
        String fourth = "";

        try {
             first = args[0];
             second = args[1];
             third = args[2];
             fourth= args[3];
        }
        catch (ArrayIndexOutOfBoundsException e){
        }

        if (first.equals("createUser")){
            CreateUser(second,third,fourth);
        }

        if (first.equals("addTask")){
            AddTask(second,third,fourth);
        }

        if (first.equals("showAllUsers")){

            ShowAllUsers();
        }

        if (first.equals("showAllTask")){

            ShowAllTask();
        }

    }
    }
