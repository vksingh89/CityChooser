package cities.chooser;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Cacheable(true)
@Table(name = "T_CITY")
@NamedQuery(name="CityEntity.fetchCityName", query="select c.cityName from CityEntity c where c.cityName like :keyword")
public class CityEntity {
@Id
@Column(name= "id")
private int id;

@Column(name= "city_name")
private String cityName;

@Column(name="state")
private String state;

@Column(name="pin_code")
private long pin;
}

