package com.chm.proxy;

/**
 * 对生产厂家要求的接口
 */
public interface IProducer {
    /**
     * 销售
     *
     * @param money
     */
    void sellProduct(Float money);

    /**
     * 售后
     *
     * @param money
     */
    void afterService(Float money);
}
