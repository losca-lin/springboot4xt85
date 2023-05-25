package com.dao;

import com.entity.ChanpinxiaoshouzhangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChanpinxiaoshouzhangmuVO;
import com.entity.view.ChanpinxiaoshouzhangmuView;


/**
 * 产品销售账目
 * 
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface ChanpinxiaoshouzhangmuDao extends BaseMapper<ChanpinxiaoshouzhangmuEntity> {
	
	List<ChanpinxiaoshouzhangmuVO> selectListVO(@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);
	
	ChanpinxiaoshouzhangmuVO selectVO(@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);
	
	List<ChanpinxiaoshouzhangmuView> selectListView(@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);

	List<ChanpinxiaoshouzhangmuView> selectListView(Pagination page,@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);
	
	ChanpinxiaoshouzhangmuView selectView(@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);



}
