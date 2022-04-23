package com.github.wecoming.mybatis.generator.generator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator;
import org.mybatis.generator.config.PropertyRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

public class EmptyContentWithRootInterfaceJavaClientGenerator extends JavaMapperGenerator {
    public EmptyContentWithRootInterfaceJavaClientGenerator() {
        super("", true);
    }

    public EmptyContentWithRootInterfaceJavaClientGenerator(String project, boolean requiresXMLGenerator) {
        //TODO project含义以及如何设置
        super(project, requiresXMLGenerator);
    }

    @Override
    public List<CompilationUnit> getCompilationUnits() {
        progressCallback.startTask(getString("Progress.17", //$NON-NLS-1$
                introspectedTable.getFullyQualifiedTable().toString()));
        CommentGenerator commentGenerator = context.getCommentGenerator();

        FullyQualifiedJavaType type = new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType());
        Interface interfaze = new Interface(type);
        interfaze.setVisibility(JavaVisibility.PUBLIC);
        commentGenerator.addJavaFileComment(interfaze);

        String rootInterface = introspectedTable.getTableConfigurationProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
        if (!stringHasValue(rootInterface)) {
            rootInterface = context.getJavaClientGeneratorConfiguration()
                    .getProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
        }

        if (stringHasValue(rootInterface)) {
            FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(rootInterface);

            fqjt.addTypeArgument(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));
            fqjt.addTypeArgument(getPrimaryKeyFullyQualifiedJavaType());
            fqjt.addTypeArgument(new FullyQualifiedJavaType(introspectedTable.getExampleType()));

            interfaze.addSuperInterface(fqjt);
            interfaze.addImportedType(fqjt);
        }

        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        if (context.getPlugins().clientGenerated(interfaze, introspectedTable)) {
            answer.add(interfaze);
        }

        List<CompilationUnit> extraCompilationUnits = getExtraCompilationUnits();
        if (extraCompilationUnits != null) {
            answer.addAll(extraCompilationUnits);
        }

        return answer;
    }

    protected FullyQualifiedJavaType getPrimaryKeyFullyQualifiedJavaType() {
        List<IntrospectedColumn> introspectedColumns = introspectedTable.getPrimaryKeyColumns();
        if (introspectedColumns.size() != 1) {
            throw new IllegalStateException("Not handle multi primary key column yet.");
        }

        return introspectedColumns.get(0).getFullyQualifiedJavaType();
    }

}
