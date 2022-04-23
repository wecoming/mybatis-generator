package com.github.wecoming.mybatis.generator.mapper;

import com.github.wecoming.mybatis.generator.domain.Persistable;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author songbinbin on 2022/4/23.
 */
public interface MybatisBaseMapper<Domain extends Persistable, PK extends Serializable, Example> {
    int countByExample(Example var1);

    int deleteByExample(Example var1);

    int deleteByPrimaryKey(PK var1);

    int insert(Domain var1);

    int insertSelective(Domain var1);

    List<Domain> selectByExample(Example var1);

    Domain selectByPrimaryKey(PK var1);

    int updateByExampleSelective(@Param("record") Domain var1, @Param("example") Example var2);

    int updateByExample(@Param("record") Domain var1, @Param("example") Example var2);

    int updateByPrimaryKeySelective(Domain var1);

    int updateByPrimaryKey(Domain var1);
}