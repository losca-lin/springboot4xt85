package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.CaiwushouruEntity;
import com.entity.view.CaiwushouruView;
import com.entity.vo.CaiwushouruVO;
import com.utils.PageUtils;
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
public interface CaiwushouruService extends IService<CaiwushouruEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaiwushouruVO> selectListVO(Wrapper<CaiwushouruEntity> wrapper);
   	
   	CaiwushouruVO selectVO(@Param("ew") Wrapper<CaiwushouruEntity> wrapper);
   	
   	List<CaiwushouruView> selectListView(Wrapper<CaiwushouruEntity> wrapper);
   	
   	CaiwushouruView selectView(@Param("ew") Wrapper<CaiwushouruEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaiwushouruEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CaiwushouruEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CaiwushouruEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CaiwushouruEntity> wrapper);



}

