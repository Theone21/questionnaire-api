package com.questionnaire.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@ApiModel(value="R",description="接口返回实体类")
public class R {
    private R() {
    }

    //成功状态码
    public static final int OK = 200;
    //失败状态码
    public static final int ERROR = 500;
    //没有权限状态码
    public static final int NO_AUTH = 410;
    //登录失败状态码
    public static final int LOGIN_FAIL = 403;

    // http 状态码
    @ApiModelProperty(value="code",name="状态码")
    private int code;
    // 返回信息
    @ApiModelProperty(value="msg",name="返回信息")
    private String msg;
    // 返回的数据
    @ApiModelProperty(value="data",name="返回的数据")
    private Object data;

    public R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static R ok(String msg, Object data) {
        return new R(R.OK,msg,data);
    }
    public static R ok(int code, String msg, Object data) {
        return new R(code,msg,data);
    }
    public static R error(String msg, Object data) {
        return new R(R.ERROR,msg,data);
    }
    public static R error(int code, String msg, Object data) {
        return new R(code,msg,data);
    }
}

