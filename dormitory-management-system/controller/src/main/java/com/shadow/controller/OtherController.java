package com.shadow.controller;


import com.shadow.entity.Article;
import com.shadow.entity.Msg;
import com.shadow.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Date;
import java.util.UUID;

@RestController
public class OtherController {

    @Autowired
    ArticleRepo articleRepo;

    @PostMapping("/saveArticle")
    public Msg saveArticle(@RequestBody Article article){
        try{
            article.setCreatedtime(new Date(System.currentTimeMillis()));
            articleRepo.save(article);
            System.out.println(article.toString());
            return Msg.success();
        }catch (Exception e){
            e.printStackTrace();
            return Msg.fail();
        }

    }



    @PostMapping("/imgUpload")
    public Msg imgUpload(HttpServletRequest request, MultipartFile image, String oldimage, String imagetype){
        try {
            System.out.println(oldimage);
            //生成uuid
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //得到上传时的文件名
            String filename=image.getOriginalFilename();
            String date = new Date(System.currentTimeMillis()).toString();
            //上传目录地址
            //1.1保存到项目指定目录
            String uploadDir="F:\\images\\"+imagetype+"\\"+date;
            //1.2 上传到相对路径 request.getSession().getServletContext().getRealPath("/")+"upload/";
            //1.2 此路径为tomcat下，可以输出看一看
            //如果目录不存在，自动创建文件夹
            File dir=new File(uploadDir);
            if(!dir.exists()){
                System.out.println("//不存在");
                dir.mkdir();
            }

            String imageUrl = uploadDir+"\\"+uuid+".jpg";
            String returnUrl = "/images/"+imagetype+"/"+date+"/"+uuid+".jpg";
            //保存文件对象 加上uuid是为了防止文件重名
            File serverFile=new File(imageUrl);
            image.transferTo(serverFile);
            return Msg.success().add("imageUrl",returnUrl);
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return Msg.fail();
        }

    }
}
