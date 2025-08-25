package com.example.demo.model.response;

import com.example.demo.entity.Ban;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BanResponse {
    private Long id;
    private String ma;
    private String hoTen;
    private String sdt;
    private String diaChi;
    private String maMQH;
    private String loaiMQH;
    private Date ngaySinh;

    public BanResponse(Ban ban) {
        this.id = ban.getId();
        this.ma = ban.getMa();
        this.hoTen = ban.getHoTen();
        this.sdt = ban.getSdt();
        this.diaChi = ban.getDiaChi();
        this.maMQH = ban.getMoiQuanHe()!=null?ban.getMoiQuanHe().getMa():null;
        this.loaiMQH = ban.getMoiQuanHe()!=null?ban.getMoiQuanHe().getLoaiQuanHe():null;
        this.ngaySinh = ban.getNgaySinh();
    }
}
