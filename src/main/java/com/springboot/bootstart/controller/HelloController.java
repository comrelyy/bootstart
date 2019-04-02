package com.springboot.bootstart.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
@ConfigurationProperties(prefix = "user")

/**
 * @Value 从配置文件中取出自定义属性的值，每个属性都需要使用该注解，但是该
 *属性对应的成员变量不需要get和set方法
 * @ConfigurationProperties(prefix = "user")
 * 根据前缀获取自定义属性值，需要对应的成员变量与属性名一致且需要为该成员变量
 * 添加get/set方法
 */
public class HelloController {

//    自定义消息转换器，springboot默认配置了
//    @Bean
//    public StringHttpMessageConverter stringHttpMessageConverter(){
//        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        return stringHttpMessageConverter;
//    }

    @Value("${book.name}")
    private String bookName;
    @Value("${book.author}")
    private String bookAuthor;

    @RequestMapping("/getValue")
    @ResponseBody
    public String getValue(){
        System.out.println(bookAuthor + ":" + bookName);
        return bookAuthor+":"+bookName;
    }

    @RequestMapping("/getConvert")
    @ResponseBody
    public String getConvert(){
        return "SpringBoot"+":"+"你好";
    }



    private String nickName;

    private Integer age;

    @RequestMapping("/getConfigurationPropertiesValue")
    @ResponseBody
    public String getConfigurationPropertiesValue(){
        System.out.println(nickName + ":" + age);
        return nickName+":"+age;
    }

    /**
     * freemarker模板引擎
     * @return
     */
    @RequestMapping("/getIndex")
    public String getIndex(){
        //int va = 5/0;
        System.out.println("getIndex执行");
        return "show";
    }

    /**
     * 使用Thymeleaf模板引擎
     * @param model
     * @return
     */
    @RequestMapping("/getThymeleaf")
    public String getThymeleaf(Model model){
        //int va = 5/0;
        model.addAttribute("name","欢迎使用Thymeleaf");
        System.out.println("getThymeleaf执行");
        return "testThymeleaf";
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
