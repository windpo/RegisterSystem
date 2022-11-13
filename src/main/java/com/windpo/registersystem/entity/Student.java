package com.windpo.registersystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

/**
 * student实体类
 * @author 风之诗
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonSerialize
public class Student {
    /**
     * 学生UID
     */
    //mp开启主键自增
    @TableId(type = IdType.AUTO)
    private Integer uid;
    /**
     * 学号
     */
    @NotNull(message = "学号不能为 null")
    private String  studentId;
    /**
     * 姓名
     */
    @NotNull(message = "姓名不能为 null")
    private String  name;
    /**
     * 专业
     */
    @NotNull(message = "专业不能为 null")
    private String  major;
    /**
     * 电话
     */
    @NotNull(message = "电话不能为 null")
    private String phoneNumber;
    /**
     * QQ号
     */
    @NotNull(message = "QQ号不能为 null")
    private String qq;
    /**
     * 问题类型(1为A题，2为B题，3为C题，4为D题，5为E题，6为F题)
     */
    @NotNull(message = "选择的问题类型不能为 null")
    private Integer problemType;
    /**
     * 队伍id
     */
    @NotNull(message =  "队伍id不能为空")
    private String teamId;
}
