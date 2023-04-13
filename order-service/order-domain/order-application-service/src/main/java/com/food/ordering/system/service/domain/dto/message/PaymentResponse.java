package com.food.ordering.system.service.domain.dto.message;

import com.food.ordering.system.domain.valueobject.PaymentStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class PaymentResponse {
	private String id;
	private String sagaId;
	private String orderId;
	private String paymentId;
	private String customerId;
	private BigDecimal price;
	private Instant       createdAt;
	private PaymentStatus paymentStatus;
	private List<String>  failureMessage;
}
