package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.YuanliaoxinxiEntity;
import com.entity.YuanliaoxinxiEntity;
import com.entity.view.YuanliaoxinxiView;
import com.entity.view.YuanliaoxinxiView;
import com.entity.vo.YuanliaoxinxiVO;
import com.entity.vo.YuanliaoxinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 原料信息
 *
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface YuanliaoxinxiService extends IService<YuanliaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuanliaoxinxiVO> selectListVO(Wrapper<YuanliaoxinxiEntity> wrapper);
   	
   	YuanliaoxinxiVO selectVO(@Param("ew") Wrapper<YuanliaoxinxiEntity> wrapper);
   	
   	List<YuanliaoxinxiView> selectListView(Wrapper<YuanliaoxinxiEntity> wrapper);
   	
   	YuanliaoxinxiView selectView(@Param("ew") Wrapper<YuanliaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuanliaoxinxiEntity> wrapper);
   	

}

