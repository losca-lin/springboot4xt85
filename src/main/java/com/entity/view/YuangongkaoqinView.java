package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.YuangongEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 员工
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-21 14:56:17
 */
@TableName("yuangongkaoqin")
public class  YuangongkaoqinView extends YuangongEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableField(exist = false)
	private String gzzsc;

	public YuangongkaoqinView(){
	}

 	public YuangongkaoqinView(YuangongEntity yuangongEntity){
 	try {
			BeanUtils.copyProperties(this, yuangongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
