package com.neusoft.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CDHong
 * @since 2018-11-22
 */
public interface IProductService extends IService<Product> {

    List<Product> productPage(Page page,Product product);
}
