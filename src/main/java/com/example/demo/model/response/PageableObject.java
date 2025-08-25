package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PageableObject <T>{
    private List<T> data;
    private Integer total;
    private Integer currentPage;

    public PageableObject(Page<T> page) {
        this.data = page.getContent();
        this.total = page.getTotalPages();
        this.currentPage = page.getNumber();
    }
}
