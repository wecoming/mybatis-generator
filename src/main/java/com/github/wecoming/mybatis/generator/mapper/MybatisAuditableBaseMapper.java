package com.github.wecoming.mybatis.generator.mapper;

import com.github.wecoming.mybatis.generator.domain.Auditable;

import java.io.Serializable;

/**
 * @author songbinbin on 2019/9/24.
 */
public interface MybatisAuditableBaseMapper<Domain extends Auditable, PK extends Serializable, Example>
        extends MybatisExpandedBaseMapper<Domain, PK, Example> {
}
