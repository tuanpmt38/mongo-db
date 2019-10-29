package com.example.demo.controller;

import com.example.demo.dto.DeviceAddDto;
import com.example.demo.service.DeviceService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeviceController {

  @Autowired
  private DeviceService deviceService;
  @PostMapping
  public void createDB (@RequestBody DeviceAddDto deviceAddDto){
    Document document = deviceService.save(deviceAddDto);
    System.out.println(document);
  }

}
