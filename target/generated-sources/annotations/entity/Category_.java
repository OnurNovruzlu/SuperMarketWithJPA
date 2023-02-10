package entity;

import entity.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-02-05T10:34:42", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Integer> category;
    public static volatile SingularAttribute<Category, String> categoryName;
    public static volatile ListAttribute<Category, Product> productList;

}