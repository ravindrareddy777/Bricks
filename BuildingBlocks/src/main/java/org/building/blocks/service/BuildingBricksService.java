package org.building.blocks.service;

import org.building.blocks.exceptions.InvalidOrderReferenceException;
import org.building.blocks.vo.Bricks;

public interface BuildingBricksService {

	public Bricks getOrders(String orderId) throws InvalidOrderReferenceException;

	public Bricks createOrder(int numberofBlocks);

}
