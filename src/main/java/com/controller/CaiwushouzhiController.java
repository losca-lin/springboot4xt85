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

import com.entity.CaiwushouzhiEntity;
import com.entity.view.CaiwushouzhiView;

import com.service.CaiwushouzhiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 财务收支
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/caiwushouzhi")
public class CaiwushouzhiController {
    @Autowired
    private CaiwushouzhiService caiwushouzhiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaiwushouzhiEntity caiwushouzhi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("caiwu")) {
			caiwushouzhi.setCaiwuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CaiwushouzhiEntity> ew = new EntityWrapper<CaiwushouzhiEntity>();
                if(dengjiriqistart!=null) ew.ge("dengjiriqi", dengjiriqistart);
                if(dengjiriqiend!=null) ew.le("dengjiriqi", dengjiriqiend);

		PageUtils page = caiwushouzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwushouzhi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaiwushouzhiEntity caiwushouzhi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqiend,
		HttpServletRequest request){
        EntityWrapper<CaiwushouzhiEntity> ew = new EntityWrapper<CaiwushouzhiEntity>();
                if(dengjiriqistart!=null) ew.ge("dengjiriqi", dengjiriqistart);
                if(dengjiriqiend!=null) ew.le("dengjiriqi", dengjiriqiend);

		PageUtils page = caiwushouzhiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwushouzhi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaiwushouzhiEntity caiwushouzhi){
       	EntityWrapper<CaiwushouzhiEntity> ew = new EntityWrapper<CaiwushouzhiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caiwushouzhi, "caiwushouzhi")); 
        return R.ok().put("data", caiwushouzhiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaiwushouzhiEntity caiwushouzhi){
        EntityWrapper< CaiwushouzhiEntity> ew = new EntityWrapper< CaiwushouzhiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caiwushouzhi, "caiwushouzhi")); 
		CaiwushouzhiView caiwushouzhiView =  caiwushouzhiService.selectView(ew);
		return R.ok("查询财务收支成功").put("data", caiwushouzhiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaiwushouzhiEntity caiwushouzhi = caiwushouzhiService.selectById(id);
        return R.ok().put("data", caiwushouzhi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaiwushouzhiEntity caiwushouzhi = caiwushouzhiService.selectById(id);
        return R.ok().put("data", caiwushouzhi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaiwushouzhiEntity caiwushouzhi, HttpServletRequest request){
    	caiwushouzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caiwushouzhi);
        caiwushouzhiService.insert(caiwushouzhi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaiwushouzhiEntity caiwushouzhi, HttpServletRequest request){
    	caiwushouzhi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caiwushouzhi);
        caiwushouzhiService.insert(caiwushouzhi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaiwushouzhiEntity caiwushouzhi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caiwushouzhi);
        caiwushouzhiService.updateById(caiwushouzhi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caiwushouzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<CaiwushouzhiEntity> ew = new EntityWrapper<CaiwushouzhiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = caiwushouzhiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<CaiwushouzhiEntity> ew = new EntityWrapper<CaiwushouzhiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = caiwushouzhiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<CaiwushouzhiEntity> ew = new EntityWrapper<CaiwushouzhiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = caiwushouzhiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<CaiwushouzhiEntity> ew = new EntityWrapper<CaiwushouzhiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = caiwushouzhiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<CaiwushouzhiEntity> ew = new EntityWrapper<CaiwushouzhiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = caiwushouzhiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,CaiwushouzhiEntity caiwushouzhi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            caiwushouzhi.setCaiwuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<CaiwushouzhiEntity> ew = new EntityWrapper<CaiwushouzhiEntity>();
        int count = caiwushouzhiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwushouzhi), params), params));
        return R.ok().put("data", count);
    }


}
