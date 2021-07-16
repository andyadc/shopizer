/**
 * 
 */
package com.salesmanager.core.business.modules.cms.content;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.model.content.FileContentType;

import java.util.Optional;


/**
 * @author Umesh Awasthi
 *
 */
public interface FileRemove {
  void removeFile(String merchantStoreCode, FileContentType staticContentType,
      String fileName, Optional<String> path) throws ServiceException;

  void removeFiles(String merchantStoreCode, Optional<String> path) throws ServiceException;

}
