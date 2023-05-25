package com.dao;

import com.entity.CaiwushouzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CaiwushouzhiVO;
import com.entity.view.CaiwushouzhiView;


/**
 * 财务收支
 * 
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface CaiwushouzhiDao extends BaseMapper<CaiwushouzhiEntity> {
	
	List<CaiwushouzhiVO> selectListVO(@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);
	
	CaiwushouzhiVO selectVO(@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);
	
	List<CaiwushouzhiView> selectListView(@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);

	List<CaiwushouzhiView> selectListView(Pagination page,@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);
	
	CaiwushouzhiView selectView(@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);



}
