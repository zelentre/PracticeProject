package com.zne.prod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zne.prod.entity.TSku;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ZNE
 * @since 2023-04-09
 */
public interface TSkuService extends IService<TSku> {

    List<TSku> getSkuList(Long prodId);

}
