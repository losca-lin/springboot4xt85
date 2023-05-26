package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.CaiwuzhichuEntity;
import com.entity.view.CaiwuzhichuView;
import com.entity.vo.CaiwuzhichuVO;
import com.utils.PageUtils;
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
public interface CaiwuzhichuService extends IService<CaiwuzhichuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaiwuzhichuVO> selectListVO(Wrapper<CaiwuzhichuEntity> wrapper);
   	
   	CaiwuzhichuVO selectVO(@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);
   	
   	List<CaiwuzhichuView> selectListView(Wrapper<CaiwuzhichuEntity> wrapper);
   	
   	CaiwuzhichuView selectView(@Param("ew") Wrapper<CaiwuzhichuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaiwuzhichuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CaiwuzhichuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CaiwuzhichuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CaiwuzhichuEntity> wrapper);



}

