package com.wipro.hotel.service;

import java.util.Date;

import com.wipro.hotel.entity.Customer;
import com.wipro.hotel.entity.Offer;
import com.wipro.hotel.exception.InvalidDataException;
import com.wipro.hotel.exception.InvalidRoomTypeException;

public class HotelBillService {
	public String validateData(String customerId, Date bookingDate, Date departureDate, String roomType){
		//String validity; 
		try{
			if(customerId.equals(null)||customerId.length()<8||bookingDate.compareTo(departureDate)>0){
				throw new InvalidDataException();
			}
			else if(!(roomType.equals("AC"))&&!(roomType.equals("Non-AC"))){
				throw new InvalidRoomTypeException();
				
			}
			else{
				return "Valid";
			}
		} 
		catch(Exception e){
			System.out.println(e);
		}	
		
		return " ";
		
	}
	public int getDaysStayed(Date bookingDate,Date departureDate){
		int daysStayed;
		daysStayed=(int) ((bookingDate.getTime()-departureDate.getTime())/86400000);
		return daysStayed;
	}
	public String calculateBill(String customerId, Date bookingDate, Date departureDate, String roomType){
		String validity=validateData(customerId,bookingDate,departureDate,roomType);
		//String v;
		if(!(validity.equals("Valid"))){
			return validity;
		}
		else{
		Customer c=new Customer(customerId, bookingDate,departureDate,roomType);
		int daysStayed=getDaysStayed(bookingDate, departureDate);
		double tariff=c.getTariffPerDay();
		double billAmount=c.getBillAmount();
		billAmount=(double)daysStayed*tariff;
		double tot_bill;
		if(billAmount<=5000){
			billAmount=billAmount+(billAmount*0.05);
		}
		if(billAmount>5000&&billAmount<=10000){
			billAmount=billAmount+(billAmount*0.10);
		}
		else{
			billAmount=billAmount+(billAmount*0.20);
		}
		Offer o=new Offer();
		double offer=o.getOffer(roomType, billAmount);
		billAmount=billAmount-offer;
		System.out.println(billAmount);
		c.setBillAmount(billAmount);
		System.out.println(c.toString());
		}
		return "";
	}
	
	
}
