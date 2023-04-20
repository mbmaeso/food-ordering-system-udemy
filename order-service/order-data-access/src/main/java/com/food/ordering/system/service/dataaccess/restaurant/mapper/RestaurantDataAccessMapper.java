package com.food.ordering.system.service.dataaccess.restaurant.mapper;

import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.domain.valueobject.ProductId;
import com.food.ordering.system.domain.valueobject.RestaurantId;
import com.food.ordering.system.order.service.domain.entity.Product;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.service.dataaccess.restaurant.entity.RestaurantEntity;
import com.food.ordering.system.service.dataaccess.restaurant.exception.RestaurantDataAccessException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class RestaurantDataAccessMapper {

	public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
		return restaurant.getProducts()
				.stream()
				.map(product -> product.getId().getValue())
				.collect(
						Collectors.toList());
	}

	public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
		RestaurantEntity restaurantEntity = restaurantEntities.stream()
				.findFirst()
				.orElseThrow(() -> new RestaurantDataAccessException(
						"Restaurant could not be found!"));

		List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
						new Product(new ProductId(entity.getProductID()),
								entity.getProductName(),
								new Money(entity.getProductPrice())))
				.toList();

		return Restaurant.builder()
				.restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
				.products(restaurantProducts)
				.active(restaurantEntity.getRestaurantActive())
				.build();
	}
}
