package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuanliaoleibieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuanliaoleibieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuanliaoleibieView;


/**
 * 原料类别
 *
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface YuanliaoleibieService extends IService<YuanliaoleibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuanliaoleibieVO> selectListVO(Wrapper<YuanliaoleibieEntity> wrapper);
   	
   	YuanliaoleibieVO selectVO(@Param("ew") Wrapper<YuanliaoleibieEntity> wrapper);
   	
   	List<YuanliaoleibieView> selectListView(Wrapper<YuanliaoleibieEntity> wrapper);
   	
   	YuanliaoleibieView selectView(@Param("ew") Wrapper<YuanliaoleibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuanliaoleibieEntity> wrapper);
   	

}

