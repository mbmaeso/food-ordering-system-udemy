package com.food.ordering.system.service.dataaccess.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(RestaurantEntityId.class)
@Entity
@Table(name = "order_restaurant_m_view", schema = "restaurant")
public class RestaurantEntity {

	@Id
	private UUID       restaurantId;
	@Id
	private UUID       productID;
	private String     restaurantName;
	private Boolean     restaurantActive;
	private String     productName;
	private BigDecimal productPrice;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RestaurantEntity that = (RestaurantEntity) o;
		return Objects.equals(restaurantId, that.restaurantId)
				&& Objects.equals(productID, that.productID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(restaurantId, productID);
	}
}
