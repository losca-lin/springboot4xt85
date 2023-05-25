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


import com.dao.ChanpinxiaoshouzhangmuDao;
import com.entity.ChanpinxiaoshouzhangmuEntity;
import com.service.ChanpinxiaoshouzhangmuService;
import com.entity.vo.ChanpinxiaoshouzhangmuVO;
import com.entity.view.ChanpinxiaoshouzhangmuView;

@Service("chanpinxiaoshouzhangmuService")
public class ChanpinxiaoshouzhangmuServiceImpl extends ServiceImpl<ChanpinxiaoshouzhangmuDao, ChanpinxiaoshouzhangmuEntity> implements ChanpinxiaoshouzhangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChanpinxiaoshouzhangmuEntity> page = this.selectPage(
                new Query<ChanpinxiaoshouzhangmuEntity>(params).getPage(),
                new EntityWrapper<ChanpinxiaoshouzhangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper) {
		  Page<ChanpinxiaoshouzhangmuView> page =new Query<ChanpinxiaoshouzhangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChanpinxiaoshouzhangmuVO> selectListVO(Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChanpinxiaoshouzhangmuVO selectVO(Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChanpinxiaoshouzhangmuView> selectListView(Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChanpinxiaoshouzhangmuView selectView(Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ChanpinxiaoshouzhangmuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
