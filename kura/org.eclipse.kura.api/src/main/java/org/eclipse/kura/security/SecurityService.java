/**
 * Copyright (c) 2011, 2015 Eurotech and/or its affiliates
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Eurotech
 */

package org.eclipse.kura.security;

import org.eclipse.kura.KuraException;

public interface SecurityService {
	
	/**
	 * This method allows the reload of the security policy's fingerprint
	 * 
	 * @throw KuraException in case an error is raised during the calculation of the fingerprint
	 * and the consequent storage.
	 */
	public void reloadSecurityPolicyFingerprint() throws KuraException;
	
	/**
	 * This method allows the reload of the command line fingerprint
	 * 
	 * @throw KuraException in case an error is raised during the calculation of the fingerprint
	 * and the consequent storage.
	 */
	public void reloadCommandLineFingerprint() throws KuraException;
	
	/**
	 * This method returns a boolean that specifies if the debugging is permitted
	 * 
	 * @return true if the debug is permitted. False otherwise.
	 */
	public boolean isDebugEnabled();
	
}
