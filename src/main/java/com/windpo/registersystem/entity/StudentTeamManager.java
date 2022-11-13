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
 * team和student的映射表
 */
@Deprecated
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentTeamManager {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @NotNull
    private Integer teamId;
    @NotNull
    private Integer uid;

}
