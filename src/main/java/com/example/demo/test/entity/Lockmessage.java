package com.example.demo.test.entity;

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
 * @since 2020-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Lockmessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @TableField("terminalId")
    private Long terminalId;

    private String type;


}
