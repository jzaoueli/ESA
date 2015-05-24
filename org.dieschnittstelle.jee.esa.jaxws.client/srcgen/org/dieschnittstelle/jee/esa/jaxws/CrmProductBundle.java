
package org.dieschnittstelle.jee.esa.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for crmProductBundle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="crmProductBundle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productObj" type="{http://dieschnittstelle.org/jee/esa/jaxws}abstractProduct" minOccurs="0"/>
 *         &lt;element name="units" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crmProductBundle", propOrder = {
    "productObj",
    "units"
})
public class CrmProductBundle {

    protected AbstractProduct productObj;
    protected int units;

    /**
     * Gets the value of the productObj property.
     * 
     * @return
     *     possible object is
     *     {@link AbstractProduct }
     *     
     */
    public AbstractProduct getProductObj() {
        return productObj;
    }

    /**
     * Sets the value of the productObj property.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractProduct }
     *     
     */
    public void setProductObj(AbstractProduct value) {
        this.productObj = value;
    }

    /**
     * Gets the value of the units property.
     * 
     */
    public int getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     */
    public void setUnits(int value) {
        this.units = value;
    }

}
