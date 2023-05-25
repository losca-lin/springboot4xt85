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


import com.dao.YuanliaocaigouDao;
import com.entity.YuanliaocaigouEntity;
import com.service.YuanliaocaigouService;
import com.entity.vo.YuanliaocaigouVO;
import com.entity.view.YuanliaocaigouView;

@Service("yuanliaocaigouService")
public class YuanliaocaigouServiceImpl extends ServiceImpl<YuanliaocaigouDao, YuanliaocaigouEntity> implements YuanliaocaigouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuanliaocaigouEntity> page = this.selectPage(
                new Query<YuanliaocaigouEntity>(params).getPage(),
                new EntityWrapper<YuanliaocaigouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuanliaocaigouEntity> wrapper) {
		  Page<YuanliaocaigouView> page =new Query<YuanliaocaigouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuanliaocaigouVO> selectListVO(Wrapper<YuanliaocaigouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuanliaocaigouVO selectVO(Wrapper<YuanliaocaigouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuanliaocaigouView> selectListView(Wrapper<YuanliaocaigouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuanliaocaigouView selectView(Wrapper<YuanliaocaigouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
