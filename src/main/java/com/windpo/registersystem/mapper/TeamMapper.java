package com.windpo.registersystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.windpo.registersystem.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 风之诗
 * @version 1.0
 */
@Deprecated
@Repository
public interface TeamMapper extends BaseMapper<Team> {

}
