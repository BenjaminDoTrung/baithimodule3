package service;

import DAO.ClassRoomDAO;
import modle.ClassRoom;

import java.util.List;

public class ManageClassRoom {
    private List<ClassRoom> classRooms;
    public List<ClassRoom> classRooms(){
        ClassRoomDAO classRoomDAO = new ClassRoomDAO();

        classRooms = classRoomDAO.listClassRoom();
        return classRooms;
    }
    public ClassRoom oneClass(int id){
        List<ClassRoom> list = classRooms();
        for (ClassRoom c : list) {
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }
}
