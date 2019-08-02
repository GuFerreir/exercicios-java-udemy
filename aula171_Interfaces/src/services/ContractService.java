package services;

import java.util.Calendar;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	Calendar cal = Calendar.getInstance();
	
	public void processContract(Contract contract, int months, OnlinePaymentService paymentService){
		
		double installmentGenericValue = contract.getTotalValue() / months;
		double interestsValue = 0;
		double feeValue = 0;
		double finalValue = 0;
		
		cal.setTime(contract.getDate());
		
		for(int i = 1; i <= months; i++){			
			interestsValue = paymentService.interest(installmentGenericValue, i);
			feeValue = paymentService.paymentFee(interestsValue);
			
			finalValue = interestsValue + feeValue;
			
			cal.add(Calendar.MONTH,1);
			contract.setDate(cal.getTime());
			
			contract.adicionarALista(new Installment(contract.getDate(), finalValue));
		}
		
	}

}
