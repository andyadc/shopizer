package com.salesmanager.core.business.modules.cms.content;

import com.salesmanager.core.business.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface FolderList {
	
	  List<String> listFolders(final String merchantStoreCode, Optional<String> path)
		      throws ServiceException;

}
