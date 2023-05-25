package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuanliaocaigouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuanliaocaigouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuanliaocaigouView;


/**
 * 原料采购
 *
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface YuanliaocaigouService extends IService<YuanliaocaigouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuanliaocaigouVO> selectListVO(Wrapper<YuanliaocaigouEntity> wrapper);
   	
   	YuanliaocaigouVO selectVO(@Param("ew") Wrapper<YuanliaocaigouEntity> wrapper);
   	
   	List<YuanliaocaigouView> selectListView(Wrapper<YuanliaocaigouEntity> wrapper);
   	
   	YuanliaocaigouView selectView(@Param("ew") Wrapper<YuanliaocaigouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuanliaocaigouEntity> wrapper);
   	

}

