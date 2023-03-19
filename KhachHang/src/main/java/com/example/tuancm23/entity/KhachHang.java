package com.example.tuancm23.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class KhachHang {
    private Integer id;
    private String name;
    private String address;
    private Integer status;
    private Integer gender;

    public KhachHang() {
    }
}
