package com.questionnaire.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_users")
public class User extends Model<User> {

    @TableId(value = "USER_ID", type = IdType.AUTO)
    private Long userId;
    private String userName;
    private String userPassword;

    @Override
    protected Serializable pkVal() {
        return userId;
    }
}
