/**
 *
 */
package com.salesmanager.shop.admin.model.digital;

import com.salesmanager.core.model.catalog.product.Product;
import com.salesmanager.core.model.catalog.product.file.DigitalProduct;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * A bean class responsible for getting form data from shop Admin for uploading
 * product files for a given product and validating the provided data.
 * <p>
 * This will work as a wrapper for underlying cache where these content images will be stored
 * and retrieved in future.
 */
public class ProductFiles implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<MultipartFile> file;
    private DigitalProduct digitalProduct;
    private Product product;

    @NotEmpty(message = "{product.files.invalid}")
    @Valid
    public List<MultipartFile> getFile() {
        return file;
    }

    public void setFile(final List<MultipartFile> file) {
        this.file = file;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public DigitalProduct getDigitalProduct() {
        return digitalProduct;
    }

    public void setDigitalProduct(DigitalProduct digitalProduct) {
        this.digitalProduct = digitalProduct;
    }
}
