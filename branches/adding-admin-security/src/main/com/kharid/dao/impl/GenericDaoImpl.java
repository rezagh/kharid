package com.kharid.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kharid.dao.GenericDao;
import com.kharid.model.BaseDO;
import com.kharid.model.ConstantDO;
import com.kharid.model.PriceDO;
import com.kharid.model.type.ConstantCodesEnum;
import com.kharid.model.type.PackageTypeEnum;
import com.kharid.model.type.PostTypeEnum;
import com.kharid.model.type.WeightBracketEnum;

public class GenericDaoImpl extends HibernateDaoSupport implements GenericDao {
	Log log = LogFactory.getLog(GenericDaoImpl.class);
	
	
	@Override
    public final List getAll(Class c) {
		getHibernateTemplate().setCacheQueries(true);
	       
		return super.getHibernateTemplate().loadAll(c);
    }

	@Override
	public Long save(BaseDO base) {
		//base.setDateModified(new Date());
		return (Long)super.getHibernateTemplate().save(base);
	}

	@Override
	public List findByCriteria(DetachedCriteria criteria) {
		getHibernateTemplate().setCacheQueries(true);
		return super.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public BaseDO get(Class clazz,Long id) {
		 return (BaseDO)super.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public void update(BaseDO o) {
		//o.setDateModified(new Date());
		super.getHibernateTemplate().update(o);
	}
	
	public Double getPrice(PostTypeEnum postType, WeightBracketEnum wb, PackageTypeEnum packageType) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(PriceDO.class).
		add( Property.forName("weightBracket").eq(wb.name())).
		add(Property.forName("postType").eq(postType.name())).
		add(Property.forName("packageType").eq(packageType.getEnName()));
		List<PriceDO> weightPrices = findByCriteria(query);
		if(weightPrices != null && weightPrices.size() == 1) 
			 return new Double(weightPrices.get(0).getPrice());
		else throw new Exception("no price found for this weight bracket : " + wb.name()); 
	}

	@Override
	public int getConstantValue(ConstantCodesEnum code) {
		DetachedCriteria query = DetachedCriteria.forClass(ConstantDO.class).
		add( Property.forName("code").eq(code.name()));
		List<ConstantDO> codes = findByCriteria(query);
		if(codes == null || codes.size() > 1) return 0;
		else return codes.get(0).getValue().intValue();
	}
}
