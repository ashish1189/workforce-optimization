package com.spo.cleaners.optimization.utilities;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spo.cleaners.optimization.data.OptimizationResponse;
import com.spo.cleaners.optimization.data.RequestModel;

public class Optimizer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Optimizer.class);

	public List<OptimizationResponse> startOptimization(RequestModel request) {

		LOGGER.info("Start of the optimization process.");
		List<OptimizationResponse> response = new ArrayList<OptimizationResponse>();

		for (int i = 0; i < request.getBuilding().length; i++) {

			int structure = request.getBuilding()[i];
			LOGGER.debug("Start of core optimization strategy for "+structure);
			OptimizationResponse resp = new OptimizationResponse();

			int srCapacity = request.getSrCapacity();
			int jrCapacity = request.getJrCapacity();

			int allSeniors = (structure / srCapacity) + 1;
			int allJuniors = 0;

			int[] workforce = optimize(structure, srCapacity, jrCapacity,
					getCommonDivisor(srCapacity, jrCapacity), allSeniors, allJuniors, allSeniors, allJuniors);

			resp.setStructure(structure);
			resp.setSenior(workforce[0]);
			resp.setJunior(workforce[1]);
			response.add(resp);
			LOGGER.debug("End of core optimization strategy for "+structure);
		}
		LOGGER.info("Returning workforce optimization results.");
		return response;
	}

	private int[] optimize(int rooms, int srCapacity, int jrCapacity, int commonDiv, int prevSeniors, int prevJuniors,
			int allSeniors, int allJuniors) {
		// TODO Auto-generated method stub
		LOGGER.debug("Executing optimization strategy");
		int[] result = new int[2];

		int totalCapacity = staffCapacity(srCapacity, allSeniors, jrCapacity, allJuniors);
		int vacant = Math.abs(rooms - totalCapacity);

		if (vacant <= commonDiv && totalCapacity >= rooms) {
			if (totalCapacity > rooms) {
				int staffCapacityOfSeniors = staffCapacity(srCapacity, allSeniors, 0, 0);
				if (allSeniors > 1 && staffCapacityOfSeniors > rooms) {
					LOGGER.debug("Reexecuting optimization strategy at level 1");
					return optimize(rooms, srCapacity, jrCapacity, commonDiv, allSeniors, allJuniors, allSeniors - 1,
							allJuniors + 1);
				}
			}

			LOGGER.debug("Return at level 1 in core optimization strategy");
			result[0] = allSeniors;
			result[1] = allJuniors;
			return result;
		}

		if (vacant > Math.min(srCapacity, jrCapacity) && totalCapacity < rooms) {

			LOGGER.debug("Return at level 2 in core optimization strategy");
			result[0] = prevSeniors;
			result[1] = prevJuniors;
			return result;
		}

		if (totalCapacity > rooms && allSeniors > 1) {
			LOGGER.debug("Reexecuting optimization strategy at level 2");
			return optimize(rooms, srCapacity, jrCapacity, commonDiv, allSeniors, allJuniors, allSeniors - 1,
					allJuniors);
		}

		if (totalCapacity < rooms) {
			LOGGER.debug("Reexecuting optimization strategy at level 3");
			return optimize(rooms, srCapacity, jrCapacity, commonDiv, allSeniors, allJuniors, allSeniors,
					allJuniors + 1);
		}

		LOGGER.debug("Return at level 3 in core optimization strategy");
		result[0] = allSeniors;
		result[1] = allJuniors;
		return result;
	}

	private int getCommonDivisor(int senior, int junior) {
		int gcd = 1;
		for (int i = 1; i <= Math.min(senior, junior); i++) {
			if (senior % i == 0 && junior % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}

	private int staffCapacity(int srCapacity, int srCount, int jrCapacity, int jrCount) {
		return (srCapacity * srCount) + (jrCapacity * jrCount);
	}
}
