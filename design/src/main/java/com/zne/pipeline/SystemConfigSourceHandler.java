package com.zne.pipeline;//package com.zne.pipeline;
//
//import org.apache.commons.lang3.StringUtils;
//
///**
// * @author ZNE
// * @since 2022/10/8
// */
//public class SystemConfigSourceHandler implements ConfigSourceHandler {
//    public static final SystemConfigSourceHandler INSTANCE = new SystemConfigSourceHandler();
//
//    @Override
//    public String get(String key, ConfigSourceHandlerContext context) {
//        String value = System.getProperty(key);
//        if (StringUtils.isNotBlank(value)) {
//            return value;
//        }
//        return context.get(key);
//    }
//}