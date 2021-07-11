package com.salesmanager.core.model.system;

import com.salesmanager.core.model.common.audit.AuditListener;
import com.salesmanager.core.model.common.audit.AuditSection;
import com.salesmanager.core.model.common.audit.Auditable;
import com.salesmanager.core.model.generic.SalesManagerEntity;
import com.salesmanager.core.model.merchant.MerchantStore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Merchant configuration information
 *
 * @author Carl Samson
 */
@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "MERCHANT_CONFIGURATION",
        uniqueConstraints = @UniqueConstraint(columnNames = {"MERCHANT_ID", "CONFIG_KEY"}))
public class MerchantConfiguration extends SalesManagerEntity<Long, MerchantConfiguration>
        implements Serializable, Auditable {

  /**
   *
   */
  private static final long serialVersionUID = 4246917986731953459L;

  @Id
  @Column(name = "MERCHANT_CONFIG_ID")
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
          valueColumnName = "SEQ_COUNT", pkColumnValue = "MERCH_CONF_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MERCHANT_ID", nullable = true)
  private MerchantStore merchantStore;

  @Embedded
  private AuditSection auditSection = new AuditSection();

  @Column(name = "CONFIG_KEY")
  private String key;

  /**
   * activate and deactivate configuration
   */
  @Column(name = "ACTIVE", nullable = true)
  private Boolean active = new Boolean(false);


  @Column(name = "VALUE")
  @Type(type = "org.hibernate.type.TextType")
  private String value;

  @Column(name = "TYPE")
  @Enumerated(value = EnumType.STRING)
  private MerchantConfigurationType merchantConfigurationType =
          MerchantConfigurationType.INTEGRATION;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public AuditSection getAuditSection() {
    return auditSection;
  }

  public void setAuditSection(AuditSection auditSection) {
    this.auditSection = auditSection;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }


  public MerchantStore getMerchantStore() {
    return merchantStore;
  }

  public void setMerchantStore(MerchantStore merchantStore) {
    this.merchantStore = merchantStore;
  }

  public MerchantConfigurationType getMerchantConfigurationType() {
    return merchantConfigurationType;
  }

  public void setMerchantConfigurationType(MerchantConfigurationType merchantConfigurationType) {
    this.merchantConfigurationType = merchantConfigurationType;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }


}
