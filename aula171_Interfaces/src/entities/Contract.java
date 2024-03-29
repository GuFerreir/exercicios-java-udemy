package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double totalValue;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	List<Installment> installments = new ArrayList<>();
	
	public Contract(){}

	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}
	
	public void adicionarALista(Installment installment){
		this.installments.add(installment);
	}
	
	public void printInstallments(){
		for(Installment isnt : installments){
			System.out.println(sdf.format(isnt.getDueDate()) + " - " + String.format("%.2f", isnt.getAmount()));
		}
	}

}
