package com.github.wecoming.mybatis.generator.domain;

import com.github.wecoming.mybatis.generator.constant.IStatusEnum;

public abstract class AbstractPersistable implements Persistable {

    private Long id;

    private IStatusEnum istatus;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public IStatusEnum getIstatus() {
        return istatus;
    }

    @Override
    public void setIstatus(IStatusEnum istatus) {
        this.istatus = istatus;
    }
}
