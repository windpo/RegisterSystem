package com.windpo.registersystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author 风之诗
 * @version 1.0
 */
@Deprecated
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Team {
    //mp开启主键自增
    /**
     * 队伍id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
}
