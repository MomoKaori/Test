package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ban")
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "ma")
    private String ma;

    @NotBlank
    @Column(name = "ho_ten")
    private String hoTen;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "0\\d{9}", message = "Số điện thoại phải có 10 chữ số và bắt đầu bằng 0")
    @Column(name = "so_dien_thoai")
    private String sdt;

    @NotEmpty
    @Column(name = "dia_chi")
    private String diaChi;

    @NotNull
    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @ManyToOne
    @JoinColumn(name = "moi_quan_he_id",referencedColumnName = "id")
    private MoiQuanHe moiQuanHe;

}
