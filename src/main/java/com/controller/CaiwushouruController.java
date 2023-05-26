package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.CaiwushouruEntity;
import com.entity.view.CaiwushouruView;
import com.service.CaiwushouruService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 财务收入
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/caiwushouru")
public class CaiwushouruController {
    @Autowired
    private CaiwushouruService caiwushouruService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaiwushouruEntity caiwushouru,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		// if(tableName.equals("caiwu")) {
		// 	caiwushouru.setCaiwuzhanghao((String)request.getSession().getAttribute("username"));
		// }
        EntityWrapper<CaiwushouruEntity> ew = new EntityWrapper<CaiwushouruEntity>();
                if(dengjiriqistart!=null) ew.ge("dengjiriqi", dengjiriqistart);
                if(dengjiriqiend!=null) ew.le("dengjiriqi", dengjiriqiend);

		PageUtils page = caiwushouruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwushouru), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaiwushouruEntity caiwushouru, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqiend,
		HttpServletRequest request){
        EntityWrapper<CaiwushouruEntity> ew = new EntityWrapper<CaiwushouruEntity>();
                if(dengjiriqistart!=null) ew.ge("dengjiriqi", dengjiriqistart);
                if(dengjiriqiend!=null) ew.le("dengjiriqi", dengjiriqiend);

		PageUtils page = caiwushouruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwushouru), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaiwushouruEntity caiwushouru){
       	EntityWrapper<CaiwushouruEntity> ew = new EntityWrapper<CaiwushouruEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caiwushouru, "caiwushouru")); 
        return R.ok().put("data", caiwushouruService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaiwushouruEntity caiwushouru){
        EntityWrapper< CaiwushouruEntity> ew = new EntityWrapper< CaiwushouruEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caiwushouru, "caiwushouru")); 
		CaiwushouruView caiwushouruView =  caiwushouruService.selectView(ew);
		return R.ok("查询财务收支成功").put("data", caiwushouruView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaiwushouruEntity caiwushouru = caiwushouruService.selectById(id);
        return R.ok().put("data", caiwushouru);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaiwushouruEntity caiwushouru = caiwushouruService.selectById(id);
        return R.ok().put("data", caiwushouru);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaiwushouruEntity caiwushouru, HttpServletRequest request){
    	caiwushouru.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caiwushouru);
        caiwushouruService.insert(caiwushouru);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaiwushouruEntity caiwushouru, HttpServletRequest request){
    	caiwushouru.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caiwushouru);
        caiwushouruService.insert(caiwushouru);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaiwushouruEntity caiwushouru, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caiwushouru);
        caiwushouruService.updateById(caiwushouru);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caiwushouruService.deleteBatchIds(Arrays.asList(ids));
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
        EntityWrapper<CaiwushouruEntity> ew = new EntityWrapper<CaiwushouruEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		// if(tableName.equals("caiwu")) {
        //     ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
		// }
        List<Map<String, Object>> result = caiwushouruService.selectValue(params, ew);
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
        EntityWrapper<CaiwushouruEntity> ew = new EntityWrapper<CaiwushouruEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = caiwushouruService.selectValue(params, ew);
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
        EntityWrapper<CaiwushouruEntity> ew = new EntityWrapper<CaiwushouruEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = caiwushouruService.selectTimeStatValue(params, ew);
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
        EntityWrapper<CaiwushouruEntity> ew = new EntityWrapper<CaiwushouruEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = caiwushouruService.selectTimeStatValue(params, ew);
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
        EntityWrapper<CaiwushouruEntity> ew = new EntityWrapper<CaiwushouruEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = caiwushouruService.selectGroup(params, ew);
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
    public R count(@RequestParam Map<String, Object> params,CaiwushouruEntity caiwushouru, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        // if(tableName.equals("caiwu")) {
        //     caiwushouru.setCaiwuzhanghao((String)request.getSession().getAttribute("username"));
        // }
        EntityWrapper<CaiwushouruEntity> ew = new EntityWrapper<CaiwushouruEntity>();
        int count = caiwushouruService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwushouru), params), params));
        return R.ok().put("data", count);
    }


}
