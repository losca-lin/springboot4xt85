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


import com.dao.CaiwushouzhiDao;
import com.entity.CaiwushouzhiEntity;
import com.service.CaiwushouzhiService;
import com.entity.vo.CaiwushouzhiVO;
import com.entity.view.CaiwushouzhiView;

@Service("caiwushouzhiService")
public class CaiwushouzhiServiceImpl extends ServiceImpl<CaiwushouzhiDao, CaiwushouzhiEntity> implements CaiwushouzhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaiwushouzhiEntity> page = this.selectPage(
                new Query<CaiwushouzhiEntity>(params).getPage(),
                new EntityWrapper<CaiwushouzhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaiwushouzhiEntity> wrapper) {
		  Page<CaiwushouzhiView> page =new Query<CaiwushouzhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CaiwushouzhiVO> selectListVO(Wrapper<CaiwushouzhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CaiwushouzhiVO selectVO(Wrapper<CaiwushouzhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CaiwushouzhiView> selectListView(Wrapper<CaiwushouzhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaiwushouzhiView selectView(Wrapper<CaiwushouzhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CaiwushouzhiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CaiwushouzhiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CaiwushouzhiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
