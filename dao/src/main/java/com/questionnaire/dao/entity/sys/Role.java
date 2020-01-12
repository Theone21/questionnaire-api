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
@TableName("sys_roles")
public class Role extends Model<Role> {

    @TableId(value = "ROLE_ID", type = IdType.AUTO)
    private long roleId;
    private String roleName;
    private String roleCode;

    @Override
    protected Serializable pkVal() {
        return roleId;
    }


}
