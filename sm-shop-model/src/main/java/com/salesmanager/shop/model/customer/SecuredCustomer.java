package com.salesmanager.shop.model.customer;

import com.salesmanager.shop.validation.FieldMatch;

import javax.validation.constraints.Size;
import java.io.Serializable;


@FieldMatch.List({
    @FieldMatch(first="password",second="checkPassword",message="password.notequal")
    
})
public class SecuredCustomer extends PersistableCustomer implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	


	@Size(min=6, message="{registration.password.not.empty}")
	private String password;
	
	@Size(min=6, message="{registration.password.not.empty}")
	private String checkPassword;
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getCheckPassword()
    {
        return checkPassword;
    }

    public void setCheckPassword( String checkPassword )
    {
        this.checkPassword = checkPassword;
    }
	
	

}
