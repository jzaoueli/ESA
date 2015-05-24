
package org.dieschnittstelle.jee.esa.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;


/**
 * <p>Java class for customerTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="completed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="customer" type="{http://dieschnittstelle.org/jee/esa/jaxws}customer" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="products" type="{http://dieschnittstelle.org/jee/esa/jaxws}crmProductBundle" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="touchpoint" type="{http://dieschnittstelle.org/jee/esa/crm/entities}abstractTouchpoint" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerTransaction", propOrder = {
    "completed",
    "customer",
    "date",
    "id",
    "products",
    "touchpoint",
    "value"
})
public class CustomerTransaction {

    protected boolean completed;
    protected Customer customer;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected int id;
    @XmlElement(nillable = true)
    protected List<CrmProductBundle> products;
    protected AbstractTouchpoint touchpoint;
    protected int value;

    /**
     * Gets the value of the completed property.
     * 
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the value of the completed property.
     * 
     */
    public void setCompleted(boolean value) {
        this.completed = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
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
     * Gets the value of the products property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the products property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrmProductBundle }
     * 
     * 
     */
    public List<CrmProductBundle> getProducts() {
        if (products == null) {
            products = new ArrayList<CrmProductBundle>();
        }
        return this.products;
    }

    /**
     * Gets the value of the touchpoint property.
     * 
     * @return
     *     possible object is
     *     {@link AbstractTouchpoint }
     *     
     */
    public AbstractTouchpoint getTouchpoint() {
        return touchpoint;
    }

    /**
     * Sets the value of the touchpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractTouchpoint }
     *     
     */
    public void setTouchpoint(AbstractTouchpoint value) {
        this.touchpoint = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

}
