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
package org.eclipse.kura.net.admin.modem;

import java.util.List;

import org.eclipse.kura.linux.net.modem.SupportedUsbModemInfo;
import org.eclipse.kura.linux.net.modem.UsbModemDriver;
import org.eclipse.kura.net.admin.modem.sierra.mc87xx.SierraMc87xxConfigGenerator;
import org.eclipse.kura.net.admin.modem.sierra.mc87xx.SierraMc87xxModemFactory;
import org.eclipse.kura.net.admin.modem.sierra.usb598.SierraUsb598ConfigGenerator;
import org.eclipse.kura.net.admin.modem.sierra.usb598.SierraUsb598ModemFactory;
import org.eclipse.kura.net.admin.modem.telit.de910.TelitDe910ConfigGenerator;
import org.eclipse.kura.net.admin.modem.telit.de910.TelitDe910ModemFactory;
import org.eclipse.kura.net.admin.modem.telit.he910.TelitHe910ConfigGenerator;
import org.eclipse.kura.net.admin.modem.telit.he910.TelitHe910ModemFactory;
import org.eclipse.kura.net.admin.modem.telit.le910.TelitLe910ModemFactory;

public class SupportedUsbModemsFactoryInfo {

	public enum UsbModemFactoryInfo {
		
	                    // modem info, implementation factory, config reader/writer class
		Telit_HE910_D		(SupportedUsbModemInfo.Telit_HE910_D, TelitHe910ModemFactory.class, TelitHe910ConfigGenerator.class),
		Telit_GE910			(SupportedUsbModemInfo.Telit_GE910, TelitHe910ModemFactory.class, TelitHe910ConfigGenerator.class),
		Telit_DE910_DUAL    (SupportedUsbModemInfo.Telit_DE910_DUAL, TelitDe910ModemFactory.class, TelitDe910ConfigGenerator.class),
		Telit_CE910_DUAL	(SupportedUsbModemInfo.Telit_CE910_DUAL, TelitDe910ModemFactory.class, TelitDe910ConfigGenerator.class),
		Telit_LE910			(SupportedUsbModemInfo.Telit_LE910, TelitLe910ModemFactory.class, TelitHe910ConfigGenerator.class),
		Sierra_MC8775	(SupportedUsbModemInfo.Sierra_MC8775, SierraMc87xxModemFactory.class, SierraMc87xxConfigGenerator.class),
		Sierra_MC8790	(SupportedUsbModemInfo.Sierra_MC8790, SierraMc87xxModemFactory.class, SierraMc87xxConfigGenerator.class),
		Sierra_USB598	(SupportedUsbModemInfo.Sierra_USB598, SierraUsb598ModemFactory.class, SierraUsb598ConfigGenerator.class);
	
		private SupportedUsbModemInfo m_usbModemInfo;
		private Class<? extends CellularModemFactory> m_factoryClass;
		private Class<? extends ModemPppConfigGenerator> m_configClass;
		
		private UsbModemFactoryInfo(SupportedUsbModemInfo modemInfo,
		        Class<? extends CellularModemFactory> factoryClass,
		        Class<? extends ModemPppConfigGenerator> configClass) {
		    this.m_usbModemInfo = modemInfo;
		    this.m_factoryClass = factoryClass;
		    this.m_configClass = configClass;
		}
		
		public SupportedUsbModemInfo getUsbModemInfo() {
		    return this.m_usbModemInfo;
		}
        
        public Class<? extends CellularModemFactory> getModemFactoryClass() {
            return this.m_factoryClass;
        }
		
		public Class<? extends ModemPppConfigGenerator> getConfigGeneratorClass() {
			return this.m_configClass;
		}
	}
	
	
	public static UsbModemFactoryInfo getModem(SupportedUsbModemInfo modemInfo) {
        if (modemInfo == null)
            return null;
        
        for (UsbModemFactoryInfo modem : UsbModemFactoryInfo.values()) {
            if (modemInfo.equals(modem.getUsbModemInfo())) {
                return modem;
            }
        }
        
        return null;
	}
	
	public static UsbModemFactoryInfo getModem(String vendor, String product) {

		UsbModemFactoryInfo modemFactoryInfo = null;
		for (UsbModemFactoryInfo modem : UsbModemFactoryInfo.values()) {
			if (modem.getUsbModemInfo().getVendorId().equals(vendor)
					&& modem.getUsbModemInfo().getProductId().equals(product)) {
				modemFactoryInfo = modem;
				break;
			}
		}
		return modemFactoryInfo;
	}
	
	public static List<? extends UsbModemDriver> getDeviceDrivers (String vendor, String product) {

		List<? extends UsbModemDriver>drivers = null;
		for (UsbModemFactoryInfo modem : UsbModemFactoryInfo.values()) {
			if (modem.getUsbModemInfo().getVendorId().equals(vendor)
					&& modem.getUsbModemInfo().getProductId().equals(product)) {
				drivers =  modem.getUsbModemInfo().getDeviceDrivers();
				break;
			}
		}
		return drivers;
	}
}

