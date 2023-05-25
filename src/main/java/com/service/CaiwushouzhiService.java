package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaiwushouzhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CaiwushouzhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CaiwushouzhiView;


/**
 * 财务收支
 *
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface CaiwushouzhiService extends IService<CaiwushouzhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaiwushouzhiVO> selectListVO(Wrapper<CaiwushouzhiEntity> wrapper);
   	
   	CaiwushouzhiVO selectVO(@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);
   	
   	List<CaiwushouzhiView> selectListView(Wrapper<CaiwushouzhiEntity> wrapper);
   	
   	CaiwushouzhiView selectView(@Param("ew") Wrapper<CaiwushouzhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaiwushouzhiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CaiwushouzhiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CaiwushouzhiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CaiwushouzhiEntity> wrapper);



}

