package com.example.tuancm23.servlet;

//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;

import com.example.tuancm23.entity.KhachHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi", //GET
        "/khach-hang/add", //POST
        "/khach-hang/detail", //GET
        "/khach-hang/update", //POST
        "/khach-hang/delete" //GET
})
public class KhachHangServlet extends HttpServlet {

    private List<KhachHang> listKhachHang = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiKhachHang(request, response);
        } else if (uri.contains("detail")) {
            this.detailKhachHang(request, response);
        } else if (uri.contains("delete")) {
            this.deleteKhachHang(request, response);
        } else {
            this.hienThiKhachHang(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addKhachHang(request, response);
        } else {
            this.updateKhachHang(request, response);
        }
    }

    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String gioiTinh = request.getParameter("gioiTinh");

        int viTri = -1;

        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getId().equals(Integer.valueOf(id))){
                viTri = i;
            }
        }

        KhachHang kh = listKhachHang.get(viTri);

        kh.setName(name);
        kh.setAddress(address);
        kh.setStatus(Integer.valueOf(status));
        kh.setGender(Integer.valueOf(gioiTinh));

        listKhachHang.set(viTri, kh);

        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void addKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String gioiTinh = request.getParameter("gioiTinh");

        KhachHang kh = new KhachHang(Integer.valueOf(id), name, address, Integer.valueOf(status), Integer.valueOf(gioiTinh));

        listKhachHang.add(kh);

        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void deleteKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        int viTri = -1;

        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getId().equals(id)){
                viTri = i;
            }
        }

        listKhachHang.remove(viTri);

        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void detailKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        int viTri = -1;

        for (int i = 0; i < listKhachHang.size(); i++) {
            if (listKhachHang.get(i).getId().equals(id)){
                viTri = i;
            }
        }

        KhachHang kh = listKhachHang.get(viTri);

        request.setAttribute("khachHang", kh);

        request.getRequestDispatcher("/view/detail.jsp").forward(request, response);
    }

    private void hienThiKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (listKhachHang.isEmpty()){
            listKhachHang.add(new KhachHang(1, "Tuan", "Ha Noi", 0, 0));
            listKhachHang.add(new KhachHang(2, "Uyen", "Ha Noi3", 1, 1));
            listKhachHang.add(new KhachHang(3, "Hung", "Ha Noi2", 0, 0));
        }

        request.setAttribute("khachHangs", listKhachHang);

        request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
    }
}
