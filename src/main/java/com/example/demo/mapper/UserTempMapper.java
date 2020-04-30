package com.example.demo.mapper;

import com.example.demo.entity.UserTemp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户临时表 Mapper 接口
 * </p>
 *
 * @author 董鑫
 * @since 2019-10-30
 */
@Mapper
public interface UserTempMapper extends BaseMapper<UserTemp> {

}
