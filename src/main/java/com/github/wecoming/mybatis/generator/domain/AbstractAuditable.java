package com.github.wecoming.mybatis.generator.domain;

import java.util.Date;

/**
 * domain rootClass
 */
public abstract class AbstractAuditable extends AbstractPersistable implements Auditable {

    private Date createTime;

    private String createBy;

    private Date lastModifyTime;

    private String lastModifyBy;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    public String getCreateByName() {
        return getNameFromOperatorBy(getCreateBy());
    }

    public String getLastModifyByName() {
        return getNameFromOperatorBy(getLastModifyBy());
    }

    protected String getNameFromOperatorBy(String operator) {
        if (operator == null) {
            return null;
        }
        String[] operatorParm = operator.split(":");
        if (operatorParm.length != 3) {
            return null;
        }
        return operatorParm[2];
    }
}
