package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.CaiwushouzhiEntity;
import com.entity.CaiwuzhichuEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 财务收支
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("caiwuzhichu")
public class CaiwuzhichuView extends CaiwuzhichuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CaiwuzhichuView(){
	}

 	public CaiwuzhichuView(CaiwushouzhiEntity caiwushouzhiEntity){
 	try {
			BeanUtils.copyProperties(this, caiwushouzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
