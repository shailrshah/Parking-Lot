package com.shail.parking.enums;

/**
 * Size represents the relative size of a physical object.
 * @author Shail Shah
 */
public enum Size {
	SMALL(1),
	MEDIUM(2),
	LARGE(3);

	private final int val;

	/**
	 * Constructor for creating a new Size
	 *
	 * @param val the numeric value of this enum
	 */
	Size(int val) {
		this.val = val;
	}

	/**
	 * @return the numeric value of this enum
	 */
	public int getVal() {
		return this.val;
	}
}
