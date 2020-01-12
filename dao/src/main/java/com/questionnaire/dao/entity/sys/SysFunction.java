package com.questionnaire.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author jlj
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "function_id", type = IdType.AUTO)
    private Integer functionId;

    /**
     * 权限编码
     */
    private String functionCode;

    /**
     * 权限名称
     */
    private String functionName;

    /**
     * 权限类型，0表示功能模块；1表示详细功能；2表示按钮权限。
     */
    private Integer functionType;

    /**
     * 所属父功能id
     */
    private Integer functionParentId;



}
