package com.example.enumjson.web;

import com.example.enumjson.model.TestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/testentity")
public class EnumDeserializerController {

    @PostMapping
    public ResponseEntity<TestEntity> addTestEntity(@RequestBody TestEntity testEntity){
        System.out.println(testEntity);
        return ResponseEntity.ok(testEntity);
    }
}
