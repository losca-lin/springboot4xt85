package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.YuangongkaoqinEntity;
import com.entity.view.YuangongkaoqinView;
import com.entity.vo.YuangongkaoqinVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 员工
 *
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface YuangongkaoqinService extends IService<YuangongkaoqinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongkaoqinVO> selectListVO(Wrapper<YuangongkaoqinEntity> wrapper);
   	
   	YuangongkaoqinVO selectVO(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
   	
   	List<YuangongkaoqinView> selectListView(Wrapper<YuangongkaoqinEntity> wrapper);
   	
   	YuangongkaoqinView selectView(@Param("ew") Wrapper<YuangongkaoqinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongkaoqinEntity> wrapper);


    YuangongkaoqinView getCount(String yuangonggonghao);
}

