package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ChanpinleixingEntity;
import com.entity.view.ChanpinleixingView;
import com.service.ChanpinleixingService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 产品类型
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/chanpinleixing")
public class ChanpinleixingController {
    @Autowired
    private ChanpinleixingService chanpinleixingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChanpinleixingEntity chanpinleixing,
		HttpServletRequest request){
        EntityWrapper<ChanpinleixingEntity> ew = new EntityWrapper<ChanpinleixingEntity>();

		PageUtils page = chanpinleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chanpinleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChanpinleixingEntity chanpinleixing, 
		HttpServletRequest request){
        EntityWrapper<ChanpinleixingEntity> ew = new EntityWrapper<ChanpinleixingEntity>();

		PageUtils page = chanpinleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chanpinleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChanpinleixingEntity chanpinleixing){
       	EntityWrapper<ChanpinleixingEntity> ew = new EntityWrapper<ChanpinleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chanpinleixing, "chanpinleixing")); 
        return R.ok().put("data", chanpinleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChanpinleixingEntity chanpinleixing){
        EntityWrapper< ChanpinleixingEntity> ew = new EntityWrapper< ChanpinleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chanpinleixing, "chanpinleixing")); 
		ChanpinleixingView chanpinleixingView =  chanpinleixingService.selectView(ew);
		return R.ok("查询产品类型成功").put("data", chanpinleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChanpinleixingEntity chanpinleixing = chanpinleixingService.selectById(id);
        return R.ok().put("data", chanpinleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChanpinleixingEntity chanpinleixing = chanpinleixingService.selectById(id);
        return R.ok().put("data", chanpinleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChanpinleixingEntity chanpinleixing, HttpServletRequest request){
    	chanpinleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chanpinleixing);
        chanpinleixingService.insert(chanpinleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChanpinleixingEntity chanpinleixing, HttpServletRequest request){
    	chanpinleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chanpinleixing);
        chanpinleixingService.insert(chanpinleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChanpinleixingEntity chanpinleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chanpinleixing);
        chanpinleixingService.updateById(chanpinleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chanpinleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
