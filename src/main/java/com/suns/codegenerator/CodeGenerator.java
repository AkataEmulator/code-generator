package com.suns.codegenerator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create(
                                 "jdbc:mysql://127.0.0.1:3306/seckill?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                                 "root", "commonsecret")
                         .globalConfig(builder -> builder.author("shuo.sun")
                                                         .enableSwagger()
                                                         .outputDir(
                                                                 "/Users/shuosun/IdeaProjects/github/advanced-seckill/src/main/java"))
                         .packageConfig(builder -> builder.parent("com.suns.seckill")
                                                          .controller("controller")
                                                          .service("service")
                                                          .serviceImpl("service.impl")
                                                          .mapper("mapper")
                                                          .xml("mapper")
                                                          .entity("pojo")
                                                          .pathInfo(Collections.singletonMap(OutputFile.xml,
                                                                                             "/Users/shuosun/IdeaProjects/github/advanced-seckill/src/main/resources/mapper"))
                                                          .build())
                         .strategyConfig(builder -> builder.addInclude("t_user") // 设置需要生成的表名
                                                           .addTablePrefix("t_", "c_") // 设置过滤表前缀
                         )
                         .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                         .execute();
    }

}
