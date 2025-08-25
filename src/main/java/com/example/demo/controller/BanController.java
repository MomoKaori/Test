package com.example.demo.controller;

import com.example.demo.entity.Ban;
import com.example.demo.model.request.BanRequest;
import com.example.demo.model.response.BanResponse;
import com.example.demo.model.response.ResponseObject;
import com.example.demo.service.BanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ban-managerment")
@CrossOrigin(origins = "*")
public class BanController {
    @Autowired
    private BanService banService;

    @GetMapping("playlist")
    public ResponseObject<?> hienThi(){
        return new ResponseObject<>(banService.getList());
    }
    @GetMapping("pagging/{pageNo}/{pageSize}")
    public ResponseObject<?> phanTrangg(@PathVariable("pageNo")Integer pageNo,
                                        @PathVariable("pageSize")Integer pageSize){
        return new ResponseObject<>(banService.phanTrang(pageNo,pageSize));
    }
    @GetMapping("detail/{id}")
    public ResponseObject<?> detail(@PathVariable("id")Long id){
        return new ResponseObject<>(banService.detail(id));
    }
    @GetMapping("delete/{id}")
    public ResponseObject<?> delete(@PathVariable("id")Long id){
        banService.delete(id);
        return new ResponseObject<>(null,"Xoa thanh cong");
    }
    @GetMapping("delete/{ma}")
    public ResponseObject<?> deleteByMa(@PathVariable("ma")String ma){
        banService.deleteByMa(ma);
        return new ResponseObject<>(null,"Xoa thanh cong");
    }

    @PostMapping("add")
    public ResponseObject<?> add(@Valid @RequestBody BanRequest banRequest){
        banService.add(banRequest);
        return new ResponseObject<>(null,"Them thanh cong");
    }
    @PutMapping("update/{id}")
    public ResponseObject<?> update (@Valid @RequestBody BanRequest banRequest,@PathVariable("id")Long id){
        banService.update(banRequest,id);
        return new ResponseObject<>(null,"Upd thành cong");
    }

}
