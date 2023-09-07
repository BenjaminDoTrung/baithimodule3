package DAO;

import modle.ClassRoom;
import modle.ThongTinHocVien;
import myconnection.MyConnection;
import service.ManageClassRoom;
import service.ManageThongTinHocVien;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ThongTinHocVienDAO {
    private static final String selectThongTin = "select * from thongtinhocvien;";
    private static final String addThongTin = "insert into thongtinhocvien (name, email, dateofbirth, address, phonenumber, classroom) values (?, ?, ?, ?, ?, ?);";
    private static final String deleteThongTin = "delete from product where id = ?";
    private static final String updateTongTin = "update thongtinhocvien set name = ?, email= ?, dateofbirth =?, address = ?, phonenumber = ?, classroom = ? where name = ?;";


    public List<ThongTinHocVien> listThongTin() {
        ManageClassRoom manageClassRoom = new ManageClassRoom();
        List<ThongTinHocVien> thongTinHocVienList = new ArrayList<>();
        List<ClassRoom> list = manageClassRoom.classRooms();
        try {
            Connection connection = MyConnection.getInstance();
            PreparedStatement pr = connection.prepareStatement(selectThongTin);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String dateofbirth = resultSet.getString("dateofbirth");
                LocalDate dateOfBirth = LocalDate.parse(dateofbirth);
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phonenumber");
                int idClass = resultSet.getInt("classroom");

                ClassRoom classRoom = null;
                for (ClassRoom cla : list) {
                    if (cla.getId() == idClass) {
                        classRoom = cla;
                        break;
                    }
                }

                ThongTinHocVien thongTin = new ThongTinHocVien(name, email, dateOfBirth, address, phone, classRoom);
                thongTinHocVienList.add(thongTin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thongTinHocVienList;
    }

    public void deleteThongTin(String name) {
        try {
            Connection conn = MyConnection.getInstance();
            PreparedStatement pr = conn.prepareStatement(deleteThongTin);
            pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddThongTin(ThongTinHocVien thongTin) {
        try {
            Connection conn = MyConnection.getInstance();
            PreparedStatement pr = conn.prepareStatement(addThongTin);
            pr.setString(1, thongTin.getName());
            pr.setString(2, thongTin.getEmail());
            pr.setDate(3, Date.valueOf(thongTin.getDateOfBirth()));
            pr.setString(4, thongTin.getAddress());
            pr.setString(5, thongTin.getPhone());
            pr.setInt(6, thongTin.getClassRoom().getId());
            pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTongTin(ThongTinHocVien thongTin) {
        try {
            Connection conn = MyConnection.getInstance();
            PreparedStatement pre = conn.prepareStatement(updateTongTin);
            pre.setString(1, thongTin.getName());
            pre.setString(2, thongTin.getEmail());
            pre.setDate(3, Date.valueOf(thongTin.getDateOfBirth()));
            pre.setString(4, thongTin.getAddress());
            pre.setString(5, thongTin.getPhone());
            pre.setInt(6, thongTin.getClassRoom().getId());
            pre.setString(7, thongTin.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
