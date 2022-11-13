package com.windpo.registersystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.windpo.registersystem.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 风之诗
 * @version 1.0
 */
@Repository
public interface StudentMapper extends BaseMapper<Student> {

}
