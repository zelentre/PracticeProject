package com.zne;//package com.zne;
//
//import com.zne.pipeline.ConfigSource;
//import com.zne.pipeline.MapConfigSourceHandler;
//import com.zne.pipeline.SystemConfigSourceHandler;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 责任链测试
// *
// * @author ZNE
// * @since 2022/10/8
// */
//@SpringBootTest
//public class ChainTest {
//
//    @Test
//    void chainTest(){
//        Map<String, String> mapConfig = new HashMap<String, String>();
//        mapConfig.put("hello", "world");
//        ConfigSourceHandler mapConfigSourceHandler = new MapConfigSourceHandler(mapConfig);
//
//        ConfigSource pipeline = new ConfigSourcePipeline()
//                .addLast(mapConfigSourceHandler)
//                .addLast(SystemConfigSourceHandler.INSTANCE);
//
//        pipeline.get("hello");
//// get value "world"
//// from mapConfig / mapConfigSourceHandler
//
//        pipeline.get("java.specification.version");
//    }
//}
