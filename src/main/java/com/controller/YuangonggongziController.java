package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.entity.CaiwuzhichuEntity;
import com.service.CaiwuzhichuService;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YuangonggongziEntity;
import com.entity.view.YuangonggongziView;

import com.service.YuangonggongziService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 员工工资
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/yuangonggongzi")
public class YuangonggongziController {
    @Autowired
    private YuangonggongziService yuangonggongziService;

    @Autowired
    private CaiwuzhichuService caiwuzhichuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangonggongziEntity yuangonggongzi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			yuangonggongzi.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuangonggongziEntity> ew = new EntityWrapper<YuangonggongziEntity>();

		PageUtils page = yuangonggongziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangonggongzi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangonggongziEntity yuangonggongzi, 
		HttpServletRequest request){
        EntityWrapper<YuangonggongziEntity> ew = new EntityWrapper<YuangonggongziEntity>();

		PageUtils page = yuangonggongziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangonggongzi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangonggongziEntity yuangonggongzi){
       	EntityWrapper<YuangonggongziEntity> ew = new EntityWrapper<YuangonggongziEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangonggongzi, "yuangonggongzi")); 
        return R.ok().put("data", yuangonggongziService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangonggongziEntity yuangonggongzi){
        EntityWrapper< YuangonggongziEntity> ew = new EntityWrapper< YuangonggongziEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangonggongzi, "yuangonggongzi")); 
		YuangonggongziView yuangonggongziView =  yuangonggongziService.selectView(ew);
		return R.ok("查询员工工资成功").put("data", yuangonggongziView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangonggongziEntity yuangonggongzi = yuangonggongziService.selectById(id);
        return R.ok().put("data", yuangonggongzi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangonggongziEntity yuangonggongzi = yuangonggongziService.selectById(id);
        return R.ok().put("data", yuangonggongzi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @Transactional
    public R save(@RequestBody YuangonggongziEntity yuangonggongzi, HttpServletRequest request){
    	yuangonggongzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangonggongzi);
        yuangonggongziService.insert(yuangonggongzi);
        CaiwuzhichuEntity<Object> caiwuzhichu = new CaiwuzhichuEntity<>();
        caiwuzhichu.setZhichuleixing("工资");
        caiwuzhichu.setZhichuneirong("员工工资");
        caiwuzhichu.setCaiwuzhichu(yuangonggongzi.getJine().intValue());
        caiwuzhichu.setDengjiriqi(new Date());
        caiwuzhichuService.insert(caiwuzhichu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangonggongziEntity yuangonggongzi, HttpServletRequest request){
    	yuangonggongzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangonggongzi);
        yuangonggongziService.insert(yuangonggongzi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuangonggongziEntity yuangonggongzi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangonggongzi);
        yuangonggongziService.updateById(yuangonggongzi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangonggongziService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
