
package org.dieschnittstelle.jee.esa.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;


/**
 * <p>Java class for customer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://dieschnittstelle.org/jee/esa/jaxws}address" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://dieschnittstelle.org/jee/esa/jaxws}gender" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobilePhoneId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="preferredTouchpoint" type="{http://dieschnittstelle.org/jee/esa/crm/entities}abstractTouchpoint" minOccurs="0"/>
 *         &lt;element name="transactions" type="{http://dieschnittstelle.org/jee/esa/jaxws}customerTransaction" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {
    "address",
    "email",
    "firstName",
    "gender",
    "id",
    "lastName",
    "mobilePhoneId",
    "preferredTouchpoint",
    "transactions"
})
public class Customer {

    protected Address address;
    protected String email;
    protected String firstName;
    protected Gender gender;
    protected int id;
    protected String lastName;
    protected String mobilePhoneId;
    protected AbstractTouchpoint preferredTouchpoint;
    @XmlElement(nillable = true)
    protected List<CustomerTransaction> transactions;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link Gender }
     *     
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gender }
     *     
     */
    public void setGender(Gender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the mobilePhoneId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilePhoneId() {
        return mobilePhoneId;
    }

    /**
     * Sets the value of the mobilePhoneId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilePhoneId(String value) {
        this.mobilePhoneId = value;
    }

    /**
     * Gets the value of the preferredTouchpoint property.
     * 
     * @return
     *     possible object is
     *     {@link AbstractTouchpoint }
     *     
     */
    public AbstractTouchpoint getPreferredTouchpoint() {
        return preferredTouchpoint;
    }

    /**
     * Sets the value of the preferredTouchpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractTouchpoint }
     *     
     */
    public void setPreferredTouchpoint(AbstractTouchpoint value) {
        this.preferredTouchpoint = value;
    }

    /**
     * Gets the value of the transactions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerTransaction }
     * 
     * 
     */
    public List<CustomerTransaction> getTransactions() {
        if (transactions == null) {
            transactions = new ArrayList<CustomerTransaction>();
        }
        return this.transactions;
    }

}
