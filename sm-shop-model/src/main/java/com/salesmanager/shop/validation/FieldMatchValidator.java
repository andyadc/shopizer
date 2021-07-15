package com.salesmanager.shop.validation;

import com.salesmanager.shop.util.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstFieldName;
    private String secondFieldName;
    private BeanUtils beanUtils;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstFieldName = constraintAnnotation.first();
        this.secondFieldName = constraintAnnotation.second();
        this.beanUtils = BeanUtils.newInstance();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            final Object firstObj = this.beanUtils.getPropertyValue(value, this.firstFieldName);
            final Object secondObj = this.beanUtils.getPropertyValue(value, this.secondFieldName);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception ex) {
//            LOG.info( "Error while getting values from object", ex );
            return false;
        }
    }
}
