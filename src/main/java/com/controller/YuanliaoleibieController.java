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

import com.entity.YuanliaoleibieEntity;
import com.entity.view.YuanliaoleibieView;

import com.service.YuanliaoleibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 原料类别
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/yuanliaoleibie")
public class YuanliaoleibieController {
    @Autowired
    private YuanliaoleibieService yuanliaoleibieService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuanliaoleibieEntity yuanliaoleibie,
		HttpServletRequest request){
        EntityWrapper<YuanliaoleibieEntity> ew = new EntityWrapper<YuanliaoleibieEntity>();

		PageUtils page = yuanliaoleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuanliaoleibie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuanliaoleibieEntity yuanliaoleibie, 
		HttpServletRequest request){
        EntityWrapper<YuanliaoleibieEntity> ew = new EntityWrapper<YuanliaoleibieEntity>();

		PageUtils page = yuanliaoleibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuanliaoleibie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuanliaoleibieEntity yuanliaoleibie){
       	EntityWrapper<YuanliaoleibieEntity> ew = new EntityWrapper<YuanliaoleibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuanliaoleibie, "yuanliaoleibie")); 
        return R.ok().put("data", yuanliaoleibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuanliaoleibieEntity yuanliaoleibie){
        EntityWrapper< YuanliaoleibieEntity> ew = new EntityWrapper< YuanliaoleibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuanliaoleibie, "yuanliaoleibie")); 
		YuanliaoleibieView yuanliaoleibieView =  yuanliaoleibieService.selectView(ew);
		return R.ok("查询原料类别成功").put("data", yuanliaoleibieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuanliaoleibieEntity yuanliaoleibie = yuanliaoleibieService.selectById(id);
        return R.ok().put("data", yuanliaoleibie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuanliaoleibieEntity yuanliaoleibie = yuanliaoleibieService.selectById(id);
        return R.ok().put("data", yuanliaoleibie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuanliaoleibieEntity yuanliaoleibie, HttpServletRequest request){
    	yuanliaoleibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuanliaoleibie);
        yuanliaoleibieService.insert(yuanliaoleibie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuanliaoleibieEntity yuanliaoleibie, HttpServletRequest request){
    	yuanliaoleibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuanliaoleibie);
        yuanliaoleibieService.insert(yuanliaoleibie);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuanliaoleibieEntity yuanliaoleibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuanliaoleibie);
        yuanliaoleibieService.updateById(yuanliaoleibie);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuanliaoleibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
