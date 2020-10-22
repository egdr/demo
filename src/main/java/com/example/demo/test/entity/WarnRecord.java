package com.example.demo.test.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhw
 * @since 2020-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarnRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报警id
     */
    private Long id;

    /**
     * 电子锁编号
     */
    @TableField("terminal_Id")
    private String terminalId;

    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 运输单位
     */
    private String ysName;

    /**
     * 报警时间
     */
    private Date warnTime;

    /**
     * 数据更时间
     */
    private Date updateTime;

    /**
     * 报警地点
     */
    private String warnAddress;

    /**
     * 报警类型
     */
    private String warnType;


}
