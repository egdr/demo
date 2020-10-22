package com.example.demo.core.res;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200,"成功"),//成功
    FAIL(400,"失败"),//失败
    UNAUTHORIZED(401,"未认证（签名错误）"),//未认证（签名错误）
    NOT_FOUND(404,"接口不存在"),//接口不存在
    INTERNAL_SERVER_ERROR(500,"服务器内部错误"),//服务器内部错误


    success(200,"成功"),
    tru(200,"success"),
    err(300,"error"),
    fail(300,"失败"),
    req_err(400,"请求有误"),
    no_auth(401,"权限不匹配"),
    no_url(402,"URL地址无效"),

    no_data(404,"无数据"),
    img_too_big(405,"文件最大不能超过2Mb"),
    img_format_err(406,"只支持jpg,png,bmp,jpeg"),
    att_err(407,"参数不对"),
    att_is_null(408,"属性不能为空"),
    att_num_err(409,"参数数量错误"),
    data_has_ref(410,"数据有引用"),
    amount_no_zero(411,"金额不能为0"),
    data_too_less(412,"数据不足"),
    data_too_much(413,"数据太多"),

    no_user(414,"没有此用户"),
    no_pwd(415,"用户名或密码不匹配"),
    no_audit(416,"企业可能还没通过审核"),
    is_login(417,"用户已经登录"),
    no_binding(418,"账号未绑定企业信息"),
    com_err(419,"登陆单位错误"),
    limit_login(420,"限制登陆，请联系管理员"),
    loginout_success(421,"退出成功"),
    loginout_fail(422,"退出失败"),
    label_fail(423,"标签有误"),
    label_isin(424,"标签已经入库"),


    smscode_err(426,"手机号验证码有误"),
    req_too_much(427,"请求太频繁"),



    err_sys(500,"系统异常"),
    dup_key(501,"主键重复"),
    dup_data(502,"数据重复"),
    key_err(503,"主键错误"),
    no_key(504,"无主键"),

    user_is_freeze(507,"用户已经被冻结");

















    private final int code;

    private final String msg;

    ResultCode(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }
    public String msg(){
        return msg;
    }
}
