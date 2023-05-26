package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.YuangongkaoqinEntity;
import com.entity.view.YuangongView;
import com.entity.view.YuangongkaoqinView;
import com.entity.vo.YuangongkaoqinVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 员工
 * 
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface YuangongkaoqinDao extends BaseMapper<YuangongkaoqinEntity> {
	
	List<YuangongkaoqinVO> selectListVO(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
	
	YuangongkaoqinVO selectVO(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
	
	List<YuangongkaoqinView> selectListView(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);

	List<YuangongkaoqinView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
	
	YuangongkaoqinView selectView(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);


    List<YuangongkaoqinView> selectList2(Page<YuangongkaoqinView> page, @Param("ew") Wrapper wrapper);

	YuangongkaoqinView getCount(String yuangonggonghao);
}
