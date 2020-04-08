package com.liuguohu.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        String password;
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入加密 salt：");
        while(true){
            password = scanner.nextLine();
            System.out.print("Yes/No：");
            String flag = scanner.nextLine();
            if(flag.equals("y") || flag.equals("yes")){
                break;
            }
        }
        scanner.close();
        new SpringApplicationBuilder(SpringbootApplication.class).properties("jasypt.encryptor.password=" + password).run(args);
    }

}
