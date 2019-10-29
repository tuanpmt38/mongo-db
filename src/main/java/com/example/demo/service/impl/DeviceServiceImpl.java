package com.example.demo.service.impl;

import com.example.demo.dto.DeviceAddDto;
import com.example.demo.dto.DeviceConstant;
import com.example.demo.service.DeviceService;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.log4j.Log4j2;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class DeviceServiceImpl implements DeviceService {

  @Value(value = "${spring.data.mongodb.host}")
  private String mongoHost;
  @Value(value = "${spring.data.mongodb.port}")
  private Integer mongoPort;
  @Value(value = "${spring.data.mongodb.database}")
  private String mongoDatabase;
  @Value(value = "${spring.data.mongodb.username}")
  private String mongoUsername;
  @Value(value = "${spring.data.mongodb.password}")
  private String mongoPassword;
  @Value(value = "${spring.data.mongodb.uri}")
  private String mongoUri;

  @Override
  public Document save(DeviceAddDto deviceAddDto) {
    //connection mongodb, insert document
    MongoCollection<Document> collection = buildCollection(deviceAddDto.getProductAlias());
    // add moi vao
    return this.insertCollection(collection, deviceAddDto);  }

  private MongoCollection<Document> buildCollection(String productAlias) {
    MongoClientOptions clientOptions = MongoClientOptions.builder().build();
    ServerAddress serverAddress = new ServerAddress(mongoHost, mongoPort);
    MongoCredential mongoCredential = MongoCredential
        .createCredential(mongoUsername, mongoDatabase, mongoPassword.toCharArray());

    MongoClient client = new MongoClient(serverAddress, mongoCredential, clientOptions);
    MongoDatabase database = client.getDatabase(DeviceConstant.MONGO_DATABASE);
    return database
        .getCollection("device_" + productAlias);
  }

  private Document insertCollection(MongoCollection collection, DeviceAddDto deviceAddDto) {
    Document document = new Document()
        .append(DeviceConstant.PRODUCT_ALIAS, deviceAddDto.getProductAlias())
        .append(DeviceConstant.DEVICE_TOKEN, deviceAddDto.getDeviceToken());

    collection.insertOne(document);
    log.info("Insert collection '{}' successfully", "connect_db");
    return document;
  }
}

