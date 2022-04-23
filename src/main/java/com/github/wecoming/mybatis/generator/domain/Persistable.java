package com.github.wecoming.mybatis.generator.domain;

import com.github.wecoming.mybatis.generator.constant.IStatusEnum;

/**
 * @author songbinbin on 2022/4/23.
 */
public interface Persistable {
    Long getId();

    void setId(Long var1);

    IStatusEnum getIstatus();

    void setIstatus(IStatusEnum var1);
}
