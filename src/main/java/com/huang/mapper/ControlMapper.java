package com.huang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.entity.Control;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ControlMapper extends BaseMapper<Control> {

}
