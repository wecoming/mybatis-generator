package com.github.wecoming.mybatis.generator.domain;

import java.util.Date;

/**
 * @author songbinbin on 2022/4/23.
 */
public interface Auditable extends Persistable {
    Date getCreateTime();

    void setCreateTime(Date var1);

    String getCreateBy();

    void setCreateBy(String var1);

    Date getLastModifyTime();

    void setLastModifyTime(Date var1);

    String getLastModifyBy();

    void setLastModifyBy(String var1);
}
