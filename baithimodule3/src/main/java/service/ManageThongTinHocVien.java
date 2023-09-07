package service;

import DAO.ThongTinHocVienDAO;
import modle.ClassRoom;
import modle.ThongTinHocVien;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ManageThongTinHocVien {
    private List<ThongTinHocVien> thongTinHocViens;

    public ManageThongTinHocVien() {
    }

    public ManageThongTinHocVien(List<ThongTinHocVien> thongTinHocViens) {
        this.thongTinHocViens = thongTinHocViens;
    }

    public List<ThongTinHocVien> listThongTin() {
        ThongTinHocVienDAO thongTinHocVienDAO = new ThongTinHocVienDAO();
        thongTinHocViens = thongTinHocVienDAO.listThongTin();
        return thongTinHocViens;
    }

    public void showThongTin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ThongTinHocVien> list = listThongTin();
        request.setAttribute("listthongtin", list);
        RequestDispatcher rq = request.getRequestDispatcher("showlistthongtinhocvien.jsp");
        rq.forward(request, response);
    }

    public void deleteThongTin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ThongTinHocVienDAO thongTinHocVienDAO = new ThongTinHocVienDAO();
        ManageThongTinHocVien manageThongTinHocVien = new ManageThongTinHocVien();
        List<ThongTinHocVien> list = manageThongTinHocVien.listThongTin();
        String name = request.getParameter("name");
        for (ThongTinHocVien t : list) {
            if (t.getName().equals(name)) {
                list.remove(t);
                thongTinHocVienDAO.deleteThongTin(name);
                break;
            }
        }
        response.sendRedirect("ThongTinHocVienServlet");
    }

    public void AddthongTin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ManageClassRoom manageClassRoom = new ManageClassRoom();
        ThongTinHocVienDAO thongTinHocVienDAO = new ThongTinHocVienDAO();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateofbirth"));
        String phone = request.getParameter("phone");
        int id = Integer.parseInt(request.getParameter("class"));
        ClassRoom classRoom = null;
        List<ClassRoom> classRooms = manageClassRoom.classRooms();
        for (ClassRoom c : classRooms) {
            if (c.getId() == id) {
                classRoom = c;
                break;
            }
        }

        ThongTinHocVien thongTinHocVien = new ThongTinHocVien(name, email, dateOfBirth, address, phone, classRoom);
        List<ThongTinHocVien> list = listThongTin();
        list.add(thongTinHocVien);
        thongTinHocVienDAO.AddThongTin(thongTinHocVien);
        response.sendRedirect("ThongTinHocVienServlet");
    }

    public ThongTinHocVien thongTinHocVien(String name) {
        ManageThongTinHocVien manageThongTinHocVien = new ManageThongTinHocVien();
        List<ThongTinHocVien> list = manageThongTinHocVien.listThongTin();
        for (ThongTinHocVien t : list) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    public void updateThongTin(HttpServletRequest request, HttpServletResponse response) {
        ThongTinHocVienDAO thongTinHocVienDAO = new ThongTinHocVienDAO();
        ManageClassRoom manageClassRoom = new ManageClassRoom();
        ManageThongTinHocVien manageThongTinHocVien = new ManageThongTinHocVien();
        List<ThongTinHocVien> list = manageThongTinHocVien.listThongTin();
        for (ThongTinHocVien t : list) {
            if (t.getName().equals(request.getParameter("name"))) {
                thongTinHocVienDAO.updateTongTin(t);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(request.getParameter("name"))) {
                list.get(i).setName(request.getParameter("name"));
                list.get(i).setEmail(request.getParameter("email"));
                list.get(i).setDateOfBirth(LocalDate.parse(request.getParameter("date")));
                list.get(i).setAddress(request.getParameter("address"));
                list.get(i).setPhone(request.getParameter("phone"));
                list.get(i).setClassRoom(manageClassRoom.oneClass(Integer.parseInt(request.getParameter("class"))));
            }
        }
    }

}
