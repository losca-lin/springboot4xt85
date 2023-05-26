package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.CaiwushouruEntity;
import com.entity.view.CaiwushouruView;
import com.entity.vo.CaiwushouruVO;
import com.entity.vo.CaiwushouruVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 财务收入
 * 
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface CaiwushouruDao extends BaseMapper<CaiwushouruEntity> {
	
	List<CaiwushouruVO> selectListVO(@Param("ew") Wrapper<CaiwushouruEntity> wrapper);
	
	CaiwushouruVO selectVO(@Param("ew") Wrapper<CaiwushouruEntity> wrapper);
	
	List<CaiwushouruView> selectListView(@Param("ew") Wrapper<CaiwushouruEntity> wrapper);

	List<CaiwushouruView> selectListView(Pagination page,@Param("ew") Wrapper<CaiwushouruEntity> wrapper);
	
	CaiwushouruView selectView(@Param("ew") Wrapper<CaiwushouruEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwushouruEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwushouruEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwushouruEntity> wrapper);



}
