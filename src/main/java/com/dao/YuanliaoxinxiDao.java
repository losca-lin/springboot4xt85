package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.YuanliaoxinxiEntity;
import com.entity.YuanliaoxinxiEntity;
import com.entity.view.ChanpinxinxiView;
import com.entity.view.YuanliaoxinxiView;
import com.entity.vo.YuanliaoxinxiVO;
import com.entity.vo.YuanliaoxinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 原料信息
 * 
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface YuanliaoxinxiDao extends BaseMapper<YuanliaoxinxiEntity> {
	
	List<YuanliaoxinxiVO> selectListVO(@Param("ew") Wrapper<YuanliaoxinxiEntity> wrapper);
	
	YuanliaoxinxiVO selectVO(@Param("ew") Wrapper<YuanliaoxinxiEntity> wrapper);
	
	List<YuanliaoxinxiView> selectListView(@Param("ew") Wrapper<YuanliaoxinxiEntity> wrapper);

	List<YuanliaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YuanliaoxinxiEntity> wrapper);

	YuanliaoxinxiView selectView(@Param("ew") Wrapper<YuanliaoxinxiEntity> wrapper);
	

}
