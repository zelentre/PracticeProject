package com.zne.pipeline;//package com.zne.pipeline;
//
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.Map;
//
///**
// * @author ZNE
// * @since 2022/10/8
// */
//public class MapConfigSourceHandler implements ConfigSourceHandle {
//    private final Map<String, String> map;
//
//    public MapConfigSourceHandler(Map<String, String> map) {
//        this.map = map;
//    }
//
//    @Override
//    public String get(String key, ConfigSourceHandlerContext context) {
//        String value = map.get(key);
//        if (StringUtils.isNotBlank(value)) {
//            return value;
//        }
//        return context.get(key);
//    }
//}
