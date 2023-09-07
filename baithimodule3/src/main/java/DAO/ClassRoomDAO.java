package DAO;

import modle.ClassRoom;
import myconnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomDAO {
    private static final String selectClassRoom = "select * from classroom;";

    public List<ClassRoom> listClassRoom () {
        List<ClassRoom> classRooms = new ArrayList<>();
        try {
            Connection conn = MyConnection.getInstance();
            PreparedStatement pr = conn.prepareStatement(selectClassRoom);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameClass = resultSet.getString("nameclass");

                ClassRoom classRoom = new ClassRoom(id, nameClass);
                classRooms.add(classRoom);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return classRooms;
    }
}
