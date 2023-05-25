package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YuanliaoleibieDao;
import com.entity.YuanliaoleibieEntity;
import com.service.YuanliaoleibieService;
import com.entity.vo.YuanliaoleibieVO;
import com.entity.view.YuanliaoleibieView;

@Service("yuanliaoleibieService")
public class YuanliaoleibieServiceImpl extends ServiceImpl<YuanliaoleibieDao, YuanliaoleibieEntity> implements YuanliaoleibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuanliaoleibieEntity> page = this.selectPage(
                new Query<YuanliaoleibieEntity>(params).getPage(),
                new EntityWrapper<YuanliaoleibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuanliaoleibieEntity> wrapper) {
		  Page<YuanliaoleibieView> page =new Query<YuanliaoleibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuanliaoleibieVO> selectListVO(Wrapper<YuanliaoleibieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuanliaoleibieVO selectVO(Wrapper<YuanliaoleibieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuanliaoleibieView> selectListView(Wrapper<YuanliaoleibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuanliaoleibieView selectView(Wrapper<YuanliaoleibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
