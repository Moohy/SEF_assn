package Employee;

import java.util.ArrayList;
import java.util.Collection;

import Branch.Branch;
import Inspection.Inspection;
import Property.SaleProperty;
import Sale.Sale;

public class SaleConsultant extends Employee {
	
	private Collection<SaleProperty> saleProperties;
	private Collection<Sale> sales;

	public SaleConsultant(int id, String name, String email, double salary, boolean isPartTime, Branch branch) {
		super(id, name, email, salary, isPartTime, branch);
		
		this.saleProperties = new ArrayList<SaleProperty>();
		this.sales = new ArrayList<Sale>();
	}
	
	public void addSale(Sale sale) {
		this.sales.add(sale);
	}
	
	public void addSaleProperty(SaleProperty saleProperty) {
		this.saleProperties.add(saleProperty);
	}
	
	public void createInspection(SaleProperty saleProperty, String date, String start, String end) {
		saleProperty.createIspection(date, start, end);
	}
	
	public void removeInspection(SaleProperty saleProperty, Inspection insp) {
		saleProperty.removeInspection(insp);
	}
	
	public void processSales(String mo) {
		
	}
	
	public ArrayList<Sale> getSales(){
		return (ArrayList<Sale>) this.sales;
	}
}
