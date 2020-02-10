package com.wipro.hotel.entity;

import java.util.Date;

public class Customer {
	private String customerId;
	private Date bookingDate;
	private Date departureDate;
	private String roomType;
	private double billAmount;
	public Customer(String customerId, Date bookingDate, Date departureDate, String roomType) {
		super();
		this.customerId = customerId;
		this.bookingDate = bookingDate;
		this.departureDate = departureDate;
		this.roomType = roomType;
		this.billAmount=billAmount;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	@Override
	public String toString() {
		return "Custormer id:"+getCustomerId()+"\nBill Amount:Rs."+getBillAmount()+" "+getRoomType();
	}
	public double getTariffPerDay(){
		double tariff;
		if(roomType.equals("AC"))
			tariff=3725.00;
		else
			tariff=2250.00;
		return tariff;
		
	}
	
}
