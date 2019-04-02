package com.springboot.bootstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/getUploadPage")
    public String getUploadPage(){

        return "uploadFile";
    }

    @RequestMapping(value = "/upload" ,method =RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file, HttpServletRequest request){
        try{
            String realPath = request.getServletContext().getRealPath("/uploadFile");
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            File filedir = new File(path+"/static/uploadFile");
            if (!filedir.exists()) filedir.mkdirs();
            String originalFilename = file.getOriginalFilename();
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            File uploadFile = new File(filedir + "/" + originalFilename);
            file.transferTo(uploadFile);
        }catch(Exception e){
         e.printStackTrace();
         return "上传失败";
        }
        return "上传成功";
    }
}
