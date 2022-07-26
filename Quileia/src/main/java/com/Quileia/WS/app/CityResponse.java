/**
 * CityResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.Quileia.WS.app;

public class CityResponse  implements java.io.Serializable {
    private int cantHabitantes;

    private java.lang.String hotelMasReservado;

    private java.lang.String nombre;

    private java.lang.String sitioMasTuristico;

    public CityResponse() {
    }

    public CityResponse(
           int cantHabitantes,
           java.lang.String hotelMasReservado,
           java.lang.String nombre,
           java.lang.String sitioMasTuristico) {
           this.cantHabitantes = cantHabitantes;
           this.hotelMasReservado = hotelMasReservado;
           this.nombre = nombre;
           this.sitioMasTuristico = sitioMasTuristico;
    }


    /**
     * Gets the cantHabitantes value for this CityResponse.
     * 
     * @return cantHabitantes
     */
    public int getCantHabitantes() {
        return cantHabitantes;
    }


    /**
     * Sets the cantHabitantes value for this CityResponse.
     * 
     * @param cantHabitantes
     */
    public void setCantHabitantes(int cantHabitantes) {
        this.cantHabitantes = cantHabitantes;
    }


    /**
     * Gets the hotelMasReservado value for this CityResponse.
     * 
     * @return hotelMasReservado
     */
    public java.lang.String getHotelMasReservado() {
        return hotelMasReservado;
    }


    /**
     * Sets the hotelMasReservado value for this CityResponse.
     * 
     * @param hotelMasReservado
     */
    public void setHotelMasReservado(java.lang.String hotelMasReservado) {
        this.hotelMasReservado = hotelMasReservado;
    }


    /**
     * Gets the nombre value for this CityResponse.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this CityResponse.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the sitioMasTuristico value for this CityResponse.
     * 
     * @return sitioMasTuristico
     */
    public java.lang.String getSitioMasTuristico() {
        return sitioMasTuristico;
    }


    /**
     * Sets the sitioMasTuristico value for this CityResponse.
     * 
     * @param sitioMasTuristico
     */
    public void setSitioMasTuristico(java.lang.String sitioMasTuristico) {
        this.sitioMasTuristico = sitioMasTuristico;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CityResponse)) return false;
        CityResponse other = (CityResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cantHabitantes == other.getCantHabitantes() &&
            ((this.hotelMasReservado==null && other.getHotelMasReservado()==null) || 
             (this.hotelMasReservado!=null &&
              this.hotelMasReservado.equals(other.getHotelMasReservado()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.sitioMasTuristico==null && other.getSitioMasTuristico()==null) || 
             (this.sitioMasTuristico!=null &&
              this.sitioMasTuristico.equals(other.getSitioMasTuristico())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCantHabitantes();
        if (getHotelMasReservado() != null) {
            _hashCode += getHotelMasReservado().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getSitioMasTuristico() != null) {
            _hashCode += getSitioMasTuristico().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CityResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://app.WS.Quileia.com/", "cityResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantHabitantes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantHabitantes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hotelMasReservado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hotelMasReservado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sitioMasTuristico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sitioMasTuristico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
