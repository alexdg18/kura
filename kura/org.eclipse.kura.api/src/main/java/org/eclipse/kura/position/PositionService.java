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
package org.eclipse.kura.position;

import org.osgi.util.position.Position;

/**
 * This interface provides methods getting a geographic position.
 * The OSGI Position class represents a geographic location, based on the WGS84 System 
 * (World Geodetic System 1984).
 * <p>
 * Position(Measurement lat, Measurement lon, Measurement alt, Measurement speed, Measurement track) 
 * <p>
 * The interface also return a NmeaPosition, subclass of Position 
 * @see org.eclipse.kura.position.NmeaPosition NmeaPosition
 * @see org.osgi.util.position.Position Position 
 * @see org.osgi.util.measurement.Measurement Measurement
 * 
 */
public interface PositionService
{
	/**
	 * Returns the current geographic position.<br>
	 * The org.osgi.util.measurement.Measurement class is used to represent the values that make up a position :<br>
	 * <li>getLongitude() : returns the longitude of this position in radians.</li>
	 * <li>getLatitude() : returns the latitude of this position in radians. </li>
	 * <li>getSpeed() : returns the ground speed of this position in meters per second.</li>
	 * <li>getTrack() : Returns the track of this position in radians as a compass heading. The track is the extrapolation of 
	 * previous previously measured positions to a future position.</li>
	 * <br>
	 * @see org.osgi.util.position.Position Position
	 */
	public Position getPosition();
	
	/**
	 * Returns the current NMEA geographic position.
	 * <li>getLongitude() : returns the longitude of this position in degrees.</li>
	 * <li>getLatitude() : returns the latitude of this position in degrees. </li>
	 * <li>getSpeedKmh() : returns the ground speed of this position in km/h.</li>
	 * <li>getSpeedMph() : returns the ground speed of this position in mph.</li>
	 * <li>getTrack() : Returns the track of this position in degrees as a compass heading. 
	 * @see org.eclipse.kura.position.NmeaPosition NmeaPosition
	 */
	public NmeaPosition getNmeaPosition();

	/**
	 * Returns the current NMEA time from GGA or ZDA sentence
	 */
	public String getNmeaTime();
	
	/**
	 * Returns the current NMEA date from ZDA sentence
	 */
	public String getNmeaDate();
	
	/**
	 * Returns true if a valid geographic position has been received.
	 */
	public boolean isLocked();

	/**
	 * Returns the last sentence received from the gps.
	 */
	public String getLastSentence();
}
