/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseLayer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author devinrahul
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustomerName", query = "SELECT c FROM Customer c WHERE c.customerName = :customerName")
    , @NamedQuery(name = "Customer.findByVehicleNumber", query = "SELECT c FROM Customer c WHERE c.vehicleNumber = :vehicleNumber")
    , @NamedQuery(name = "Customer.findByVehicleType", query = "SELECT c FROM Customer c WHERE c.vehicleType = :vehicleType")
    , @NamedQuery(name = "Customer.findByContactNumber", query = "SELECT c FROM Customer c WHERE c.contactNumber = :contactNumber")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
    , @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address")})
public class Customer implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Id
    @Basic(optional = false)
    @Column(name = "VEHICLE_NUMBER")
    private Integer vehicleNumber;
    @Column(name = "VEHICLE_TYPE")
    private String vehicleType;
    @Column(name = "CONTACT_NUMBER")
    private Integer contactNumber;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;

    public Customer() {
    }

    public Customer(Integer vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        String oldCustomerName = this.customerName;
        this.customerName = customerName;
        changeSupport.firePropertyChange("customerName", oldCustomerName, customerName);
    }

    public Integer getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Integer vehicleNumber) {
        Integer oldVehicleNumber = this.vehicleNumber;
        this.vehicleNumber = vehicleNumber;
        changeSupport.firePropertyChange("vehicleNumber", oldVehicleNumber, vehicleNumber);
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        String oldVehicleType = this.vehicleType;
        this.vehicleType = vehicleType;
        changeSupport.firePropertyChange("vehicleType", oldVehicleType, vehicleType);
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        Integer oldContactNumber = this.contactNumber;
        this.contactNumber = contactNumber;
        changeSupport.firePropertyChange("contactNumber", oldContactNumber, contactNumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleNumber != null ? vehicleNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.vehicleNumber == null && other.vehicleNumber != null) || (this.vehicleNumber != null && !this.vehicleNumber.equals(other.vehicleNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBaseLayer.Customer[ vehicleNumber=" + vehicleNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
