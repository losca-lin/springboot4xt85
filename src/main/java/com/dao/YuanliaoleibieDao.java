package com.dao;

import com.entity.YuanliaoleibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuanliaoleibieVO;
import com.entity.view.YuanliaoleibieView;


/**
 * 原料类别
 * 
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface YuanliaoleibieDao extends BaseMapper<YuanliaoleibieEntity> {
	
	List<YuanliaoleibieVO> selectListVO(@Param("ew") Wrapper<YuanliaoleibieEntity> wrapper);
	
	YuanliaoleibieVO selectVO(@Param("ew") Wrapper<YuanliaoleibieEntity> wrapper);
	
	List<YuanliaoleibieView> selectListView(@Param("ew") Wrapper<YuanliaoleibieEntity> wrapper);

	List<YuanliaoleibieView> selectListView(Pagination page,@Param("ew") Wrapper<YuanliaoleibieEntity> wrapper);
	
	YuanliaoleibieView selectView(@Param("ew") Wrapper<YuanliaoleibieEntity> wrapper);
	

}
