package com.liuguohu.springboot.controller;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot-encrypt-configFile
 * @description:
 * @author: liuguohu
 * @create: 2020-04-08 17:39
 **/

@RestController
public class EncryptionController {

    @Autowired
    private StringEncryptor encryptor;

    @RequestMapping(value = "/encryption", method = RequestMethod.POST)
    public Map<String, String> encryption(@RequestBody Map<String, String> params){
        Map<String, String> result = new HashMap<>();
        for(String key : params.keySet()){
            result.put(key, encryptor.encrypt(params.get(key)));
        }

        return result;
    }

}
