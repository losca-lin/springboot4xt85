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

import com.entity.YuangongbaoxiaoEntity;
import com.entity.view.YuangongbaoxiaoView;

import com.service.YuangongbaoxiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 员工报销
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/yuangongbaoxiao")
public class YuangongbaoxiaoController {
    @Autowired
    private YuangongbaoxiaoService yuangongbaoxiaoService;

    @Autowired
    private CaiwuzhichuService caiwuzhichuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangongbaoxiaoEntity yuangongbaoxiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		// if(tableName.equals("yuangong")) {
		// 	yuangongbaoxiao.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		// }
        EntityWrapper<YuangongbaoxiaoEntity> ew = new EntityWrapper<YuangongbaoxiaoEntity>();

		PageUtils page = yuangongbaoxiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongbaoxiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongbaoxiaoEntity yuangongbaoxiao, 
		HttpServletRequest request){
        EntityWrapper<YuangongbaoxiaoEntity> ew = new EntityWrapper<YuangongbaoxiaoEntity>();

		PageUtils page = yuangongbaoxiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongbaoxiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongbaoxiaoEntity yuangongbaoxiao){
       	EntityWrapper<YuangongbaoxiaoEntity> ew = new EntityWrapper<YuangongbaoxiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangongbaoxiao, "yuangongbaoxiao")); 
        return R.ok().put("data", yuangongbaoxiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongbaoxiaoEntity yuangongbaoxiao){
        EntityWrapper< YuangongbaoxiaoEntity> ew = new EntityWrapper< YuangongbaoxiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangongbaoxiao, "yuangongbaoxiao")); 
		YuangongbaoxiaoView yuangongbaoxiaoView =  yuangongbaoxiaoService.selectView(ew);
		return R.ok("查询员工报销成功").put("data", yuangongbaoxiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongbaoxiaoEntity yuangongbaoxiao = yuangongbaoxiaoService.selectById(id);
        return R.ok().put("data", yuangongbaoxiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongbaoxiaoEntity yuangongbaoxiao = yuangongbaoxiaoService.selectById(id);
        return R.ok().put("data", yuangongbaoxiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongbaoxiaoEntity yuangongbaoxiao, HttpServletRequest request){
    	yuangongbaoxiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongbaoxiao);
        yuangongbaoxiaoService.insert(yuangongbaoxiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongbaoxiaoEntity yuangongbaoxiao, HttpServletRequest request){
    	yuangongbaoxiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuangongbaoxiao);
        yuangongbaoxiaoService.insert(yuangongbaoxiao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuangongbaoxiaoEntity yuangongbaoxiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangongbaoxiao);
        yuangongbaoxiaoService.updateById(yuangongbaoxiao);//全部更新
        if (yuangongbaoxiao.getSfsh().equals("是")){
            CaiwuzhichuEntity<Object> caiwuzhichu = new CaiwuzhichuEntity<>();
            caiwuzhichu.setZhichuleixing("报销");
            caiwuzhichu.setZhichuneirong("员工报销");
            caiwuzhichu.setCaiwuzhichu(Integer.valueOf(yuangongbaoxiao.getBaoxiaojine()));
            caiwuzhichu.setDengjiriqi(new Date());
            caiwuzhichuService.insert(caiwuzhichu);
        }
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YuangongbaoxiaoEntity> list = new ArrayList<YuangongbaoxiaoEntity>();
        for(Long id : ids) {
            YuangongbaoxiaoEntity yuangongbaoxiao = yuangongbaoxiaoService.selectById(id);
            yuangongbaoxiao.setSfsh(sfsh);
            yuangongbaoxiao.setShhf(shhf);
            if (yuangongbaoxiao.getSfsh().equals("是")){
                CaiwuzhichuEntity<Object> caiwuzhichu = new CaiwuzhichuEntity<>();
                caiwuzhichu.setZhichuleixing("报销");
                caiwuzhichu.setZhichuneirong("员工报销");
                caiwuzhichu.setCaiwuzhichu(Integer.valueOf(yuangongbaoxiao.getBaoxiaojine()));
                caiwuzhichu.setDengjiriqi(new Date());
                caiwuzhichuService.insert(caiwuzhichu);
            }
            list.add(yuangongbaoxiao);
        }
        yuangongbaoxiaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongbaoxiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
