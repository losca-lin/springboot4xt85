package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.YuanliaoxinxiEntity;
import com.entity.view.YuanliaoxinxiView;
import com.service.YuanliaoxinxiService;
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
 * 原料信息
 * 后端接口
 *
 * @author
 * @email
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/yuanliaoxinxi")
public class YuanliaoxinxiController {
    @Autowired
    private YuanliaoxinxiService yuanliaoxinxiService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YuanliaoxinxiEntity yuanliaoxinxi,
                  HttpServletRequest request) {
        EntityWrapper<YuanliaoxinxiEntity> ew = new EntityWrapper<YuanliaoxinxiEntity>();

        PageUtils page = yuanliaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuanliaoxinxi), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, YuanliaoxinxiEntity yuanliaoxinxi,
                  HttpServletRequest request) {
        EntityWrapper<YuanliaoxinxiEntity> ew = new EntityWrapper<YuanliaoxinxiEntity>();

        PageUtils page = yuanliaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuanliaoxinxi), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(YuanliaoxinxiEntity yuanliaoxinxi) {
        EntityWrapper<YuanliaoxinxiEntity> ew = new EntityWrapper<YuanliaoxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre(yuanliaoxinxi, "yuanliaoxinxi"));
        return R.ok().put("data", yuanliaoxinxiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuanliaoxinxiEntity yuanliaoxinxi) {
        EntityWrapper<YuanliaoxinxiEntity> ew = new EntityWrapper<YuanliaoxinxiEntity>();
        ew.allEq(MPUtil.allEQMapPre(yuanliaoxinxi, "yuanliaoxinxi"));
        YuanliaoxinxiView yuanliaoxinxiView = yuanliaoxinxiService.selectView(ew);
        return R.ok("查询产品信息成功").put("data", yuanliaoxinxiView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        YuanliaoxinxiEntity yuanliaoxinxi = yuanliaoxinxiService.selectById(id);
        return R.ok().put("data", yuanliaoxinxi);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        YuanliaoxinxiEntity yuanliaoxinxi = yuanliaoxinxiService.selectById(id);
        return R.ok().put("data", yuanliaoxinxi);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuanliaoxinxiEntity yuanliaoxinxi, HttpServletRequest request) {
        yuanliaoxinxi.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        // ValidatorUtils.validateEntity(yuanliaoxinxi);
        yuanliaoxinxiService.insert(yuanliaoxinxi);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuanliaoxinxiEntity yuanliaoxinxi, HttpServletRequest request) {
        yuanliaoxinxi.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        // ValidatorUtils.validateEntity(yuanliaoxinxi);
        yuanliaoxinxiService.insert(yuanliaoxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuanliaoxinxiEntity yuanliaoxinxi, HttpServletRequest request) {
        // ValidatorUtils.validateEntity(yuanliaoxinxi);
        yuanliaoxinxiService.updateById(yuanliaoxinxi);// 全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        yuanliaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
