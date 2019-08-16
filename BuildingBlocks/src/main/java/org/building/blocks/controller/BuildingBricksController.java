package org.building.blocks.controller;

import org.building.blocks.exceptions.InvalidOrderReferenceException;
import org.building.blocks.service.BuildingBricksService;
import org.building.blocks.vo.Bricks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/")
public class BuildingBricksController {

	@Autowired
	@Qualifier("BuildingBricksServiceImpl")
	private BuildingBricksService buildingBricksService;

	@ApiOperation(value = "To get order details")
	@RequestMapping(value = "/getOrders/{orderId}/", method = RequestMethod.GET)
	public ResponseEntity<?> getOrders(
			@ApiParam(value = "The Order ID", required = true) @PathVariable("orderId") String orderId) throws InvalidOrderReferenceException {

		Bricks briksResult = null;

		briksResult = buildingBricksService.getOrders(orderId);

		return new ResponseEntity<Bricks>(briksResult, HttpStatus.CREATED);

	}

	@ApiOperation(value = "To Create Order")
	@RequestMapping(value = "/createOrder/{numberofBlocks}/", method = RequestMethod.GET)
	public ResponseEntity<?> createOrder(
			@ApiParam(value = "Numer of Blocks", required = true) @PathVariable("numberofBlocks") int numberofBlocks) {
		Bricks result = null;
		result = buildingBricksService.createOrder(numberofBlocks);
		return new ResponseEntity<Bricks>(result, HttpStatus.CREATED);

	}
}
