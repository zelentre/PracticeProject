package main;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Objects;
import java.util.Scanner;

/**
 * MP代码生成
 *
 * @author zelen
 * @since 2022-11-07
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 驱动连接的URL、数据库连接用户名、数据库连接密码
        String jdbcUrl = "jdbc:mysql://43.139.93.181:3306/t?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "G3xfGgW4";

        FastAutoGenerator.create(jdbcUrl, username, password)
                // 全局配置
                .globalConfig(builder -> {
                    builder
                            // 作者名
                            .author("ZNE")
                            // 时间策略
                            //.dateType(DateType.TIME_PACK)
                            // 暂时使用 java.util.date
                            .dateType(DateType.ONLY_DATE)
                            // 注释日期格式
                            .commentDate("yyyy-MM-dd")
                            // 指定输出目录 默认值: windows:D:// linux or mac : /tmp
                            .outputDir(System.getProperty("user.dir") + "/mybatis-plus-generator/src/main/java")
                            // 生成swagger注解
                            //.enableSwagger()
                            //禁止打开输出目录，默认打开
                            .disableOpenDir();
                })
                // 包配置
                .packageConfig(builder -> {
                    builder
                            // 父包名
                            .parent("com.code")
                            // 父包模块名
                            .moduleName(scanner("模块名"));
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder
                            // 设置需要生成的表名
                            .addInclude(scanner("表名，多个英文逗号分割").split(","))
                            // 设置过滤表前缀
                            // .addTablePrefix("sys_")
                            // Entity 策略配置
                            .entityBuilder()
                            .enableLombok()
                            // 覆盖已生成文件
                            .enableFileOverride()
                            //数据库表映射到实体的命名策略：下划线转驼峰命
                            .naming(NamingStrategy.underline_to_camel)
                            //数据库表字段映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)
                            // Mapper 策略配置
                            .mapperBuilder()
                            // 覆盖已生成文件
                            .enableFileOverride()
                            // Service 策略配置
                            .serviceBuilder()
                            // 覆盖已生成文件
                            .enableFileOverride()
                            //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceFileName("%sService")
                            //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                            .formatServiceImplFileName("%sServiceImpl")
                            // Controller 策略配置
                            .controllerBuilder()
                            // 覆盖已生成文件
                            .enableFileOverride()
                            //格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
                            .formatFileName("%sController")
                            // 开启生成@RestController控制器
                            .enableRestStyle();

                })
                // 模板引擎
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    /**
     * 读取控制台内容
     */
    private static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (Objects.nonNull(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
