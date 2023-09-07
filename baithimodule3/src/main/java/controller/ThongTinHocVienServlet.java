package controller;

import DAO.ThongTinHocVienDAO;
import modle.ThongTinHocVien;
import service.ManageThongTinHocVien;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ThongTinHocVienServlet", value = "/ThongTinHocVienServlet")
public class ThongTinHocVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongTinHocVienDAO thongTinHocVienDAO = new ThongTinHocVienDAO();
        ManageThongTinHocVien manageThongTinHocVien = new ManageThongTinHocVien();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "":
                manageThongTinHocVien.showThongTin(request, response);
                break;
            case "delete":
                manageThongTinHocVien.deleteThongTin(request,response);
                break;
            case "addThongTin":
                manageThongTinHocVien.AddthongTin(request, response);
                break;
            case "update":
                String name = request.getParameter("name");
                ThongTinHocVien thongTinHocVien = manageThongTinHocVien.thongTinHocVien(name);
                request.setAttribute("thongtin", thongTinHocVien);
                RequestDispatcher rq = request.getRequestDispatcher("addthongtin.jsp");
                rq.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManageThongTinHocVien manageThongTinHocVien = new ManageThongTinHocVien();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "update":
                manageThongTinHocVien.updateThongTin(request, response);
                break;
        }
    }
}