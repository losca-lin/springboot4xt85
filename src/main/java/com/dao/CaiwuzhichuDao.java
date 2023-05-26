package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.CaiwuzhichuEntity;
import com.entity.CaiwuzhichuEntity;
import com.entity.view.CaiwuzhichuView;
import com.entity.vo.CaiwuzhichuVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 财务支出
 * 
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface CaiwuzhichuDao extends BaseMapper<CaiwuzhichuEntity> {
	
	List<CaiwuzhichuVO> selectListVO(@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);
	
	CaiwuzhichuVO selectVO(@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);
	
	List<CaiwuzhichuView> selectListView(@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);

	List<CaiwuzhichuView> selectListView(Pagination page,@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);
	
	CaiwuzhichuView selectView(@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);



}
