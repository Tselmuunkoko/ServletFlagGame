package com.example.demo3;


import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;

public class UserSerializer {
    private File f;
    private ArrayList<UserBean> userList;
    UserSerializer(){}
    public UserSerializer(String filePath) throws IOException {
        this.f  = new File(filePath); // in tomcat_home/bin/user.txt
        if (this.f.createNewFile()) {
            System.out.println("File created: " + f.getName());
        } else {
            System.out.println("File already exists.");
        }
        this.userList = this.readFromFile();
    }
    public void writeToFile(UserBean userBean) throws IOException {
        ArrayList<UserBean> u = this.readFromFile();
        u.add(userBean);
        ObjectOutputStream outputStream = new ObjectOutputStream(
                Files.newOutputStream(this.f.toPath()));
        outputStream.writeObject(u);
        outputStream.close();
    }
    public ArrayList<UserBean> readFromFile() throws IOException {
        ArrayList<UserBean> u = new ArrayList<>();
        if (this.f.length()==0) return u;
        ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(this.f.toPath()));
        try {
             u = (ArrayList<UserBean>) inputStream.readObject();
             this.setUserList(u);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        inputStream.close();
        return u;
    }

    public void setUserList(ArrayList<UserBean> userList) {
        this.userList = userList;
    }

    public ArrayList<UserBean> getUserList() {
        return userList;
    }
}
