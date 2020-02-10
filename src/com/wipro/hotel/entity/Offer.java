package com.wipro.hotel.entity;

public class Offer {
	public double getOffer(String roomType,double billAmount){
		double tot_bill=0.0;
		if(roomType.equals("AC")){
			if(billAmount<=5000){
				tot_bill=billAmount;
			}
			else if(billAmount>5000&&billAmount<=10000){
				tot_bill=billAmount-(billAmount*0.12);
			}
			else{
				tot_bill=billAmount-(billAmount*0.18);
			}
		}
		else{
			if(billAmount<=10000){
				tot_bill=billAmount;
			}
			else{
				tot_bill=billAmount-(billAmount*0.03);

			}
		}
		return tot_bill;	
	}
}
