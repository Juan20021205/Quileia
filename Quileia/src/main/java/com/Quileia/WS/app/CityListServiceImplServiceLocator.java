/**
 * CityListServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.Quileia.WS.app;

public class CityListServiceImplServiceLocator extends org.apache.axis.client.Service implements com.Quileia.WS.app.CityListServiceImplService {

	private static final long serialVersionUID = 1L;

	public CityListServiceImplServiceLocator() {
    }


    public CityListServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CityListServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CityListServiceImplPort
    private java.lang.String CityListServiceImplPort_address = "http://localhost:8080/City-WS-Quileia/CityListServiceImpl";

    public java.lang.String getCityListServiceImplPortAddress() {
        return CityListServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CityListServiceImplPortWSDDServiceName = "CityListServiceImplPort";

    public java.lang.String getCityListServiceImplPortWSDDServiceName() {
        return CityListServiceImplPortWSDDServiceName;
    }

    public void setCityListServiceImplPortWSDDServiceName(java.lang.String name) {
        CityListServiceImplPortWSDDServiceName = name;
    }

    public com.Quileia.WS.app.CityListService getCityListServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CityListServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCityListServiceImplPort(endpoint);
    }

    public com.Quileia.WS.app.CityListService getCityListServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.Quileia.WS.app.CityListServiceImplServiceSoapBindingStub _stub = new com.Quileia.WS.app.CityListServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCityListServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCityListServiceImplPortEndpointAddress(java.lang.String address) {
        CityListServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(@SuppressWarnings("rawtypes") Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.Quileia.WS.app.CityListService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.Quileia.WS.app.CityListServiceImplServiceSoapBindingStub _stub = new com.Quileia.WS.app.CityListServiceImplServiceSoapBindingStub(new java.net.URL(CityListServiceImplPort_address), this);
                _stub.setPortName(getCityListServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CityListServiceImplPort".equals(inputPortName)) {
            return getCityListServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://app.WS.Quileia.com/", "CityListServiceImplService");
    }

    @SuppressWarnings("rawtypes")
	private java.util.HashSet ports = null;

    @SuppressWarnings("rawtypes")
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            extracted();
        }
        return ports.iterator();
    }


	@SuppressWarnings("unchecked")
	private boolean extracted() {
		return ports.add(new javax.xml.namespace.QName("http://app.WS.Quileia.com/", "CityListServiceImplPort"));
	}

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CityListServiceImplPort".equals(portName)) {
            setCityListServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
