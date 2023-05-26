package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.YuangongkaoqinEntity;
import com.entity.view.YuangongkaoqinView;
import com.service.TokenService;
import com.service.YuangongkaoqinService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 员工
 * 后端接口
 *
 * @author
 * @email
 * @date 2023-05-21 14:56:17
 */
@RestController
@RequestMapping("/yuangongkaoqin")
public class YuangongkaoqinController {
    @Autowired
    private YuangongkaoqinService yuangongkaoqinService;


    @Autowired
    private TokenService tokenService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, YuangongkaoqinEntity yuangongkaoqin,
                  HttpServletRequest request) {
        EntityWrapper<YuangongkaoqinEntity> ew = new EntityWrapper<YuangongkaoqinEntity>();

        PageUtils page = yuangongkaoqinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongkaoqin), params), params));

        return R.ok().put("data", page);
    }

    @RequestMapping("/page2")
    public R page2(@RequestParam Map<String, Object> params, YuangongkaoqinEntity yuangongkaoqin,
                   HttpServletRequest request) {
        EntityWrapper<YuangongkaoqinEntity> ew = new EntityWrapper<YuangongkaoqinEntity>();
        PageUtils page = yuangongkaoqinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongkaoqin), params), params));

        return R.ok().put("data", page);
    }

    @RequestMapping("/getCount")
    public R getCount(String yuangonggonghao){
        YuangongkaoqinView data = yuangongkaoqinService.getCount(yuangonggonghao);
        return R.ok().put("data", data);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, YuangongkaoqinEntity yuangongkaoqin,
                  HttpServletRequest request) {
        EntityWrapper<YuangongkaoqinEntity> ew = new EntityWrapper<YuangongkaoqinEntity>();

        PageUtils page = yuangongkaoqinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongkaoqin), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(YuangongkaoqinEntity yuangongkaoqin) {
        EntityWrapper<YuangongkaoqinEntity> ew = new EntityWrapper<YuangongkaoqinEntity>();
        ew.allEq(MPUtil.allEQMapPre(yuangongkaoqin, "yuangongkaoqin"));
        return R.ok().put("data", yuangongkaoqinService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongkaoqinEntity yuangongkaoqin) {
        EntityWrapper<YuangongkaoqinEntity> ew = new EntityWrapper<YuangongkaoqinEntity>();
        ew.allEq(MPUtil.allEQMapPre(yuangongkaoqin, "yuangongkaoqin"));
        YuangongkaoqinView yuangongkaoqinView = yuangongkaoqinService.selectView(ew);
        return R.ok("查询员工成功").put("data", yuangongkaoqinView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        YuangongkaoqinEntity yuangongkaoqin = yuangongkaoqinService.selectById(id);
        return R.ok().put("data", yuangongkaoqin);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        YuangongkaoqinEntity yuangongkaoqin = yuangongkaoqinService.selectById(id);
        return R.ok().put("data", yuangongkaoqin);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongkaoqinEntity yuangongkaoqin, HttpServletRequest request) {
        yuangongkaoqin.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        // ValidatorUtils.validateEntity(yuangongkaoqin);
        YuangongkaoqinEntity u = yuangongkaoqinService.selectOne(new EntityWrapper<YuangongkaoqinEntity>().eq("yuangonggonghao", yuangongkaoqin.getYuangonggonghao()));
        // if (u != null) {
        //     return R.error("用户已存在");
        // }
        yuangongkaoqin.setId(new Date().getTime());
        yuangongkaoqinService.insert(yuangongkaoqin);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongkaoqinEntity yuangongkaoqin, HttpServletRequest request) {
        yuangongkaoqin.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        // ValidatorUtils.validateEntity(yuangongkaoqin);
        YuangongkaoqinEntity u = yuangongkaoqinService.selectOne(new EntityWrapper<YuangongkaoqinEntity>().eq("yuangonggonghao", yuangongkaoqin.getYuangonggonghao()));
        if (u != null) {
            return R.error("用户已存在");
        }
        yuangongkaoqin.setId(new Date().getTime());
        yuangongkaoqinService.insert(yuangongkaoqin);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuangongkaoqinEntity yuangongkaoqin, HttpServletRequest request) {
        // ValidatorUtils.validateEntity(yuangongkaoqin);
        yuangongkaoqinService.updateById(yuangongkaoqin);// 全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        yuangongkaoqinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
