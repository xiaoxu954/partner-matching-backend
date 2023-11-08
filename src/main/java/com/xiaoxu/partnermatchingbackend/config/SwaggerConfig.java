package com.xiaoxu.partnermatchingbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Shier
 * @date 2023/02/02
 * 自定义 Swagger 接口文档的配置
 */
@Configuration // 配置类
@EnableSwagger2 // 开启 swagger2 的自动配置
@Profile({"dev","test"}) //版本控制访问
public class SwaggerConfig  {
    @Bean
    public Docket docket() {
        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                //Swagger2 URL: http://localhost:8080/api/swagger-ui.html
                //Kinef4j URL: http://localhost:8080/api/doc.html
                //用户信息
                .apiInfo(apiInfo())
                // 配置接口信息
                .select() // 设置扫描接口
                // 配置如何扫描接口
                .apis(RequestHandlerSelectors
                                //.any() // 扫描全部的接口，默认
                                //.none() // 全部不扫描
                                .basePackage("com.xiaoxu.partnermatchingbackend.controller") // 扫描指定包下的接口，最为常用
                        //.withClassAnnotation(RestController.class) // 扫描带有指定注解的类下所有接口
                        //.withMethodAnnotation(PostMapping.class) // 扫描带有只当注解的方法接口

                ).paths(PathSelectors.any() // 满足条件的路径，该断言总为true
                        //.none() // 不满足条件的路径，该断言总为false（可用于生成环境屏蔽 swagger）
                        //.ant("/user/**") // 满足字符串表达式路径
                        //.regex("") // 符合正则的路径
                ).build();
    }

    // 基本信息设置
    private ApiInfo apiInfo() {
        Contact contact = new Contact("xiaoxu", // 作者姓名
                "https://xiaoxucode.icu", // 作者网址
                "1665887032@qq.com"); // 作者邮箱
        return new ApiInfoBuilder().title("伙伴匹配系统-接口文档") // 标题
                .description("追求源于热爱") // 描述
                .termsOfServiceUrl("https://github.com/xiaoxu954") // 跳转连接
                .version("1.0") // 版本
                .license("Swagger-的使用(详细教程)").licenseUrl("https://blog.csdn.net/xhmico/article/details/125353535").contact(contact).build();
    }
    /**
     * 解决高版本springboot无法访问http://localhost:8080/swagger-ui.html
     *
     * @param registry void
     */
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // 解决静态资源无法访问
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        // 解决swagger无法访问
//        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        // 解决swagger的js文件无法访问
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}