package com.kharid.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.kharid.model.BaseDO;
import com.kharid.model.type.ConstantCodesEnum;
import com.kharid.model.type.PackageTypeEnum;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.model.type.WeightBracketEnum;

public interface GenericDao {
	List getAll(Class c);
	Long save(BaseDO base);
	List findByCriteria(DetachedCriteria criteria);
	BaseDO get(Class clazz,Long id);
	void update(BaseDO o);
	int getConstantValue(ConstantCodesEnum code);
	
	Double getPrice(PostTypeEnum postType, WeightBracketEnum wb, PackageTypeEnum packageType) throws Exception;
}
