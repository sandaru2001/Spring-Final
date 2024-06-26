package com.example.cw_spring.controller;

import com.example.cw_spring.dto.SizeDTO;
import com.example.cw_spring.entity.SizeEntity;
import com.example.cw_spring.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/size")
@RequiredArgsConstructor
public class Size {
    @Autowired
    private SizeService sizeService;

    @GetMapping("/health")
    public String health(){
        return "Size Health Check is working";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean save(@RequestBody SizeDTO sizeDTO){
        return sizeService.saveSize(sizeDTO);
    }

    @GetMapping
    public List<SizeDTO> getAll(){
        return sizeService.getAllSizes();
    }

    @GetMapping("/getItemIds")
    public List<String> getItemIds(){
        return sizeService.getItemIds();
    }

    @DeleteMapping("/delete")
    public boolean delete(
            @RequestPart("item_id") String item_id,
            @RequestPart("size_id") String size_id
    ){
        return sizeService.deleteSize(item_id,size_id);
    }

    @GetMapping("/getDataWithSize/{item_code}/{item_size}")
    public SizeEntity getDataWithSizeAndItemId(
            @PathVariable String item_code,
            @PathVariable String item_size
    ){
        return sizeService.getDataWithSizeAndItemID(item_code,item_size);
    }
}
