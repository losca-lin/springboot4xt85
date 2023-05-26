package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.CaiwuzhichuDao;
import com.entity.CaiwuzhichuEntity;
import com.entity.view.CaiwuzhichuView;
import com.entity.vo.CaiwuzhichuVO;
import com.service.CaiwuzhichuService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("caiwuzhichuService")
public class CaiwuzhichuServiceImpl extends ServiceImpl<CaiwuzhichuDao, CaiwuzhichuEntity> implements CaiwuzhichuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaiwuzhichuEntity> page = this.selectPage(
                new Query<CaiwuzhichuEntity>(params).getPage(),
                new EntityWrapper<CaiwuzhichuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaiwuzhichuEntity> wrapper) {
		  Page<CaiwuzhichuView> page =new Query<CaiwuzhichuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CaiwuzhichuVO> selectListVO(Wrapper<CaiwuzhichuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CaiwuzhichuVO selectVO(Wrapper<CaiwuzhichuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CaiwuzhichuView> selectListView(Wrapper<CaiwuzhichuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaiwuzhichuView selectView(Wrapper<CaiwuzhichuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CaiwuzhichuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CaiwuzhichuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CaiwuzhichuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
