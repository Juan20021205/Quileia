package com.Quileia.WS.app;

public class CityListServiceProxy implements com.Quileia.WS.app.CityListService {
  private String _endpoint = null;
  private com.Quileia.WS.app.CityListService cityListService = null;
  
  public CityListServiceProxy() {
    _initCityListServiceProxy();
  }
  
  public CityListServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCityListServiceProxy();
  }
  
  private void _initCityListServiceProxy() {
    try {
      cityListService = (new com.Quileia.WS.app.CityListServiceImplServiceLocator()).getCityListServiceImplPort();
      if (cityListService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cityListService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cityListService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cityListService != null)
      ((javax.xml.rpc.Stub)cityListService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.Quileia.WS.app.CityListService getCityListService() {
    if (cityListService == null)
      _initCityListServiceProxy();
    return cityListService;
  }
  
  public com.Quileia.WS.app.CityResponse[] getCitys() throws java.rmi.RemoteException{
    if (cityListService == null)
      _initCityListServiceProxy();
    return cityListService.getCitys();
  }
  
  
}