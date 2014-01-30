package ie.ucc.bis.supportinglife.ccm.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Date> updatedDate;
	public static volatile SingularAttribute<User, Boolean> imciUser;
	public static volatile SingularAttribute<User, String> userId;
	public static volatile SingularAttribute<User, String> surname;
	public static volatile SingularAttribute<User, String> role;
	public static volatile SingularAttribute<User, Boolean> ccmUser;
	public static volatile SetAttribute<User, CcmPatient> ccmPatientList;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Date> createdDate;

}

