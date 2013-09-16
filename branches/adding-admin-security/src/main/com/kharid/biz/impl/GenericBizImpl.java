package com.kharid.biz.impl;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.kharid.biz.GenericBiz;
import com.kharid.dao.GenericDao;
import com.kharid.model.BaseDO;
import com.kharid.model.type.ConstantCodesEnum;

public class GenericBizImpl implements GenericBiz{
	private static Cache constantCache = CacheManager.getInstance().getCache("constantCache");
	
	Log log = LogFactory.getLog(GenericBizImpl.class);
	GenericDao genericDao;
	
	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public List getAll(Class c) {
		return genericDao.getAll(c);
		//return null;
	}

	@Override
	public Long save(BaseDO base) {
		return genericDao.save(base);
		//return null;
	}

	@Override
	public List getAllActive(Class c) {
		DetachedCriteria query = DetachedCriteria.forClass(c).add(Property.forName("isActive").eq(Boolean.TRUE));
		return genericDao.findByCriteria(query);
		//return null;
	}

	@Override
	public BaseDO get(Class clazz, Long id) {
		return genericDao.get(clazz, id);
	}

	@Override
	public int getConstantValue(ConstantCodesEnum code) {
		if(constantCache.get(code) != null ) {
			return (Integer)constantCache.get(code).getObjectValue();
		}else{
			int value = genericDao.getConstantValue(code);
			constantCache.put(new Element(code,value));
			return value;
		}
	}
}
