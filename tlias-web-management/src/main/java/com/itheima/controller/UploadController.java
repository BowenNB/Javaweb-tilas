package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @SneakyThrows
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image){
        log.info("文件上传 {}, {}, {}", username, age, image);

        //获取原始文件名
        String originalFilename = image.getOriginalFilename();

        //构建新的文件名
        String extname = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = UUID.randomUUID().toString() + extname;

        //将文件储存在服务器的磁盘目录
        image.transferTo(new File("/Users/macpc/Desktop/Java/Javaweb/day11-SpringBootWeb案例/资料/03. 文件上传" + newFilename));

        return Result.success();
    }


}
