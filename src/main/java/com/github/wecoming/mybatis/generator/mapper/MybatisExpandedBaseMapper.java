package com.github.wecoming.mybatis.generator.mapper;

import com.github.wecoming.mybatis.generator.domain.Persistable;

import java.io.Serializable;
import java.util.List;

/**
 * @author songbinbin on 2019/9/24.
 */
public interface MybatisExpandedBaseMapper<Domain extends Persistable, PK extends Serializable, Example>
        extends MybatisBaseMapper<Domain, PK, Example> {
    /**
     * 批量插入mapper接口
     *
     * @param vars
     */
    void batchInsert(List<Domain> vars);
}
