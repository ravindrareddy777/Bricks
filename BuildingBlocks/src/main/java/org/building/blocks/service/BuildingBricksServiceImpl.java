package org.building.blocks.service;

import java.time.Instant;
import java.util.UUID;

import org.building.blocks.exceptions.InvalidOrderReferenceException;
import org.building.blocks.vo.Bricks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BuildingBricksServiceImpl")
public class BuildingBricksServiceImpl implements BuildingBricksService {

	@Autowired
	private OrderValidationService orderValidationService;

	@Override
	public Bricks getOrders(String orderId) throws InvalidOrderReferenceException {

		// validation for Invalid Order Id
		orderValidationService.validateOrderReference(orderId);
		Bricks bricks = new Bricks();
		bricks.setBlocksQuantity(1000);
		bricks.setOrderId(orderId);
		bricks.setOrderName("Bricks");
		bricks.setOrderAmount(5000);
		bricks.setOrderCreationDate(Instant.now());
		bricks.setOrderModifiedDate(Instant.now());
		return bricks;
	}

	@Override
	public Bricks createOrder(int numberofBlocks) {

		Bricks bricks = new Bricks();
		bricks.setOrderId(UUID.randomUUID().toString());
		bricks.setBlocksQuantity(numberofBlocks);
		bricks.setOrderName("Bricks");
		bricks.setOrderAmount(5000);
		bricks.setOrderCreationDate(Instant.now());
		bricks.setOrderModifiedDate(Instant.now());
		return bricks;
	}

}
