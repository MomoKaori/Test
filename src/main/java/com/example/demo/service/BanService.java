package com.example.demo.service;

import com.example.demo.entity.Ban;
import com.example.demo.entity.MoiQuanHe;
import com.example.demo.model.request.BanRequest;
import com.example.demo.model.response.BanResponse;
import com.example.demo.model.response.PageableObject;
import com.example.demo.repository.BanRepository;
import com.example.demo.repository.MoiQuanHeRepository;
import com.example.demo.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanService {
    @Autowired
    private BanRepository banRepository;
    @Autowired
    private MoiQuanHeRepository moiQuanHeRepository;

    public List<BanResponse> getList(){
        return  banRepository.findAll().stream().map(BanResponse::new).toList();
    }

    public PageableObject<BanResponse> phanTrang(Integer pageNo,Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Ban> banPage = banRepository.findAll(pageable);
        Page<BanResponse> banResponsePage = banPage.map(BanResponse::new);
        return new PageableObject<>( banResponsePage);
     }

     public void add(BanRequest banRequest){
        Ban ban = MapperUtils.map(banRequest,Ban.class);
        MoiQuanHe moiQuanHe= moiQuanHeRepository.findById(banRequest.getIdMQH()).orElse(null);
        ban.setMoiQuanHe(moiQuanHe);
        banRepository.save(ban);
     }
     public void update(BanRequest banRequest,Long id){
        Ban ban = banRepository.findById(id).orElse(null);
        MapperUtils.mapToExisting(banRequest,ban);
        MoiQuanHe moiQuanHe = moiQuanHeRepository.findById(banRequest.getIdMQH()).orElse(null);
        ban.setId(id);
        ban.setMoiQuanHe(moiQuanHe);
        banRepository.save(ban);
     }

     public Ban detail(Long id){
        return banRepository.findById(id).orElseThrow();
     }

     public void delete(Long id){
        banRepository.deleteById(id);
     }
}
