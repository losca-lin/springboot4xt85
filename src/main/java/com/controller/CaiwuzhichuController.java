package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.CaiwuzhichuEntity;
import com.entity.view.CaiwuzhichuView;
import com.service.CaiwuzhichuService;
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
 * 财务支出
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/caiwuzhichu")
public class CaiwuzhichuController {
    @Autowired
    private CaiwuzhichuService caiwuzhichuService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaiwuzhichuEntity caiwuzhichu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		// if(tableName.equals("caiwu")) {
		// 	caiwuzhichu.setCaiwuzhanghao((String)request.getSession().getAttribute("username"));
		// }
        EntityWrapper<CaiwuzhichuEntity> ew = new EntityWrapper<CaiwuzhichuEntity>();
                if(dengjiriqistart!=null) ew.ge("dengjiriqi", dengjiriqistart);
                if(dengjiriqiend!=null) ew.le("dengjiriqi", dengjiriqiend);

		PageUtils page = caiwuzhichuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwuzhichu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaiwuzhichuEntity caiwuzhichu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqiend,
		HttpServletRequest request){
        EntityWrapper<CaiwuzhichuEntity> ew = new EntityWrapper<CaiwuzhichuEntity>();
                if(dengjiriqistart!=null) ew.ge("dengjiriqi", dengjiriqistart);
                if(dengjiriqiend!=null) ew.le("dengjiriqi", dengjiriqiend);

		PageUtils page = caiwuzhichuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwuzhichu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaiwuzhichuEntity caiwuzhichu){
       	EntityWrapper<CaiwuzhichuEntity> ew = new EntityWrapper<CaiwuzhichuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caiwuzhichu, "caiwuzhichu")); 
        return R.ok().put("data", caiwuzhichuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaiwuzhichuEntity caiwuzhichu){
        EntityWrapper< CaiwuzhichuEntity> ew = new EntityWrapper< CaiwuzhichuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caiwuzhichu, "caiwuzhichu")); 
		CaiwuzhichuView caiwuzhichuView =  caiwuzhichuService.selectView(ew);
		return R.ok("查询财务收支成功").put("data", caiwuzhichuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaiwuzhichuEntity caiwuzhichu = caiwuzhichuService.selectById(id);
        return R.ok().put("data", caiwuzhichu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaiwuzhichuEntity caiwuzhichu = caiwuzhichuService.selectById(id);
        return R.ok().put("data", caiwuzhichu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaiwuzhichuEntity caiwuzhichu, HttpServletRequest request){
    	caiwuzhichu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caiwuzhichu);
        caiwuzhichuService.insert(caiwuzhichu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaiwuzhichuEntity caiwuzhichu, HttpServletRequest request){
    	caiwuzhichu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(caiwuzhichu);
        caiwuzhichuService.insert(caiwuzhichu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaiwuzhichuEntity caiwuzhichu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caiwuzhichu);
        caiwuzhichuService.updateById(caiwuzhichu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caiwuzhichuService.deleteBatchIds(Arrays.asList(ids));
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
        EntityWrapper<CaiwuzhichuEntity> ew = new EntityWrapper<CaiwuzhichuEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		// if(tableName.equals("caiwu")) {
        //     ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
		// }
        List<Map<String, Object>> result = caiwuzhichuService.selectValue(params, ew);
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
        EntityWrapper<CaiwuzhichuEntity> ew = new EntityWrapper<CaiwuzhichuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = caiwuzhichuService.selectValue(params, ew);
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
        EntityWrapper<CaiwuzhichuEntity> ew = new EntityWrapper<CaiwuzhichuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = caiwuzhichuService.selectTimeStatValue(params, ew);
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
        EntityWrapper<CaiwuzhichuEntity> ew = new EntityWrapper<CaiwuzhichuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        // if(tableName.equals("caiwu")) {
        //     ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        // }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = caiwuzhichuService.selectTimeStatValue(params, ew);
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
        EntityWrapper<CaiwuzhichuEntity> ew = new EntityWrapper<CaiwuzhichuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("caiwu")) {
            ew.eq("caiwuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = caiwuzhichuService.selectGroup(params, ew);
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
    public R count(@RequestParam Map<String, Object> params,CaiwuzhichuEntity caiwuzhichu, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        // if(tableName.equals("caiwu")) {
        //     caiwuzhichu.setCaiwuzhanghao((String)request.getSession().getAttribute("username"));
        // }
        EntityWrapper<CaiwuzhichuEntity> ew = new EntityWrapper<CaiwuzhichuEntity>();
        int count = caiwuzhichuService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwuzhichu), params), params));
        return R.ok().put("data", count);
    }


}
