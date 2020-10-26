package com.example.demo.produce.tool;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;



@RestController
public class updateImg {
    private final  String fileBaseDirector="d:\\img\\";
    private final Path fileBasePath;

    public updateImg() {
        this.fileBasePath = Path.of(fileBaseDirector);
    }
    @GetMapping("/{fileName}")
    public ResponseEntity loadFile(@PathVariable String fileName){
        Path resolve = fileBasePath.resolve(fileName);
        Resource urlResource = null;
        try {
            urlResource = new UrlResource(resolve.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return  ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+urlResource.getFilename()+"\"")
                .body(urlResource);
    }
    @DeleteMapping("/{fileName}")
    public ResponseEntity deleteFile(@PathVariable String fileName) throws IOException {
        Path resolve = fileBasePath.resolve(fileName);
        Boolean aFalse = Boolean.FALSE;
        aFalse = FileSystemUtils.deleteRecursively(resolve);
        return ResponseEntity.ok(aFalse);
    }
    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file){
        String s = StringUtils.cleanPath(file.getOriginalFilename());
        Path of = Path.of(fileBaseDirector + s);
        try {
            Files.copy(file.getInputStream(),of, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("OK");
    }
}
