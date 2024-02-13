package com.myblog.myblog11;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {
//    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(10,10,20,23,14,15,20,65,67,14,68);
//        List<Integer> val = data.stream().distinct().collect(Collectors.toList());
//        System.out.println(val);
//
//    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("Testing"));
        }
}

