package org.primefaces.showcase.view.data;
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.showcase.domain.Car;
import org.primefaces.showcase.service.CarService;
  
public class CarouselView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Car> cars;
 
    private Car selectedCar;
 
    @ManagedProperty("org.primefaces.showcase.service.CarService@3c3d49da")
    private CarService service;
 
    @PostConstruct
    public void init() {
        cars = service.createCars(2);
    }
 
    public List<Car> getCars() {
        return cars;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}