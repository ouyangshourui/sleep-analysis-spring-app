package com.example.sleepanalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Controller
public class CameraController {

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping("/")
    public String index() {
        return "camera";
    }

    @PostMapping("/analyze")
    public ModelAndView analyzeImage(@RequestParam("image") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView("result");

        if (file.isEmpty()) {
            modelAndView.addObject("error", "请上传图片");
            return modelAndView;
        }

        try {
            // 保存上传的图片
            String fileName = UUID.randomUUID().toString() + ".jpg";
            Path filePath = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(Paths.get(UPLOAD_DIR));
            Files.write(filePath, file.getBytes());

            // 调用睡眠分析服务
            boolean isSleepEnough = analyzeSleepQuality(filePath.toString());

            modelAndView.addObject("isSleepEnough", isSleepEnough);
            modelAndView.addObject("imagePath", fileName);

        } catch (IOException e) {
            e.printStackTrace();
            modelAndView.addObject("error", "处理图片时出错");
        }

        return modelAndView;
    }

    // 模拟睡眠质量分析算法
    private boolean analyzeSleepQuality(String imagePath) {
        // 这里应该集成真正的计算机视觉算法
        // 本示例仅作演示，返回随机结果
        return Math.random() > 0.5;
    }
}    