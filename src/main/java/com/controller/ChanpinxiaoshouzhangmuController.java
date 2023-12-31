package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.CaiwushouruEntity;
import com.entity.ChanpinxiaoshouzhangmuEntity;
import com.entity.ChanpinxinxiEntity;
import com.entity.view.ChanpinxiaoshouzhangmuView;
import com.service.CaiwushouruService;
import com.service.ChanpinxiaoshouzhangmuService;
import com.service.ChanpinxinxiService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 产品销售账目
 * 后端接口
 *
 * @author
 * @email
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/chanpinxiaoshouzhangmu")
public class ChanpinxiaoshouzhangmuController {
    @Autowired
    private ChanpinxiaoshouzhangmuService chanpinxiaoshouzhangmuService;

    @Autowired
    private CaiwushouruService caiwushouruService;

    @Autowired
    private ChanpinxinxiService chanpinxinxiService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmu,
                  @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date riqistart,
                  @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date riqiend,
                  HttpServletRequest request) {
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yuangong")) {
            chanpinxiaoshouzhangmu.setYuangonggonghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> ew = new EntityWrapper<ChanpinxiaoshouzhangmuEntity>();
        if (riqistart != null) ew.ge("riqi", riqistart);
        if (riqiend != null) ew.le("riqi", riqiend);

        PageUtils page = chanpinxiaoshouzhangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chanpinxiaoshouzhangmu), params), params));

        return R.ok().put("data", page);
    }

    @RequestMapping("/getCount")
    public R getCount(String yuangonggonghao) {
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("yuangonggonghao", yuangonggonghao);
        List<ChanpinxiaoshouzhangmuEntity> list = chanpinxiaoshouzhangmuService.selectList(wrapper);
        if (list == null){
            return R.ok().put("data", 0);
        }
        Integer count = 0;
        for (ChanpinxiaoshouzhangmuEntity entity : list) {
            count += (entity.getCount() == null?0:entity.getCount());
        }
        return R.ok().put("data", count);

    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmu,
                  @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date riqistart,
                  @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date riqiend,
                  HttpServletRequest request) {
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> ew = new EntityWrapper<ChanpinxiaoshouzhangmuEntity>();
        if (riqistart != null) ew.ge("riqi", riqistart);
        if (riqiend != null) ew.le("riqi", riqiend);

        PageUtils page = chanpinxiaoshouzhangmuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chanpinxiaoshouzhangmu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmu) {
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> ew = new EntityWrapper<ChanpinxiaoshouzhangmuEntity>();
        ew.allEq(MPUtil.allEQMapPre(chanpinxiaoshouzhangmu, "chanpinxiaoshouzhangmu"));
        return R.ok().put("data", chanpinxiaoshouzhangmuService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmu) {
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> ew = new EntityWrapper<ChanpinxiaoshouzhangmuEntity>();
        ew.allEq(MPUtil.allEQMapPre(chanpinxiaoshouzhangmu, "chanpinxiaoshouzhangmu"));
        ChanpinxiaoshouzhangmuView chanpinxiaoshouzhangmuView = chanpinxiaoshouzhangmuService.selectView(ew);
        return R.ok("查询产品销售账目成功").put("data", chanpinxiaoshouzhangmuView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmu = chanpinxiaoshouzhangmuService.selectById(id);
        return R.ok().put("data", chanpinxiaoshouzhangmu);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmu = chanpinxiaoshouzhangmuService.selectById(id);
        return R.ok().put("data", chanpinxiaoshouzhangmu);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @Transactional
    public R save(@RequestBody ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmu, HttpServletRequest request) {
        chanpinxiaoshouzhangmu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        // ValidatorUtils.validateEntity(chanpinxiaoshouzhangmu);
        chanpinxiaoshouzhangmuService.insert(chanpinxiaoshouzhangmu);
        CaiwushouruEntity<Object> caiwushouru = new CaiwushouruEntity<>();
        caiwushouru.setShouruleixing("销售");
        caiwushouru.setShouruneirong("产品销售");
        caiwushouru.setCaiwushouru(chanpinxiaoshouzhangmu.getXiaoshoue());
        caiwushouru.setDengjiriqi(new Date());
        caiwushouruService.insert(caiwushouru);
        EntityWrapper<ChanpinxinxiEntity> wrapper = new EntityWrapper<>();
        wrapper.eq("chanpinmingcheng", chanpinxiaoshouzhangmu.getChanpinmingcheng());
        ChanpinxinxiEntity chanpinxinxiEntity = chanpinxinxiService.selectOne(wrapper);
        Integer shuliang = chanpinxinxiEntity.getShuliang();
        shuliang = shuliang - chanpinxiaoshouzhangmu.getCount();
        if (shuliang <= 0) {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return R.error("销售大于库存");
            }
        }
        chanpinxinxiEntity.setShuliang(shuliang);
        chanpinxinxiService.updateById(chanpinxinxiEntity);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmu, HttpServletRequest request) {
        chanpinxiaoshouzhangmu.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        // ValidatorUtils.validateEntity(chanpinxiaoshouzhangmu);
        chanpinxiaoshouzhangmuService.insert(chanpinxiaoshouzhangmu);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChanpinxiaoshouzhangmuEntity chanpinxiaoshouzhangmu, HttpServletRequest request) {
        // ValidatorUtils.validateEntity(chanpinxiaoshouzhangmu);
        chanpinxiaoshouzhangmuService.updateById(chanpinxiaoshouzhangmu);// 全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        chanpinxiaoshouzhangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> ew = new EntityWrapper<ChanpinxiaoshouzhangmuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yuangong")) {
            ew.eq("yuangonggonghao", (String) request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = chanpinxiaoshouzhangmuService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Map<String, Object> m : result) {
            for (String k : m.keySet()) {
                if (m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date) m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName, @RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String, Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> ew = new EntityWrapper<ChanpinxiaoshouzhangmuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yuangong")) {
            ew.eq("yuangonggonghao", (String) request.getSession().getAttribute("username"));
        }
        for (int i = 0; i < yColumnNames.length; i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = chanpinxiaoshouzhangmuService.selectValue(params, ew);
            for (Map<String, Object> m : result) {
                for (String k : m.keySet()) {
                    if (m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date) m.get(k)));
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
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> ew = new EntityWrapper<ChanpinxiaoshouzhangmuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yuangong")) {
            ew.eq("yuangonggonghao", (String) request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = chanpinxiaoshouzhangmuService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Map<String, Object> m : result) {
            for (String k : m.keySet()) {
                if (m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date) m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType, @RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String, Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> ew = new EntityWrapper<ChanpinxiaoshouzhangmuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yuangong")) {
            ew.eq("yuangonggonghao", (String) request.getSession().getAttribute("username"));
        }
        for (int i = 0; i < yColumnNames.length; i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = chanpinxiaoshouzhangmuService.selectTimeStatValue(params, ew);
            for (Map<String, Object> m : result) {
                for (String k : m.keySet()) {
                    if (m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date) m.get(k)));
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
    public R group(@PathVariable("columnName") String columnName, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<ChanpinxiaoshouzhangmuEntity> ew = new EntityWrapper<ChanpinxiaoshouzhangmuEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("yuangong")) {
            ew.eq("yuangonggonghao", (String) request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = chanpinxiaoshouzhangmuService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (Map<String, Object> m : result) {
            for (String k : m.keySet()) {
                if (m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date) m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }


}
