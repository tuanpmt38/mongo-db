package com.example.demo.service;

import com.example.demo.dto.DeviceAddDto;
import org.bson.Document;

public interface DeviceService {
  Document save(DeviceAddDto deviceAddDto);
}
