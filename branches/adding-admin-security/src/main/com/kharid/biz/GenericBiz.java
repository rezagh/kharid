package com.kharid.biz;

import java.util.List;

import com.kharid.model.BaseDO;
import com.kharid.model.type.ConstantCodesEnum;

public interface GenericBiz {
	List getAll(Class c);
	List getAllActive(Class c);
	Long save(BaseDO base);
	//List findByCriteria(DetachedCriteria criteria);
	BaseDO get(Class clazz,Long id);
	int getConstantValue(ConstantCodesEnum code);
}
