package com.example.demo.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BanRequest {
    @NotBlank(message = "Ma k dc de trong")
    private String ma;
    @NotBlank(message = "Ten k dc de trong")
    private String hoTen;
    private String sdt;
    private String diaChi;
    @NotNull(message = "Chua có ngay sinh")
    private Date ngaySinh;
    private Long idMQH;
}
