package com.zne.pipeline;


import com.foldright.auto.pipeline.AutoPipeline;

/**
 * @author ZNE
 * @since 2022/10/8
 */
@AutoPipeline
public interface ConfigSource {
    String get(String key);
}
