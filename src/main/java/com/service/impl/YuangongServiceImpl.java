package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.YuangongDao;
import com.dao.YuangongkaoqinDao;
import com.entity.YuangongEntity;
import com.entity.view.YuangongView;
import com.entity.view.YuangongkaoqinView;
import com.entity.vo.YuangongVO;
import com.service.YuangongService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("yuangongService")
public class YuangongServiceImpl extends ServiceImpl<YuangongDao, YuangongEntity> implements YuangongService {

    @Autowired
    private YuangongkaoqinDao yuangongkaoqinDao;



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangongEntity> page = this.selectPage(
                new Query<YuangongEntity>(params).getPage(),
                new EntityWrapper<YuangongEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangongEntity> wrapper) {
        Page<YuangongView> page = new Query<YuangongView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public PageUtils queryPage2(Map<String, Object> params, Wrapper wrapper) {
        Page<YuangongkaoqinView> page = new Query<YuangongkaoqinView>(params).getPage();
        wrapper.groupBy("yuangonggonghao");
        page.setRecords(yuangongkaoqinDao.selectList2(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<YuangongVO> selectListVO(Wrapper<YuangongEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public YuangongVO selectVO(Wrapper<YuangongEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<YuangongView> selectListView(Wrapper<YuangongEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public YuangongView selectView(Wrapper<YuangongEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
