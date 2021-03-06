/**
 * Copyright (c) 2011, 2014 Eurotech and/or its affiliates
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Eurotech
 */
package org.eclipse.kura.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
	private Method m_beforeClass;
	private Method m_afterClass;
	private Method m_before;
	private Method m_after;
	private List<Method> tests;
	
	public Test() {
		tests = new ArrayList<Method>();
	}
	
	public Method getBeforeClass() {
		return m_beforeClass;
	}
	
	public void setBeforeClass(Method beforeClass) {
		m_beforeClass = beforeClass;
	}
	
	public Method getAfterClass() {
		return m_afterClass;
	}
	
	public void setAfterClass(Method afterClass) {
		m_afterClass = afterClass;
	}
	
	public Method getBefore() {
		return m_before;
	}
	
	public void setBefore(Method before) {
		m_before = before;
	}
	
	public Method getAfter() {
		return m_after;
	}
	
	public void setAfter(Method after) {
		m_after = after;
	}
	
	public List<Method> getTests() {
		return tests;
	}
	
	public void addTest(Method method) {
		tests.add(method);
	}
}