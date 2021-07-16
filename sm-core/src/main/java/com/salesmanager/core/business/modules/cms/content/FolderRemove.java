/**
 * 
 */
package com.salesmanager.core.business.modules.cms.content;

import com.salesmanager.core.business.exception.ServiceException;

import java.util.Optional;


public interface FolderRemove {
  void removeFolder(final String merchantStoreCode, String folderName, Optional<String> folderPath)
      throws ServiceException;

}
