/*
 * Copyright 2015-2023 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.tool.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.tool.Calculator;

@DisplayName("tool-test/com.example.tool.CalculatorTests")
public class CalculatorTests {

	private final Calculator calculator = new Calculator();

	@Test
	public void addTest() {
		Assertions.assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@Test
	public void mulTest() {
		Assertions.assertEquals(4, calculator.mul(2, 2), "2 * 2 should equal 4");
	}

	@Test
	public void powTest() {
		Assertions.assertEquals(8, calculator.pow(2, 3), "2 ^ 3 should equal 8");
	}

}
