package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.CaiwushouruDao;
import com.entity.CaiwushouruEntity;
import com.entity.view.CaiwushouruView;
import com.entity.vo.CaiwushouruVO;
import com.service.CaiwushouruService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("caiwushouruService")
public class CaiwushouruServiceImpl extends ServiceImpl<CaiwushouruDao, CaiwushouruEntity> implements CaiwushouruService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaiwushouruEntity> page = this.selectPage(
                new Query<CaiwushouruEntity>(params).getPage(),
                new EntityWrapper<CaiwushouruEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaiwushouruEntity> wrapper) {
		  Page<CaiwushouruView> page =new Query<CaiwushouruView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CaiwushouruVO> selectListVO(Wrapper<CaiwushouruEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CaiwushouruVO selectVO(Wrapper<CaiwushouruEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CaiwushouruView> selectListView(Wrapper<CaiwushouruEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaiwushouruView selectView(Wrapper<CaiwushouruEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CaiwushouruEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CaiwushouruEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CaiwushouruEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
