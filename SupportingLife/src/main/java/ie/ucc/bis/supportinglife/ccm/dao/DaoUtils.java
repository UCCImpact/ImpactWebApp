package ie.ucc.bis.supportinglife.ccm.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.SingularAttribute;

public class DaoUtils {

	public static <X, Y, Z> void addEqualCondition(String userParam, CriteriaBuilder builder,
								List<Predicate> criteriaList, Join<X, Y> tableJoin, 
								SingularAttribute<Y, Z> singularAttrib) {
		if (userParam != null && !userParam.isEmpty()) {
			Predicate nationalIdCondition = builder.equal(tableJoin.get(singularAttrib), userParam);
			criteriaList.add(nationalIdCondition);
		}
	}

}
