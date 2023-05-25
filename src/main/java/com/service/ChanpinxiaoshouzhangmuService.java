package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChanpinxiaoshouzhangmuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChanpinxiaoshouzhangmuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChanpinxiaoshouzhangmuView;


/**
 * 产品销售账目
 *
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
public interface ChanpinxiaoshouzhangmuService extends IService<ChanpinxiaoshouzhangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChanpinxiaoshouzhangmuVO> selectListVO(Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);
   	
   	ChanpinxiaoshouzhangmuVO selectVO(@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);
   	
   	List<ChanpinxiaoshouzhangmuView> selectListView(Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);
   	
   	ChanpinxiaoshouzhangmuView selectView(@Param("ew") Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper);



}

