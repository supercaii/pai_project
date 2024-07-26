package com.github.paicoding.forum.api.model.vo.banner;

import lombok.Data;

import java.io.Serializable;

/**
 * 保存Banner请求参数
 *
 * @author LouZai
 * @date 2022/9/17
 */
@Data
public class ConfigReq implements Serializable {

    /**
     * ID
     */
    private Long configId;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片链接
     */
    private String bannerUrl;

    /**
     * 跳转链接
     */
    private String jumpUrl;

    /**
     * 内容
     */
    private String content;

    /**
     * 排序
     */
    private Integer rank;

    /**
     * 标签
     */
    private String tags;
}
