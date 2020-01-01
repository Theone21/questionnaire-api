package com.questionnaire.dao.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_function")
public class Function extends Model<Function> {

    @TableId(value = "FUNCTION_ID", type = IdType.AUTO)
    private int functionId;
    private String functionCode;
    private String functionName;

    @Override
    protected Serializable pkVal() {
        return functionId;
    }
}
